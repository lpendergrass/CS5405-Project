import java.awt.*;
import javax.swing.*;
import java.util.*;
public class AuthorIdentification extends JInternalFrame
{
	Font normal = new Font("Helvetica", Font.PLAIN, 14);
	Font bold = new Font("TimesRoman", Font.BOLD, 14);
	Font bigNormal = new Font("Courier", Font.PLAIN, 22);
	Font bigBold = new Font("SansSerif", Font.BOLD, 25);
	FontMetrics fn;
	FontMetrics fb;
	FontMetrics fbn;
	FontMetrics fbb;
	int strwid,y,h,w;
	String str;

public AuthorIdentification()
{	
	super("Author",true,true,true,true);
	setOpaque(true);
	setSize(400,400);
	setVisible(true);
}
public void paint(Graphics g)
	{
		super.paint(g);
		fn = g.getFontMetrics(normal);
		fb = g.getFontMetrics(bold);
		fbn = g.getFontMetrics(bigNormal);
		fbb = g.getFontMetrics(bigBold);
		y=115; w = getWidth(); h = getHeight();
		g.setFont(bold);
		str= "Demonstration of Assignment for";
		strwid = fb.stringWidth(str);
		g.drawString(str, w/2-(strwid/2),y);
		
		str="Java, GUI and Visualization";  y=y+20;
		strwid = fb.stringWidth(str);
		g.drawString(str, w/2-(strwid/2),y);

		g.setFont(normal);
		str= "For";y=y+20;
		strwid = fn.stringWidth(str);
		g.drawString(str, w/2-(strwid/2), y);

		str= "Dr. Chaman L. Sabharwal"; y=y+20;
		strwid = fn.stringWidth( str );
		g.drawString(str, w/2-(strwid/2), y);

		str= " Presented by "; y=y+50;
		strwid = fn.stringWidth(str);
		g.drawString(str, w/2-(strwid/2), y);

		g.setFont(bigBold);
		str= "Lance and Ravindra"; y=y+30;
		strwid = fbn.stringWidth(str);
		g.setColor(Color.red);
		g.drawString("str", w/2-(strwid/2), y);


		}

}

