package scriveFileApplet;

import java.awt.*;
import java.applet.*;
import java.io.*;

/**
 * <p>
 * Title: Caloclatriceb fase 3
 * </p>
 * 
 * <p>
 * Description: Questo Applet serve a dimostrare l'uso dei layout manager
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

public class ScriveFileApplet extends Applet implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5857043481744211751L;
	boolean scrittura = false, lettura = false;
	String stato = "Nessun errore";

	public void init() {
		FilePermission fp = new FilePermission("/prova/", "read,write,delete");
		SecurityManager sm = new SecurityManager();
		sm.checkPermission(fp);
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		System.out.println("Partito il metodo run di Scrivefile");

		for (;;) {
			scrittura = true;
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			try {
				FileWriter out = new FileWriter("eccoilfile.dat");
				for (int i = 0; i < 10; i++) {
					out.write("Buongiorno " + i);
					out.write("\n");
				}
				System.out.println("closing...");
				out.close();
			}

			catch (IOException e) {
				stato = e.toString();
				System.out.println(stato);
				repaint();
			}

			scrittura = false;
			repaint();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}

			int inByte;
			System.out.println("reopening...");
			lettura = true;
			repaint();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}

			try {
				FileReader in = new FileReader("eccoilfile.dat");
				System.out.println("Puntatore del file riaperto" + in);
				do {
					inByte = in.read();
					if (inByte != -1)
						System.out.print((char) inByte);
				} while (inByte != -1);
				in.close();

			} catch (Exception e) {
				stato = e.toString();
				repaint();
			}

			lettura = false;
			repaint();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}

	public void paint(Graphics g) {
		if (!scrittura) {
			g.setColor(Color.black);
		} else {
			g.setColor(Color.red);
		}
		g.fillOval(10, 10, 30, 30);
		if (!lettura) {
			g.setColor(Color.black);
		} else {
			g.setColor(Color.green);
		}
		g.fillOval(50, 50, 30, 30);
		g.drawString(stato, 60, 20);
	}
}
