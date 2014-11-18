import java.awt.Color;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.swing.JLabel;

public class DigitalClock extends JLabel implements Runnable {

	public DigitalClock() {
			setText(new Date().toString());
			setForeground(Color.blue);
			Executor newExecutor = Executors.newFixedThreadPool(1);
			newExecutor.execute(this);
		}

		public void run() {
			
			while (true) {
				setText(new Date().toString());
				try { Thread.sleep(500); }
				catch ( InterruptedException ex ){}
			}
		}
}
