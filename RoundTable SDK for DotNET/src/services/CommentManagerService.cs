﻿//------------------------------------------------------------------------------
// <autogenerated>
//     This code was generated by a tool.
//     Runtime Version: 1.1.4322.2032
//
//     Changes to this file may cause incorrect behavior and will be lost if 
//     the code is regenerated.
// </autogenerated>
//------------------------------------------------------------------------------

// 
// This source code was auto-generated by wsdl, Version=1.1.4322.2032.
// 
using System.Diagnostics;
using System.Xml.Serialization;
using System;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Web.Services;

using RoundTable;
using RoundTable.ProjectServer.Services.CommentManager;


/// <remarks/>
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Web.Services.WebServiceBindingAttribute(Name="CommentManagerSoapBinding", Namespace="http://localhost:8080/ProjectServer/services/CommentManager")]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(NotificationContextObject))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Announcement))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(ForumReply))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(CommentAttachment))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Session))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(SessionLogEntry))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(DiscussionMessage))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Notification))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(AccountSettings))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(AccountProfile))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(ObjectAttachment))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(RoundTable.EventLogEntry))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(RecentChange))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(MeetingNoteItem))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(BinaryAttachment))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(MeetingFollowupItem))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(MeetingAgendaItem))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(AccountContact))]
public class CommentManagerService : System.Web.Services.Protocols.SoapHttpClientProtocol, ICommentManager {
    
	public SessionHeader sessionHeader = null;

