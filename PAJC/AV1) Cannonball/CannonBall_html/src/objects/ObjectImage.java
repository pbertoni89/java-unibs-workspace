package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import engine.Window;

public abstract class ObjectImage {

	final static String ERROR_LOAD = "Errore di caricamento di un'immagine.";
	final static String ERROR_READ = "Errore di lettura di un'immagine.";
	String iconStringURL;
	private int x, y;
	
	private URL iconURL = null;
	private BufferedImage buffImage;
	private int width, height;
	
	
	public ObjectImage(int x, int y, String iconStringURL) {
		
		this.iconStringURL = iconStringURL;
	    this.x = x;
		this.y = y;

		try {  iconURL = new URL(iconStringURL);
			
		} catch (MalformedURLException e1) {
			
			Window.msgBox("Errore", ERROR_LOAD); 
			e1.printStackTrace();
		}

		
		try {  buffImage = ImageIO.read(iconURL);
			
		} catch (IOException e) {

			Window.msgBox("Errore", ERROR_READ); 
			System.exit(1);
		}
	
		width = buffImage.getWidth();
		height = buffImage.getHeight();
		
	}
	
	public void disegnati(Graphics g, ImageObserver obs) {
	    
	    g.drawImage(buffImage, x - width/2 , y - height/2 , obs);
	    
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
}
