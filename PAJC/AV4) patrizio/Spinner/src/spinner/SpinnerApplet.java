package spinner;

import java.awt.*;  //contiene componenti
import java.awt.event.*;  //eventi
import java.applet.*; 

public class SpinnerApplet extends Applet implements MouseListener {

	final static long serialVersionUID = 7;
	
	CanvasSpazio spazioPallina;
	Panel pannelloVelocita;
	CheckboxGroup velocita;
	Checkbox cento;
	Checkbox settcinque;
	Checkbox cinquanta;
	Checkbox venticinque;
	Checkbox zero;
	
	public void init() {
		this.setLayout(new GridLayout (1,0));   //   || canvas | pannello ||
		
		pannelloVelocita = new Panel();
		pannelloVelocita.setLayout( new GridLayout (6,0));  //colonna 1x6 ???
		
		pannelloVelocita.setBackground(Color.PINK);
		velocita = new CheckboxGroup();
		cento = new Checkbox("100%", velocita, false);
		pannelloVelocita.add(cento);
		settcinque = new Checkbox("75%", velocita, false);
		pannelloVelocita.add(settcinque);
		cinquanta = new Checkbox("50%", velocita, false);
		pannelloVelocita.add(cinquanta);
		venticinque = new Checkbox("25%", velocita, false);
		pannelloVelocita.add(venticinque);
		zero = new Checkbox("0%", velocita, true);
		pannelloVelocita.add(zero);
		
		Button ok = new Button("vai");
		ok.addMouseListener(this);
		pannelloVelocita.add(ok);
		
		this.add(pannelloVelocita);
		
		spazioPallina = new CanvasSpazio();
		spazioPallina.setBackground(Color.BLUE);
		
		this.add(spazioPallina);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		double velocita = 0;
		
		if ( cento.getState() )
			velocita = 1;
		else
			if ( settcinque.getState() )
				velocita = 0.75;
			else
				if ( cinquanta.getState() )
					velocita = 0.5;
				else
					if ( venticinque.getState() )
						velocita = 0.25;
		
		spazioPallina.setVelocita(velocita);
		//System.out.println(velocita);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}