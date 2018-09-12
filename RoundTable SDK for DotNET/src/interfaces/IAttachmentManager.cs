/*
 * IAttachmentManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.AttachmentManager
{
	/// <summary>
	/// Summary description for IAttachmentManager.
	/// </summary>
	public interface IAttachmentManager
	{
		int addBinaryAttachement(object obj, BinaryAttachment attachement);
   
		void dropBinaryAttachement(int attachementId);
   
		void modifyBinaryAttachement(BinaryAttachment attachement);
   
		BinaryAttachment getBinaryAttachement(int attachmentId);
   
		BinaryAttachment[] getAllBinaryAttachementsForObject(object obj);

		ObjectAttachment createObjectAttachement(object obj, object attObj, ObjectAttachment attachement);
   
		void dropObjectAttachement(int attachementId);
   
		void modifyObjectAttachement(ObjectAttachment attachement);
   
		ObjectAttachment getObjectAttachement(int attachmentId);
   
		ObjectAttachment[] getAllObjectAttachementsForObject(object obj);
	}
}
/*
 * 
 * $Log: IAttachmentManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */