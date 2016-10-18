package mountainscene;

import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>Create a snow man in a graphics window</p>
 * @author <insert name>
 */  

public class SnowMan {

	// Your instance fields go here
	private GWindow window;

	private int x;
	private int y;

	private double scale;

	/**
	 * Create a snow man in at location (x,y) in the GWindow window.
	 * @param x the x coordinate of the center of the head of the snow man
	 * @param y the y coordinate of the center of the head of the snow man
	 * @scale the factor that multiplies all default dimensions for this snow man
	 * (e.g. if the default head radius is 20, the head radius of this snow man is
	 * scale * 20)
	 * @window the graphics window this snow man belongs to
	 */
	//Defining the variables so that they can be used anywhere in this class.
	public SnowMan(int x, int y, double scale, GWindow window)
	{  
		// the details of the drawing are in written in the private method draw()
		// initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;

		// Put the details of the drawing in a private method
		this.draw();

	}

	/** Draw in the graphics window a snow man at location (x,y) */
	// drawing the details in a private method. 
	private void draw()
	{
		// Draw the objects
		uwcse.graphics.Oval snowmanHead = new uwcse.graphics.Oval(x, 
																  y, 
																  (int)(20*this.scale), 
																  (int)(20*this.scale), 
																  Color.white, true);
		
		uwcse.graphics.Oval snowmanBody = new uwcse.graphics.Oval(x-(int)(5*this.scale), 
																  y+(int)(19*this.scale), 
																  (int)(30*this.scale), 
																  (int)(30*this.scale), 
																  Color.white, true);
		
		uwcse.graphics.Oval snowmanLeftEye = new uwcse.graphics.Oval(x+(int)(2*this.scale), 
																     y+(int)(5*this.scale), 
																     (int)(4*this.scale), 
																     (int)(4*this.scale), 
																     Color.black, true);
		
		uwcse.graphics.Oval snowmanRightEye = new uwcse.graphics.Oval(x+(int)(12*this.scale), 
																  	 y+(int)(5*this.scale), 
																     (int)(4*this.scale), 
																     (int)(4*this.scale), 
																     Color.black, true);
		
		uwcse.graphics.Line snowmanMouth = new uwcse.graphics.Line(x+(int)(3*this.scale), 
																   y+(int)(13*this.scale), 
																   x+(int)(15*this.scale), 
																   y+(int)(13*this.scale));
		
		uwcse.graphics.Triangle snowmanHat = new uwcse.graphics.Triangle(x+(int)(2*this.scale), 
																		 y+(int)(4*this.scale), 
																		 x+(int)(11*this.scale), 
																		 y-(int)(20*this.scale), 
																		 x+(int)(18*this.scale), 
																		 y+(int)(4*this.scale), 
																		Color.red, true);
		
		uwcse.graphics.Line snowmanArm1 = new uwcse.graphics.Line(x-(int)(5*this.scale), 
																  y+(int)(30*this.scale), 
																  x-(int)(12*this.scale), 
																  y+(int)(20*this.scale));
		
		uwcse.graphics.Line snowmanArm2 = new uwcse.graphics.Line(x+(int)(24*this.scale), 
																  y+(int)(30*this.scale), 
																  x+(int)(32*this.scale), 
																  y+(int)(40*this.scale));
		
		// add them to the window
		this.window.add(snowmanHead);
		this.window.add(snowmanBody);
		this.window.add(snowmanRightEye);
		this.window.add(snowmanLeftEye);
		this.window.add(snowmanMouth);
		this.window.add(snowmanHat);
		this.window.add(snowmanArm1);
		this.window.add(snowmanArm2);
	}
}
