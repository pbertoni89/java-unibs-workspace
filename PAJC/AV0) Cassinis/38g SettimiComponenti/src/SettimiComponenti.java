import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description: attraverso un componente choice si puo' scegliere un font di
 * testo disponibile nel sistema e stampare una stringa con il font selezionato
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author Giuseppe Marti
 * @version 1.0
 */

public class SettimiComponenti extends Applet implements ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Choice fonts;
	String sFont;
	String[] fontNames;

	public void init() {
		trovaFonts();
		add(fonts);
		fonts.addItemListener(this);
	}

	public void itemStateChanged(ItemEvent e) {
		sFont = fontNames[fonts.getSelectedIndex()];
		System.out.println("Carattere: " + sFont);
		repaint();
	}

	public void trovaFonts() {
		fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();
		fonts = new Choice();
		for (int i = 0; i < (fontNames.length - 2); i++)
			fonts.add(fontNames[i]);
	}

	public void paint(Graphics g) {
		Font f = new Font(sFont, Font.BOLD, 26);
		g.setFont(f);
		g.drawString("Ciao!", 100, 100);
	}
}