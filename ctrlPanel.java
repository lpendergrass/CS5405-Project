import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ctrlPanel extends JPanel {

	JButton btnStop, btnStart, btnPause;
	Icon icnStop, icnStart, icnPause;
	
	public ctrlPanel(){
		super();
		
		icnStop = new ImageIcon(getClass().getResource("/images/icnStop.png"));
		icnStart = new ImageIcon(getClass().getResource("/images/icnStart.png"));
		icnPause = new ImageIcon(getClass().getResource("/images/icnPause.png"));
		
		btnStop = new JButton(icnStop);
		btnStart = new JButton(icnStart);
		btnPause = new JButton(icnPause);
		
		add(btnStop);
		add(new JPanel());
		add(btnStart);
		add(new JPanel());
		add(btnPause);
	}
}
