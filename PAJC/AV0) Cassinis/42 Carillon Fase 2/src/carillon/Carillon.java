package carillon;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.applet.*;
import java.io.IOException;
import java.net.*;

import javax.imageio.ImageIO;

/**
 * <p>
 * Title: Applet musicale
 * </p>
 * 
 * <p>
 * Description: Questo applet mostra un metodo un pochino piu' sofisticato per
 * suonare un file di musica
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author Riccardo Cassinis
 * @version 1.0
 */

public class Carillon extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 156463938491822740L;
	String stringa = new String("");
	AudioClip clip; // Classe fatta apposta per suonare
	URL URLSuono = null;
	URL URLimmagine = null;

	private BufferedImage bi; // Classe fatta apposta per essere disegnata
	int w, h;

	public void init() {

		try {
			URLimmagine = new URL("http://www.ing.unibs.it/~cassinis/Dida/evergreen/informatica/immagini/gabbiano.jpg");

		} catch (MalformedURLException e1) {
			stringa = "Errore nella URL dell'immagine";
			e1.printStackTrace();
		}

		try {
			bi = ImageIO.read(URLimmagine);
		} catch (IOException e) {
			System.out.println("Image could not be read");
			System.exit(1);
		}

		w = bi.getWidth();
		h = bi.getHeight();

		resize(w, h); // ATTENZIONE!!! Funziona solo con l'applet viewer!

		try {
			URLSuono = new URL(
					"http://www.ing.unibs.it/~cassinis/Dida/evergreen/informatica/suoni/gabbiano.wav");
			stringa = "URL creata";
			repaint();
		} catch (MalformedURLException e) {
			stringa = "Errore nella URL del suono";
			repaint();
		}

		if (URLSuono != null) {
			// Creiamo l'audioClip, ma non lo facciamo suonare
			clip = newAudioClip(URLSuono);

		}
	}

	public void start() {
		 //clip.play(); //Il metodo play suona il clip una sola volta
		clip.loop(); // Il metodo loop lo suona in continuazione

	}

	public void stop() {
		clip.stop(); // Il metodo stop interrompe l'esecuzione del clip
	}

	public void paint(Graphics g) {
		g.drawImage(bi, 0, 0, this);
		g.drawString(stringa, 10, 20);
	}
}
