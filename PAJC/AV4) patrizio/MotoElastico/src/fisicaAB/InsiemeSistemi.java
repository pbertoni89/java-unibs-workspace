package fisicaAB;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

public class InsiemeSistemi extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final long refreshRate = 10;
	
	Vector <Sistema> insSistemi;
	Thread gestore;
	//private Image offScreen;
	
	final static int xChiodoMax = 200;
	final static int yChiodoMax = 200;
	final static int xDiscoMax = 400;
	final static int yDiscoMax = 400;
	final static int rDiscoMax = 50;
	final static int rChiodo = 5;
	final static int coloreMax = Integer.MAX_VALUE;
	
	public InsiemeSistemi() {
		
		insSistemi = new Vector <Sistema> ();
		
		for (int i=0; i<10; i++){
			insSistemi.add(  new Sistema(  
								  
								  (int)(200 + xChiodoMax*Math.random()), (int)(200 + yChiodoMax*Math.random()), rChiodo,
								  (int)(xDiscoMax*Math.random()), (int)(yDiscoMax*Math.random()), 
								  (int)(rDiscoMax*Math.random()), 
								   new Color( (int)(coloreMax*Math.random()+i) ), 2, 40, 20 )
						  );
			}	
		
		gestore = new Thread (this);
		gestore.start();
	}
	
	public void init_sistemi() {  //lancia il thread; inizializza ogni sistema.
	
		/*for (int i = 0; i < insSistemi.size(); i++) 
			{ insSistemi.get(i).inizializzati(); }*/
	

	}
	
	@SuppressWarnings("static-access") @Override
	public void run() {
	
		while(true){
			
			repaint();
			try { gestore.sleep(refreshRate); } 
			catch (InterruptedException e) { System.out.println("Errore nell'attesa per il thread gestore: "+e.getMessage()); }	 
	    }
	}
	
	public void paint(Graphics g) {
		
		for (int i = 0; i < insSistemi.size(); i++) {
			insSistemi.get(i).disegnati(g);
			//System.out.println( i+"|  disco:"+ insSistemi.get(i).disco.getXCentro() + ","+ insSistemi.get(i).disco.getYCentro()+ "| chiodo:"+insSistemi.get(i).chiodo.getXCentro()+","+ insSistemi.get(i).chiodo.getYCentro() );
		}
	}
	
	public void update(Graphics g) {
	
		Image offScreen = this.createImage(this.getWidth(), this.getHeight());

		Graphics off_g;
		if(offScreen!=null) {
			off_g=offScreen.getGraphics();
			off_g.setColor(getBackground());
			off_g.fillRect(0, 0, getSize().width, getSize().height);
			off_g.setColor(g.getColor());
			paint(off_g);
			g.drawImage(offScreen,0,0,this);
		}
	}
	
} //end of class