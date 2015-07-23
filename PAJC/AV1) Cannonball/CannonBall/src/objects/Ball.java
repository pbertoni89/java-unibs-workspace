package objects;

import java.awt.Color;
import java.awt.Graphics;

import engine.*;

public class Ball extends Thread {

	private int xIniziale, x, yIniziale, y;
	final private int radius = 10;
	private boolean exists = false;
	Color color;
	
	private final double deltaT = 0.006;
	private final long refreshFlight = 1;
	private double timeFlight;
	public final static double GRAV = 9.81;
	
	private double xVelIniziale, yVelIniziale;
	
	public Ball( int x, int y, Color color ) {
		
		this.x = xIniziale = x;
		this.y = yIniziale = y;
		this.color = color;	
	}
	
	public void condizioniIniziali( int power, int angle ) {
		
		x = xIniziale;
		y = yIniziale;
		
		timeFlight = 0;
		
		double powerPerCent = (double) (power*0.01);
		double angleRadians = Math.toRadians(angle);
		final int moduloMax = 100;
		
		xVelIniziale = (int) ( moduloMax * powerPerCent * Math.cos( angleRadians ) );
		yVelIniziale = (int) ( moduloMax * powerPerCent * Math.sin( angleRadians ) );
		
		if( xVelIniziale == 0) xVelIniziale = 1;
		if( xVelIniziale == 0) yVelIniziale = 1;  
	}
	
	public void disegnati(Graphics g) {
		
		g.setColor(color);
		g.fillOval( Landscape.trasfX(x), Landscape.trasfY(y), radius, radius);
	}
	
	/** Descrive una parabola che indica il moto balistico del proiettile.
	 * @param g */
	public void parabola() {
		
		timeFlight += deltaT;
		
		x = (int) (xVelIniziale * timeFlight);
		y = (int) (yVelIniziale * timeFlight - (GRAV * timeFlight * timeFlight * 0.5) );
	}
	
	public boolean getExists() {
		return exists;
	}
	
	public void reset() {
		
		x = xIniziale;
		y = yIniziale;
		exists = false;
	}
	
	public void lancia() {
	
		exists = true;
		condizioniIniziali(Window.getPower(),Window.getAngle());
	}
	
	public void run() {
		
		while(true){

			if(getExists())
			
				this.parabola();
	
			try{sleep(refreshFlight);}   
				catch(InterruptedException e){System.out.println("Errore nell'attesa per il thread di volo: "+e.getMessage());}
		
			
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getRadius() {
		return radius;
	}
}
