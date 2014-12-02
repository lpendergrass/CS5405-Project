import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class graphPane extends JPanel {

	// Array Parameters
	int arrayLen = 20;
	int maxVal = 100;
	Random rand = new Random();
	
	ArrayList<Integer> array;
	
	public graphPane(){
		super();

		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		array = new ArrayList<Integer>();
		
		populate( arrayLen, maxVal );
	}
	
	public void populate( int len, int max ) {
		
		arrayLen = len;
		maxVal = max;
		
		array.clear();
		
		for(int i = 0; i < arrayLen; i++)
	    	array.add(rand.nextInt(maxVal));
	}
	
	public void swap( int x, int y ){
		Collections.swap(array, x, y);
		repaint();
	}
	
	public int get( int x ){ 
		return array.get(x);
	}
	
	public int length(){
		return arrayLen;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		int barHeight;
		int barWidth = getWidth() / arrayLen;
		float heightRatio = getHeight() / maxVal;
		
		for( int i = 0; i < arrayLen; i++ ){
			
			barHeight = (int)(array.get(i) * heightRatio);
			
			g.setColor(Color.green);
			g.fillRect( i * barWidth, getHeight() - barHeight - 2, barWidth, barHeight);
			g.setColor(Color.black);
			g.drawRect( i * barWidth, getHeight() - barHeight - 2, barWidth, barHeight);
	}
}
	
}
