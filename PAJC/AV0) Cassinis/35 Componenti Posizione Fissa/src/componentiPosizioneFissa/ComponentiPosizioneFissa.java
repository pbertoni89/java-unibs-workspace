/**
 * 
 */
package componentiPosizioneFissa;

import java.applet.Applet;
import java.awt.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * <p>
 * Title: ComponentiPosizioneFissa
 * </p>
 * 
 * <p>
 * Description: Un applet che mostra come i componenti possano essere
 * posizionati sulla finestra o sul panel a cui appartengono.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>	
 * 
 * <p>
 * Company: UNIBS
 * </p>
 * 
 * @author Riccardo Cassinis
 * @version 1.0
 */

public class ComponentiPosizioneFissa extends Applet implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2056600146309169862L;
	Button b1;

	public void init() {

		setLayout(null);
		b1 = new Button("Cliccami");

		add(b1);

		b1.setBounds(50, 50, 100, 50);
		b1.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("BRAVO!!!!!!!");
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		int newX = (int) (500 * Math.random());
		int newY = (int) (550 * Math.random());
		b1.setBounds(newX, newY, 100, 50);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
