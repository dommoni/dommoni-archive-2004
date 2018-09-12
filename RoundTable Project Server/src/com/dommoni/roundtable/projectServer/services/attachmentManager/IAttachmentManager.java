/*
 * Created on Jan 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.attachmentManager;

import com.dommoni.roundtable.BinaryAttachment;
import com.dommoni.roundtable.ObjectAttachment;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface IAttachmentManager
{
   public int addBinaryAttachment(BinaryAttachment attachment)
   throws Exception;
   
   public void dropBinaryAttachment(int attachmentId)
   throws Exception;
   
   public void modifyBinaryAttachment(BinaryAttachment attachment)
   throws Exception;
   
   public BinaryAttachment getBinaryAttachment(int attachmentId)
   throws Exception;
   
   public BinaryAttachment[] getAllBinaryAttachmentsForObject(Object obj)
   throws Exception;

   public ObjectAttachment createObjectAttachment(Object object, Object attObj, ObjectAttachment attachment)
   throws Exception;
   
   public void dropObjectAttachment(int attachmentId)
   throws Exception;
   
   public void modifyObjectAttachment(ObjectAttachment attachment)
   throws Exception;
   
   public ObjectAttachment getObjectAttachment(int attachmentId)
   throws Exception;
   
   public ObjectAttachment[] getAllObjectAttachmentsForObject(Object obj)
   throws Exception;
}
/*
 * 
 * $Log: IAttachmentManager.java,v $
 * Revision 1.3  2005/10/17 05:55:59  brian
 * Fixed spelling errors.
 *
 * Revision 1.2  2005/03/23 07:21:56  brian
 * Corrected spelling of attachment.
 *
 * 
 */