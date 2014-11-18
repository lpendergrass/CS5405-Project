import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		JMenu sortMenu = new JMenu("Sorting Algorithms");
		JCheckBox chkBubble = new JCheckBox("Bubble Sort");
		JCheckBox chkInsertion = new JCheckBox("Insertion Sort");
		JCheckBox chkSelection = new JCheckBox("Selection Sort");
		JCheckBox chkMerge = new JCheckBox("Merge Sort");
		JCheckBox chkQuick = new JCheckBox("Quick Sort");
		JCheckBox chkHeap = new JCheckBox("Heap Sort");
		JCheckBox chkShell = new JCheckBox("Shell Sort");
		sortMenu.add(chkBubble);
		sortMenu.add(chkInsertion);
		sortMenu.add(chkSelection);
		sortMenu.add(chkMerge);
		sortMenu.add(chkQuick);
		sortMenu.add(chkHeap);
		sortMenu.add(chkShell);
		demoMenu.add(sortMenu);
		
		// Create MultiTasking menu structure
		JMenu multiMenu = new JMenu("MultiTasking");
		JMenu selectMenu = new JMenu("Select Algorithms");
		multiMenu.add(selectMenu);
		
		// Inline Action listener example
		/*
		someMenuItem.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae) {
					someInternalPane.setVisible(true); }
			} );
		*/

		// Disabled menu choice (if un-implemented) example
		// someMenuItem.setEnabled(false);
		
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
