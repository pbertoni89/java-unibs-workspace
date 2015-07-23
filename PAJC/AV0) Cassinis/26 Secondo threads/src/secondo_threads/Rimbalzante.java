package secondo_threads;

import java.awt.*;
//import java.awt.event.*;
import java.applet.*;

/**
 * <p>Title: Applet con pallina che rimbalza sulle pareti della finestra</p>
 *
 * <p>Description: Questo applet mostra come si costruisce un applet
 * "temporizzato"</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Riccardo Cassinis
 * @version 1.0
 */

public class Rimbalzante
    extends Applet implements Runnable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 6286517742788234123L;
static final int diam = 40;

  /**
   * init() trasforma l'applet in un thread, istanziandolo e facendone
   * partire il metodo run() tramite il metodo start()
   */
  public void init() {
    Thread t1 = new Thread(this);
    t1.start();
  }

  /**
   * Vedi l'uso nei metodi start(), stop() e run()
   */
  boolean gira = false;

  public void start() {
    setSize(250, 200);
    gira = true;
  }

  public void stop() {
    gira = false;
  }

  /**
   * Coordinate e colore iniziali
   */
  double x = 200., y = 40.;
  int col = 0;
  /**
   * Determina la velocita' di spostamento della pallina
   */
  double incrementox = 4., incrementoy = 2.;

  /**
   * Il metodo run() e' un ciclo senza fine ripetuto circa 20 volte al secondo
   * ogni volta vengono calcolate le nuove coordinate e il nuovo colore della
   * pallina, e viene invocato il metodo repaint()
   */
  public void run() {
    for ( ; ; ) {
      try { //Perche' il metodo sleep potrebbe lanciare eccezioni in casi
        //molto particolari
        Thread.sleep(20); //Sospendi l'esecuzione per 40 ms
      }
      catch (InterruptedException e) {} //Sono cos“ particolari che non ce ne
      //preoccupiamo in questo esempio

      if (gira) {
        x += incrementox;
        y += incrementoy;
        repaint();

        //Abbiamo urtato il bordo della finestra?
        if (x > getSize().width - diam) {
          incrementox = -incrementox;
        }
        else
        if (x < 0) {
          incrementox = -incrementox;
        }

        if (y > getSize().height - diam) {
          incrementoy = -incrementoy;
        }
        else
        if (y < 0) {
          incrementoy = -incrementoy;
        }

        //Calcoliamo il nuovo colore
        col =(int)(Math.random()*256*256*256);
      }
      else {
        //non facciamo nulla
      }
    }
  }

  /**
   * Il metodo paint si limita ad impostare il colore e a disegnare
   * la pallina, confidando nel fatto che update() cancella tutta la
   * finestra
   * @param g Graphics
   */
  public void paint(Graphics g) {
    g.setColor(new Color(col));
    g.fillOval( (int) x, (int) y, diam, diam);
  }
}
