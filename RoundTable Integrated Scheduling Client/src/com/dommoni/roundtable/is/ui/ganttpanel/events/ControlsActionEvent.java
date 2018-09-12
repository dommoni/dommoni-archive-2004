package com.dommoni.roundtable.is.ui.ganttpanel.events;

import java.util.Calendar;
import java.util.EventObject;

import sun.security.krb5.internal.crypto.t;

import com.dommoni.roundtable.Schedule;

public class ControlsActionEvent extends EventObject
{
   private Schedule schedule;
   private Calendar when;
   
   public ControlsActionEvent(Schedule schedule) 
   {
      super(schedule);
      this.when = Calendar.getInstance();
   }
   
   public Schedule getSchedule()
   {
      return this.schedule;
   }
   
   public Calendar getWhen()
   {
      return this.when;
   }
}
