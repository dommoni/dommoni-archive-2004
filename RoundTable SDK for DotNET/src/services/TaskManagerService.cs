using System.Diagnostics;
using System.Xml.Serialization;
using System;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Web.Services;

using RoundTable;
using RoundTable.ProjectServer.Services.TaskManager;


/// <remarks/>
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Web.Services.WebServiceBindingAttribute(Name="TaskManagerSoapBinding", Namespace="http://localhost:8080/ProjectServer/services/TaskManager")]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(Comment))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(BinaryAttachment))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(MeetingNoteItem))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(MeetingFollowupItem))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(MeetingAgendaItem))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(DiscussionMessage))]
[System.Xml.Serialization.SoapIncludeAttribute(typeof(NotificationContextObject))]
public class TaskManagerService : System.Web.Services.Protocols.SoapHttpClientProtocol, ITaskManager
{
    public SessionHeader sessionHeader = null;

	/// <remarks/>
	public TaskManagerService(string ipAddr, int port, string sessionId) 
	{
		this.Url = "http://"+ipAddr+":"+port+"/ProjectServer/services/TaskManager";
		sessionHeader = new SessionHeader();
		sessionHeader.SessionID = sessionId;
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("addTaskReturn")]
	public int addTask(Task task) 
	{
		object[] results = this.Invoke("addTask", new object[] {
																   task});
		return ((int)(results[0]));
	}
    
	/// <remarks/>
	public System.IAsyncResult BeginaddTask(Task task, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("addTask", new object[] {
															task}, callback, asyncState);
	}
    
