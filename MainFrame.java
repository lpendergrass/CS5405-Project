import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.Box;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame implements ActionListener {

	// Default Frame Dimensions
	private static int defaultWidth = 500;
	private static int defaultHeight = 500;
	JDesktopPane desktop;
	
	public MainFrame(String title){
		
		// Initialize Frame
		super(title);
		setSize(defaultWidth, defaultHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create Desktop Pane
		desktop = new JDesktopPane();
		desktop.setBorder(new LineBorder(Color.gray, 1));
		setContentPane(desktop);
		
		// Add Menu and make visible
		setJMenuBar(createMenu());
		setVisible(true);
	}

	/**
	 *  Creates a Menu Bar for navigating functionality
	 */
	private JMenuBar createMenu(){
		
		// Create Initial MenuBar
		JMenuBar menu = new JMenuBar();
		
		// Create About menu structure
		JMenu aboutMenu = new JMenu("About");
		JMenuItem authItem = new JMenuItem("Author");
		JMenuItem descItem = new JMenuItem("Problem Description");
		JMenuItem helpItem = new JMenuItem("Help");
		aboutMenu.add(authItem);
		aboutMenu.add(descItem);
		aboutMenu.add(helpItem);
		
		// Create Demo menu structure
		JMenu demoMenu = new JMenu("Demos");
		JMenuItem bubbleItem = new JMenuItem("Bubble Sort");
		JMenuItem insertItem = new JMenuItem("Insertion Sort");
		JMenuItem selectItem = new JMenuItem("Selection Sort");
		JMenuItem mergeItem = new JMenuItem("Merge Sort");
		JMenuItem quickItem = new JMenuItem("Quick Sort");
		JMenuItem heapItem = new JMenuItem("Heap Sort");
		JMenuItem shellItem = new JMenuItem("Shell Sort");
		demoMenu.add(bubbleItem);
		demoMenu.add(insertItem);
		demoMenu.add(selectItem);
		demoMenu.add(mergeItem);
		demoMenu.add(quickItem);
		demoMenu.add(heapItem);
		demoMenu.add(shellItem);
		
		// Create MultiTasking menu structure
		JMenu multiMenu = new JMenu("MultiTasking");
		JCheckBoxMenuItem bubbleChk = new JCheckBoxMenuItem("Bubble Sort");
		JCheckBoxMenuItem insertChk = new JCheckBoxMenuItem("Insertion Sort");
		JCheckBoxMenuItem selectChk = new JCheckBoxMenuItem("Selection Sort");
		JCheckBoxMenuItem mergeChk = new JCheckBoxMenuItem("Merge Sort");
		JCheckBoxMenuItem quickChk = new JCheckBoxMenuItem("Quick Sort");
		JCheckBoxMenuItem heapChk = new JCheckBoxMenuItem("Heap Sort");
		JCheckBoxMenuItem shellChk = new JCheckBoxMenuItem("Shell Sort");
		multiMenu.add(bubbleChk);
		multiMenu.add(insertChk);
		multiMenu.add(selectChk);
		multiMenu.add(mergeChk);
		multiMenu.add(quickChk);
		multiMenu.add(heapChk);
		multiMenu.add(shellChk);
		
		// NEED TO REGISTER ITEM ACTION LISTENERS
		
		// Add menu components to the Menu Bar
		menu.add(aboutMenu);
		menu.add(demoMenu);
		menu.add(multiMenu);
		
		// Add Spacer and Digital Clock to end of Menu Bar
		menu.add(Box.createHorizontalGlue());
		menu.add( new DigitalClock() );
		menu.add(new JLabel("   "));
		
		// Return the completed menu
		return menu;
	}

	/**
	 * 	Event Handler for MenuBar Items
	 */
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == "")
			/* Do Some Action */;
		else if (event.getSource() == "")
			/* Do Some Other Action */;
	}
	
}
