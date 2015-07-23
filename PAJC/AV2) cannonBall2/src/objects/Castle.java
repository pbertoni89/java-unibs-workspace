package objects;

import java.awt.Graphics;

public class Castle extends ObjectImage implements Collidable {

	private int xMax, yMax, xMin, yMin;
	private boolean exists;
	
	//final static String iconPath = "objects/castle.png";  //LINUX
	final static String iconPath = "objects\\castle.png";  //WINDOWS doppia \\ per escape avoid
	
	public Castle(int x, int y) {
			
		super(x,y,iconPath);
		exists = true;
	 
		calcolaLati();
	}
	
	@Override
	public boolean controllaImpatto(int x, int y) {
		/*
		if( x-Explosion.getRadiusMax() <= xMax && x+radius>= xMin)
			if( y<= yMax && y>= yMin)
				return true;
		*/
		//System.out.println("confronto xBall="+x+" nel range ("+xMin+","+xMax+")   e yBall="+y+" nel range ("+yMin+","+yMax+")");
		if( x<= xMax && x>= xMin)
			if( y<= yMax && y>= yMin)
				return true;
		
		return false;
	}

	@Override
	public void calcolaLati() {
		
		xMax = getX()+(int)(icon.getWidth(null)/2);
		yMax = getY()+(int)(icon.getHeight(null)/2); 
		xMin = getX()-(int)(icon.getWidth(null)/2);
		yMin = getY()-(int)(icon.getHeight(null)/2);
		
	}

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