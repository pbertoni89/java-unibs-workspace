package objects;

import java.awt.Color;
import java.awt.Graphics;

public class Explosion extends Thread {

	private int x, y;
	private int radius;
	private final static int radiusMax = 25;
	Color color;
	Graphics g;
	@SuppressWarnings("unused")
	private boolean exist, growing;
	private final static int refresh = 50;
	
	
	public Explosion(int x, int y, Color color, Graphics g) {
		
		this.x = x;
		this.y = y;
		this.color = color;
		this.g = g;
		exist = true;
		radius = 1;
	}
	
	
	public void disegnati(Graphics g) {
		
		g.setColor(color);
		g.fillOval( x, y, radius, radius);
	}
	
	public void run() {
		
		while (exist) {
			
			g.setColor(color);
			g.fillOval( x - radius/2, y - radius/2 , radius, radius);
      
			try { sleep(refresh); } catch (InterruptedException e) {}
			
			if(radius<=radiusMax)
				radius++;
			else
				radius--;
			
			if(radius==0)
				exist = false;
			
			//g.setColor(c);  //copre il semaforo con lo sfondo!!! il thread non si ferma mai.
			//g.fillOval(50, 100, 20, 20);
		}
	}
	
	public int getRadiusMax() {
		return radiusMax;
	}
	
}
