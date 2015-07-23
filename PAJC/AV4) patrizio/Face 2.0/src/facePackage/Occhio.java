package facePackage;
import java.awt.Color;
import java.awt.Graphics;

public class Occhio extends Cerchio {
	
	final static Color COLORE_BORDO = Color.BLACK;
	final static Color COLORE_INTERNO = Color.WHITE;
	final static Color COLORE_PUPILLA = Color.BLACK;
	
	private Cerchio pupilla;
	private Cerchio limitePupilla;

	public Occhio(int xc, int yc, int raggio) {
		super(xc, yc, raggio, COLORE_BORDO, COLORE_INTERNO);
		pupilla = new Cerchio(xc, yc, (int)raggio/4, COLORE_PUPILLA, COLORE_PUPILLA);
		limitePupilla = new Cerchio(xc, yc, raggio-pupilla.getRaggio());
	}
	
	public void disegna(Graphics g){
		super.disegnaTutto(g);
		pupilla.disegnaTutto(g);
	}
	
	public void riposiziona(int xMouse, int yMouse){
		if(limitePupilla.isInside(xMouse, yMouse)){  //dentroBocca
			pupilla.setXCentro(xMouse);
			pupilla.setYCentro(yMouse);
		}
		else{
			double theta = Math.atan2 (yMouse-getYCentro(), xMouse-getXCentro());
			int xNuova = (int)(getXCentro() + limitePupilla.getRaggio()*Math.cos(theta));
			int yNuova = (int)(getYCentro() + limitePupilla.getRaggio()*Math.sin(theta));
			
			pupilla.setXCentro(xNuova);
			pupilla.setYCentro(yNuova);
		}
	}
}