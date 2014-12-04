
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
public class ShellSort extends JInternalFrame implements Runnable {
	int[] sort;
	int dr;
	graphPane gp = new graphPane();
	public ShellSort(int[] sort, int dr ){
		this.sort= sort;
		this.dr = dr;
		}
	public ShellSort(){
		
		super("shellsort",true,true,true,true);
		setOpaque(true);
		setSize(400,400);
		setVisible(true);
	}
	
public void run() {
	int n = sort.length;
	int inc,i,j, temp;
	for (inc =n/2; inc>0; inc /=2)
	{ 
		try { Thread.sleep(500);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		for (j=inc; j<n; j++) {
			temp = sort[j];
			for (i = j; i>= inc; i= i-inc) {
				if(temp <sort[i-inc]) {
					sort[i] = sort[i-inc];
				}
				else {
					break;
				}
			}
	sort[i] = temp;
	gp.draw(sort, i);
	
			}
		}
	}
	}
