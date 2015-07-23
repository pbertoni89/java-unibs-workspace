package objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import engine.Window;

public abstract class ObjectImage {

	final static String ERROR_READ = "Errore di lettura di un'immagine.";
	
	private int x, y;
	
	Image icon;
	File iconFile;
	
	public ObjectImage( int x, int y, String iconPath) {  //TODO controllare che su linux non servano le slash inverse.
		
		iconFile = new File(iconPath);
		//System.out.println(iconFile.getAbsolutePath());
		try {
			icon = ImageIO.read(iconFile);}
	    
	    catch(IOException e)
	      { e.printStackTrace(); Window.msgBox(ERROR_READ, "Errore"); }
		
	    this.x = x;
		this.y = y;
	}
	
	public void disegnati(Graphics g, ImageObserver obs) {
	    
		g.drawImage(icon, x - icon.getWidth(obs)/2 , y - icon.getHeight(obs)/2 , obs);
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}	
}