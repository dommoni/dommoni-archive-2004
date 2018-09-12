package com.dommoni.roundtable.is.ui.ganttpanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Renderer;
import javax.swing.RepaintManager;

import sun.security.krb5.internal.crypto.t;

import com.dommoni.roundtable.is.ui.ganttpanel.events.TaskActionEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.TaskActionListener;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ZoomActionEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ZoomActionListener;


public class GanttPanel extends JPanel 
   implements MouseListener, MouseMotionListener, MouseWheelListener
{
	//-------------------------------------------------------------------------
	// Local Variables
	//
	
	// Public: 
	public LineModel lineModel;	
	public CursorController cursorController;

	/**
	 * This variable represents the starting time to display in the 
	 * viewing area. This time is displayed in the first time column. 
	 * The view-mode represents the offset to add to Each following 
	 * column.
	 */
	//public Calendar clCurrentlyDisplayedTime;
   private Calendar clBeginTime;
   private Calendar clEndTime;
   private Calendar clViewTime;
	
	// Private:
	//private ControlCollection controlCollection;

	private int dragging_x_offset = 0;
	private int dragging_y_offset = 0;
	private int dragging_mode = DRAGGING_MODE_MOVE;
	
   // image for double-buffering screen drawing.
	private Image offScreenImage = null;
	
   // images used for gradients
	private Image img = null; // new ImageIcon("h0_sn100_l60.jpg").getImage();
	private Image imgLBlueGrad = null; // new ImageIcon("lblue_grad.jpg").getImage();
	private Image imgDBlueGrad = null; // new ImageIcon("blue_grad.jpg").getImage();
   private Image imgColGrad = null;
   private Image imgColGradSpacer = null;
   
   // TODO: Declare these as javax.swing.event.EventListenerList's
	private List taskActionListeners;
   private List zoomActionListeners;
   
   private VerticalScrollBar verticalScrollBar = null;
   private HorizontalScrollBar horizontalScrollBar = null;
   private int vScrollVal;
   private int hScrollVal;
   
   private int viewMode;
	
	//-------------------------------------------------------------------------
	// Static Variables 
	//
	public static final int VMODE_WEEK = 1;
	public static final int VMODE_MONTH = 2;
	public static final int VMODE_3MONTH = 3;
	public static final int VMODE_6MONTH = 4;
	
	public final static int DRAGGING_MODE_MOVE = 1;
	public final static int DRAGGING_MODE_PINCH = 2;
	
	// X-AXIS Limit of the Task-Column
	public static final int taskColumnOffset = 100;
	
	// Height of a task-gantt object in pixels
	public static final int taskHeight = 15;
	
   // total height (including space) consumed by the task Object.
   public static final int taskLineHeight = 19;
   
	// Margin of offset in task-name column.
	public static final int taskNameColumnMargin = 10; 
	
	// Height of headers.
	public static final int headerHeight = 15;	
	
	public GanttPanel(CursorController _cursorController, Map images)//ControlCollection cc, CursorController _cursorController)
	{
      //setLayout(null);
      
		lineModel = new LineModel();
		lineModel.lineWidths = taskLineHeight;
		
		//controlCollection = cc;
		cursorController = _cursorController;
		
		// Default to Week view. 
		this.viewMode = VMODE_WEEK;
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);//new Mouse(this));//, cc));
		this.addMouseMotionListener(this);//new MouseMotion(this));
      this.addMouseWheelListener(this);
      
      img = (Image)images.get("h0_sn100_l60.jpg");
      imgLBlueGrad = (Image)images.get("lblue_grad.jpg");
      imgDBlueGrad = (Image)images.get("blue_grad.jpg");
      imgColGrad = (Image)images.get("column_gradient.jpg");
      imgColGradSpacer = (Image)images.get("column_gradient_spacer.jpg");
      
      // Configure our Clocks.
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      clBeginTime = Calendar.getInstance();
      System.out.println("BeginTime: " + sdf.format(clBeginTime.getTime()));
      clViewTime = Calendar.getInstance();
      System.out.println("ViewTime: " + sdf.format(clViewTime.getTime()));
      clEndTime = Calendar.getInstance();
      // we always keep a minimum six month window.
      long mo6 = (1000 * 60);
      mo6 *= 60;
      mo6 *= 24;
      mo6 *= 30;
      mo6 *= 6;
      long time = clEndTime.getTimeInMillis() + 
         mo6;
      clEndTime.setTimeInMillis(time);
      
      //set(Calendar.MONTH, clEndTime.get(Calendar.MONTH) + 6);
      System.out.println("EndTime: " + sdf.format(clEndTime.getTime()));
      
      taskActionListeners = new Vector();
      zoomActionListeners = new Vector();
      
      horizontalScrollBar = new HorizontalScrollBar();
      add(horizontalScrollBar);
      
      verticalScrollBar = new VerticalScrollBar();
      add(verticalScrollBar);
	}
	
	public void paint(Graphics g)
	{
		if(offScreenImage == null || offScreenImage.getWidth(null) != getWidth() || 
				offScreenImage.getHeight(null) != getHeight())
		   offScreenImage = createImage(getWidth(), getHeight());
		
		Graphics2D offg = (Graphics2D)offScreenImage.getGraphics();
		drawLines(offg);
      drawTaskTitleColumn(offg);
      drawHeaders(offg);
      
      paintChildren(offg);
      
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	private void drawZoom(int view, Graphics2D g2)
	{
		//
		// X-Axis Time Columns drawn on top
		//
		Color lineColor = new Color(0xd9, 0xd9, 0xd9);
		g2.setColor(lineColor);
		
		int sp = getColumnSpacing();
		int width = this.getWidth();
		
		int curr_sp = sp + taskColumnOffset;
		while(curr_sp < width)
		{
			g2.drawLine(curr_sp, headerHeight + 1, curr_sp, getHeight());
			curr_sp += sp;
		}
	}
	
	public void drawHeaders(Graphics2D g2)
	{
		int sp = getColumnSpacing();
		int width = this.getWidth();
		
		int curr_sp = 0;
		
		while(curr_sp < width)
		{
			g2.drawImage(imgColGrad, curr_sp, 0, 1, 15, null);
			curr_sp += 1;
		}
		
		curr_sp = taskColumnOffset;
		while(curr_sp < width)
		{
			g2.drawImage(imgColGradSpacer, curr_sp, 0, 1, 15, null);
			curr_sp += sp;
		}
		
		// Draw closing line...
		g2.setColor(Color.DARK_GRAY);
		g2.drawLine(0, 15, width, 15);
		
		// Draw titles...
		Calendar clToday = Calendar.getInstance();
      g2.setFont(new Font("Arial", Font.PLAIN, 12));
		g2.drawString("Task Name", 4, 12);
		curr_sp = taskColumnOffset;
			
		if (getViewMode() == VMODE_WEEK)
		{
			Calendar clCurrentTime = (Calendar)this.clViewTime.clone();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yy");
          
			int dayOfYear = clCurrentTime.get(Calendar.DAY_OF_YEAR);
			while (curr_sp < width)
			{
				//clCurrentTime.set(Calendar.DAY_OF_YEAR, dayOfYear);
            
				g2.drawString(sdf.format(clCurrentTime.getTime()), curr_sp + 4, 12);
				curr_sp += sp;
				dayOfYear++;
            clCurrentTime.setTimeInMillis(clCurrentTime.getTimeInMillis() + 
                  (1000 * 60 * 60 * 24));
			}
		}
		else if (getViewMode() == VMODE_MONTH)
		{
			Calendar clCurrentTime = (Calendar)this.clViewTime.clone();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yy");
			
			int weekOfYear = clCurrentTime.get(Calendar.WEEK_OF_YEAR);
			while (curr_sp < width)
			{
				clCurrentTime.set(Calendar.WEEK_OF_YEAR, weekOfYear);
				g2.drawString(sdf.format(clCurrentTime.getTime()), curr_sp + 4, 12);
				curr_sp += sp;
				weekOfYear++;
			}
		}
		else if (getViewMode() == VMODE_3MONTH || getViewMode() == VMODE_6MONTH)
		{
			Calendar clCurrentTime = (Calendar)this.clViewTime.clone();
			SimpleDateFormat sdf = new SimpleDateFormat("MMMMM yy");
			
			int month = clCurrentTime.get(Calendar.MONTH);
			while (curr_sp < width)
			{
            clCurrentTime.set(Calendar.MONTH, month);
            g2.drawString(sdf.format(clCurrentTime.getTime()), curr_sp + 4, 12);
				curr_sp += sp;
				month++;
			}
		}
	}
	
   public void drawTaskTitleColumn(Graphics2D g2)
   {
      int y = headerHeight + 1;
      
      for(int i = 0; y < getHeight(); i++)
      {  
         // Draw Task-Title Column
         if(i % 2 == 0)
         {  
            g2.setColor(Color.DARK_GRAY);
            g2.drawRect(0, y - 1, taskColumnOffset, y + lineModel.lineWidths + 1);
            g2.setColor(Color.LIGHT_GRAY);
            g2.fillRect(0, y, taskColumnOffset, y + lineModel.lineWidths);
         }
         else
         {  
            g2.setColor(Color.DARK_GRAY);
            g2.drawRect(0, y, taskColumnOffset, y + lineModel.lineWidths);
            g2.setColor(Color.LIGHT_GRAY);
            g2.fillRect(0, y + 1, taskColumnOffset, y + lineModel.lineWidths - 1);
         }
         
         y += lineModel.lineWidths;
      }
      
      for(int i = 0; i < lineModel.size(); i++)
         drawLineTitle(lineModel.getLine(i), g2);
   }
   
	public void drawLines(Graphics2D g2)
	{
		//
		// Draws the White/Blue tabular lines
		//
		int y = headerHeight + 1;
		Color iTunesBlue = new Color(0xed, 0xf3, 0xfe);
		
		for(int i = 0; y < getHeight(); i++)
		{	
/*			// Draw Task-Title Column
			if(i % 2 == 0)
			{	
				g2.setColor(Color.DARK_GRAY);
				g2.drawRect(0, y - 1, taskColumnOffset, y + lineModel.lineWidths + 1);
				g2.setColor(Color.LIGHT_GRAY);
				g2.fillRect(0, y, taskColumnOffset, y + lineModel.lineWidths);
			}
			else
			{	
				g2.setColor(Color.DARK_GRAY);
				g2.drawRect(0, y, taskColumnOffset, y + lineModel.lineWidths);
				g2.setColor(Color.LIGHT_GRAY);
				g2.fillRect(0, y + 1, taskColumnOffset, y + lineModel.lineWidths - 1);
			}
	*/		
			// Draw main Gantt Area..
			//if(i % 2 == 0)
				g2.setColor(Color.WHITE);
			//else
			//	g2.setColor(iTunesBlue);

			g2.fillRect(0 + taskColumnOffset + 1, y, getWidth(), y + lineModel.lineWidths);
			
			y += lineModel.lineWidths;
		}
		
		drawZoom(viewMode, g2);
		
		//drewFirst = false;
		for(int i = 0; i < lineModel.size(); i++)
		{
			drawLine(lineModel.getLine(i), g2);
		}
		
		// Step through line-model and draw blank lines....
	}
	//boolean drewFirst = false;
	
	// Here is where THE REAL WORK is done.
	public void drawLine(Line line, Graphics2D g2)
	{
		if(line.task != null)
		{	
         drawLineTitle(line, g2);
			drawTask(line.task, g2);  
		}
	}
	
	private void drawTask(GanttTask task, Graphics2D g2)
	{
		Image grad = null;
		
		if(task.getXCoord() < (taskColumnOffset + 1))
			task.setXCoord(taskColumnOffset + 2);
		
		if (!task.getHighlighted() && !task.getSelected()) 
			grad = imgLBlueGrad;
		if(task.getSelected())
			grad = imgDBlueGrad;
		if(task.getHighlighted() && !task.getSelected())
			grad = img;
		
		int x = task.getXCoord() - hScrollVal;
		
		int endx = task.getXCoord() + getTaskPixelWidthForDuration(task) - hScrollVal;//task.x_coord + task.width;
		while (x < endx)
		{
			g2.drawImage(grad, x, (task.getYCoord() + 1) - vScrollVal, null);
			x++;
		}
	}
	
	public void drawLineTitle(Line line, Graphics g)
	{
		if (line != null && g != null)
		{	
			Graphics2D g2d = (Graphics2D)g;
			
			if(line.task.getSelected())
			{	
				g2d.setFont(new Font("Arial", Font.BOLD, 12));
			}
			else
			{
				g2d.setFont(new Font("Arial", Font.PLAIN, 12));
			}
			
			int yVal = (line.yMin + (lineModel.lineWidths /2) + 6);
						
			g2d.setColor(Color.WHITE);
			//if(!drewFirst)
			//{
				g2d.drawString(line.task.getName(), 10, 
					(line.yMin + headerHeight + 
               (lineModel.lineWidths /2) + 6) - 
               vScrollVal); 
			/*}
			else
			{
				g2d.drawString(line.task.name, 10, 
						(line.yMin + (lineModel.lineWidths /2) + 6)); 
				
			}*/
			// 6 is a magic number to push the string further down... it will
			// change depending on the font, font-size, line-width, etc.
		}
	}
	
   public void doLayout()
   {
      super.doLayout();
      
      Dimension d = getSize();
      Dimension d0 = getGanttArea();
      Dimension d1 = verticalScrollBar.getPreferredSize();
      Dimension d2 = horizontalScrollBar.getPreferredSize();

      int w = Math.max(d.width - d1.width-1, 0);
      int h = Math.max(d.height - d2.height-1, 0);
            
      verticalScrollBar.setBounds(
            getWidth() - verticalScrollBar.getWidth(), 
            headerHeight + 1, 
            d1.width, 
            getHeight() - d2.height - headerHeight);
      
      horizontalScrollBar.setBounds(
            taskColumnOffset + 1, 
            getHeight() - d2.height, 
            getWidth() - taskColumnOffset, 
            d2.height);

      /*
       * Horizontal Scrolling:
       * 
       * take maximum time - minimum time, divide by zoom units, that creats max-constraint.
       * block-increment could always be 1.
       * */
      
      
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      
      long t = clEndTime.getTimeInMillis()-clBeginTime.getTimeInMillis();
      long days = t / 1000 / 60/ 60/ 24;
      
      int timeUnits = 0;
      int viewTime = 0;
      if (this.viewMode == VMODE_WEEK) 
      {
         timeUnits = (int)days;
         viewTime = horizontalScrollBar.getValue();
      }
      else if (this.viewMode == VMODE_MONTH) 
      {
         timeUnits = (int)days/7;
         viewTime = horizontalScrollBar.getValue() * 7;
      }
      else if (this.viewMode == VMODE_3MONTH) 
      {
         timeUnits = (int)days / 30;
         viewTime = horizontalScrollBar.getValue() * 30;
      }
      else if (this.viewMode == VMODE_6MONTH) 
      {
         timeUnits = (int)days / 30;
         viewTime = horizontalScrollBar.getValue() * 30;
      }
      else // unknown, just set to days.
      {
         timeUnits = (int)days;
         viewTime = horizontalScrollBar.getValue();
      }
      
      //clViewTime.set(Calendar.DAY_OF_YEAR, 
      //      clBeginTime.get(Calendar.DAY_OF_YEAR) + viewTime);
      long de = viewTime;
      de *= (24 * 60 * 60 * 1000); // multiply this way to avoid neg values from int conversions
      clViewTime.setTimeInMillis(clBeginTime.getTimeInMillis() + de);
      
      //int xs = Math.max(d0.width - w, 0);
      //horizontalScrollBar.setMaximum(xs);
      horizontalScrollBar.setMaximum(timeUnits);
      horizontalScrollBar.setBlockIncrement(1);//xs / 5);
      horizontalScrollBar.setEnabled(true);//xs > 0);

      int ys = getMaxLines();
      verticalScrollBar.setMaximum(ys);
      verticalScrollBar.setBlockIncrement(getVisibleLineCount());
      verticalScrollBar.setEnabled(getMaxLines() > getVisibleLineCount());
      
      horizontalScrollBar.setVisibleAmount(horizontalScrollBar.getBlockIncrement());
      verticalScrollBar.setVisibleAmount(verticalScrollBar.getBlockIncrement());
   }
   
	public void newTaskDlg()
	{
		/*Task task = new Task();
		task.name = "Task-" + lineModel.size();
		task.x_coord = 10;
		task.duration = 0.5f;
		task.width = getTaskPixelWidthForDuration(0.5f);
		
		Calendar clToday = Calendar.getInstance();
		task.startTime = (Calendar)clToday.clone();
		
		clToday.set(Calendar.DAY_OF_YEAR, clToday.get(Calendar.DAY_OF_YEAR) + 1);
		task.endTime = (Calendar)clToday.clone(); 
		
		Line line = new Line();
		line.task = task;
		line = lineModel.addLine(line);
		
		line.task.setYCoord(line.yMin + 3 + headerHeight);
		
      paint(getGraphics());*/
	}
   
   public void addTask(GanttTask task) throws GanttException
   {
      task.setXCoord(10);
      task.setDuration(0.5f);
      task.setWidth(getTaskPixelWidthForDuration(0.5f));
      
      Calendar clToday = Calendar.getInstance();
      task.setStartDate((Calendar)clToday.clone());
      
      clToday.set(Calendar.DAY_OF_YEAR, clToday.get(Calendar.DAY_OF_YEAR) + 1);
      task.setEndDate((Calendar)clToday.clone()); 
      
      Line line = new Line();
      line.task = task;
      line = lineModel.addLine(line);
      
      line.task.setYCoord(line.yMin + 3 + headerHeight);
      
      TaskActionEvent event = 
         new TaskActionEvent(task, TaskActionEvent.TASK_ADDED);
      fireTaskActionEvent(event);
      
      paint(getGraphics());
      
      doLayout();
   }
   
   public void removeTask(GanttTask task) throws GanttException
   {
      
   }
	
	public int getViewMode()
	{
		return this.viewMode;
	}
	
	public void setViewMode(int _viewMode)
	{
		this.viewMode = _viewMode;
		
		paint(getGraphics());
	}
	
	public void zoomIn() 
	{
		// lame solution... 
		if (getViewMode() == VMODE_WEEK)
         return;
      
      int fromZoom = getViewMode();
	
      // Zoom-In: Year->6Mo->3Mo->Mo->Wk
		if(getViewMode() == VMODE_MONTH)
			setViewMode(VMODE_WEEK);
		else if(getViewMode() == VMODE_3MONTH)
			setViewMode(VMODE_MONTH);
		else if(getViewMode() == VMODE_6MONTH)
			setViewMode(VMODE_3MONTH);      
      
      // TODO: Re-Map each task's X/Y coordinate to meet the new zoom level.
      for (int i = 0; i < lineModel.size(); i++)
      {
         GanttTask t = lineModel.getLine(i).task;
      }
      
      ZoomActionEvent event = new ZoomActionEvent(this, fromZoom, 
            getViewMode(), ZoomActionEvent.ZOOM_IN);
      fireZoomActionEvent(event);
      
      doLayout();
   }
	
	public void zoomOut() 
	{
      if (getViewMode() == VMODE_WEEK)
         return;
      
      // Zoom-Out: Wk->Mo->3Mo->6Mo
      int fromZoom = getViewMode();
      
		if(getViewMode() == VMODE_WEEK)
			setViewMode(VMODE_MONTH);
		else if (getViewMode() == VMODE_MONTH)
			setViewMode(VMODE_3MONTH);
		else if (getViewMode() == VMODE_3MONTH)
			setViewMode(VMODE_6MONTH);

      // TODO: Re-Map each task's X/Y coordinate to meet the new zoom level.
      
      ZoomActionEvent event = new ZoomActionEvent(this, fromZoom, 
            getViewMode(), ZoomActionEvent.ZOOM_OUT);
      fireZoomActionEvent(event);
      
      doLayout();
	}
	
   /**
    * When certain events occur, the X Coordinates need to be re-mapped as they
    * are no longer correct. This function handles the remapping for all
    * elements in the model.
    * 
    * Note: Caller is responsible for repainting this instance of JPanel.
    * 
    * @param task
    * @return
    */
   public void remapXCoords()
   {
      List lines = lineModel.getLines();
      for (int i = 0; i < lines.size(); i++)
      {
         Line line = (Line)lines.get(i);
         GanttTask task = line.task;
         
         if (task != null)
         {
            System.out.println("X-Coord WAS: " + task.getXCoord());
            
            long daysInTimeModelMillis = 
               clEndTime.getTimeInMillis() - clBeginTime.getTimeInMillis();
            int daysInTimeModel = 
               (int)(daysInTimeModelMillis / (24 * 60 * 60 * 1000));
            
            System.out.println("DaysInTimeModel: " + daysInTimeModel);
            
            // find days from beginning, multiply that accordingly.
            //   - translate days to pixels.
            int pxDays = getTaskPixelWidthForDuration(1);
            int daysFromStart = 
               (int)((task.getStartDate().getTimeInMillis() - 
                     clBeginTime.getTimeInMillis()) / (24 * 60 * 60 * 1000));
            System.out.println("Days from Start: " + daysFromStart);
            int newX = pxDays * daysFromStart;
            
            System.out.println("NewX: " + newX);
            task.setXCoord(newX);
         }
      }
   }
   
   private int makeYCoord(GanttTask task)
   {
       int y = 0;
      Line line = lineModel.getLineForTask(task);
      if (line != null)
      {   
         y = (line.yMin + 3 + headerHeight);
      }
      
      System.out.println("Y IS: " + y);
      return y;
   }
   
	public int getTaskPixelWidthForDuration(float duration)
	{
		float timeArea = getWidth() - taskColumnOffset;
		float pixelDay = 0;
		
		if (getViewMode() == VMODE_WEEK)
		{
			pixelDay = getColumnSpacing();
		}
		else if (getViewMode() == VMODE_MONTH) 
		{
			pixelDay = timeArea / 30;
		}
		else if (getViewMode() == VMODE_3MONTH) 
		{
			pixelDay = timeArea / 90;
		}
		else if (getViewMode() == VMODE_6MONTH) 
		{
			pixelDay = timeArea / 180;
		}
		
		int pixelsForDuration = (int)(duration * pixelDay);
		
		return pixelsForDuration;
	}
	
	/**
	 * Converts task duration to pixel width for the
	 * current zoom.
	 * 
	 * @return - time-duration as screen pixels
	 */
	public int getTaskPixelWidthForDuration(GanttTask task)
	{
		return this.getTaskPixelWidthForDuration(task.getDuration());
	}
	
	/**
	 * Returns the duration of this task as days : float
	 * derived from the width of the task's 
	 * graphical representation.
	 */
	public float getTaskDurationForPixelWidth(GanttTask task)
	{
		float timeArea = getWidth() - taskColumnOffset;
		float taskPixels = task.getWidth();
		float pixelDay = 0;
		
		float days = 0;
		
		if (getViewMode() == VMODE_WEEK)
		{
			pixelDay = getColumnSpacing();
			days = taskPixels / pixelDay;
		}
		else if (getViewMode() == VMODE_MONTH) 
		{
			pixelDay = getColumnSpacing();
			days = taskPixels / 30;
		}
		else if (getViewMode() == VMODE_3MONTH) 
		{
			pixelDay = getColumnSpacing();
			days = taskPixels / 90;
		}
		else if (getViewMode() == VMODE_6MONTH) 
		{
			pixelDay = getColumnSpacing();
			days = taskPixels / 180;
		}
		
		float r = days % 1;
		if (r > 0.25f && r < 0.75f)
			r = 0.5f;
		else if (r < 0.25f)
			r = 0;
		else if (r > 0.75f)
			r = 1;
		
		int tDays = (int)days;
		
		float finDays = (((float)tDays) + r);
		
		return finDays;
	}
	
	public int getDraggingXOffset()
	{
		return this.dragging_x_offset;
	}
	
	public void setDraggingXOffset(int x_off)
	{
		this.dragging_x_offset = x_off;
	}
	
	public int getDraggingYOffset()
	{
		return this.dragging_y_offset;
	}
	
	public void setDraggingYOffset(int y_off)
	{
		this.dragging_y_offset = y_off;
	}
	
	public int getDraggingMode()
	{
		return this.dragging_mode;
	}
	
	public void setDraggingMode(int draggingMode)
	{
		this.dragging_mode = draggingMode;
	}
	
	public void antiAliasingOn(Graphics2D g2)
	{
		/*RenderingHints rh = g2.getRenderingHints();
		rh.put(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHints(rh);*/
	}
	
	public void antiAliasingOff(Graphics2D g2)
	{
		RenderingHints rh = g2.getRenderingHints();
		rh.put(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_OFF);
		g2.setRenderingHints(rh);
	}
	
	private int getColumnSpacing()
	{
		// note: for resizing & scrolling, there will need to be two variables
		// one would be getDisplayWidth (what is actually visible) and, the other
		// would be getWith (the full width of the panel).
		
		int width = this.getWidth() - taskColumnOffset;
		int sp = 0;
		int view = getViewMode();
		
		if(view == VMODE_WEEK)
			sp = width/7; // Divisible unit as DAY
		if(view == VMODE_MONTH)
			sp = width/4; // Divisible unit as WEEK
		if(view == VMODE_3MONTH)
			sp = width/3; // Divisible unit as MONTH
		if(view == VMODE_6MONTH)
			sp = width/6; // Divisible unit as MONTH (again)
		
		return sp;
	}
	
	public int getColumnCount()
	{
		int view = getViewMode();
		
		if(view == VMODE_WEEK)
			return 7; // Divisible unit as DAY
		if(view == VMODE_MONTH)
			return 4; // Divisible unit as WEEK
		if(view == VMODE_3MONTH)
			return 3; // Divisible unit as MONTH
		if(view == VMODE_6MONTH)
			return 6; // Divisible unit as MONTH (again)

		return 0;
	}
	
   /**
    * Creates a Dimension object representative of the total gant area.
    * 
    * @return - Dimension representing total area consumed by task lines + date-Max, Date-Min.
    */
   public Dimension getGanttArea()
   {
      Dimension ganttArea = new Dimension();
      
      // make Y Dimension...
      int linesX = lineModel.size() * taskLineHeight;
      if (linesX < this.getHeight())
         ganttArea.height = this.getHeight();
      else
         ganttArea.height = linesX;
      
      // make X Dimension...
      // TODO: Complete this with the ability to quantify 
      ganttArea.width = this.getWidth();
      
      return ganttArea;
   }
   
   /**
    * Returns the maximum displayable line count. 
    * 
    * IF the line model has less lines that what is displayed:
    *    return displayed lines
    * ELSE
    *    return number of lines in the line model.
    * 
    * @return
    */
   public int getMaxLines()
   {
      int minLines = (getHeight() - horizontalScrollBar.getHeight() - 
         headerHeight) / taskLineHeight;
      
      if (minLines > lineModel.size())
         return minLines;
      else
         return lineModel.size();
   }
   
   /**
    * Returns the number of Lines that could possibly be displayed
    * given the size of the current window and the line height.
    *
    */
   public int getVisibleLineCount()
   {
      int visHeight = getHeight() - horizontalScrollBar.getHeight() - headerHeight;
      return (visHeight / taskLineHeight);
   }
   
	/** 
    * update task from UI Changes, relative to view, mode, etc.
    * this could either be from Mouse Movement in the gantt pane or,
    * Direct input in the "Control" Pane.
    * 
    * Brian Abbott, Dommoni Corporation.
    */
	public void updateTaskFromGanttChange(GanttTask task)
	{
		/*
		 * Need to do the following:
		 *   - Get the start-date from the X-Cord/View
		 *   - Get the end-date from the X-Width.
		 * 
		 * ... what else.... 
		 * */
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		int width = getWidth() - taskColumnOffset; 
		int sp = width / 7;
		int curr_sp = sp;
		int loc = 0; 
		
		int dist = task.getXCoord() - taskColumnOffset;// - sp; 	
		loc = dist / sp;
		
		Calendar cl = (Calendar)clViewTime.clone();
		cl.set(Calendar.DAY_OF_YEAR, cl.get(Calendar.DAY_OF_YEAR) + loc);
		task.setStartDate(cl);
		
		Calendar cl2 = (Calendar)cl.clone();
		cl2.set(Calendar.DAY_OF_YEAR, cl2.get(Calendar.DAY_OF_YEAR) + (int)task.getDuration());
		task.setEndDate(cl2);
		
		TaskActionEvent event = 
         new TaskActionEvent(task, TaskActionEvent.TASK_MODIFIED);
      fireTaskActionEvent(event);
	}
	
	// Control sends new values
	public void updateTaskFromControlChange()
	{
		/*SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		Task task = controlCollection.getCurrentSelection();
		task.name = controlCollection.getUiNameText();
		
		try 
		{
			Date startDate = sdf.parse(controlCollection.getUiStartDateText());
			Calendar clStartDate = Calendar.getInstance();
			clStartDate.setTime(startDate);
			task.startTime = clStartDate;
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			Date endDate = sdf.parse(controlCollection.getUiEndDateText());
			Calendar clEndDate = Calendar.getInstance();
			clEndDate.setTime(endDate);
			task.endTime = clEndDate;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		task.duration = new Float(controlCollection.getUiDurationText()).floatValue();
		*/
		paint(getGraphics());
	}
   
   //--------------------------------------------------------------------------
   // Event Notifiers
   
   public void fireTaskActionEvent(TaskActionEvent event)
   {
      Iterator it = taskActionListeners.iterator();
      while (it.hasNext())
      {
         TaskActionListener l = (TaskActionListener)it.next();
         if (l != null)
         {   
            switch(event.getType())
            {
            case TaskActionEvent.TASK_ADDED:
               l.taskAdded(event);
               break;
               
            case TaskActionEvent.TASK_DELETED:
               l.taskDeleted(event);
               break;
               
            case TaskActionEvent.TASK_MODIFIED:
               l.taskModified(event);
               break;
               
            case TaskActionEvent.TASK_SELECTED:
               l.taskSelected(event);
               break;
               
            case TaskActionEvent.TASK_DESELECTED:
               l.taskDeselected(event);
               break;
               
            default:
               break;
            }
         }
      }
   }
   
   public void fireZoomActionEvent(ZoomActionEvent event)
   {
      Iterator it = zoomActionListeners.iterator();
      while (it.hasNext())
      {
         ZoomActionListener l = (ZoomActionListener)it.next();
         if (l != null)
         {   
            l.zoomAction(event);
         }
      }
   }
   
   public void addTaskActionListener(TaskActionListener listener)
   {
      taskActionListeners.add(listener);
   }
   
   public boolean removeTaskActionListener(TaskActionListener listener)
   {
      return taskActionListeners.remove(listener);
   }
   
   public void addZoomActionListener(ZoomActionListener listener)
   {
      zoomActionListeners.add(listener);
   }
   
   public boolean removeZoomActionListener(ZoomActionListener listener)
   {
      return zoomActionListeners.remove(listener);
   }
 
   
   //--------------------------------------------------------------------------
   //
   // Scroll Bar Implementations....
   //
   
   class HorizontalScrollBar extends JScrollBar
   {  
      HorizontalScrollBar()
      {
         super(JScrollBar.HORIZONTAL, 0, 0, 0, 0);
         
         addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
               RepaintManager rm = RepaintManager.currentManager(GanttPanel.this);
               rm.addDirtyRegion(GanttPanel.this, 0, 0, GanttPanel.this.getWidth(), GanttPanel.this.getHeight());
               
               hScrollVal = horizontalScrollBar.getValue() * getColumnSpacing();
               
               GanttPanel.this.doLayout();
            }
         });
         
         // need to add continuous scrolling awareness....
         //this.addMouseMotionListener(new MouseMotionListener() {
      
         addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e)
            {
               JScrollBar jsb = (JScrollBar)e.getSource();
               boolean repaint = false;
               boolean remapXCoords = false;
               // TODO: Change the instanceof logic... this is ridiculously bad.
               // TODO: It could very likely fail across JAVA-RT-LIB implementations
               if (jsb.getComponent(0) instanceof JButton)
               {
                  JButton comp = (JButton)jsb.getComponent(0);
                  if (e.getX() < comp.getWidth())
                  {   
                     if (getViewMode() == VMODE_WEEK)
                     {   
                        clBeginTime.setTimeInMillis(
                              clBeginTime.getTimeInMillis() - (1000 * 60 * 60 * 24));
                     }
                     remapXCoords = true;
                     repaint = true;
                  }
                  else if (e.getX() > 
                     (jsb.getVisibleRect().width - comp.getWidth()))
                  {
                     if (getViewMode() == VMODE_WEEK)
                     {
                        clEndTime.setTimeInMillis(
                              clEndTime.getTimeInMillis() + (1000 * 60 * 60 * 24)); 
                     }
                     
                     remapXCoords = true;
                     repaint = true;
                  }
               }
               
               if (remapXCoords)
                  remapXCoords();
               if (repaint)
               {
                  RepaintManager rm = RepaintManager.currentManager(GanttPanel.this);
                  rm.addDirtyRegion(GanttPanel.this, 0, 0, 
                        GanttPanel.this.getWidth(), GanttPanel.this.getHeight());
                  
                  GanttPanel.this.doLayout();
               }
            }
            
            public void mouseMoved(MouseEvent e)
            {
            }
         });
         
         addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e)
            {
               System.out.println("\nMouseClicked");
            }
            
            public void mouseEntered(MouseEvent e)
            {
            }
            
            public void mouseExited(MouseEvent e)
            {
            }
            
            public void mousePressed(MouseEvent e)
            {
            }
            
            public void mouseReleased(MouseEvent e)
            {
            }
         });
         
         Component c = getComponent(0);
         if (c instanceof JButton)
         {
            ((JButton)c).addMouseListener(new MouseListener() 
               {
                  public void mouseClicked(MouseEvent e)
                  {
                     System.out.println("Button Clicked");
                  }
                  
                  public void mouseEntered(MouseEvent e)
                  {
                  }
                  
                  public void mouseExited(MouseEvent e)
                  {
                  }
                  
                  public void mousePressed(MouseEvent e)
                  {
                  }
                  
                  public void mouseReleased(MouseEvent e)
                  {
                  }
               });
            
            Component c2 = getComponent(1);
            if (c2 instanceof JButton)
            {
               ((JButton)c2).addMouseListener(new MouseListener() 
                  {
                     public void mouseClicked(MouseEvent e)
                     {
                        System.out.println("Button Clicked");
                     }
                     
                     public void mouseEntered(MouseEvent e)
                     {
                     }
                     
                     public void mouseExited(MouseEvent e)
                     {
                     }
                     
                     public void mousePressed(MouseEvent e)
                     {
                     }
                     
                     public void mouseReleased(MouseEvent e)
                     {
                     }
                  });
            }
         }
      }
      
      public Point getLocationOnScreen()
      {
         return this.getLocation();
      }
      
      public Point getLocation()
      {
         // Usually not called but... we'll implement anyway.
         return new Point(this.getX(), this.getY());
      }
      
      public int getWidth()
      {
         int panelWidth = GanttPanel.this.getWidth();
         int w;
         if (panelWidth < taskColumnOffset)
         {
            w = taskColumnOffset - panelWidth;
         }
         else
         {
            w = panelWidth - taskColumnOffset;
         }
         return w; 
      }
      
      public int getX()
      {
         return taskColumnOffset + 1;
      }
      
      public int getY()
      {
         return GanttPanel.this.getHeight() - this.getHeight();
      }
   }

   class VerticalScrollBar extends JScrollBar
   {  
      VerticalScrollBar()
      {
         super(JScrollBar.VERTICAL, 0, 0, 0, 0);
         
         addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
               RepaintManager rm = RepaintManager.currentManager(GanttPanel.this);
               rm.addDirtyRegion(GanttPanel.this, 0, 0, GanttPanel.this.getWidth(), GanttPanel.this.getHeight());
               
               vScrollVal = verticalScrollBar.getValue() * taskLineHeight;
               
               GanttPanel.this.doLayout();
            }
         });
      }
      
      public int getHeight()
      {  
         return GanttPanel.this.getHeight() - headerHeight - this.getWidth();
      }
      
      public int getX()
      {
         return GanttPanel.this.getWidth() - this.getWidth();
      }
      
      public int getY()
      {
         return GanttPanel.this.headerHeight + 1;
      }
   }

   //--------------------------------------------------------------------------
   // MouseListener
   public void mouseClicked(MouseEvent arg) 
   {   
      Point pt = arg.getPoint();
      
      if(pt.x > GanttPanel.taskColumnOffset)
      {  
         boolean tmpDidSelection = false; // lame solution to selection problem.
         Iterator tasks = lineModel.getTaskCollection().iterator();
         while(tasks.hasNext())
         {
            GanttTask t = (GanttTask)tasks.next();
            if(pt.x > t.getXCoord() - hScrollVal && 
                  pt.x < (t.getXCoord() - hScrollVal) + t.getWidth() &&
                  pt.y > t.getYCoord() - vScrollVal && 
                  pt.y < t.getYCoord() - vScrollVal + GanttPanel.taskHeight)
            {
               if(t.getSelected()) 
               {
                  // if this task was previously selected, 
                  // this click is a deselection.
                  t.setSelected(false);
                  
                  // *** THIS IS WHERE THE DESELECTION PROP goes!!
                  //controlCollection.deselectTask();
                  TaskActionEvent event = 
                     new TaskActionEvent(t, TaskActionEvent.TASK_DESELECTED);
                  fireTaskActionEvent(event);
               }
               else
               {
                  t.setSelected(true);
                  //*** FIRE controlCollection.selectTask(t);
                  tmpDidSelection = true;
                  
                  TaskActionEvent event = 
                     new TaskActionEvent(t, TaskActionEvent.TASK_SELECTED);
                  fireTaskActionEvent(event);
               }
            }
            else
            {
               t.setSelected(false);
               if(!tmpDidSelection) // only do a de-select if we havent done a select
               {
                  //*** FIRE controlCollection.deselectTask();
                  TaskActionEvent event = 
                     new TaskActionEvent(t, TaskActionEvent.TASK_DESELECTED);
                  fireTaskActionEvent(event);
               }
            }
         }
      }
      else // handle the task-name column
      {
         Line line = this.lineModel.getLineFromYCoord(pt.y + vScrollVal);
         
         if(line != null && line.task != null)
         {
            // Deselect currently selected Task...
            for (int i = 0; i < this.lineModel.size(); i++)
            {
               Line ltmp = this.lineModel.getLine(i);
               if(ltmp.task != null)
                  ltmp.task.setSelected(false);
            }
            
            line.task.setSelected(true);
            // **** FIRE TASK SELECTION
            //controlCollection.selectTask(line.task);
            TaskActionEvent event = 
               new TaskActionEvent(line.task, TaskActionEvent.TASK_SELECTED);
            fireTaskActionEvent(event);
         }
      }
      
      this.paint(this.getGraphics());
   }
   
   public void mouseEntered(MouseEvent arg0) 
   {
   }
   
   public void mouseExited(MouseEvent arg0) 
   {
   }
   
   public void mousePressed(MouseEvent arg) 
   {
      Point pt = arg.getPoint();
      GanttTask t = getTaskForPoint(pt);
      if(t != null)
      {
         this.setDraggingXOffset(pt.x - t.getXCoord());
         this.setDraggingYOffset(pt.y - t.getYCoord());
      }
      /*Iterator tasks = gantt.lineModel.getTaskCollection().iterator();
      while(tasks.hasNext())
      {
         Task t = (Task)tasks.next();
         if(pt.x > t.x_coord && pt.x < t.x_coord + 20 &&
               pt.y > t.y_coord && pt.y < t.y_coord + 10)
         {
            t.selected = true;
            controlCollection.setName(t.name);
         }
         else
         {
            t.selected = false; 
         }
      }*/
   }
   
   public void mouseReleased(MouseEvent arg0) 
   {
      this.setDraggingXOffset(0);
      this.setDraggingYOffset(0);
      
      // update the task 
      Point pt = arg0.getPoint();
      GanttTask t = getTaskForPoint(pt);
      if (t != null)
         t.setWidth(this.getTaskPixelWidthForDuration(t.getDuration()));
      else
      {  
         Line l = this.lineModel.getLineFromYCoord( arg0.getPoint().y );
         if (l != null && l.task != null)
            l.task.setWidth(this.getTaskPixelWidthForDuration(l.task.getDuration()));
      }
      /*Task t = getTaskForPoint(pt);
      if(t != null)
      {
         if(!t.wasDragged)
            t.selected = false;
         t.wasDragged = false;
      }*/
   }
   
   private GanttTask getTaskForPoint(Point pt)
   {
      Iterator tasks = this.lineModel.getTaskCollection().iterator();
      while(tasks.hasNext())
      {
         GanttTask t = (GanttTask)tasks.next();
         if(
            (pt.x > t.getXCoord() && pt.x < t.getXCoord() + t.getWidth() &&
            pt.y > t.getYCoord() && pt.y < t.getYCoord() + GanttPanel.taskHeight) 
            ||
            (pt.x > t.getXCoord() && 
             pt.x < t.getXCoord() + this.getTaskPixelWidthForDuration(t.getDuration()) &&
             pt.y > t.getYCoord() && 
             pt.y < t.getYCoord() + GanttPanel.taskHeight)
         )
         {
            return t;
         }
      }
      return null;
   }
   
   
   //--------------------------------------------------------------------------
   // MouseMotionListener
   public void mouseDragged(MouseEvent arg) 
   {
      Point pt = arg.getPoint();
      
      Iterator tasks = this.lineModel.getTaskCollection().iterator();
      while(tasks.hasNext())
      {
         GanttTask t = (GanttTask)tasks.next();
         if(t.getHighlighted())
         {  
            t.setXCoord(pt.x - this.getDraggingXOffset());
            //t.y_coord = (pt.y - gantt.getDraggingYOffset());
            
            if(!t.getWasDragged())
               t.setWasDragged(true);
            
            this.updateTaskFromGanttChange(t);
         }
         
         if(t.getPinched())
         {
            int width = pt.x - t.getXCoord();
            
            t.setDuration(this.getTaskDurationForPixelWidth(t)); // numberOfDays : float
            t.setWidth(width);
            
            this.updateTaskFromGanttChange(t);
         }
      }
      
      //Task t = getTaskForPoint(pt);

      this.paint(this.getGraphics());
   }
   
   public void mouseMoved(MouseEvent arg) {
      
      boolean doUpdate = false;
      Point pt = arg.getPoint();
      boolean tmpSetPinch = false;
      
      // Determine weather or not to highlight the task.
      Iterator tasks = this.lineModel.getTaskCollection().iterator();
      while(tasks.hasNext())
      {
         GanttTask t = (GanttTask)tasks.next();
         boolean twas = t.getHighlighted();
         
         if(pt.x > t.getXCoord() - hScrollVal && 
               pt.x < (t.getXCoord() - hScrollVal) + t.getWidth() &&
               pt.y > t.getYCoord() - vScrollVal && 
               pt.y < t.getYCoord() - vScrollVal + GanttPanel.taskHeight)
         {
            t.setHighlighted(true);
         }
         else
            t.setHighlighted(false);
         
         // Do PINCH Cursor/Mode
         if(pt.x > (t.getXCoord() + t.getWidth() - 1) && 
               pt.x < (t.getXCoord() + t.getWidth() + 2) &&
               pt.y > t.getYCoord() && 
               pt.y < t.getYCoord() + GanttPanel.taskHeight)
         {
            this.cursorController.cursorFrame.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            this.setDraggingMode(GanttPanel.DRAGGING_MODE_PINCH);
            tmpSetPinch = true;
            t.setPinched(true);
            //doUpdate = true;
         }
         else // Move Cursor/Mode
         {
            if(!tmpSetPinch && this.cursorController.cursorFrame.getCursor().getType() != Cursor.DEFAULT_CURSOR)
            {
               this.cursorController.cursorFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
               this.setDraggingMode(GanttPanel.DRAGGING_MODE_MOVE); 
            }
            
            t.setPinched(false);
         }
         
         if(twas != t.getHighlighted())
            doUpdate = true;
      }
      
      Iterator it = this.lineModel.getLines().iterator();
      while(it.hasNext())
         ((Line)it.next()).lineHighLight = false;
      
      // Do highlight if were within the panel.
      Line line = this.lineModel.getLineFromYCoord(pt.y);
      if(line != null && line.task != null && pt.x < GanttPanel.taskColumnOffset)
      {  
         if(!line.lineHighLight)
            doUpdate = true;
         line.lineHighLight = true;
         /*gantt.drawLineTitle(line, gantt.getGraphics());*/
         
         /*System.out.println("Task for line is: " + line.task.name);*/
      }  
      
      if(doUpdate)
         this.paint(this.getGraphics());
   }
   
   //--------------------------------------------------------------------------
   // MouseWheelListener
   public void mouseWheelMoved(MouseWheelEvent wheelEvent)
   {  
      if (verticalScrollBar.isEnabled())
      {   
         verticalScrollBar.setValue(
               verticalScrollBar.getValue() + wheelEvent.getUnitsToScroll());
      }
   }
}