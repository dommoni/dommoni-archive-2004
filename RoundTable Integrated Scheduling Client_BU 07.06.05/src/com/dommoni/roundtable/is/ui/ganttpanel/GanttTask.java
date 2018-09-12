package com.dommoni.roundtable.is.ui.ganttpanel;

import java.util.Calendar;

/**
 * Property Interface for GanttPanel specific elements.
 * GanttPanel should restrict itself to using task properties
 * defined only in this interface to enhance potetial portability, etc.
 * 
 * @author Brian Abbott
 *
 */
public interface GanttTask
{
   public String getName(); 
   public void setName(String name);
   
   public int getXCoord();
   public void setXCoord(int xcoord);
   
   public int getYCoord();
   public void setYCoord(int ycoord);
   
   public int getWidth();
   public void setWidth(int width);
   
   public boolean getHighlighted();
   public void setHighlighted(boolean highlighted);
   
   public boolean getSelected();
   public void setSelected(boolean selected);
   
   public boolean getPinched();
   public void setPinched(boolean pinched);
   
   public boolean getWasDragged();
   public void setWasDragged(boolean wasDragged);
   
   public Calendar getStartDate();
   public void setStartDate(Calendar startDate);
   
   public Calendar getEndDate();
   public void setEndDate(Calendar endDate);
   
   /**
    * Duration stays static across zoom operations. Zoom
    * uses duration to establish the x/y/width values across
    * zooms.
    */
   public float getDuration();
   public void setDuration(float duration);
}
