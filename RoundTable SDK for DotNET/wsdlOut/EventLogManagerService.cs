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
[System.Web.Services.WebServiceBindingAttribute(Name="EventLogManagerSoapBinding", Namespace="http://localhost:8080/ProjectServer/services/EventLogManager")]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(EventLogEntry))]
public class EventLogManagerService : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    /// <remarks/>
    public EventLogManagerService() {
        this.Url = "http://localhost:8080/ProjectServer/services/EventLogManager";
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://eventlogManager.logging.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/EventLogManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getEventLogsForAccountReturn")]
    public EventLogEntry[] getEventLogsForAccount(int accountId) {
        object[] results = this.Invoke("getEventLogsForAccount", new object[] {
                    accountId});
        return ((EventLogEntry[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetEventLogsForAccount(int accountId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getEventLogsForAccount", new object[] {
                    accountId}, callback, asyncState);
    }
    
    /// <remarks/>
    public EventLogEntry[] EndgetEventLogsForAccount(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((EventLogEntry[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://eventlogManager.logging.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/EventLogManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getEventLogsForProjectReturn")]
    public EventLogEntry[] getEventLogsForProject(int projectId) {
        object[] results = this.Invoke("getEventLogsForProject", new object[] {
                    projectId});
        return ((EventLogEntry[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetEventLogsForProject(int projectId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getEventLogsForProject", new object[] {
                    projectId}, callback, asyncState);
    }
    
    /// <remarks/>
    public EventLogEntry[] EndgetEventLogsForProject(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((EventLogEntry[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://eventlogManager.logging.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/EventLogManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getEventLogsFromQueryStringReturn")]
    public EventLogEntry[] getEventLogsFromQueryString(string queryString) {
        object[] results = this.Invoke("getEventLogsFromQueryString", new object[] {
                    queryString});
        return ((EventLogEntry[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetEventLogsFromQueryString(string queryString, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getEventLogsFromQueryString", new object[] {
                    queryString}, callback, asyncState);
    }
    
    /// <remarks/>
    public EventLogEntry[] EndgetEventLogsFromQueryString(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((EventLogEntry[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://eventlogManager.logging.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/EventLogManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAllEventLogsReturn")]
    public EventLogEntry[] getAllEventLogs() {
        object[] results = this.Invoke("getAllEventLogs", new object[0]);
        return ((EventLogEntry[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAllEventLogs(System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAllEventLogs", new object[0], callback, asyncState);
    }
    
    /// <remarks/>
    public EventLogEntry[] EndgetAllEventLogs(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((EventLogEntry[])(results[0]));
    }
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
