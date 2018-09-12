package com.dommoni.roundtable.is.ui.ganttpanel;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.dommoni.roundtable.is.model.ScheduleTask;

/*
 * Created on May 22, 2005
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
public class LineModel 
{
	private List lines;
	public int lineWidths;

	public LineModel()
	{
		lines = new Vector();
	}
	
	/**
	 * Adds a line to the line model. If the Y-Coordinates of the 
	 * line is not set, determines next line in the sequence and
	 * sets y-coordinates to that.
	 *
	 */
	public Line addLine(Line line) 
	{
		if(line.yMax == 0 && line.yMin == 0)
		{
			// Line position was never set.
			if(lines.size() > 0)
			{
				Line lGreatest = null;
				for(int i = 0; i < lines.size(); i++)
				{
					Line l = (Line)lines.get(i);
					if(lGreatest == null || l.yMax > lGreatest.yMax)
					{
						lGreatest = l;
					}
				}
				
				line.yMin = lGreatest.yMax;
				line.yMax = line.yMin + lineWidths;
			}
			else
			{
				line.yMin = 0;
				line.yMax = lineWidths;
			}
		}
		
		lines.add(line);
		
		return line;
	}
   
   public void removeLine(Line line)
      throws LineNotFoundException
   {
      if (lines.remove(line))
      {
         Line[] arrLines = (Line[])lines.toArray(new Line[lines.size()]);
         lines.clear();
         
         for(int i = 0; i < arrLines.length; i++)
         {
            // setting the ordinal now doesnt really matter anyway... 
            arrLines[i].yMin = 0;
            arrLines[i].yMax = 0;
            addLine(arrLines[i]);
         }
      }
      else
      {
         // TODO: Throw an Exception if its not found.
         throw new LineNotFoundException(line);
      }
   }
	
	public Line getLineFromYCoord(int y)
	{
		for(int i = 0; i < lines.size(); i++)
		{
			Line line = (Line)lines.get(i);
			if(line.yMin + GanttPanel.headerHeight < y && line.yMax + GanttPanel.headerHeight > y)
				return line;
		}
		return null;
	}
	
	public int size()
	{
		return lines.size();
	}
	
	public Line getLine(int position)
	{
		return (Line)lines.get(position);
	}
   
   public List getLines()
   {
      return this.lines;
   }
	
	public Collection getTaskCollection()
	{
		List tasks = new Vector();
		for(int i = 0; i < lines.size(); i++)
		{
			Line line = (Line)lines.get(i);
			if(line.task != null)
				tasks.add(line.task);
		}
		return tasks;
	}
   
   public Line getLineForTask(GanttTask task) 
   {
      for (int i = 0; i < lines.size(); i++)
      {
         Line line = (Line)lines.get(i);
         if (line.task != null && line.task.equals(task))
         {
            return line;
         }
      }
      return null;
   }
}
