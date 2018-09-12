/*
 * Created on Dec 23, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommentAttachment
{
   private int id;
   private int commentId;
   private String filename;
   private byte[] attachement;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int id)
   {
      this.id = id;
   }
   
   public int getCommentId()
   {
      return this.commentId;
   }
   
   public void setCommentId(int commentId)
   {
      this.commentId = commentId;
   }
   
   public String getFilename()
   {
      return this.filename;
   }
   
   public void setFilename(String filename)
   {
      this.filename = filename;
   }
   
   public byte[] getAttachement()
   {
      return this.attachement;
   }
   
   public void setAttachement(byte[] attachement)
   {
      this.attachement = attachement;
   }
}
/*
 * 
 * $Log: CommentAttachment.java,v $
 * Revision 1.2  2005/03/23 09:07:23  brian
 * Added footer.
 *
 * 
 */