
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
public class BubbleSort extends JInternalFrame implements Runnable {
	int[] sort;
	int dr;
	graphPane gp = new graphPane();
	public BubbleSort(int[] sort, int dr ){
		this.sort= sort;
		this.dr = dr;
		}
	public BubbleSort(){
		
		
			super("bubblesort",true,true,true,true);
			setOpaque(true);
			setSize(400,400);
			setVisible(true);
			
	}

	public void run() 
	{
		int n= sort.length;
		int temp =0;
		for (int j=0; j<n; j++){
			try {
				Thread.sleep(500); }
			catch (InterruptedException e){
				e.printStackTrace();
			}
			for(int i=1; i<(n-j); i++) {
				if(sort[i-1]> sort[i]){
					// swappping elements
					temp = sort[i-1];
					sort[i-1]= sort[i];
					sort[i]= temp;
					gp.draw(sort, j);
				}
			}
		}
	}
	
}