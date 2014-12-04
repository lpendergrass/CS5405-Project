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
public class QuickSort extends JInternalFrame implements Runnable {
	int[] sort;
	int dr;
	graphPane gp = new graphPane();
	public QuickSort(int[] sort, int dr ){
		this.sort= sort;
		this.dr = dr;
		}
	public QuickSort(){
		
		super("quicksort",true,true,true,true);
		setOpaque(true);
		setSize(400,400);
		setVisible(true);
	}
	public void run() {
		quicksort(sort, 0, sort.length-1);
	}
	public void quicksort(int[] a, int p, int q)
	{ try {
		Thread.sleep(500);
	}
	catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	if(p<q)
	{
		int r= partition(a,p,q);
		quicksort(a,p,r);
		quicksort(a,r+1,q);
	}
	
	}
	private int partition(int[] a, int p, int q) {
		int y = a[p];
		int i = p-1;
		int j = q+1;
		gp.draw(sort, p);
		
		while(true) {
			i++;
			while (i< q && a[i] < y)
				i++;
			j--;
			while (j >p && a[j]>y)
				j--;
			if(i<j)
			{ int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			}
				
			else 
				return j;
		}
	}
		
	}
	