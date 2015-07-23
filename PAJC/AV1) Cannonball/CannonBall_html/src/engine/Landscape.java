package engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import objects.*;

/**
 * <p>
 * Title: Landscape
 * </p>
 * 
 * <p>
 * Description: Questa classe costituisce il canvas dove verrà disegnato il gioco.
 * </p>
 * 
 * <p>
 * Copyright: Pillars of Software 2010
 * </p>
 * 
 * <p>
 * Company: Pillars of Software
 * </p>
 * 
 * @author Patrizio Bertoni
 * @version 0.1
 * 
 * @notes Implementazioni future interessanti: fattore vento. 
 * 	 	  oltre a determinare il moto delle nuvole nel sky
 * 		  potrebbe influire sulla parabola del proiettile! 
 */

public class Landscape extends Canvas implements Runnable {

	final static long serialVersionUID = 7;
	final static int REFRESH = 20;

	//private static final long refreshExplosion = 20;
	
	final static int xOrigine = 150;
	final static int yOrigine = 200;
	final static int distFromCastle = 460;
	final static int groundHeight = -15;
	
	final static String SUCCESS = "Success!";
	final static String SUCCESS_CASTLE = " You destroyed the castle!";
	final static String FAIL = "Fail!";
	final static String FAIL_WALL = " You destroyed a wall.";
	final static String FAIL_GROUND = " You hit the ground.";
	
	final static Color sky = new Color(190,200,240);
	final static Color ground = new Color(139,69,19);
	final static Color ballColor = Color.BLACK;

	private Thread control;
	private Image offScreenImage;
	
	Cannon cannon;
	Ball ball;
	Wall wall1, wall2, wall3;
	Castle castle;
	
	int xWall1 = trasfX(200);
	int yWall1 = trasfY(0);
	int xWall2 = trasfX(200);
	int yWall2 = trasfY(28);
	int xWall3 = trasfX(200);
	int yWall3 = trasfY(56);
	
	int xCastle = trasfX(distFromCastle);
	int yCastle = trasfY(20);

 //TODO il proiettile potrebbe esplodere a terra ma coinvolgere qualche oggetto....*/
	
	public Landscape() {

		control = new Thread(this);
		init();
		ball.start();
		control.start();	
	}
	
	/**  In init() si ha il disegno degli oggetti statici (il cannone, i muri, il castello)
	 * 	 Avendoli disegnati qui una volta sola, potranno esser distrutti più facilmente in caso di impatto.
	 *   L'unico evento che può ricrearli è l'evento RESET.  */
	public void init() {
	
		Window.msgBox("init di landscape", "init");
			
		this.setSize( Window.larghezzaWindow, Window.altezzaLandscape );
		this.setBackground(sky);
		Window.msgBox("ok dopo cielo", "ok");
		cannon = new Cannon( xOrigine, yOrigine);
		Window.msgBox("ok dopo il cannone", "ok");
		wall1 = new Wall( xWall1, yWall1);
		wall2 = new Wall( xWall2, yWall2);    
		wall3 = new Wall( xWall3, yWall3);		 
		castle = new Castle( xCastle, yCastle);
		ball = new Ball( xOrigine, yOrigine, ballColor);
		ball.reset();
	}
	
	public void paint(Graphics g) {		
		
		g.setColor(ground); 
		g.fillRect( trasfX(-200), trasfY(groundHeight), trasfX(600), trasfY(-175) );
		g.setColor( Color.BLACK );
		g.drawLine( trasfX(-200), trasfY(groundHeight), trasfX(600), trasfY(groundHeight) );
		
		mira(g);

		cannon.disegnati(g, this);
		
		if(wall1.getExists())
			wall1.disegnati(g, this);
		if(wall2.getExists())
			wall2.disegnati(g, this);
		if(wall3.getExists())
			wall3.disegnati(g, this); 
		if(castle.getExists())
			castle.disegnati(g, this);  
		if(ball.getExists())
			ball.disegnati(g);
	}
	
