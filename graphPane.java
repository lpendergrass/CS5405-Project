import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class graphPane extends JPanel implements Runnable {

	// Initial Array Parameters
	int arrayLen = 20;
	int maxVal = 100;
	int sleepTime = 100;
	
	// Random number generator
	Random rand = new Random();
	
	ArrayList<Integer> array;
	
	public graphPane(){
		super();

		// Set border around graph
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		// Instantiate ArrayList
		array = new ArrayList<Integer>();
		
		// Generate initial array values
		populate( arrayLen, maxVal );
	}
	
	// Clears and populates the array with random integers
	public void populate( int len, int max ) {
		
		arrayLen = len;
		maxVal = max;
		
		array.clear();
		
		for(int i = 0; i < arrayLen; i++)
	    	array.add(rand.nextInt(maxVal));
	}

	
	// Swaps items at the specified indices
	public void swap( int x, int y ){
		Collections.swap(array, x, y);
		repaint();
	}
	
	// Returns the array value at the specified index
	public int get( int x ){ 
		return array.get(x);
	}
	
	// Returns the length of the array
	public int length(){
		return arrayLen;
	}
	
	// Paints the arrays values as a bar graph
	//public void paint(Graphics g){
	//	super.paint(g);
	
	
	public void draw(int[] sort, int k){
		Graphics g2 = this.getGraphics();
		
		int barHeight;
		int barWidth = getWidth() / arrayLen;
		float heightRatio = getHeight() / maxVal;
		
		for( int i = 0; i < arrayLen; i++ ){
			
			// Scale bar i's height
			barHeight = (int)(array.get(i) * heightRatio);
			
			// Fill bar i's background
			g2.setColor(Color.green);
			g2.fillRect( i * barWidth, getHeight() - barHeight - 2, barWidth, barHeight);
			
			// Draw bar i's border
			g2.setColor(Color.black);
			g2.drawRect( i * barWidth, getHeight() - barHeight - 2, barWidth, barHeight);
		}
		
	}	

JPanel panel;
@Override
public void paintComponent(Graphics g) {
	super.paintComponent(g);
}

@Override
public void run()
{
	try {
		Thread.sleep(1000);
	}
	catch(InterruptedException e){
		e.printStackTrace();
	}
}

}
	


