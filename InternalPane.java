import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;


public class InternalPane extends JInternalFrame {
	
	// Default Sizing
	protected int startPos = 20;
	protected int initWidth = 450;
	protected int initHeight = 400;
	
	graphPane graph;

	// Constructor
	public InternalPane(String title){
		super(title, true, true, true, true);
		
		// Set dimensions
		setBounds(startPos, startPos, initWidth, initHeight);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		graph = new graphPane();
		
    // Will add controls for array length and sorting speed

		add( graph, BorderLayout.CENTER );
		
		// Spacers
		add( new JPanel(), BorderLayout.NORTH);
		add( new JPanel(), BorderLayout.EAST);
		add( new JPanel(), BorderLayout.SOUTH);
		add( new JPanel(), BorderLayout.WEST);
		
		setVisible(true);
		
		// Bring to front
		try { setSelected(true); }
			catch(Exception e) {/*unused handler*/}

	}
}