	public void update(Graphics g){
		
		offScreenImage= createImage(getSize().width,getSize().height);
		
		if(offScreenImage!=null)
		 {
			Graphics off_g=offScreenImage.getGraphics();
			off_g.setColor(getBackground());
			off_g.fillRect(0, 0, getSize().width, getSize().height);
			off_g.setColor(g.getColor());
			paint(off_g);
			g.drawImage(offScreenImage,0,0,this);
		}
	}
	
	/** trasformano il sdr dall'angolo alto sinistro in un sdr cartesiano sull'origine.
	 * @param x, y
	 * @return origine + (x,y)
	 */
	public static int trasfX(int x) { 
	
		return xOrigine + x;
	}
	public static int trasfY(int y) {  
			
		return yOrigine - y;
	}

	
	/** Descrive un segmento che indica la direzione iniziale del volo.
	 * @param g  */
	public void mira( Graphics g ) {
		
		double powerPerCent = (double) (Window.getPower()*0.01);
		double angleRadians = Math.toRadians(Window.getAngle());
		final int moduloMax = 100;
		
		int xFinale = (int) ( moduloMax * powerPerCent * Math.cos( angleRadians ) );
		int yFinale = (int) ( moduloMax * powerPerCent * Math.sin( angleRadians ) );
		if( xFinale == 0) xFinale = 1;
		if( yFinale == 0) yFinale = 1;  
		
		g.setColor(Color.RED);
		g.drawLine( trasfX(0), trasfY(0), trasfX(xFinale), trasfY(yFinale));

	}
	
	public void boom() {

		ball.lancia();
	}
	
	public void reset() {
		
		wall1.setExists(true);
		wall2.setExists(true);
		wall3.setExists(true);
		castle.setExists(true);
		
		ball.reset();
		repaint();
	}
	
	/** Un thread deve sempre esistere, e a seconda di quali flag sono alzati (sta volando? sta fiorendo l'esplosione?
	 *  esso deve ridisegnare gli oggetti interessati.
	 */
	public void run() {

		 while(true) {
			 
			if( ball.getExists() ) {
	
				controllaImpatti( trasfX(ball.getX()), trasfY(ball.getY()) );
				repaint();	
			}
			
			try { Thread.sleep(REFRESH);} catch (InterruptedException e) {
				System.out.println("Errore nell'attesa per il thread di controllo: "+e.getMessage()); }
		}
	}
	
	void controllaImpatti(int xBall, int yBall) {
							
		if( wall1.getExists() && wall1.controllaImpatto(xBall + ball.getRadius(), yBall+ ball.getRadius()) ) {
			
			if( wall3.getExists() )
				wall3.setExists(false);
			else
				if( wall2.getExists() )
					wall2.setExists(false);
				else
					wall1.setExists(false);
			
			Window.msgBox(FAIL_WALL,FAIL);
			ball.reset();
			repaint();
		}
		else 
			if( wall2.getExists() && wall2.controllaImpatto(xBall + ball.getRadius(), yBall+ ball.getRadius()) ) {
				
				if( wall3.getExists() )
					wall3.setExists(false);
				else
					wall2.setExists(false);
				
				Window.msgBox(FAIL_WALL,FAIL);
				ball.reset();
				repaint();
			}
			else
				if( wall3.getExists() && wall3.controllaImpatto(xBall + ball.getRadius(), yBall+ ball.getRadius()) ) {
					wall3.setExists(false);
					Window.msgBox(FAIL_WALL,FAIL);
					ball.reset();
					repaint();
				}
				else
					if( castle.getExists() && castle.controllaImpatto(xBall + ball.getRadius(), yBall+ ball.getRadius()) ) {
						castle.setExists(false);
						Window.msgBox(SUCCESS_CASTLE,SUCCESS);
						ball.reset();
						repaint();
					}
					else
						if( yBall + ball.getRadius() +1 > trasfY(groundHeight) ) {
							Window.msgBox(FAIL_GROUND,FAIL);
							ball.reset();
							repaint();
					}
	}
	
} //END OF CLASS
		