    /// <remarks/>
    public CommentManagerService(string ipAddr, int port, string sessionId) {
        this.Url = "http://"+ipAddr+":"+port+"/ProjectServer/services/CommentManager";
		sessionHeader = new SessionHeader();
		sessionHeader.SessionID = sessionId;
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://commentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/CommentManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("addCommentReturn")]
    public int addComment(object parentObj, Comment comment) {
        object[] results = this.Invoke("addComment", new object[] {
                    parentObj,
                    comment});
        return ((int)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginaddComment(object parentObj, Comment comment, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("addComment", new object[] {
                    parentObj,
                    comment}, callback, asyncState);
    }
    
    /// <remarks/>
    public int EndaddComment(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((int)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://commentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/CommentManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	public void dropComment(int commentId) {
        this.Invoke("dropComment", new object[] {
                    commentId});
    }
    
    /// <remarks/>
    public System.IAsyncResult BegindropComment(int commentId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("dropComment", new object[] {
                    commentId}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EnddropComment(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://commentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/CommentManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	public void modifyComment(object parentObj, Comment comment) {
        this.Invoke("modifyComment", new object[] {
                    parentObj,
                    comment});
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginmodifyComment(object parentObj, Comment comment, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("modifyComment", new object[] {
                    parentObj,
                    comment}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EndmodifyComment(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://commentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/CommentManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("getCommentsForObjectReturn")]
    public Comment[] getCommentsForObject(object parentObj) {
        object[] results = this.Invoke("getCommentsForObject", new object[] {
                    parentObj});
        return ((Comment[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetCommentsForObject(object parentObj, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getCommentsForObject", new object[] {
                    parentObj}, callback, asyncState);
    }
    
    /// <remarks/>
    public Comment[] EndgetCommentsForObject(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Comment[])(results[0]));
    }
}
/*
/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("NotificationContextObject", "http://roundtable.dommoni.com")]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Forum))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Discussion))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(ToDo))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Document))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Meeting))]
public abstract class NotificationContextObject {
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string name;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Forum", "http://www.dommoni.com/ROUNDTABLE")]
public class Forum : NotificationContextObject {
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public string message;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public string subject;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Discussion", "http://www.dommoni.com/ROUNDTABLE")]
public class Discussion : NotificationContextObject {
    
    /// <remarks/>
    public System.DateTime date;
    
    /// <remarks/>
    public int[] memberIds;
    
    /// <remarks/>
    public DiscussionMessage[] messages;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public string title;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("DiscussionMessage", "http://www.dommoni.com/ROUNDTABLE")]
public class DiscussionMessage {
    
    /// <remarks/>
    public int accountId;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string messageText;
    
    /// <remarks/>
    public System.DateTime timestamp;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("ToDo", "http://www.dommoni.com/ROUNDTABLE")]
public class ToDo : NotificationContextObject {
    
    /// <remarks/>
    public int assignedTo;
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public ToDoStatus currentStatus;
    
    /// <remarks/>
    public string description;
    
    /// <remarks/>
    public System.DateTime dueDate;
    
    /// <remarks/>
    public int flag;
    
    /// <remarks/>
    public bool isPublic;
    
    /// <remarks/>
    public System.DateTime lastModified;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public string title;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("ToDoStatus", "http://www.dommoni.com/ROUNDTABLE")]
public class ToDoStatus {
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public string title;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Document", "http://www.dommoni.com/ROUNDTABLE")]
public class Document : NotificationContextObject {
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public string description;
    
    /// <remarks/>
    [System.Xml.Serialization.SoapElementAttribute(DataType="base64Binary")]
    public System.Byte[] document;
    
    /// <remarks/>
    public int documentType;
    
    /// <remarks/>
    public string filename;
    
    /// <remarks/>
    public int ownerId;
    
    /// <remarks/>
    public int projectId;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Meeting", "http://www.dommoni.com/ROUNDTABLE")]
public class Meeting : NotificationContextObject {
    
    /// <remarks/>
    public MeetingAgendaItem[] agendaItems;
    
    /// <remarks/>
    public int[] attendees;
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public string description;
    
    /// <remarks/>
    public System.DateTime endTime;
    
    /// <remarks/>
    public MeetingFollowupItem[] followupItems;
    
    /// <remarks/>
    public MeetingNoteItem[] meetingNotes;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public bool sendInvitation;
    
    /// <remarks/>
    public System.DateTime startTime;
    
    /// <remarks/>
    public string title;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("MeetingAgendaItem", "http://www.dommoni.com/ROUNDTABLE")]
public class MeetingAgendaItem {
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string notes;
    
    /// <remarks/>
    public int ordinal;
    
    /// <remarks/>
    public string title;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("MeetingFollowupItem", "http://www.dommoni.com/ROUNDTABLE")]
public class MeetingFollowupItem {
    
    /// <remarks/>
    public int ordinal;
    
    /// <remarks/>
    public string text;
    
    /// <remarks/>
    public string title;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("MeetingNoteItem", "http://www.dommoni.com/ROUNDTABLE")]
public class MeetingNoteItem {
    
    /// <remarks/>
    public BinaryAttachment[] attachments;
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public string description;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public int meetingId;
    
    /// <remarks/>
    public string title;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("BinaryAttachment", "http://www.dommoni.com/ROUNDTABLE")]
public class BinaryAttachment {
    
    /// <remarks/>
    [System.Xml.Serialization.SoapElementAttribute(DataType="base64Binary")]
    public System.Byte[] attachment;
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string notes;
    
    /// <remarks/>
    public string objectContext;
    
    /// <remarks/>
    public int objectId;
    
    /// <remarks/>
    public int projectId;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Announcement", "http://www.dommoni.com/ROUNDTABLE")]
public class Announcement {
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public string text;
    
    /// <remarks/>
    public string title;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("ForumReply", "http://www.dommoni.com/ROUNDTABLE")]
public class ForumReply {
    
    /// <remarks/>
    public int accountId;
    
    /// <remarks/>
    public int forumId;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string reply;
    
    /// <remarks/>
    public System.DateTime timestamp;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("CommentAttachment", "http://www.dommoni.com/ROUNDTABLE")]
public class CommentAttachment {
    
    /// <remarks/>
    [System.Xml.Serialization.SoapElementAttribute(DataType="base64Binary")]
    public System.Byte[] attachement;
    
    /// <remarks/>
    public int commentId;
    
    /// <remarks/>
    public string filename;
    
    /// <remarks/>
    public int id;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Session", "http://www.dommoni.com/ROUNDTABLE")]
public class Session {
    
    /// <remarks/>
    public Account account;
    
    /// <remarks/>
    public Project currentProject;
    
    /// <remarks/>
    public System.DateTime endTime;
    
    /// <remarks/>
    public System.DateTime lastActivityTime;
    
    /// <remarks/>
    public string remoteIPAddress;
    
    /// <remarks/>
    public string sessionId;
    
    /// <remarks/>
    public System.DateTime startTime;
    
    /// <remarks/>
    public int type;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Account", "http://www.dommoni.com/ROUNDTABLE")]
public class Account {
    
    /// <remarks/>
    public int accountType;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string name;
    
    /// <remarks/>
    public string nickName;
    
    /// <remarks/>
    public string password;
    
    /// <remarks/>
    public string profile;
    
    /// <remarks/>
    public string username;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Project", "http://www.dommoni.com/ROUNDTABLE")]
public class Project {
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public Account[] members;
    
    /// <remarks/>
    public string name;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Comment", "http://www.dommoni.com/ROUNDTABLE")]
public class Comment {
    
    /// <remarks/>
    public string comment;
    
    /// <remarks/>
    public string context;
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public int objectId;
    
    /// <remarks/>
    public int projectId;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("SessionLogEntry", "http://www.dommoni.com/ROUNDTABLE")]
public class SessionLogEntry {
    
    /// <remarks/>
    public int accountId;
    
    /// <remarks/>
    public System.DateTime endTime;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string remoteIpAddress;
    
    /// <remarks/>
    public string sessionId;
    
    /// <remarks/>
    public System.DateTime startTime;
    
    /// <remarks/>
    public int type;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Notification", "http://www.dommoni.com/ROUNDTABLE")]
public class Notification {
    
    /// <remarks/>
    public string context;
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string name;
    
    /// <remarks/>
    public int[] objectIds;
    
    /// <remarks/>
    public int operation;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public int type;
    
    /// <remarks/>
    public int[] userIds;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("AccountSettings", "http://www.dommoni.com/ROUNDTABLE")]
public class AccountSettings {
    
    /// <remarks/>
    public int accountId;
    
    /// <remarks/>
    public bool notificationsDesktopPager;
    
    /// <remarks/>
    public bool notificationsEmail;
    
    /// <remarks/>
    public bool notificationsSystemMessage;
    
    /// <remarks/>
    public string primaryEmailAddress;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("AccountProfile", "http://www.dommoni.com/ROUNDTABLE")]
public class AccountProfile {
    
    /// <remarks/>
    public int accountId;
    
    /// <remarks/>
    public string city;
    
    /// <remarks/>
    public string emailAddress;
    
    /// <remarks/>
    public string faxNumber;
    
    /// <remarks/>
    public string homePhoneNumber;
    
    /// <remarks/>
    [System.Xml.Serialization.SoapElementAttribute(DataType="base64Binary")]
    public System.Byte[] image;
    
    /// <remarks/>
    public string mailingAddress;
    
    /// <remarks/>
    public string mobilePhoneNumber;
    
    /// <remarks/>
    public string profileText;
    
    /// <remarks/>
    public string state;
    
    /// <remarks/>
    public string workPhoneNumber;
    
    /// <remarks/>
    public string zip;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("ObjectAttachment", "http://www.dommoni.com/ROUNDTABLE")]
public class ObjectAttachment {
    
    /// <remarks/>
    public string attachmentObjectContext;
    
    /// <remarks/>
    public int attachmentObjectId;
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string notes;
    
    /// <remarks/>
    public string objectContext;
    
    /// <remarks/>
    public int objectId;
    
    /// <remarks/>
    public int projectId;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("EventLogEntry", "http://www.dommoni.com/ROUNDTABLE")]
public class EventLogEntry {
    
    /// <remarks/>
    public int accountId;
    
    /// <remarks/>
    public string context;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string logMessage;
    
    /// <remarks/>
    public string operationName;
    
    /// <remarks/>
    public int operationType;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public string sessionId;
    
    /// <remarks/>
    public System.DateTime timestamp;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("RecentChange", "http://www.dommoni.com/ROUNDTABLE")]
public class RecentChange {
    
    /// <remarks/>
    public string changeMessage;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public System.DateTime timestamp;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("AccountContact", "http://www.dommoni.com/ROUNDTABLE")]
public class AccountContact {
    
    /// <remarks/>
    public int accountId;
    
    /// <remarks/>
    public string city;
    
    /// <remarks/>
    public string officeAddress;
    
    /// <remarks/>
    public string phoneNumber;
    
    /// <remarks/>
    public string state;
    
    /// <remarks/>
    public string zip;
}
*/