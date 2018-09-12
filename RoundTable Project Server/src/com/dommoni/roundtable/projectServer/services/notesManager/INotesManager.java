/*
 * Created on Mar 30, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.notesManager;

import com.dommoni.roundtable.Note;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface INotesManager
{
   public void addNote(Note note);
   
   public void dropNote(int noteId);
   
   public void modifyNote(Note note);
   
   public Note getNote(int noteId);
   
   public Note[] getAllNotes();
   
   public Note[] getAllNotesForProject(int projectId);
   
   public Note[] getAllNotesForAccount(int accountId);
}
