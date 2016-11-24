import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.util.*;
import uwcse.io.*;
import uwcse.graphics.*;
import javax.swing.*;

/**
 * A class to create and manipulate graphics elements stored in an ArrayList
 * 
 * @author AUTHOR_NAME
 */

public class GraphicsElements {

	/** Maximum number of disks in a pile of disks */
	public static final int MAXIMUM_NUMBER_OF_DISKS = 100;

	/** Maximum number of rows (or columns) in a square checkered board */
	public static final int MAXIMUM_NUMBER_OF_ROWS = 50;

	/** Maximum number of points in a Sierpinski triangle */
	public static final int MAXIMUM_NUMBER_OF_POINTS = 10000;

	/** Width of the window (from ViewWindow) */
	public static final int WIDTH = ViewWindow.WINDOW_WIDTH;

	/** Height of the window (from ViewWindow) */
	public static final int HEIGHT = ViewWindow.WINDOW_HEIGHT;

	// Put your other instance fields here (if you need any)
	public Oval theOval;
	
	/**
	 * Create a top view of a pile of disks of decreasing diameters (from bottom
	 * to top). Use filled circles. The color of each disk is random. The pile
	 * should fill the window. <br>
	 * Store the circles in an ArrayList and return that ArrayList (the disk at
	 * the bottom should be the first element of the ArrayList)<br>
	 * The number of disks is given by the user (use a dialog box). If that
	 * number is less than or equal to 0 or greater than
	 * MAXIMUM_NUMBER_OF_DISKS, display an error message (use
	 * JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Oval> createAPileOfDisks() {
		
		// Add your own code here
		int hmax = 700;
		ArrayList<Oval> pileOfDisks = new ArrayList<Oval>();
		for(int i = 0; i<MAXIMUM_NUMBER_OF_DISKS; i++){
			//find height and width of disk defined by the width of the window and the maximum disk number
			int width = (int)((double)WIDTH/2.0-0.5*((double)hmax/(double)MAXIMUM_NUMBER_OF_DISKS*((double)i+1)));
			int height = (int)((double)WIDTH/2.0-0.5*((double)hmax/(double)MAXIMUM_NUMBER_OF_DISKS*((double)i+1)));
			//spawn point of disks is the center of the window, minus the halved height/width of the disk. 
			int x = WIDTH/2 - width/2;
			int y = HEIGHT/2 - height/2;
			pileOfDisks.add(anOval(x,y,height,height));
			
		}
		return pileOfDisks;
		
	}
	
	//oval method called in createAPileOfDisks, generates an oval with a random color.
	public Oval anOval(int x, int y, int ovalHeight, int ovalWidth){
		Oval tmp = new Oval(x, y, ovalHeight, ovalWidth,
				new Color(randInt(1,254),randInt(1,254),randInt(1,254)),true);
		return tmp;
		
	}
	
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
	/**
	 * Create a square checkered board. Create a Rectangle for each square on
	 * the board. Store the Rectangles in an ArrayList and return that
	 * ArrayList. Use two colors only to paint the squares.<br>
	 * The board should cover most of the window. The number of rows (=number of
	 * columns) is given by the user (use a dialog box). If that number is less
	 * than or equal to 0 or greater than MAXIMUM_NUMBER_OF_ROWS, display an
	 * error message (use JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Rectangle> createACheckeredBoard() {
		//code for user input. parses a string taken from showInputDialog and makes user re-enter value if greater
		//than 50 or less than 0
		String ui = JOptionPane.showInputDialog("Enter number of columns");
		int userInput = Integer.parseInt(ui);
		if(userInput > MAXIMUM_NUMBER_OF_ROWS || userInput < 0){
			JOptionPane.showMessageDialog(ViewWindow.frame, "Invalid input. Must be less than 50 and greater than 0");
			createACheckeredBoard();
		}
		//int userInput = 30;
		// Add your own code here
		ArrayList<Rectangle> squares = new ArrayList<Rectangle>();
		//find area of the board
		int boardArea = WIDTH * WIDTH;
		//number of columns to divide up the board
		int numOfColumns = userInput;
		//find column area
		double columnArea = boardArea / numOfColumns;
		//find the area of individual squares by dividing up columns by number of columns and round
		double sqA = columnArea/numOfColumns;
		int squareArea = (int)Math.round(sqA);
		//find number of squares by dividing up board by square size
		int numOfSquares = (int)Math.round(boardArea/squareArea);
		//find square dimensions with square root
		int squareSide = (int)Math.sqrt(squareArea);
		System.out.println(sqA);
		System.out.println(squareSide);
		System.out.println(numOfSquares);
		//iterators for tracking when to move to next row
		int xTrack = 0;
		int yTrack = 0;
		//number to flip to change square color
		int colorSwitcher = -1;
		//add squares to array list
		for(int i=0;i<numOfSquares;i++){
			//if the total length of squares in a row(xTrack) is greater than the window width, 
			//add one square length to yTrack to start spawn in a new row and set xTrack to 0 
			if(xTrack>WIDTH){
				yTrack += squareSide;
				xTrack = 0;
				//check if the first square of the last row is the same color to keep checker board pattern
				for(int p = 0; p<squares.size();p++){
					//conditional finds square that is in the last row created(yTrack - squareSide), which has an x value of 0, 
					//which would be the first square created on that row
					if(squares.get(p).getY() == yTrack - squareSide && squares.get(p).getX() == 0){
						//if that first square in the last row is blue, make sure colorSwitcher is set to make it red
						//and vice versa
						if(squares.get(p).getColor() == Color.BLUE){
							colorSwitcher = 1;
						}
						else if(squares.get(p).getColor() == Color.RED){
							colorSwitcher = -1;
						}
					}
				}
			}
			else{
				//conditionals for creating square and deciding whether to make a red or blue square.
				//colorSwitcher is multiplied by -1 after a square has been created, to flip the integer
				//xTrack keeps track of the x value of where to spawn the squares, by adding the width of
				//the determined squareSide to the total value.
				if(colorSwitcher == -1){
					Rectangle square = new Rectangle(xTrack,yTrack,squareSide,squareSide,Color.BLUE,true);
					xTrack+=squareSide;
					squares.add(square);
				}
				else{
					Rectangle square = new Rectangle(xTrack,yTrack,squareSide,squareSide,Color.RED,true);
					xTrack+=squareSide;
					squares.add(square);
				}
			colorSwitcher *= -1;
			}
		}
		return squares;
	}

	/**
	 * Create a Sierpinski triangle. Create a filled Oval (circle of radius 1)
	 * for each point of the triangle. Store the Ovals in an ArrayList and
	 * return that ArrayList. Use one color only to paint the Ovals.<br>
	 * The triangle should cover most of the window.<br>
	 * The number of points is given by the user (use a dialog box). If that
	 * number is less than or equal to 0 or greater than
	 * MAXIMUM_NUMBER_OF_POINTS, display an error message (use
	 * JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Oval> createASierpinskiTriangle() {

		// Add your own code here
		ArrayList<Oval> points = new ArrayList<Oval>();
		//arrays defining the three points to start the triangle from
		int[] P1 = {0,HEIGHT};
		int[] P2 = {(WIDTH/2),0};
		int[] P3 = {WIDTH,HEIGHT};
		//array to define the point to change and spawn new points
		int[] P4 = {0,HEIGHT};
		//array to store point that is calculated from midpoints of P4 and P1,2,3
		int[] Q = {0,0};
		for(int i = 0;i<10000;i++){
			//rng to pick number 1 to 3
			int randomInt = randInt(1,4);
			// these conditionals use the midpoint formula to find the point to spawn for each triangle
			if(randomInt == 1){
				Q[0] = (P1[0]+P4[0])/2;
				Q[1] = (P1[1]+P4[1])/2;

			}
			if(randomInt == 2){
				Q[0] = (P2[0]+P4[0])/2;
				Q[1] = (P2[1]+P4[1])/2;

			}
			if(randomInt == 3){
				Q[0] = (P3[0]+P4[0])/2;
				Q[1] = (P3[1]+P4[1])/2;

			}
			//add the point to the array
			points.add(new Oval(Q[0],Q[1],1,1,Color.BLUE,true));
			//set P4 to whatever was calculated in Q for the next iteration of the loop.
			P4[0] = Q[0];
			P4[1] = Q[1];
		}
		return points;
	}

	/**
	 * Rotate the colors in the pile of disks. Set the color of each disk to the
	 * color of the disk just above it. For the top disk, set its color to the
	 * color of the bottom disk (e.g. with 3 disks, if the colors are from
	 * bottom to top, red, blue, yellow, the new colors of the disks are from
	 * bottom to top, blue, yellow, red).<br>
	 * Precondition: graphicsList describes a pile of disks
	 */
	public ArrayList<Oval> rotateColorsInPileOfDisks(ArrayList<Oval> graphicsList) {

		// Itererate over the arraylist
		for(int i = 0; i<graphicsList.size(); i++){
			//conditional to ensure it doesnt try to grab a disk thats outside the size of the array
			if(i != graphicsList.size() - 1){
				//sets the color of disk currently on the iterator to the disk below it.
				graphicsList.get(i).setColor(graphicsList.get(i+1).getColor());
			}
		}		
		//after iterating over all the disks, set the top disk to a random color, so all disks dont
		//eventually become the same color
		graphicsList.get(0).setColor(new Color(randInt(1,254),randInt(1,254),randInt(1,254)));
		return graphicsList;
	}

