package layout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import face.*;

public class CanvasFace extends Canvas implements MouseMotionListener{

	final static long serialVersionUID = 666;

	private Faccia f1;
	private int XCF1 = 100;
	private int YCF1 = 50;
	private int RF1 = 50;
	private Image offScreenImage;
	
	public CanvasFace(){
		init();
	}
	
	public void init(){
		addMouseMotionListener(this);
		this.setSize(600,600);
		this.setBackground(new Color(255,255,255));
		f1 = new Faccia( XCF1, YCF1, RF1 );
		f1.inizializza();
	}
	
	/*b ic void start(){
		  //non conosco le dimensioni dell applet
	}*/
	
	public void paint(Graphics g){
		f1.disegna(g);
	}

	public void update(Graphics g){
		offScreenImage=createImage(getSize().width,getSize().height);

		if(offScreenImage!=null) //il foglietto esiste?
		 {
			Graphics off_g=offScreenImage.getGraphics();
			off_g.setColor(getBackground());
			off_g.fillRect(0, 0, getSize().width, getSize().height);
			off_g.setColor(g.getColor());
			paint(off_g);
			g.drawImage(offScreenImage,0,0,this);
		}
	}
	
	@Override   //TRASCINA FACCIA
	public void mouseDragged(MouseEvent arg0) {
		
		int xMouse = arg0.getX();
		int yMouse = arg0.getY();
		f1.draggaFaccia(xMouse, yMouse);
		repaint();  System.out.println("eee");
		
	}

	@Override  //SPOSTAMENTO OCCHI
	public void mouseMoved(MouseEvent arg0) {
		
		int xMouse = arg0.getX();
		int yMouse = arg0.getY();
		
		f1.muoviPupille(xMouse, yMouse);
		repaint();  System.out.println("eee");
	}
	
}
