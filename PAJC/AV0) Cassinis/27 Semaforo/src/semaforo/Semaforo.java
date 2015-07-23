package semaforo;

import java.awt.*;
import java.applet.*;

/**
 * <p>Title: prima_applet_threads</p>
 *
 * <p>Description: Quest'applet implementa due classi che si autodisegnano
 * seguendo la loro temporizzazione</p>
 *
 * <p>Copyright: Copyright (c) 2007 R. Cassinis</p>
 *
 * <p>Company: UNIBS</p>
 *
 * @author Riccardo Cassinis
 * @version 1.0
 */


public class Semaforo extends Applet {
 
	private static final long serialVersionUID = -8240481835786947901L;
	
	public Semaforo() {}

    Rosso rosso;
    Verde verde;

    public void init() {}

    public void start() {
    	
    	Graphics gx = getGraphics();
    	
    	rosso = new Rosso(gx, getBackground());
    	rosso.start();
    
    	verde = new Verde(gx, getBackground());
    	verde.start();
  }

  public void stop() {
   
	  rosso.fermati();
	  verde.fermati();
  }

  public void paint(Graphics g) {
    
	  g.setColor(Color.PINK);
	  g.fillOval(100, 100, 20, 20);
  }

}