	/**
	 * Flip the 2 colors of the checkboard<br>
	 * Precondition: graphicsList describes a checkered board
	 */
	public ArrayList<Rectangle> flipColorsInCheckeredBoard(ArrayList<Rectangle> graphicsList) {
		
		// iterate over the list
		for(int i = 0; i<graphicsList.size();i++){
			//if the color in the square is blue, change it red. If red, change to blue.
			if(graphicsList.get(i).getColor() == Color.BLUE){
				graphicsList.get(i).setColor(Color.RED);
			}
			else if(graphicsList.get(i).getColor() == Color.RED){
				graphicsList.get(i).setColor(Color.BLUE);
			}
		}
		
		return graphicsList;

	}

	/**
	 * Change the color of the Sierpinski triangle (all circles should change to
	 * the same color). Switch between 3 colors (e.g. blue->red->green, if the
	 * triangle was blue, make it red, if it was red, make it green, if it was
	 * green make it blue).<br>
	 * Precondition: graphicsList describes a Sierpinski triangle
	 */
	public ArrayList<Oval> changeColorsInSierpinskiTriangle(ArrayList<Oval> graphicsList) {

		// iterate thru array of ovals
		for(int i = 0;i<graphicsList.size();i++){
			//if the color of the oval is blue, set to red, else if red, set to green, else if green, set to blue. 
			if(graphicsList.get(i).getColor() == Color.BLUE){
				graphicsList.get(i).setColor(Color.RED);
			}
			else if(graphicsList.get(i).getColor() == Color.RED){
				graphicsList.get(i).setColor(Color.GREEN);
			}
			else if(graphicsList.get(i).getColor() == Color.GREEN){
				graphicsList.get(i).setColor(Color.BLUE);
			}
			
		}
		return graphicsList;

	}

	/**
	 * Return the color at location (x,y) in the pile of disks. If (x,y) is not
	 * part of the pile of disks, return null.<br>
	 * Precondition: graphicsList describes a pile of disks
	 */
	public Color getColorInPileOfDisks(int x, int y, ArrayList<Oval> graphicsList) {

		//find height/2
		//if n greater than previous radius and less than next radius
		// Add your own code here
		Color color = null;
		return color;
		
	}

	/**
	 * Return the color at location (x,y) in the checkered board. If (x,y) is
	 * not part of the board, return null.<br>
	 * Precondition: graphicsList describes a checkered board
	 */
	public Color getColorInCheckeredBoard(int x, int y, ArrayList<Rectangle> graphicsList) {

		// Add your own code here
		Color color = null;
		return color;
		
	}

	/**
	 * Return the color at location (x,y) in the Sierpinski triangle. If (x,y)
	 * is not part of the pile of disks, return null.<br>
	 * Precondition: graphicsList describes a Sierpinski triangle
	 */
	public Color getColorInSierpinskiTriangle(int x, int y, ArrayList<Oval> graphicsList) {
		
		// Add your own code here
		Color color = null;
		return color;
		
	}
}
