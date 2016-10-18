package mountainscene;

import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>Create a tree with ornaments in a graphics window</p>
 * @author <insert name>
 */   

public class Tree {

	// Instance fields
	// The graphics window this tree belongs to
	private GWindow window;
	// The location of this tree
	// (precisely (as done in the draw method), (x,y) is
	// the upper left corner of the tree trunk)
	private int x;
	private int y;
	// The scale used to draw this tree
	private double scale;

	/**
	 * Create a tree
	 * @param x the x coordinate of the tree location (upper left corner of the tree trunk)
	 * @param y the y coordinate of the tree location
	 * @param window the graphics window this Tree belongs to
	 * @param scale the scale of the drawing (all default dimensions are multiplied
	 * by scale)
	 */
	public Tree(int x, int y, double scale, GWindow window)
	{
		// Initialize the instance fields (the use of this is required
		// since the instance fields have the same name as the
		// parameters of the constructor)
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;

		// the details of the drawing are in written in the private method draw()
		this.draw();
	}

	/**
	 * draw a pine tree
	 */
	private void draw()
	{
		// trunk of the tree: a brown rectangle
		// (int) converts to an int 20*this scale (etc...), which is a double
		// For instance, (int)23.8 is 23
		// This is necessary since the Rectangle constructor takes integers
		Rectangle trunk = new Rectangle(x,y,(int)(20*this.scale),(int)(60*this.scale),Color.black,true);
		this.window.add(trunk);

		// Foliage (improve the drawing!)
		// a green triangle
		Triangle foliage1 = new Triangle(this.x-(int)(35*this.scale),
										this.y+(int)(30*this.scale),
										this.x+(int)(10*this.scale),
										this.y-(int)(10*this.scale),
										this.x+(int)(50*this.scale),
										this.y+(int)(30*this.scale),
										Color.green,true);
		
		Triangle foliage2 = new Triangle(this.x-(int)(25*this.scale),
										this.y+(int)(10*this.scale),
										this.x+(int)(10*this.scale),
										this.y-(int)(30*this.scale),
										this.x+(int)(40*this.scale),
										this.y+(int)(10*this.scale),
										Color.green,true);		
		
		Triangle foliage3 = new Triangle(this.x-(int)(25*this.scale),
										this.y-(int)(10*this.scale),
										this.x+(int)(10*this.scale),
										this.y-(int)(50*this.scale),
										this.x+(int)(40*this.scale),
										this.y-(int)(10*this.scale),
										Color.green,true);		
		this.window.add(foliage1);
		this.window.add(foliage2);
		this.window.add(foliage3);


		// Improve the drawing of the foliage and add the ornaments...
		uwcse.graphics.Oval ornamentLeft = new uwcse.graphics.Oval(this.x-(int)(10*this.scale), 
																   this.y-(int)(20*this.scale), 
																   10, 10, Color.red, true);
		
		uwcse.graphics.Oval ornamentRight = new uwcse.graphics.Oval(this.x+(int)(10*this.scale), 
				   												   this.y+(int)(10*this.scale), 
				   												   10, 10, Color.red, true);
		this.window.add(ornamentLeft);
		this.window.add(ornamentRight);
	}
}
