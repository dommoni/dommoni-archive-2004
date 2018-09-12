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
[System.Web.Services.WebServiceBindingAttribute(Name="RecentChangesManagerSoapBinding", Namespace="http://localhost:8080/ProjectServer/services/RecentChangesManager")]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(RecentChange))]
public class RecentChangesManagerService : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    /// <remarks/>
    public RecentChangesManagerService() {
        this.Url = "http://localhost:8080/ProjectServer/services/RecentChangesManager";
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://recentChangesManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/RecentChangesManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getRecentChangesForProjectReturn")]
    public RecentChange[] getRecentChangesForProject(int projectId) {
        object[] results = this.Invoke("getRecentChangesForProject", new object[] {
                    projectId});
        return ((RecentChange[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetRecentChangesForProject(int projectId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getRecentChangesForProject", new object[] {
                    projectId}, callback, asyncState);
    }
    
    /// <remarks/>
    public RecentChange[] EndgetRecentChangesForProject(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((RecentChange[])(results[0]));
    }
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
