import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class graphPane extends JPanel {

	// Initial Array Parameters
	int arrayLen = 20;
	int maxVal = 100;
	
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
	public void paint(Graphics g){
		super.paint(g);
		
		int barHeight;
		int barWidth = getWidth() / arrayLen;
		float heightRatio = getHeight() / maxVal;
		
		for( int i = 0; i < arrayLen; i++ ){
			
			// Scale bar i's height
			barHeight = (int)(array.get(i) * heightRatio);
			
			// Fill bar i's background
			g.setColor(Color.green);
			g.fillRect( i * barWidth, getHeight() - barHeight - 2, barWidth, barHeight);
			
			// Draw bar i's border
			g.setColor(Color.black);
			g.drawRect( i * barWidth, getHeight() - barHeight - 2, barWidth, barHeight);
	}
}
	
}
