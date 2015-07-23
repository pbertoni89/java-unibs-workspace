import java.awt.*;

public class HelloApplet extends java.applet.Applet {

	final static long serialVersionUID = 1;

	public void paint (java.awt.Graphics graphicObj1) {
	
		Color blue = new Color (0,0,255);
		graphicObj1.setColor(blue);
		graphicObj1.drawString ("HELLO PAJC", 22, 180);
		
		for (int j=0;j<100;j++)
			graphicObj1.drawLine(200,0, j,j+50);
		
		Color red = new Color (255,0,0);
		graphicObj1.setColor(red);
		
		for (int j=0;j<15;j++)
			graphicObj1.drawLine(200,10, j,j+50);
		
		graphicObj1.draw3DRect(100,100, 100, 100, true);
		graphicObj1.draw3DRect(95, 95, 100, 100, false);
		
		graphicObj1.drawRoundRect(140, 140, 40, 50, 50, 60);
		
		Shape forma =  graphicObj1.getClip() ;
		
		Rectangle rett = forma.getBounds();
	
		graphicObj1.drawLine(400,0, 400,400);
		
		System.out.println( rett.toString() );
		
	}
	
}

