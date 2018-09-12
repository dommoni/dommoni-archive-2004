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
[System.Web.Services.WebServiceBindingAttribute(Name="AccountManagerSoapBinding", Namespace="http://localhost:8080/ProjectServer/services/AccountManager")]
public class AccountManagerService : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    /// <remarks/>
    public AccountManagerService() {
        this.Url = "http://localhost:8080/ProjectServer/services/AccountManager";
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAccountReturn")]
    public Account getAccount(int accountId) {
        object[] results = this.Invoke("getAccount", new object[] {
                    accountId});
        return ((Account)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAccount(int accountId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAccount", new object[] {
                    accountId}, callback, asyncState);
    }
    
    /// <remarks/>
    public Account EndgetAccount(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Account)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("addAccountReturn")]
    public int addAccount(Account account) {
        object[] results = this.Invoke("addAccount", new object[] {
                    account});
        return ((int)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginaddAccount(Account account, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("addAccount", new object[] {
                    account}, callback, asyncState);
    }
    
    /// <remarks/>
    public int EndaddAccount(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((int)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    public void dropAccount(int accountId) {
        this.Invoke("dropAccount", new object[] {
                    accountId});
    }
    
    /// <remarks/>
    public System.IAsyncResult BegindropAccount(int accountId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("dropAccount", new object[] {
                    accountId}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EnddropAccount(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    public void modifyAccount(Account account) {
        this.Invoke("modifyAccount", new object[] {
                    account});
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginmodifyAccount(Account account, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("modifyAccount", new object[] {
                    account}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EndmodifyAccount(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAccountFromUsernameReturn")]
    public Account getAccountFromUsername(string username) {
        object[] results = this.Invoke("getAccountFromUsername", new object[] {
                    username});
        return ((Account)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAccountFromUsername(string username, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAccountFromUsername", new object[] {
                    username}, callback, asyncState);
    }
    
    /// <remarks/>
    public Account EndgetAccountFromUsername(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Account)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAllAccountsReturn")]
    public Account[] getAllAccounts() {
        object[] results = this.Invoke("getAllAccounts", new object[0]);
        return ((Account[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAllAccounts(System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAllAccounts", new object[0], callback, asyncState);
    }
    
    /// <remarks/>
    public Account[] EndgetAllAccounts(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Account[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAllAccountsForProjectReturn")]
    public Account[] getAllAccountsForProject(int projectId) {
        object[] results = this.Invoke("getAllAccountsForProject", new object[] {
                    projectId});
        return ((Account[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAllAccountsForProject(int projectId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAllAccountsForProject", new object[] {
                    projectId}, callback, asyncState);
    }
    
    /// <remarks/>
    public Account[] EndgetAllAccountsForProject(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Account[])(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    public void modifyAccountSettings(AccountSettings accountSettings) {
        this.Invoke("modifyAccountSettings", new object[] {
                    accountSettings});
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginmodifyAccountSettings(AccountSettings accountSettings, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("modifyAccountSettings", new object[] {
                    accountSettings}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EndmodifyAccountSettings(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAccountSettingsReturn")]
    public AccountSettings getAccountSettings(int accountId) {
        object[] results = this.Invoke("getAccountSettings", new object[] {
                    accountId});
        return ((AccountSettings)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAccountSettings(int accountId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAccountSettings", new object[] {
                    accountId}, callback, asyncState);
    }
    
    /// <remarks/>
    public AccountSettings EndgetAccountSettings(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((AccountSettings)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    public void modifyAccountProfile(AccountProfile accountProfile) {
        this.Invoke("modifyAccountProfile", new object[] {
                    accountProfile});
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginmodifyAccountProfile(AccountProfile accountProfile, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("modifyAccountProfile", new object[] {
                    accountProfile}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EndmodifyAccountProfile(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAccountProfileReturn")]
    public AccountProfile getAccountProfile(int accountId) {
        object[] results = this.Invoke("getAccountProfile", new object[] {
                    accountId});
        return ((AccountProfile)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAccountProfile(int accountId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAccountProfile", new object[] {
                    accountId}, callback, asyncState);
    }
    
    /// <remarks/>
    public AccountProfile EndgetAccountProfile(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((AccountProfile)(results[0]));
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    public void addAccountContact(AccountContact contact) {
        this.Invoke("addAccountContact", new object[] {
                    contact});
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginaddAccountContact(AccountContact contact, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("addAccountContact", new object[] {
                    contact}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EndaddAccountContact(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    public void dropAccountContact(int accountContactId) {
        this.Invoke("dropAccountContact", new object[] {
                    accountContactId});
    }
    
    /// <remarks/>
    public System.IAsyncResult BegindropAccountContact(int accountContactId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("dropAccountContact", new object[] {
                    accountContactId}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EnddropAccountContact(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    public void modifyAccountContact(AccountContact contact) {
        this.Invoke("modifyAccountContact", new object[] {
                    contact});
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginmodifyAccountContact(AccountContact contact, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("modifyAccountContact", new object[] {
                    contact}, callback, asyncState);
    }
    
    /// <remarks/>
    public void EndmodifyAccountContact(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://accountManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/AccountManager")]
    [return: System.Xml.Serialization.SoapElementAttribute("getAccountContactReturn")]
    public AccountContact getAccountContact(int accountId) {
        object[] results = this.Invoke("getAccountContact", new object[] {
                    accountId});
        return ((AccountContact)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BegingetAccountContact(int accountId, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getAccountContact", new object[] {
                    accountId}, callback, asyncState);
    }
    
    /// <remarks/>
    public AccountContact EndgetAccountContact(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((AccountContact)(results[0]));
    }
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
