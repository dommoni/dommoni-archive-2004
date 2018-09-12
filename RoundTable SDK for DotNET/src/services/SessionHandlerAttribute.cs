/*
 * $File$
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;
using System.Web.Services.Protocols;

/// <summary>
/// Summary description for SessionHandlerAttribute.
/// </summary>

[AttributeUsage(AttributeTargets.Method)]
public class SessionHandlerAttribute : SoapExtensionAttribute
{
	private int priority = 0;
	
	public override Type ExtensionType 
	{
		get { return typeof (SessionHandlerExtension); }
	}

	public override int Priority 
	{
		get { return priority; }
		set { priority = value; }
	}
}