	/// <remarks/>
	public int EndaddTask(System.IAsyncResult asyncResult) 
	{
		object[] results = this.EndInvoke(asyncResult);
		return ((int)(results[0]));
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	public void dropTask(int taskId) 
	{
		this.Invoke("dropTask", new object[] {
												 taskId});
	}
    
	/// <remarks/>
	public System.IAsyncResult BegindropTask(int taskId, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("dropTask", new object[] {
															 taskId}, callback, asyncState);
	}
    
	/// <remarks/>
	public void EnddropTask(System.IAsyncResult asyncResult) 
	{
		this.EndInvoke(asyncResult);
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	public void modifyTask(Task task) 
	{
		this.Invoke("modifyTask", new object[] {
												   task});
	}
    
	/// <remarks/>
	public System.IAsyncResult BeginmodifyTask(Task task, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("modifyTask", new object[] {
															   task}, callback, asyncState);
	}
    
	/// <remarks/>
	public void EndmodifyTask(System.IAsyncResult asyncResult) 
	{
		this.EndInvoke(asyncResult);
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("getTaskReturn")]
	public Task getTask(int taskId) 
	{
		object[] results = this.Invoke("getTask", new object[] {
																   taskId});
		return ((Task)(results[0]));
	}
    
	/// <remarks/>
	public System.IAsyncResult BegingetTask(int taskId, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("getTask", new object[] {
															taskId}, callback, asyncState);
	}
    
	/// <remarks/>
	public Task EndgetTask(System.IAsyncResult asyncResult) 
	{
		object[] results = this.EndInvoke(asyncResult);
		return ((Task)(results[0]));
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("getAllTasksReturn")]
	public Task[] getAllTasks() 
	{
		object[] results = this.Invoke("getAllTasks", new object[0]);
		return ((Task[])(results[0]));
	}
    
	/// <remarks/>
	public System.IAsyncResult BegingetAllTasks(System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("getAllTasks", new object[0], callback, asyncState);
	}
    
	/// <remarks/>
	public Task[] EndgetAllTasks(System.IAsyncResult asyncResult) 
	{
		object[] results = this.EndInvoke(asyncResult);
		return ((Task[])(results[0]));
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("getAllTasksForProjectReturn")]
	public Task[] getAllTasksForProject(int projectId) 
	{
		object[] results = this.Invoke("getAllTasksForProject", new object[] {
																				 projectId});
		return ((Task[])(results[0]));
	}
    
	/// <remarks/>
	public System.IAsyncResult BegingetAllTasksForProject(int projectId, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("getAllTasksForProject", new object[] {
																		  projectId}, callback, asyncState);
	}
    
	/// <remarks/>
	public Task[] EndgetAllTasksForProject(System.IAsyncResult asyncResult) 
	{
		object[] results = this.EndInvoke(asyncResult);
		return ((Task[])(results[0]));
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("addTaskStatusReturn")]
	public int addTaskStatus(TaskStatus status) 
	{
		object[] results = this.Invoke("addTaskStatus", new object[] {
																		 status});
		return ((int)(results[0]));
	}
    
	/// <remarks/>
	public System.IAsyncResult BeginaddTaskStatus(TaskStatus status, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("addTaskStatus", new object[] {
																  status}, callback, asyncState);
	}
    
	/// <remarks/>
	public int EndaddTaskStatus(System.IAsyncResult asyncResult) 
	{
		object[] results = this.EndInvoke(asyncResult);
		return ((int)(results[0]));
	}
    
	/// <remarks/>
	[System.Web.Services.WebMethodAttribute(MessageName="addTaskStatus1")]
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[return: System.Xml.Serialization.SoapElementAttribute("addTaskStatusReturn")]
	public int addTaskStatus(TaskStatus status, int projectId) 
	{
		object[] results = this.Invoke("addTaskStatus1", new object[] {
																		  status,
																		  projectId});
		return ((int)(results[0]));
	}
    
	/// <remarks/>
	public System.IAsyncResult BeginaddTaskStatus1(TaskStatus status, int projectId, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("addTaskStatus1", new object[] {
																   status,
																   projectId}, callback, asyncState);
	}
    
	/// <remarks/>
	public int EndaddTaskStatus1(System.IAsyncResult asyncResult) 
	{
		object[] results = this.EndInvoke(asyncResult);
		return ((int)(results[0]));
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	public void dropTaskStatus(int statusId) 
	{
		this.Invoke("dropTaskStatus", new object[] {
													   statusId});
	}
    
	/// <remarks/>
	public System.IAsyncResult BegindropTaskStatus(int statusId, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("dropTaskStatus", new object[] {
																   statusId}, callback, asyncState);
	}
    
	/// <remarks/>
	public void EnddropTaskStatus(System.IAsyncResult asyncResult) 
	{
		this.EndInvoke(asyncResult);
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	public void modifyTaskStatus(TaskStatus status) 
	{
		this.Invoke("modifyTaskStatus", new object[] {
														 status});
	}
    
	/// <remarks/>
	public System.IAsyncResult BeginmodifyTaskStatus(TaskStatus status, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("modifyTaskStatus", new object[] {
																	 status}, callback, asyncState);
	}
    
	/// <remarks/>
	public void EndmodifyTaskStatus(System.IAsyncResult asyncResult) 
	{
		this.EndInvoke(asyncResult);
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("getTaskStatusReturn")]
	public TaskStatus getTaskStatus(int statusId) 
	{
		object[] results = this.Invoke("getTaskStatus", new object[] {
																		 statusId});
		return ((TaskStatus)(results[0]));
	}
    
	/// <remarks/>
	public System.IAsyncResult BegingetTaskStatus(int statusId, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("getTaskStatus", new object[] {
																  statusId}, callback, asyncState);
	}
    
	/// <remarks/>
	public TaskStatus EndgetTaskStatus(System.IAsyncResult asyncResult) 
	{
		object[] results = this.EndInvoke(asyncResult);
		return ((TaskStatus)(results[0]));
	}
    
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("getAllTaskStatusForProjectReturn")]
	public TaskStatus[] getAllTaskStatusForProject(int projectId) 
	{
		object[] results = this.Invoke("getAllTaskStatusForProject", new object[] {
																					  projectId});
		return ((TaskStatus[])(results[0]));
	}
    
	/// <remarks/>
	public System.IAsyncResult BegingetAllTaskStatusForProject(int projectId, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("getAllTaskStatusForProject", new object[] {
																			   projectId}, callback, asyncState);
	}
    
	/// <remarks/>
	public TaskStatus[] EndgetAllTaskStatusForProject(System.IAsyncResult asyncResult) 
	{
		object[] results = this.EndInvoke(asyncResult);
		return ((TaskStatus[])(results[0]));
	}
 
	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("addCommentForTaskReturn")]
	public int addCommentForTask(Task task, Comment comment) 
	{
		object[] results = this.Invoke("addCommentForTask", new object[] {
																			 task,
																			 comment});
		return ((int)(results[0]));
	}
    
	/// <remarks/>
	public System.IAsyncResult BeginaddCommentForTask(Task task, Comment comment, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("addCommentForTask", new object[] {
																	  task,
																	  comment}, callback, asyncState);
	}
    
	/// <remarks/>
	public int EndaddCommentForTask(System.IAsyncResult asyncResult) 
	{
		object[] results = this.EndInvoke(asyncResult);
		return ((int)(results[0]));
	}


	/// <remarks/>
	[System.Web.Services.Protocols.SoapRpcMethodAttribute("", RequestNamespace="http://taskManager.services.projectServer.roundtable.dommoni.com", ResponseNamespace="http://localhost:8080/ProjectServer/services/TaskManager")]
	[SoapHeader("sessionHeader")]
	[SessionHandler()]
	[return: System.Xml.Serialization.SoapElementAttribute("getCommentsForTaskReturn")]
	public Comment[] getCommentsForTask(Task task) 
	{
		object[] results = this.Invoke("getCommentsForTask", new object[] {
																			  task});
		return ((Comment[])(results[0]));
	}
    
	/// <remarks/>
	public System.IAsyncResult BegingetCommentsForTask(Task task, System.AsyncCallback callback, object asyncState) 
	{
		return this.BeginInvoke("getCommentsForTask", new object[] {
																	   task}, callback, asyncState);
	}
    
	/// <remarks/>
	public Comment[] EndgetCommentsForTask(System.IAsyncResult asyncResult) 
	{
		object[] results = this.EndInvoke(asyncResult);
		return ((Comment[])(results[0]));
	}
}