package quintiComponenti;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
/**
 * Questo programma mostra come puo' avvenire la gestione degli eventi
 * relativi ad un componente.
 * 
 * @author R. Cassinis
 * @version 1.0
 * 
 */

public class QuintiComponenti extends Applet implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1037544416519054996L;
	CheckboxGroup cbg;
	Checkbox[] cb = new Checkbox[4];
	Panel p;
	Button b;
	Checkbox n;
	Label l = new Label("Scegli una voce:");

	public void init() {
		setSize(800, 400);
		
		l.setBounds(0, 0, 500, 20);
		add(l);

		cbg = new CheckboxGroup();
		setLayout(null); // Non usiamo lauyout manager: usiamo il
		// posizionamento assoluto

		b = new Button("Ok scelta");
		b.setBounds(40, 200, 160, 30); // Attenzione alle dimensioni!
		b.addActionListener(this);		//Dichiariamo interesse agli eventi
		add(b);

		p = new Panel();	// Quattro pulsanti raggruppati bene in ordine
		p.setBounds(20, 20, 400, 100);
		p.setLayout(new GridLayout(1, 4, 5, 5));
		for (int i = 0; i < 4; i++) {
			cb[i] = new Checkbox("voce " + i, false, cbg);
			p.add(cb[i]);
		}
		p.setBackground(Color.lightGray);
		add(p);
	}

	/**
	 * Questo metodo gestisce gli eventi che ci interessano.
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == b) { // E chi altro potrebbe essere?
			Checkbox c = cbg.getSelectedCheckbox();
			if (c == null)
				l.setText("Non hai selezionato nulla, babbeo!");
			else
				l.setText("Hai scelto: " + c.getLabel());
		}
	}
}