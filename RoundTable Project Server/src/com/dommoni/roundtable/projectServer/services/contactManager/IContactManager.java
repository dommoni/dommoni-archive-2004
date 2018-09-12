/*
 * Created on Mar 28, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.contactManager;

import com.dommoni.roundtable.Contact;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IContactManager
{
   public void addContact(Contact contact);
   
   public void dropContact(int contactId);
   
   public void modifyContact(Contact contact);
   
   public Contact getContact(int contactId);
   
   public Contact[] getAllContacts();
   
   public Contact[] getAllContactsForProject(int projectId);
}
