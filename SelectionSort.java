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
public class SelectionSort extends JInternalFrame implements Runnable {
	int[] sort;
	int dr;
	graphPane gp = new graphPane();
	public SelectionSort(int[] sort, int dr ){
		this.sort= sort;
		this.dr = dr;
		}
	public SelectionSort(){
		
		
		super("selectionsort",true,true,true,true);
		setOpaque(true);
		setSize(400,400);
		setVisible(true);
	}
public void run() {
	int i,j, min, temp;
	for(i=0; i<sort.length-1; i++) {
		try {
			Thread.sleep(500); }
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		min =i;;
		for (j=i+1; j<sort.length; j++)
			if(sort[j]<sort[min])
				min =j;
	if(i!= min){
		temp = sort[i];
		sort[i] = sort[min];
		sort[min]= temp;
		gp.draw(sort, i);
	}
		
		}
		}
	}
