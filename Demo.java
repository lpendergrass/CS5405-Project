import javax.swing.JApplet;

public class Demo extends JApplet {

	public static String defaultString = "CS5405 Project";
	
	public void init(){ new MainFrame( defaultString ); }
	
	public static void main(String[] args) {
			new MainFrame( defaultString );
	}

}
