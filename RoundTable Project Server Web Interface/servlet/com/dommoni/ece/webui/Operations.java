package com.dommoni.ece.webui;

public class Operations
{

   //
   // Project Operations
   //
   public static final int CREATE_PROJECT                            = 1;
   public static final int DELETE_PROJECT                            = 2;
   public static final int EDIT_PROJECT                              = 3;
   public static final int SET_PROJECT                               = 4;
   public static final int CLOSE_PROJECT                             = 5;

   //
   // Account Operations
   //
   public static final int CREATE_ACCOUNT                            = 6;
   public static final int DELETE_ACCOUNT                            = 7;
   public static final int EDIT_ACCOUNT                              = 8;
   
   //
   // Document Operations
   //
   public static final int UPLOAD_DOCUMENT                           = 9;
   public static final int DOWNLOAD_DOCUMENT                         = 10;
   public static final int DELETE_DOCUMENT                           = 11;
   public static final int EDIT_DOCUMENT                             = 12;
   public static final int CREATE_DOCUMENT_FOLDER                    = 13;
   
   //
   // Meeting Operations
   //
   public static final int CREATE_MEETING                            = 14;
   public static final int DELETE_MEETING                            = 15;
   public static final int EDIT_MEETING                              = 16;
   
   //
   // ToDo Operations
   //
   public static final int CREATE_TODO                               = 17;
   public static final int DELETE_TODO                               = 18;
   public static final int EDIT_TODO                                 = 19;
   
   //
   // Notification Operations
   //
   public static final int CREATE_NOTIFICATION                       = 20;
   public static final int DELETE_NOTIFICATION                       = 21;

   //
   // Discussion Operations
   //
   public static final int DELETE_DISCUSSION                         = 22;
   
   //
   // Forum Operations
   //
   public static final int CREATE_FORUM                              = 23;
   public static final int POST_FORUM_REPLY                          = 24;
   public static final int DELETE_FORUM                              = 25;
   public static final int EDIT_FORUM                                = 26;
   
   // Account Settings...
   public static final int SAVE_SETTINGS                             = 27;
   public static final int CHANGE_PASSWORD                           = 28;
   public static final int UPDATE_PROFILE                            = 29;
   
   //
   // Comment Operations
   //
   public static final int CREATE_COMMENT                            = 30;
   public static final int DELETE_COMMENT                            = 31;
   public static final int EDIT_COMMENT                              = 32;
   
   //
   // Announcement Operations
   //
   public static final int CREATE_ANNOUNCEMENT                       = 33;
   
   //
   // Attachment Operations
   //
   public static final int CREATE_FILE_ATTACHMENT                    = 34;
   public static final int DELETE_FILE_ATTACHMENT                    = 35;
   public static final int MODIFY_FILE_ATTACHMENT                    = 36;
   
   public static final int CREATE_OBJECT_ATTACHMENT                  = 37;
   public static final int DELETE_OBJECT_ATTACHMENT                  = 38;
   public static final int MODIFY_OBJECT_ATTACHMENT                  = 39;
   
   //
   // Schedule Operations
   //
   public static final int CREATE_SCHEDULE                           = 40;
   public static final int DELETE_SCHEDULE                           = 41;
   public static final int MODIFY_SCHEDULE                           = 42;
   
   //
   // Log Operations
   //
   public static final int GENERATE_LOG_REPORT                       = 43;
   public static final int EXPORT_LOG_REPROT_XLS                     = 44;
   public static final int EXPORT_LOG_REPROT_CSV                     = 45;
   public static final int EXPORT_LOG_REPROT_PDF                     = 46;
   
   //
   // Miscellaneous Operations
   //
   public static final int HANDLE_MENU                               = 47;
   public static final int LOGIN                                     = 48;
   public static final int LOGOUT                                    = 49;
}
/*
 *
 * $Log: Operations.java,v $
 * Revision 1.2  2005/10/16 04:33:39  brian
 * Added support for attachments and schedules.
 *
 *
 */