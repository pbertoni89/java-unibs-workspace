package objects;

import java.awt.Graphics;

public class Wall extends ObjectImage implements Collidable {

	private int xMax, yMax, xMin, yMin;
	private boolean exists;
	
	final static String iconStringURL = "http://dcdt.ing.unibs.it/~pbertoni/cannonball/engine/wall.gif";
	
	public Wall(int x, int y) {
			
		super(x,y,iconStringURL);
		exists = true;
	 
		calcolaLati();
	}
	
	@Override
	public boolean controllaImpatto(int x, int y) {
		
		if( x<= xMax && x>= xMin)
			if( y<= yMax && y>= yMin)
				return true;

		return false;
	}

	@Override
	public void calcolaLati() {
		
		xMax = getX()+(int)(getWidth()/2);
		yMax = getY()+(int)(getHeight()/2); 
		xMin = getX()-(int)(getWidth()/2);
		yMin = getY()-(int)(getHeight()/2);
	
	}
	
	@Override
	public void disegnaSpazio(Graphics g) {
		
		g.drawRect(xMin, yMin, xMax-xMin, yMax-yMin);
	}
	
	public void setExists(boolean b) {
		exists = b;
	}
		
	public boolean getExists() {
		return exists;
	}

}
