/*
 * Created on Sep 14, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.axis;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.xml.namespace.QName;
import javax.xml.rpc.holders.Holder;

import org.apache.axis.AxisFault;
import org.apache.axis.Constants;
import org.apache.axis.MessageContext;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.description.ServiceDesc;
import org.apache.axis.enum.Style;
import org.apache.axis.handlers.soap.SOAPService;
import org.apache.axis.message.RPCElement;
import org.apache.axis.message.RPCHeaderParam;
import org.apache.axis.message.RPCParam;
import org.apache.axis.message.SOAPBodyElement;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.providers.java.JavaProvider;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;
import org.apache.axis.utils.Messages;
import org.xml.sax.SAXException;

import com.dommoni.roundtable.Session;
import com.dommoni.roundtable.exceptions.LicenseNotFoundException;
import com.dommoni.roundtable.projectServer.ProjectServer;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.events.EventGenerator;
import com.dommoni.roundtable.projectServer.licensing.License;
import com.dommoni.roundtable.projectServer.licensing.LicenseFileReader;
import com.dommoni.roundtable.projectServer.logging.EventLogger;
import com.dommoni.roundtable.projectServer.notificationEngine.NotificationEngine;
import com.dommoni.roundtable.projectServer.recentChangesEngine.RecentChangesEngine;
import com.dommoni.roundtable.projectServer.services.systemManager.SystemManager;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoundTableProvider extends JavaProvider
{
   License license = null;
   
   public RoundTableProvider()
   {
      super();
      
      ProjectServer ps = ProjectServer.getInstance();
      synchronized(ps)
	  {
      	this.license = ps.getLicense();
	  }
   }
   
	public void processMessage(MessageContext msgContext, SOAPEnvelope reqEnv, SOAPEnvelope resEnv, Object obj)
		throws Exception
	{
		SOAPService service = msgContext.getService();
		ServiceDesc serviceDesc = service.getServiceDescription();
		OperationDesc operation = msgContext.getOperation();

		Vector bodies = reqEnv.getBodyElements();

		RPCElement body = null;

		// Find the first "root" body element, which is the RPC call.
		for (int bNum = 0; body == null && bNum < bodies.size(); bNum++)
		{
			// If this is a regular old SOAPBodyElement, and it's a root,
			// we're probably a non-wrapped doc/lit service.  In this case,
			// we deserialize the element, and create an RPCElement "wrapper"
			// around it which points to the correct method.
			// FIXME : There should be a cleaner way to do this...
			if (!(bodies.get(bNum) instanceof RPCElement))
			{
				SOAPBodyElement bodyEl = (SOAPBodyElement) bodies.get(bNum);
				// igors: better check if bodyEl.getID() != null
				// to make sure this loop does not step on SOAP-ENC objects
				// that follow the parameters! FIXME?
				if (bodyEl.isRoot() && operation != null && bodyEl.getID() == null)
				{
					ParameterDesc param = operation.getParameter(bNum);
					// at least do not step on non-existent parameters!
					if (param != null)
					{
						Object val = bodyEl.getValueAsType(param.getTypeQName());
						body = new RPCElement("", operation.getName(), new Object[] { val });
					}
				}
			}
			else
			{
				body = (RPCElement) bodies.get(bNum);
			}
		}

		// special case code for a document style operation with no
		// arguments (which is a strange thing to have, but whatever)
		if (body == null)
		{
			// throw an error if this isn't a document style service
			if (!(serviceDesc.getStyle().equals(Style.DOCUMENT)))
			{
				throw new Exception("No body in the SOAP Message");
			}

			// look for a method in the service that has no arguments,
			// use the first one we find.
			ArrayList ops = serviceDesc.getOperations();
			for (Iterator iterator = ops.iterator(); iterator.hasNext();)
			{
				OperationDesc desc = (OperationDesc) iterator.next();
				if (desc.getNumInParams() == 0)
				{
					// found one with no parameters, use it
					msgContext.setOperation(desc);
					// create an empty element
					body = new RPCElement(desc.getName());
					// stop looking
					break;
				}
			}

			// If we still didn't find anything, report no body error.
			if (body == null)
			{
				throw new Exception(Messages.getMessage("noBody00"));
			}
		}

		String methodName = body.getMethodName();
		Vector args = null;
		try
		{
			args = body.getParams();
		}
		catch (SAXException e)
		{
			if (e.getException() != null)
				throw e.getException();
			throw e;
		}
		int numArgs = args.size();

		// This may have changed, so get it again...
		// FIXME (there should be a cleaner way to do this)
		operation = msgContext.getOperation();

		if (operation == null)
		{
			QName qname = new QName(body.getNamespaceURI(), body.getName());
			operation = serviceDesc.getOperationByElementQName(qname);
		}

		if (operation == null)
		{
			throw new AxisFault(Messages.getMessage("noSuchOperation", methodName));
		}

		// Create the array we'll use to hold the actual parameter
		// values.  We know how big to make it from the metadata.
		Object[] argValues = new Object[operation.getNumParams()];

		// A place to keep track of the out params (INOUTs and OUTs)
		ArrayList outs = new ArrayList();

		// Put the values contained in the RPCParams into an array
		// suitable for passing to java.lang.reflect.Method.invoke()
		// Make sure we respect parameter ordering if we know about it
		// from metadata, and handle whatever conversions are necessary
		// (values -> Holders, etc)
		for (int i = 0; i < numArgs; i++)
		{
			RPCParam rpcParam = (RPCParam) args.get(i);
			Object value = rpcParam.getValue();

			// first check the type on the paramter
			ParameterDesc paramDesc = rpcParam.getParamDesc();

			// if we found some type info try to make sure the value type is
			// correct.  For instance, if we deserialized a xsd:dateTime in
			// to a Calendar and the service takes a Date, we need to convert
			if (paramDesc != null && paramDesc.getJavaType() != null)
			{

				// Get the type in the signature (java type or its holder)
				Class sigType = paramDesc.getJavaType();

				// Convert the value into the expected type in the signature
				value = JavaUtils.convert(value, sigType);

				rpcParam.setValue(value);
				if (paramDesc.getMode() == ParameterDesc.INOUT)
				{
					outs.add(rpcParam);
				}
			}

			// Put the value (possibly converted) in the argument array
			// make sure to use the parameter order if we have it
			if (paramDesc == null || paramDesc.getOrder() == -1)
			{
				argValues[i] = value;
			}
			else
			{
				argValues[paramDesc.getOrder()] = value;
			}

			if (log.isDebugEnabled())
			{
				log.debug("  " + Messages.getMessage("value00", "" + argValues[i]));
			}
		}

		// See if any subclasses want a crack at faulting on a bad operation
		// FIXME : Does this make sense here???
		String allowedMethods = (String) service.getOption("allowedMethods");
		checkMethodName(msgContext, allowedMethods, operation.getName());

		// Now create any out holders we need to pass in
		int count = numArgs;
		for (int i = 0; i < argValues.length; i++)
		{

			// We are interested only in OUT/INOUT
			ParameterDesc param = operation.getParameter(i);
			if (param.getMode() == ParameterDesc.IN)
				continue;

			Class holderClass = param.getJavaType();
			if (holderClass != null && Holder.class.isAssignableFrom(holderClass))
			{
				int index = count;
				// Use the parameter order if specified or just stick them to the end.  
				if (param.getOrder() != -1)
				{
					index = param.getOrder();
				}
				else
				{
					count++;
				}
				// If it's already filled, don't muck with it
				if (argValues[index] != null)
				{
					continue;
				}
				argValues[index] = holderClass.newInstance();
				// Store an RPCParam in the outs collection so we
				// have an easy and consistent way to write these
				// back to the client below
				RPCParam p = new RPCParam(param.getQName(), argValues[index]);
				p.setParamDesc(param);
				outs.add(p);
			}
			else
			{
				throw new AxisFault(
					Messages.getMessage(
						"badOutParameter00",
						"" + param.getQName(),
						operation.getName()));
			}
		}

		// OK!  Now we can invoke the method
		Object objRes = null;
		try
		{
         //----------------------------------------------------------------------------------------
         //
         //          ** MY CODE ** 
         //
         //----------------------------------------------------------------------------------------
			
         //
			// BA: now i need to decide how we should do this.
			// options:
			//   - Call everything here (service.meth, notif, logger)
			//   - create additional objs and pass those as params to service
			// assuming the call worked, send a notice to the 
			// notification engine, log the app-level op.

			//---------------
			// This could/should have been implemented as a handler on the response side
			// of the provider.
		   
			Event event = null;
			Session session = null;
         
			try
			{
				session = (Session)msgContext.getProperty("session");
            
				if (session != null && session.getAccount() != null)
					// if false, it's too early for this (not logged in, authenticated yet)
				{  
               if(session.getRemoteIPAddress() == null)
               {   
                  String remoteIP = msgContext.getStrProp(Constants.MC_REMOTE_ADDR); 
                  session.setRemoteIPAddress(remoteIP);
               }
               
               session.touch();
               
					EventGenerator eg = new EventGenerator();

					String serviceName = msgContext.getService().getServiceDescription().getName();
					String operationName = operation.getMethod().getName();

					event = eg.generateEvent(session, serviceName, operationName, argValues);    
				}
			}
			catch (Exception e)
			{
				DebugUtils.GI().logException(e);
			}
         
         // we dont want axis to touch our Event object so, we insert it into the args, here:
         //Object[] newArray = new Object[argValues.length + 1];
         //newArray[0] = event;
         //System.arraycopy(argValues, 0, newArray, 1, argValues.length);
         //argValues = newArray;
         
         //
         // Axix SOAP Invocation 
         //
         
         // Handle Blocked IP's
         // TODO: Need to figure out how the system should call internal methods.
         /*String[] blockedIps = new SystemManager().getAllBlockedIPs(event);
         for(int i = 0; i < blockedIps.length; i++)
         {
            if(session.getRemoteIPAddress().equals(blockedIps[i]))
            {
               throw new Exception("Access Denied");
            }
         }*/
         
         //
         // Handle Licensing
         //
         if(license == null)
         {  
            throw new LicenseNotFoundException();
         }
         else
         {
            // Product - 100;
            // Trial - 125;
            if(license.getMode() == 125)
            {
               // TODO: How to determine license start-date
               Calendar today = Calendar.getInstance();
               long todayMilli = today.getTimeInMillis();
               
               // Construct the end date
               Calendar clEnd = Calendar.getInstance();
               clEnd.setTime(license.getLoadDate().getTime());
               clEnd.add(Calendar.DAY_OF_WEEK, license.getDays());
               
               if(todayMilli > clEnd.getTimeInMillis())
               	  throw new Exception("Trial-License Expired");
            }
            else if (license.getMode() != 100)
            {
               throw new Exception("Invalid License File");
            }
         }
         
         objRes = invokeMethod(msgContext, operation.getMethod(), obj, argValues);
         
         //
         // TODO: I dont think this will scale well. The way I would like to implement this
         // would be to have a threaded queue the receives events and sends the event to
         // systems that have registered to listen to the event channel. This shouldnt take
         // too long but, for now, this is easier.
         //
         if (event != null)
         {
            //
            // Do Notifications...
            //
            //if(event.isNotifiable())
            //{  
            try
            {
               NotificationEngine nEngine = new NotificationEngine();
               nEngine.receiveEvent(event);
            }
            catch(Exception e)
            {
            	DebugUtils.GI().logException(e);
            }
            //}

            //
            // Do recent-changes...
            //
            try
            {
               RecentChangesEngine rce = new RecentChangesEngine();
               rce.receiveEvent(event);
            }
            catch(Exception e)
            {
            	DebugUtils.GI().logException(e);
            }
            
            //
            // Do Application-Logging
            //
            try
            {
               EventLogger el = new EventLogger();
               el.receiveEvent(event);
            }
            catch(Exception e)
            {
            	DebugUtils.GI().logException(e);
            }
         }
         else
         {
            DebugUtils.GI().printDbg("Event was Null.");
         }
		}
		catch (IllegalArgumentException e)
		{
			String methodSig = operation.getMethod().toString();
			String argClasses = "";
			for (int i = 0; i < argValues.length; i++)
			{
				if (argValues[i] == null)
				{
					argClasses += "null";
				}
				else
				{
					argClasses += argValues[i].getClass().getName();
				}
				if (i + 1 < argValues.length)
				{
					argClasses += ",";
				}
			}
			log.info(Messages.getMessage("dispatchIAE00", new String[] { methodSig, argClasses }), e);
			throw new AxisFault(
				Messages.getMessage("dispatchIAE00", new String[] { methodSig, argClasses }),
				e);
		}

		/* Now put the result in the result SOAPEnvelope */
		/*************************************************/
		RPCElement resBody = new RPCElement(methodName + "Response");
		resBody.setPrefix(body.getPrefix());
		resBody.setNamespaceURI(body.getNamespaceURI());
		resBody.setEncodingStyle(msgContext.getEncodingStyle());

		try
		{
			// Return first
			if (operation.getMethod().getReturnType() != Void.TYPE)
			{
				QName returnQName = operation.getReturnQName();
				if (returnQName == null)
				{
					returnQName = new QName(body.getNamespaceURI(), methodName + "Return");
				}

				RPCParam param = new RPCParam(returnQName, objRes);
				param.setParamDesc(operation.getReturnParamDesc());

				if (!operation.isReturnHeader())
				{
					// For SOAP 1.2 rpc style, add a result
					if (msgContext.getSOAPConstants() == SOAPConstants.SOAP12_CONSTANTS
						&& (serviceDesc.getStyle().equals(Style.RPC)))
					{
						RPCParam resultParam = new RPCParam(Constants.QNAME_RPC_RESULT, returnQName);
						resultParam.setXSITypeGeneration(Boolean.FALSE);
						resBody.addParam(resultParam);
					}
					resBody.addParam(param);
				}
				else
				{
					resEnv.addHeader(new RPCHeaderParam(param));
				}
			}

			// Then any other out params
			if (!outs.isEmpty())
			{
				for (Iterator i = outs.iterator(); i.hasNext();)
				{
					// We know this has a holder, so just unwrap the value
					RPCParam param = (RPCParam) i.next();
					Holder holder = (Holder) param.getValue();
					Object value = JavaUtils.getHolderValue(holder);
					ParameterDesc paramDesc = param.getParamDesc();

					param.setValue(value);
					if (paramDesc != null && paramDesc.isOutHeader())
					{
						resEnv.addHeader(new RPCHeaderParam(param));
					}
					else
					{
						resBody.addParam(param);
					}
				}
			}
		}
		catch (Exception e)
		{
         e.printStackTrace();
			throw e;
		}

		resEnv.addBodyElement(resBody);

	}

	/**
	     * This method encapsulates the method invocation.             
	     * @param msgContext MessageContext
	     * @param method the target method.
	     * @param obj the target object
	     * @param argValues the method arguments
	     */
	protected Object invokeMethod(
		MessageContext msgContext,
		Method method,
		Object obj,
		Object[] argValues)
		throws Exception
	{
		try
      {
         /*System.out.println("Invoke:ObjName: " + obj.getClass().getName());
   		System.out.println("Invoke:Method: " + method.getName());
   		for(int i = 0; i < argValues.length; i++)
   		{
            if(argValues[i] != null)
               System.out.println("Invoke:Args["+i+"]: " + argValues[i].getClass().getName() + " :: " + argValues[i]);
   		}
         
         Method[] meths = obj.getClass().getMethods();
         for(int i = 0; i < meths.length; i++)
         {
            System.out.println(meths[i].getName());
            Class[] params = meths[i].getParameterTypes();
            for(int j = 0; j < params.length; j++)
            { 
               System.out.println("\t" + params[j].getName());
            }
         }
         */
         
         Class cls[] = method.getParameterTypes();
         //Class myCls[] = new Class[cls.length +1];
         //myCls[0] = Event.class;
         //System.arraycopy(cls, 0, myCls, 1, cls.length);
         
         //Method myMethod = obj.getClass().getMethod(method.getName(), myCls);
         Method myMethod = obj.getClass().getMethod(method.getName(), cls);
         
         //Object retObj = method.invoke(obj, argValues);
         Object retObj = myMethod.invoke(obj, argValues);
         DebugUtils.GI().printDbg("RET: " + retObj);
         
   		return retObj;
      }
      catch(Exception e)
      {
      	 DebugUtils.GI().logException(e);
         throw e;
      }
	}

	/**
	 * Throw an AxisFault if the requested method is not allowed.
	 * @param msgContext MessageContext
	 * @param allowedMethods list of allowed methods
	 * @param methodName name of target method
	 */
	protected void checkMethodName(
		MessageContext msgContext,
		String allowedMethods,
		String methodName)
		throws Exception
	{
		// Our version doesn't need to do anything, though inherited
		// ones might.
	}
}
/*
 * 
 * $Log: RoundTableProvider.java,v $
 * Revision 1.3  2005/10/17 03:30:26  brian
 * Added support for Product Licensing.
 *
 * Revision 1.2  2005/03/23 19:02:41  brian
 * Removed print statements. Temporarily removed event passing.
 *
 * 
 */