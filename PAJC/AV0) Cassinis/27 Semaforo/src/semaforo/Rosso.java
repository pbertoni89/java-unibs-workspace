package semaforo;

import java.awt.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Riccardo Cassinis
 * @version 1.0
 */



public class Rosso extends Thread {
  
	Graphics g;
	Color c;
	boolean gira;

	public Rosso(Graphics g, Color c) {
		
		this.g = g;
		this.c = c;
	}

	public void run() {
		
		gira = true;
		while (gira) {
			
			{g.setColor(Color.RED);
			 g.fillOval(50, 100, 20, 20);}
      
			try {
				sleep(1000);
			}
			catch (InterruptedException e) {}
			
			g.setColor(c);  //copre il semaforo con lo sfondo!!! il thread non si ferma mai.
			g.fillOval(50, 100, 20, 20);
      
			try {
				sleep(1000);
			}
			catch (InterruptedException e) {}
		}
  }

  public void fermati() {
	  
    gira = false;
    
  }

}
