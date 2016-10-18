package mountainscene;
import java.awt.Color;

import uwcse.graphics.*;

public class Mountain {
	//instance fields
	private GWindow window;

	private int x;
	private int y;

	private double scale;
	
	//Defining the variables so that they can be used anywhere in this class.
	public Mountain(int x, int y, double scale, GWindow window)
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
	//drawing details as private method
	private void draw(){
		//drawing the parts
		uwcse.graphics.Triangle mountainBody = new uwcse.graphics.Triangle(this.x-(int)(35*this.scale),
																		this.y+(int)(30*this.scale),
																		this.x+(int)(10*this.scale),
																		this.y-(int)(10*this.scale),
																		this.x+(int)(50*this.scale),
																		this.y+(int)(30*this.scale),
																		Color.LIGHT_GRAY,true);
		
		uwcse.graphics.Triangle mountainSnow = new uwcse.graphics.Triangle(this.x-(int)(8*this.scale),
																		this.y+(int)(6*this.scale),
																		this.x+(int)(10*this.scale),
																		this.y-(int)(10*this.scale),
																		this.x+(int)(26*this.scale),
																		this.y+(int)(6*this.scale),
																		Color.white,true);
		//adding to window
		this.window.add(mountainBody);
		this.window.add(mountainSnow);
	}
}
