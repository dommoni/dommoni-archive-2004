/*
 * Created on Apr 12, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.ece.webui.utils;

import java.util.Vector;

import com.dommoni.roundtable.BinaryAttachment;
import com.dommoni.roundtable.ObjectAttachment;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AttachmentSorter
{
   Vector attachments;
   
   public AttachmentSorter()
   {
      attachments = new Vector();
   }
   
   public void addAttachments(Object[] ats)
   {
      if(ats != null)
      {
         for(int i = 0; i < ats.length; i++)
         {
            if(ats[i] instanceof BinaryAttachment ||
               ats[i] instanceof ObjectAttachment)
            {
               attachments.add(ats[i]);
            }
         }
      }
   }
   
   public Vector sort()
   {
      Vector sorted = new Vector();
      while(attachments.size() > 0)
      {
         long createdOn = 0;
         int pos = -1;
         
         for(int i = 0; i < attachments.size(); i++)
         {   
            try
            {
               if(attachments.get(i) instanceof BinaryAttachment)
               {   
                  BinaryAttachment bin = (BinaryAttachment)attachments.get(i);
                  if(createdOn == 0 || bin.getCreatedOn().getTimeInMillis() < createdOn) 
                  {
                     createdOn = bin.getCreatedOn().getTimeInMillis();
                     pos = i;
                  }
               }
               else if(attachments.get(i) instanceof ObjectAttachment) 
               {
                  ObjectAttachment obj = (ObjectAttachment)attachments.get(i);
                  if(createdOn == 0 || obj.getCreatedOn().getTimeInMillis() < createdOn)
                  {
                     createdOn = obj.getCreatedOn().getTimeInMillis();
                     pos = i;
                  }
               }
               else 
               {
                  // ?
               }
            }
            catch(Exception e)
            {
               e.printStackTrace();
            }
         }
         
         if(pos > -1)
         {   
            sorted.add(attachments.remove(pos));
         }
      }
      return sorted;
   }
}
/*
 * 
 * $Log: AttachmentSorter.java,v $
 * Revision 1.1  2005/10/16 06:13:53  brian
 * Initial Revision.
 *
 * 
 */
