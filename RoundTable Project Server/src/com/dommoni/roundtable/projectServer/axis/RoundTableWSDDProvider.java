/*
 * Created on Sep 14, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.axis;


import org.apache.axis.EngineConfiguration;
import org.apache.axis.Handler;
import org.apache.axis.deployment.wsdd.WSDDProvider;
import org.apache.axis.deployment.wsdd.WSDDService;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoundTableWSDDProvider extends WSDDProvider
{
   public Handler newProviderInstance(WSDDService service, EngineConfiguration arg1) 
      throws Exception
   {
      return new RoundTableProvider();
   }
   
   public String getName()
   {
      return "ROUNDTABLE";
   }
}
/*
 * 
 * $Log: RoundTableWSDDProvider.java,v $
 * Revision 1.2  2005/03/23 19:02:57  brian
 * Added footer.
 *
 * 
 */