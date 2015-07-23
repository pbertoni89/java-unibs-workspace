package objects;

import java.awt.Graphics;

 public interface Collidable {

	 /** Vengono calcolati una volta sola, o dovrei computarli a ogni chiamata di impatto() durante il thread per gli impatti. */
	 public void calcolaLati(); 
	 
	 /**
	  * @param x
	  * @param y
	  * @return true   sse (x,y) sono comprese nello spazio dell'oggetto.
	  */
     public boolean controllaImpatto(int x, int y);

     public void disegnaSpazio(Graphics g);
 }
