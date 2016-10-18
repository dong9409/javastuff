package mountainscene;

import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class


/**
 * <p>Create a cable car in a graphics window</p>  
 * @author <insert name>
 */

public class CableCar {

	// Your instance fields go here
	private GWindow window;
	// The location of this tree
	// (precisely (as done in the draw method), (x,y) is
	// the upper left corner of the tree trunk)
	private int x;
	private int y;
	// The scale used to draw this tree
	private double scale;


	/**
	 * Create a cable car at location (x,y) in the GWindow window.
	 * @param x the x coordinate of the center of the cable car
	 * @param y the y coordinate of the center of the cable car
	 * @scale the factor that multiplies all default dimensions for this cable car
	 * (e.g. if the default size is 80, the size of this cable car is
	 * scale * 80)
	 * @window the graphics window this cable car belongs to
	 */
	public CableCar(int x, int y, double scale, GWindow window)
	{    
		// initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		
		// The details of the drawing are in a private method
		this.draw();

	}



	/** Draw a cable car at location (x,y) */
	// To draw cable car, using private drawing method.
	private void draw()
	{ 
		//drawing cable car and its lines by using rectangles and lines from the library.
		
		uwcse.graphics.Rectangle cableCar = new uwcse.graphics.Rectangle(x,
																		 y,
																		(int)(60*this.scale),
																		(int)(40*this.scale),
																		Color.red,true);
		
		this.window.add(cableCar);
		
		//adding the rectangles and lines on the window.
		uwcse.graphics.Rectangle carWindow1 = new uwcse.graphics.Rectangle(x+5,
																		   y+5,
																		   (int)(20*this.scale),
																		   (int)(15*this.scale),
																		   Color.cyan,true);
		
		uwcse.graphics.Rectangle carFrame1 = new uwcse.graphics.Rectangle(x+5,
																		  y+5,
																		  (int)(20*this.scale),
																		  (int)(15*this.scale),
																		  Color.black,false);
		
		uwcse.graphics.Rectangle carWindow2 = new uwcse.graphics.Rectangle(x+35,y+5,
																		  (int)(20*this.scale),
																		  (int)(15*this.scale),
																		  Color.cyan,true);
		
		uwcse.graphics.Rectangle carFrame2 = new uwcse.graphics.Rectangle(x+35,y+5,
																		 (int)(20*this.scale),
																		 (int)(15*this.scale),
																		 Color.black,false);
		this.window.add(carWindow1);
		this.window.add(carFrame1);
		this.window.add(carWindow2);
		this.window.add(carFrame2);
		//adding cable grip
		uwcse.graphics.Triangle cableGrip = new uwcse.graphics.Triangle(this.x-(int)(0*this.scale),
																		this.y-(int)(0*this.scale), 
																		this.x+(int)(30*this.scale), 
																		this.y-(int)(40*this.scale), 
																		this.x+(int)(60*this.scale), 
																		this.y-(int)(0*this.scale), 
																		Color.black, false);
		this.window.add(cableGrip);
		
		//adding cable
		uwcse.graphics.Line cableLine = new uwcse.graphics.Line(window.getWindowWidth(), 
																100, 
																0, 
																350, 
																Color.black);
		this.window.add(cableLine);
	}

}
