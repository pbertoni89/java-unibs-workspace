package fisicaAB;

import forme.*;
import java.awt.Color;
import java.awt.Graphics;

/*contiene un chiodo generato in una posizione casuale; un disco che interagisce con lui secondo le leggi
F = ma
F = -kx
e una molla cioè una linea retta che unisce i centri dei due cerchi.
in più implementa i metodi che determinano il moto relativo del sistema, ovvero la legge oraria del disco.
*/

public class Sistema implements Runnable {

	public final static double kVolumeSfera = Math.PI*4/3;
	public final static double gGravitazionale = 9.81;
	
	Cerchio chiodo, disco;
	
	int xChiodo, yChiodo, xDisco, yDisco;
	
	int rChiodo, rDisco;
	
	Color coloreChiodo, coloreFilo, coloreDisco;
	
	int refreshRate; 
	Thread muoviti;
	
	private double kElastica; //Newton su pixel
	private double mDisco; // grammi
	
	private double velInitX; //pixel al secondo
	private double velInitY; //pixel al secondo
	
	private double accX;
	private double accY;
	
	private int distX;
	private int distY;
	
	
	public Sistema( int xChiodo, int yChiodo, int rChiodo, int xDisco, int yDisco, int rDisco, Color coloreDisco,  
				    double kElastica, double rhoDisco, int refreshRate) {
		
		coloreChiodo = Color.BLACK;
		coloreFilo = new Color ( 30, 30, 30 );
		this.coloreDisco = coloreDisco;
		
		this.xChiodo =xChiodo;  // xChiodo sta tra 200 e 300
		this.yChiodo =  yChiodo;	  // yChiodo tra 20 e 80
		this.rChiodo = rChiodo;
		
		//System.out.println("è davvero xChiodo ="+ xChiodo); // ok, nascono misure casuali. più avanti vengono azzerate. ->WHO?
		
		velInitX = 0; velInitY = 0;
		
		this.kElastica = kElastica; 
		//this.rhoDisco = rhoDisco;
		this.refreshRate = refreshRate;
		
		chiodo = new Cerchio( xChiodo, yChiodo, rChiodo, Color.BLACK, new Color(200,200,200) );
		disco = new Cerchio( xDisco, yDisco, rDisco, Color.BLACK, Color.BLUE);
		mDisco = rDisco * rDisco * rDisco * kVolumeSfera * rhoDisco;
		
		
		muoviti = new Thread(this);
		muoviti.start();
	}
	
	public void run() {
	
		while (true) {
			
			this.aggiorna();
			try { Thread.sleep(20); } catch (InterruptedException e) { System.out.println("thread error.");}
		}
	}
	
	public void disegnati(Graphics g) {
			g.setColor(coloreFilo);
			///System.out.println( "disco:"+ disco.getXCentro() + ","+ disco.getYCentro()+ "| chiodo:"+chiodo.getXCentro()+","+ chiodo.getYCentro() );
			g.drawLine(disco.getXCentro(), disco.getYCentro(), chiodo.getXCentro(), chiodo.getYCentro());
			
			chiodo.disegnaPieno(g);
			disco.disegnaPieno(g);
	}
	
	public int distXdaChiodo(int xPunto){
		return xPunto-chiodo.getXCentro();
	}
	
	public int distYdaChiodo(int yPunto){
		return yPunto-chiodo.getYCentro();
	}
	
	
	private void aggiornaDistanzeUnidimensionali(){
		this.distX = distYdaChiodo(disco.getXCentro() );
		this.distY = distYdaChiodo(disco.getYCentro() );
	}
	
	private void aggiornaVelocitaIniziali(){
		this.velInitX = velInitX + accX * refreshRate;
		this.velInitY = velInitY + accY * refreshRate; 
	}
	
	private void aggiornaAccelerazioni(){
		
		double accElasticoX = -kElastica * distX/mDisco;
		double accElasticoY = -kElastica * distY/mDisco;	
		
		if (distX>0) 
			this.accX = accElasticoX;
		else 
			if (distX<0) 
				this.accX = accElasticoX;
			else 
				this.accX = accElasticoX;  //ha controllato pure la temuta condizione x=0
		
		if (distY>0) 
			this.accY = accElasticoY;
		else 
			if (distY<0) 
				this.accY = accElasticoY;
			else 
				this.accY = accElasticoY;
	}
	
	public void aggiorna() {
		
		aggiornaDistanzeUnidimensionali();
		aggiornaAccelerazioni();
																		// x0 + v0 * t + a * (1/2)*t^2
		disco.setXCentro( 
				(int) (Math.floor( (double)(disco.getXCentro() + this.velInitX*refreshRate + accX*refreshRate*refreshRate/2)) ) );
		
		disco.setYCentro( 
				(int) (Math.floor( (double)(disco.getYCentro() + this.velInitY*refreshRate + accY*refreshRate*refreshRate/2)) ) );
		
		aggiornaVelocitaIniziali();
	}

	
}//end of class
