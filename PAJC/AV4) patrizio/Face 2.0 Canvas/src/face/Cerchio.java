package face;

import java.awt.Color;

public class Cerchio extends Ovale {
	
	private int raggio;

	public Cerchio(int xCentro, int yCentro, int raggio){   
		super(xCentro, yCentro, raggio, raggio);
		this.raggio = raggio;
	}
	
	public Cerchio(int xCentro, int yCentro, int raggio, Color bordo, Color interno){
		
		super(xCentro, yCentro, raggio, raggio, bordo, interno);
		this.raggio = raggio;
	}	
	
	public boolean isInside(int x, int y){
		if(distanzaDaCentro(x,y)<raggio) return true;
		else return false;
	}
	
	public int distanzaDaCentro(int x, int y){
		int dx = Math.abs(getXCentro()-x);
		int dy = Math.abs(getYCentro()-y);
		int distanza = (int) Math.sqrt(dx*dx+dy*dy);
		
		return distanza;
	}
	
	public int getRaggio() {
		return raggio;
	}
}
