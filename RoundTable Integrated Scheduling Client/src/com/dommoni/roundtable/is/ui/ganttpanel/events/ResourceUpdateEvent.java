package com.dommoni.roundtable.is.ui.ganttpanel.events;

import java.util.EventObject;

import com.dommoni.roundtable.is.model.ScheduleTask;

public class ResourceUpdateEvent extends EventObject
{
   public ResourceUpdateEvent(ScheduleTask task)
   {
      super(task);
   }
}
