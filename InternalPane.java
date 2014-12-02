import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class InternalPane extends JInternalFrame implements Runnable, ChangeListener {
	
	// Default Sizing
	protected int startPos = 20;
	protected int initWidth = 450;
	protected int initHeight = 400;
	
	// Speed Settings
	int speedMin = 100;
	int speedMax = 1000;
	int speedInit = 550;
	int sleepTime = 550;

	JSlider speedCtrl;
	graphPane graph;
	JPanel ctrlPanel;
	
	boolean stopped = false;
	boolean resumed = false;

	ExecutorService executor;
	
	// Constructor
	public InternalPane(String title){
		super(title, true, true, true, true);
		
		// Set Frame Conditions
		setBounds(startPos, startPos, initWidth, initHeight);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// Create new graph
		graph = new graphPane();
		add( graph, BorderLayout.CENTER );
		
		// Add speed slider
		speedCtrl = new JSlider(speedMin, speedMax, speedInit);
		speedCtrl.addChangeListener(this);
		speedCtrl.setMajorTickSpacing(150);
		speedCtrl.setPaintTicks(true);
		speedCtrl.setSnapToTicks(true);
		speedCtrl.setInverted(true);
		
		// Add speed control labels and border
		LineBorder border = new LineBorder(Color.lightGray, 1);
		TitledBorder tborder = new TitledBorder(border, "Sorting Speed", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
		speedCtrl.setBorder(tborder);
		Hashtable<Integer, JLabel> speedLabels = new Hashtable<Integer, JLabel>();
		speedLabels.put(new Integer(speedMax), new JLabel("Slow"));
		speedLabels.put(new Integer(speedMin), new JLabel("Fast"));
		speedCtrl.setLabelTable(speedLabels);
		speedCtrl.setPaintLabels(true);
		
		createControlPanel();
		
		// Controls and Spacers
		add( speedCtrl, BorderLayout.NORTH);
		add( ctrlPanel, BorderLayout.SOUTH);
		add( new JPanel(), BorderLayout.EAST);
		add( new JPanel(), BorderLayout.WEST);
		
		setVisible(true);
		
		// Bring to front
		try { setSelected(true); }
			catch(Exception e) {/*unused handler*/}
		
		executor = Executors.newFixedThreadPool(1);	
		executor.execute(this);
	}
	
	// Threadable task
	public void run() {
		while(!stopped){
			try {
				
				// Strange race condition if this line removed
				Thread.sleep(1);
				
				if( resumed ) {
					
					// sort stuff
					
					// Sleep based on speed setting
					Thread.sleep(sleepTime);
				}	    
			}
			
			catch (InterruptedException ex){}
		}
	}

	private void createControlPanel() {
		
		ctrlPanel = new JPanel();
		
		JButton btnStop, btnStart, btnPause;
		Icon icnStop, icnStart, icnPause;
		
		icnStop = new ImageIcon(getClass().getResource("/images/icnStop.png"));
		icnStart = new ImageIcon(getClass().getResource("/images/icnStart.png"));
		icnPause = new ImageIcon(getClass().getResource("/images/icnPause.png"));
		
		btnStop = new JButton(icnStop);
		btnStart = new JButton(icnStart);
		btnPause = new JButton(icnPause);
		
		ctrlPanel.add(btnStop);
		ctrlPanel.add(new JPanel());
		ctrlPanel.add(btnStart);
		ctrlPanel.add(new JPanel());
		ctrlPanel.add(btnPause);
		
		btnStop.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				
				// Close Internal Frame
				try {
					resumed = false;
					stopped = true;
					executor.shutdownNow();
					executor.awaitTermination(0, TimeUnit.SECONDS);
					setClosed(true);
				}
				
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		} );
		
		btnStart.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				resumed = true;	}
		} );
		
		btnPause.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				resumed = false; }
		} );
	}
	
	// Speed slider handler
	public void stateChanged(ChangeEvent e) {
		sleepTime = speedCtrl.getValue();
	}
}
