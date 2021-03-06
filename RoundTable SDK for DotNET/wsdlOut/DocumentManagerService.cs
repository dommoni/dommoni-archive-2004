﻿//------------------------------------------------------------------------------
// <autogenerated>
//     This code was generated by a tool.
//     Runtime Version: 1.1.4322.573
//
//     Changes to this file may cause incorrect behavior and will be lost if 
//     the code is regenerated.
// </autogenerated>
//------------------------------------------------------------------------------

// 
// This source code was auto-generated by wsdl, Version=1.1.4322.573.
// 
using System.Diagnostics;
using System.Xml.Serialization;
using System;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Web.Services;


/// <remarks/>
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Web.Services.WebServiceBindingAttribute(Name="DocumentManagerSoapBinding", Namespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Account))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(ScheduleItem))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(DiscussionMessage))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(BinaryAttachment))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(MeetingNoteItem))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(MeetingFollowupItem))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(MeetingAgendaItem))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(NamedFieldCollection))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(CustomField))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(NotificationContextObject))]
public class DocumentManagerService : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    /// <remarks/>
    public DocumentManagerService() {
        this.Url = "http://localhost:8080/ProjectServer/services/DocumentManager";
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("addDocumentReturn")]
    public int addDocument(Document document) {
        object[] results = this.Invoke("addDocument", new object[] {
                    document});
        return ((int)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginaddDocument(Document document, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("addDocument", new object[] {
                    document}, callback, asyncState);
    }
    
    /// <remarks/>
    public int EndaddDocument(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((int)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    public void dropDocument(int documentId) {
        this.Invoke("dropDocument", new object[] {
                    documentId});
    }
    
    /// <remarks/>
    public System.IAsyncResult BegindropDocument(int documentId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("dropDocument", new object[] {
                    documentId}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EnddropDocument(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    public void modifyDocument(Document document) {
        this.Invoke("modifyDocument", new object[] {
                    document});
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginmodifyDocument(Document document, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("modifyDocument", new object[] {
                    document}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EndmodifyDocument(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getDocumentDeepReturn")]
    public Document getDocumentDeep(int documentId) {
        object[] results = this.Invoke("getDocumentDeep", new object[] {
                    documentId});
        return ((Document)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetDocumentDeep(int documentId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getDocumentDeep", new object[] {
                    documentId}, callback, asyncState);
    }
    
    /// <remarks/>
    public Document EndgetDocumentDeep(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Document)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getDocumentShallowReturn")]
    public Document getDocumentShallow(int documentId) {
        object[] results = this.Invoke("getDocumentShallow", new object[] {
                    documentId});
        return ((Document)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetDocumentShallow(int documentId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getDocumentShallow", new object[] {
                    documentId}, callback, asyncState);
    }
    
    /// <remarks/>
    public Document EndgetDocumentShallow(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Document)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAllDocumentsDeepReturn")]
    public Document[] getAllDocumentsDeep() {
        object[] results = this.Invoke("getAllDocumentsDeep", new object[0]);
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAllDocumentsDeep(System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAllDocumentsDeep", new object[0], callback, asyncState);
    }
    
    /// <remarks/>
    public Document[] EndgetAllDocumentsDeep(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAllDocumentsShallowReturn")]
    public Document[] getAllDocumentsShallow() {
        object[] results = this.Invoke("getAllDocumentsShallow", new object[0]);
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAllDocumentsShallow(System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAllDocumentsShallow", new object[0], callback, asyncState);
    }
    
    /// <remarks/>
    public Document[] EndgetAllDocumentsShallow(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAllDocumentsForProjectDeepReturn")]
    public Document[] getAllDocumentsForProjectDeep(int projectId) {
        object[] results = this.Invoke("getAllDocumentsForProjectDeep", new object[] {
                    projectId});
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAllDocumentsForProjectDeep(int projectId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAllDocumentsForProjectDeep", new object[] {
                    projectId}, callback, asyncState);
    }
    
    /// <remarks/>
    public Document[] EndgetAllDocumentsForProjectDeep(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAllDocumentsForProjectReturn")]
    public Document[] getAllDocumentsForProject(int projectId) {
        object[] results = this.Invoke("getAllDocumentsForProject", new object[] {
                    projectId});
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAllDocumentsForProject(int projectId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAllDocumentsForProject", new object[] {
                    projectId}, callback, asyncState);
    }
    
    /// <remarks/>
    public Document[] EndgetAllDocumentsForProject(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAllDocumentsForProjectShallowReturn")]
    public Document[] getAllDocumentsForProjectShallow(int projectId) {
        object[] results = this.Invoke("getAllDocumentsForProjectShallow", new object[] {
                    projectId});
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAllDocumentsForProjectShallow(int projectId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAllDocumentsForProjectShallow", new object[] {
                    projectId}, callback, asyncState);
    }
    
    /// <remarks/>
    public Document[] EndgetAllDocumentsForProjectShallow(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getDocumentsForProjectFromDocumentTypeReturn")]
    public Document[] getDocumentsForProjectFromDocumentType(int projectId, int documentType) {
        object[] results = this.Invoke("getDocumentsForProjectFromDocumentType", new object[] {
                    projectId,
                    documentType});
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetDocumentsForProjectFromDocumentType(int projectId, int documentType, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getDocumentsForProjectFromDocumentType", new object[] {
                    projectId,
                    documentType}, callback, asyncState);
    }
    
    /// <remarks/>
    public Document[] EndgetDocumentsForProjectFromDocumentType(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getDocumentsForProjectFromDocumentTypeDeepReturn")]
    public Document[] getDocumentsForProjectFromDocumentTypeDeep(int projectId, int documentType) {
        object[] results = this.Invoke("getDocumentsForProjectFromDocumentTypeDeep", new object[] {
                    projectId,
                    documentType});
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetDocumentsForProjectFromDocumentTypeDeep(int projectId, int documentType, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getDocumentsForProjectFromDocumentTypeDeep", new object[] {
                    projectId,
                    documentType}, callback, asyncState);
    }
    
    /// <remarks/>
    public Document[] EndgetDocumentsForProjectFromDocumentTypeDeep(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getDocumentsForProjectFromDocumentTypeShallowReturn")]
    public Document[] getDocumentsForProjectFromDocumentTypeShallow(int projectId, int documentType) {
        object[] results = this.Invoke("getDocumentsForProjectFromDocumentTypeShallow", new object[] {
                    projectId,
                    documentType});
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetDocumentsForProjectFromDocumentTypeShallow(int projectId, int documentType, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getDocumentsForProjectFromDocumentTypeShallow", new object[] {
                    projectId,
                    documentType}, callback, asyncState);
    }
    
    /// <remarks/>
    public Document[] EndgetDocumentsForProjectFromDocumentTypeShallow(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Document[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("addCommentForDocumentReturn")]
    public int addCommentForDocument(Document document, Comment comment) {
        object[] results = this.Invoke("addCommentForDocument", new object[] {
                    document,
                    comment});
        return ((int)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginaddCommentForDocument(Document document, Comment comment, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("addCommentForDocument", new object[] {
                    document,
                    comment}, callback, asyncState);
    }
    
    /// <remarks/>
    public int EndaddCommentForDocument(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((int)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://documentManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/DocumentManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getCommentsForDocumentReturn")]
    public Comment[] getCommentsForDocument(Document document) {
        object[] results = this.Invoke("getCommentsForDocument", new object[] {
                    document});
        return ((Comment[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetCommentsForDocument(Document document, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getCommentsForDocument", new object[] {
                    document}, callback, asyncState);
    }
    
    /// <remarks/>
    public Comment[] EndgetCommentsForDocument(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Comment[])(results[0]));
    }
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
[System.Xml.Serialization.SoapTypeAttribute("NotificationContextObject", "http://roundtable.dommoni.com")]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Document))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Schedule))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Forum))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Discussion))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Meeting))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Task))]
public abstract class NotificationContextObject {
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string name;
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
[System.Xml.Serialization.SoapTypeAttribute("ScheduleItem", "http://www.dommoni.com/ROUNDTABLE")]
public class ScheduleItem {
    
    /// <remarks/>
    public Comment[] comments;
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public string description;
    
    /// <remarks/>
    public System.Single duration;
    
    /// <remarks/>
    public System.DateTime endDate;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public int ordinal;
    
    /// <remarks/>
    public int percentComplete;
    
    /// <remarks/>
    public int priority;
    
    /// <remarks/>
    public Account[] resources;
    
    /// <remarks/>
    public System.DateTime startDate;
    
    /// <remarks/>
    public string title;
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
    public string name;
    
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
[System.Xml.Serialization.SoapTypeAttribute("TaskReminder", "http://www.dommoni.com/ROUNDTABLE")]
public class TaskReminder {
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public int[] recipients;
    
    /// <remarks/>
    public System.DateTime reminderTime;
    
    /// <remarks/>
    public int taskId;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("NamedFieldCollection", "http://www.dommoni.com/ROUNDTABLE")]
public class NamedFieldCollection {
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public string description;
    
    /// <remarks/>
    public CustomField[] fields;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string name;
    
    /// <remarks/>
    public int projectId;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("CustomField", "http://www.dommoni.com/ROUNDTABLE")]
public class CustomField {
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public string name;
    
    /// <remarks/>
    public int ordinal;
    
    /// <remarks/>
    public int type;
    
    /// <remarks/>
    public CustomFieldValueWrapper valueWrapper;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("CustomFieldValueWrapper", "http://www.dommoni.com/ROUNDTABLE")]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(CustomFieldValueWrapperString))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(CustomFieldValueWrapperInt))]
public abstract class CustomFieldValueWrapper {
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("CustomFieldValueWrapperString", "http://www.dommoni.com/ROUNDTABLE")]
public class CustomFieldValueWrapperString : CustomFieldValueWrapper {
    
    /// <remarks/>
    public string value;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("CustomFieldValueWrapperInt", "http://www.dommoni.com/ROUNDTABLE")]
public class CustomFieldValueWrapperInt : CustomFieldValueWrapper {
    
    /// <remarks/>
    public int value;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("TaskStatus", "http://www.dommoni.com/ROUNDTABLE")]
public class TaskStatus {
    
    /// <remarks/>
    public int id;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public string title;
}

/// <remarks/>
[System.Xml.Serialization.SoapTypeAttribute("Schedule", "http://www.dommoni.com/ROUNDTABLE")]
public class Schedule : NotificationContextObject {
    
    /// <remarks/>
    public int accessMode;
    
    /// <remarks/>
    public Comment[] comments;
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public System.DateTime scheduleEndDate;
    
    /// <remarks/>
    public ScheduleItem[] scheduleItems;
    
    /// <remarks/>
    public System.DateTime scheduleStartDate;
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
[System.Xml.Serialization.SoapTypeAttribute("Task", "http://www.dommoni.com/ROUNDTABLE")]
public class Task : NotificationContextObject {
    
    /// <remarks/>
    public int assignedTo;
    
    /// <remarks/>
    public int createdBy;
    
    /// <remarks/>
    public System.DateTime createdOn;
    
    /// <remarks/>
    public TaskStatus currentStatus;
    
    /// <remarks/>
    public CustomField[] customFields;
    
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
    public NamedFieldCollection[] namedFieldCollections;
    
    /// <remarks/>
    public int percentComplete;
    
    /// <remarks/>
    public int projectId;
    
    /// <remarks/>
    public System.DateTime startDate;
    
    /// <remarks/>
    public TaskReminder taskReminder;
    
    /// <remarks/>
    public string title;
}
