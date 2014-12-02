import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Hashtable;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class InternalPane extends JInternalFrame implements ChangeListener {
	
	// Default Sizing
	protected int startPos = 20;
	protected int initWidth = 450;
	protected int initHeight = 400;
	
	// Speed Settings
	int speedMin = 100;
	int speedMax = 1000;
	int speedInit = 500;

	JSlider speedCtrl;
	graphPane graph;

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
		
		
		// Controls and Spacers
		add( speedCtrl, BorderLayout.NORTH);
		add( new ctrlPanel(), BorderLayout.SOUTH);
		add( new JPanel(), BorderLayout.EAST);
		add( new JPanel(), BorderLayout.WEST);
		
		setVisible(true);
		
		// Bring to front
		try { setSelected(true); }
			catch(Exception e) {/*unused handler*/}

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
