package com.dommoni.roundtable.is.ui.ganttpanel.events;

import java.util.EventObject;

public class ZoomActionEvent extends EventObject
{
   public static final int ZOOM_IN = 1;
   public static final int ZOOM_OUT = 2;
   
   private int zoomFrom;
   private int zoomTo;
   private int type;
   private long when;
   
   public ZoomActionEvent(Object source, int from, int to, int type)
   {
      super(source);
      
      this.zoomFrom = from;
      this.zoomTo = to;
      this.type = type;
      this.when = System.currentTimeMillis();
   }
   
   public int getZoomFrom()
   {
      return zoomFrom;
   }
   
   public void setZoomFrom(int zoomFrom)
   {
      this.zoomFrom = zoomFrom;
   }
   
   public int getZoomTo()
   {
      return zoomTo;
   }
   
   public void setZoomTo(int zoomTo)
   {
      this.zoomTo = zoomTo;
   }
   
   public long getWhen()
   {
      return when;
   }
   
   public void setWhen(long when)
   {
      this.when = when;
   }
}
