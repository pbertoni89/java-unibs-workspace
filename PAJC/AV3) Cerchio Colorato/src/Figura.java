import java.applet.Applet;
import java.awt.*;


public class Figura extends Applet{

	private static final long serialVersionUID = 1L;
	String col;
	
	public void init(){
		col=getParameter("colore");
	}
	
	public void paint(Graphics g){
		
		if (col!=null){
			
			if (col.equalsIgnoreCase("r")) 
				g.setColor(Color.red);
			else if (col.equalsIgnoreCase("n"))
				g.setColor(Color.black);
			else if (col.equalsIgnoreCase("v"))
				g.setColor(Color.green);
			else if (col.equalsIgnoreCase("b"))
				g.setColor(Color.blue);
			else
				g.setColor(Color.gray);
		}
		
		g.fillOval(100, 100, 100, 100);
	}
}
