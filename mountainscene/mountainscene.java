package mountainscene;

import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class
import java.util.Random;

/**
 * <p>
 * A MountainScene displays snow men, trees (with ornaments), a cable car and a
 * fourth element of your choice in a graphics window
 * </p>
 * 
 * @author <insert name>
 */

public class MountainScene {

	//first a RNG for fun and profit
	public int randInt(int minimum, int maximum){
		//store values for recursion conditional
		int a = minimum;
		int b = maximum;
		//instantiate RNG
		Random randomer = new Random();
		//nextInt picks a random number between the entered parameters
		int randNum = randomer.nextInt(maximum);
		//recursive conditional for discarding values below minimum
		if(randNum < minimum){
			randNum = randInt(a,b);
		}
		//spit out the random number
		return randNum;
		
	}
	
	//method for making small random doubles for randomized scale. min and max are multiplied by .01(100 becomes 1, 50 becomes .5 etc)
	public double scaleNum(int min, int max){
		//get random int from randInt
		int numToDoub = randInt(min,max);
		//make it a double
		double doubedNum = (double)numToDoub;
		//make it tiny 
		double scaleNum = doubedNum * .01;
		//spit it out
		return scaleNum;
		
	}
	/** The graphics window that displays the picture */
	private GWindow window;
	
	
	/**
	 * Create an image of a mountain scene
	 */
	public MountainScene() {

		// The graphics window
		// The window is by default 500 wide and 400 high
		this.window = new GWindow("Mountain scene",1000,700);
		this.window.setExitOnClose(); // so that a click on the close box of the
		// window terminates the application

		// Background (cyan here)
		Rectangle bgnd = new Rectangle(0, 0, window.getWindowWidth(), window.getWindowHeight(), Color.cyan, true);
		this.window.add(bgnd);

		// Create the scene elements
		//first two params are x and y
		// e.g. a tree in the lower left area 1.5 times the normal size
		Mountain mount1 = new Mountain(500,250,15,this.window);
		CableCar car1 = new CableCar(300,300,1,this.window);		
		
		//snowmen appear at random locations
		//set number of snowmen to spawn
		int snowmenToSpawn = 150;
		int i = 0;		
		while(i<snowmenToSpawn){		
			//spawn snowman
			SnowMan snowMan = new SnowMan(randInt(200,900),randInt(400,800),scaleNum(40,150),this.window);
			i++;
		}
		//trees appear at random locations
		//set number of trees to spawn
		int treesToSpawn = 80;
		int n = 0;
		while(n<treesToSpawn){		
			//spawn the tree
			Tree tree1 = new Tree(randInt(200,900),randInt(400,800),scaleNum(40,100),this.window);
			n++;
		}

	}

	/**
	 * Entry point of the program
	 */
	//Running the program.
	public static void main(String[] args) {
		new MountainScene();
	}

}
