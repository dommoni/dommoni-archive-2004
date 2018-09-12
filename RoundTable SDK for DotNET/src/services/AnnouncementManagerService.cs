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
using RoundTable.ProjectServer.Services.AnnoucementManager;

/// <remarks/>
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Web.Services.WebServiceBindingAttribute(Name="AnnouncementManagerSoapBinding", Namespace="http://localhost:8080/ProjectServer/services/AnnouncementManager")]
public class AnnouncementManagerService : System.Web.Services.Protocols.SoapHttpClientProtocol, IAnnouncementManager {
    
	public SessionHeader sessionHeader = null;

    /// <remarks/>
    public AnnouncementManagerService(string ipAddr, int port, string sessionId) {
        this.Url = "http://"+ipAddr+":"+port+"/ProjectServer/services/AnnouncementManager";
		sessionHeader = new SessionHeader();
		sessionHeader.SessionID = sessionId;
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://announcementManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AnnouncementManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("addAnnouncementReturn")]
    public int addAnnouncement(Announcement announcement) {
        object[] results = this.Invoke("addAnnouncement", new object[] {
                    announcement});
        return ((int)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginaddAnnouncement(Announcement announcement, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("addAnnouncement", new object[] {
                    announcement}, callback, asyncState);
    }
    
    /// <remarks/>
    public int EndaddAnnouncement(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((int)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://announcementManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AnnouncementManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	public void dropAnnouncement(int announcementId) {
        this.Invoke("dropAnnouncement", new object[] {
                    announcementId});
    }
    
    /// <remarks/>
    public System.IAsyncResult BegindropAnnouncement(int announcementId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("dropAnnouncement", new object[] {
                    announcementId}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EnddropAnnouncement(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://announcementManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AnnouncementManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	public void modifyAnnouncement(Announcement announcement) {
        this.Invoke("modifyAnnouncement", new object[] {
                    announcement});
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginmodifyAnnouncement(Announcement announcement, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("modifyAnnouncement", new object[] {
                    announcement}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EndmodifyAnnouncement(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://announcementManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AnnouncementManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("getAnnouncementReturn")]
    public Announcement getAnnouncement(int announcementId) {
        object[] results = this.Invoke("getAnnouncement", new object[] {
                    announcementId});
        return ((Announcement)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAnnouncement(int announcementId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAnnouncement", new object[] {
                    announcementId}, callback, asyncState);
    }
    
    /// <remarks/>
    public Announcement EndgetAnnouncement(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Announcement)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://announcementManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AnnouncementManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("getAllAnnouncementsForProjectReturn")]
    public Announcement[] getAllAnnouncementsForProject(int projectId) {
        object[] results = this.Invoke("getAllAnnouncementsForProject", new object[] {
                    projectId});
        return ((Announcement[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAllAnnouncementsForProject(int projectId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAllAnnouncementsForProject", new object[] {
                    projectId}, callback, asyncState);
    }
    
    /// <remarks/>
    public Announcement[] EndgetAllAnnouncementsForProject(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Announcement[])(results[0]));
    }
}
/*
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
*/