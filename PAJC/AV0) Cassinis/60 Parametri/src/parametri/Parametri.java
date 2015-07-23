package parametri;

import java.awt.*;

import java.applet.*;

/**
 * Prima applet che usa i parametri
 * 
 * Questa applet mostra come lo stesso codice possa avere comportamenti diversi
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

public class Parametri extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -106868983111486595L;

	// Get a string parameter value
	String prendiParametro(String key, String def) {

		/*		if (getParameter(key) != null) return getParameter(key);
		else
			return def;
	*/	
		return (getParameter(key) != null ? getParameter(key) : def);
	}

	// Initialize the applet
	public void init() {
		String stringa_parametro;

		stringa_parametro = this.prendiParametro("Parametro0",
				"Manca il parametro!");

		Label lb1 = new Label(stringa_parametro);
		add(lb1);

	}
}
