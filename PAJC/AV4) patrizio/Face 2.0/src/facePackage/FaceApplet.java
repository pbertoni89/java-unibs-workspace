package facePackage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FaceApplet extends java.applet.Applet implements MouseMotionListener{
	
	final static long serialVersionUID = 1;
	
	private Faccia f1;
	private int XCF1 = 75;
	private int YCF1 = 75;
	private int RF1 = 50;
	private Image offScreenImage;
	static JFrame messages;
	

	public void init(){
		
		//msgBox("inizia init", "init");
		
		addMouseMotionListener(this);
		this.setSize(600,600);
		this.setBackground(new Color(255,255,255));
		f1 = new Faccia( XCF1, YCF1, RF1 );
		f1.inizializza();
	}
	
	public void start(){
		offScreenImage=createImage(getSize().width,getSize().height);  //non conosco le dimensioni dell applet
	}
	
	public void paint(Graphics g){
		f1.disegna(g);	
	}

	public void update(Graphics g){
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
		repaint();
		
	}

	@Override  //SPOSTAMENTO OCCHI
	public void mouseMoved(MouseEvent arg0) {
		
		int xMouse = arg0.getX();
		int yMouse = arg0.getY();
		
		f1.muoviPupille(xMouse, yMouse);
		repaint();
	}
	
	
	public void prepareMessages() {
			
			messages = null;
			messages = new JFrame("test dei messaggi");
		    messages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    messages.setBounds(50,50,250,150);
		    messages.setContentPane(new JDesktopPane());
		}
		
		/** Apre un frame informativo indipendente dall'applet, mostrando una determinata stringa.
		 * 
		 * @param text  Il messaggio
		 * @param title  Il titolo del frame
		 */
		public static void msgBox(String text, String title) {
			
			JOptionPane.showMessageDialog(messages, text, title, JOptionPane.INFORMATION_MESSAGE);
		}
	
	
}