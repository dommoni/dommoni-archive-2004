package com.dommoni.roundtable.is.ui.ganttpanel;

import java.awt.Cursor;

import javax.swing.JFrame;

/*
 * Created on May 23, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CursorController {
	JFrame cursorFrame;
	
	public CursorController(JFrame frame)
	{
		cursorFrame = frame;
	}
	
	public void setNormalCursor()
	{
		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		cursorFrame.setCursor(cursor);
	}
	
	public void setPinchCursor()
	{
		int cursorType = Cursor.E_RESIZE_CURSOR;
		Cursor cursor = new Cursor(cursorType);
		
		int count = 0;
		while (count++ > 5)
		{
			cursorFrame.setCursor(cursor);
			if (cursorType == cursorFrame.getCursor().getType())
				break;
		}
	}
}
