package com.dommoni.roundtable.is.model;

import java.util.Calendar;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.ScheduleItem;
import com.dommoni.roundtable.is.ui.ganttpanel.GanttTask;

public class ScheduleTask extends ScheduleItem implements GanttTask
{
   int width;
   boolean highlighted;
   int x_coord;
   int y_coord;
   boolean selected;
   boolean pinched;
   boolean wasDragged;
   
   public ScheduleTask()
   {
   }
   
   public ScheduleTask(ScheduleItem si)
   {
      setId(si.getId()); 
      setTitle(si.getTitle()); 
      setCreatedBy(si.getCreatedBy()); 
      setCreatedOn(si.getCreatedOn()); 
      setStartDate(si.getStartDate()); 
      setEndDate(si.getEndDate()); 
      setDuration(si.getDuration()); 
      setPercentComplete(si.getPercentComplete()); 
      setPriority(si.getPriority()); 
      setResources(si.getResources()); 
      setDescription(si.getDescription()); 
      setOrdinal(si.getOrdinal());
      setComments(si.getComments()); 
   }
   
   public String getName()
   {
      return getTitle();
   }
   
   public void setName(String name)
   {
      setTitle(name);
   }
   
   public int getWidth()
   {
      return this.width;
   }
   
   public void setWidth(int width)
   {
      this.width = width;
   }
   
   public boolean getHighlighted()
   {
      return this.highlighted;
   }
   
   public void setHighlighted(boolean highlighted)
   {
      this.highlighted = highlighted;
   }
   
   public int getXCoord()
   {
      return this.x_coord;
   }
   
   public void setXCoord(int xcoord)
   {
      this.x_coord = xcoord;
   }
   
   public int getYCoord()
   {
      return this.y_coord;
   }
   
   public void setYCoord(int ycoord)
   {
      this.y_coord = ycoord;
   }
   
   public boolean getSelected()
   {
      return this.selected;
   }
   
   public void setSelected(boolean selected)
   {
      this.selected = selected;
   }
   
   public boolean getPinched()
   {
      return this.pinched;
   }
   
   public void setPinched(boolean pinched)
   {
      this.pinched = pinched;
   }
   
   public boolean getWasDragged()
   {
      return this.wasDragged;
   }
   
   public void setWasDragged(boolean wasDragged)
   {
      this.wasDragged = wasDragged;
   }
}
