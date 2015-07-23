package parametri;

import java.awt.*;

import java.applet.*;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description:
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

public class Parametri extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8688954934171598969L;

	// Get a string parameter value
	String prendiParametro(String key, String def) {
		return (getParameter(key) != null ? getParameter(key) : def);
	}

	// Get a numeric parameter value
	int getNumberParameter(String key, String def) throws NumberFormatException {
		String valore = (getParameter(key) != null ? getParameter(key) : def);
		return Integer.parseInt(valore);
	}

	// Initialize the applet
	public void init() {
		String stringa_parametro;

		stringa_parametro = this.prendiParametro("Parametro0",   // CFR RUN CONFIGURATIONS
				"Manca il parametro!");

		Label lb1 = new Label(stringa_parametro);
		add(lb1);

		try {
			stringa_parametro = String.valueOf(getNumberParameter("Parametro1",
					"1232"));
		} catch (NumberFormatException e) {
			stringa_parametro = "Numero non convertibile!";
		}

		Label lb2 = new Label(stringa_parametro);
		add(lb2);

	}
}
