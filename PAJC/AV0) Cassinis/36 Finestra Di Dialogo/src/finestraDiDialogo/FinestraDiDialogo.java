package finestraDiDialogo;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
 * <p>
 * Title: Esempio di finestra di dialogo
 * </p>
 * 
 * <p>
 * Description: Questo Applet serve a dimostrare l'uso di una finestra di
 * dialogo
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author Riccardo Cassinis
 * @version 1.0
 */

public class FinestraDiDialogo extends Applet implements MouseListener {

	private static final long serialVersionUID = 1386062544766472403L;
	CanvasMio canvas1;
	TextField cognome;
	TextField nome;
	CheckboxGroup cbg1;
	Checkbox maschio;
	Checkbox femmina;
	Button annulla;
	Button invia;
	Label segnalazione;

	// Initialize the applet
	public void init() {
		this.setLayout(new GridLayout(0, 1));

		Panel p1 = new Panel();
		this.add(p1);

		Panel p11 = new Panel();
		p11.setBackground(Color.pink);
		p1.add(p11);

		p11.add(new Label("Cognome:"));
		cognome = new TextField(40);
		p11.add(cognome);

		Panel p12 = new Panel();
		p1.add(p12);
		p12.setBackground(Color.cyan);

		p12.add(new Label("Nome:"));
		nome = new TextField(40);
		p12.add(nome);

		Panel p2 = new Panel();
		add(p2);
		p2.setBackground(Color.WHITE);

		p2.add(new Label("Sesso:"));
		cbg1 = new CheckboxGroup();
		maschio = new Checkbox("M", cbg1, false);
		p2.add(maschio);
		femmina = new Checkbox("F", cbg1, false);
		p2.add(femmina);

		Panel p3 = new Panel();
		add(p3);
		p3.setBackground(Color.PINK);

		segnalazione = new Label("                                     ");
		p3.add(segnalazione);

		annulla = new Button("Annulla");
		p3.add(annulla);

		invia = new Button("Invia");
		p3.add(invia);

		canvas1 = new CanvasMio();
		canvas1.setBackground(Color.BLUE);

		add(canvas1);

		invia.addMouseListener(this);
		annulla.addMouseListener(this);
	}

	/* public void paint(Graphics g) {	//System.out.println("Passato da Paint"); }    */
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == invia) {
			if (verifica()) {
				System.out.println("Cognome " + cognome.getText());
				System.out.println("Nome " + nome.getText());
				if (maschio.getState())
					System.out.println("Maschio");
				else
					System.out.println("Femmina");

				canvas1.setDefungi(true);
			}
		}

		if (e.getSource() == annulla)
			annullatutto();

	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void actionPerformed(ActionEvent e) {}

	private boolean verifica() {
		if (cognome.getText().length() == 0) {
			segnalazione.setText("Manca cognome!");
			return false;
		}
		if (nome.getText().length() == 0) {
			segnalazione.setText("Manca nome!");
			return false;
		}
		if (!(maschio.getState() || femmina.getState())) {
			segnalazione.setText("Sesso non specificato!");
			return false;
		}
		segnalazione.setText("");
		return true;
	}

	private void annullatutto() {
		System.out.println("annullo");
		cognome.setText("");
		nome.setText("");
		cbg1.setSelectedCheckbox(null);
	}

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class CanvasMio extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5021507192152053856L;

	public CanvasMio() {

		Thread t = new Thread(this);
		t.start();
	}

	boolean defungi = false;

	public void setDefungi(boolean defungi) {
		this.defungi = defungi;
	}

	public void run() {
		Graphics g;
		final int incremento = 4;
		int diametro = 100;
		int x = 0, delta = incremento;

		while (!defungi) {
			g = this.getGraphics();
			if (g == null)
				System.out.println("Puntatore null");
			else {
				g.setColor(getBackground());
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				g.setColor(Color.yellow);
				g.fillOval(x, getHeight() / 2 - diametro / 2, diametro,
						diametro);
				x += delta;
				if (x >= this.getWidth() - diametro)
					delta = -incremento;
				if (x <= 0)
					delta = incremento;

			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {

				break;
			}

		}

		while (diametro >= 0) {
			g = this.getGraphics();
			if (g == null)
				System.out.println("Puntatore null");
			else {
				g.setColor(getBackground());
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				g.setColor(Color.yellow);
				g.fillOval(x, getHeight() / 2 - diametro / 2, diametro,
						diametro);
				x += delta;
				if (x >= this.getWidth() - diametro)
					delta = -incremento;
				if (x <= 0)
					delta = incremento;
				diametro--;
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				break;
			}

		}
	}
}
