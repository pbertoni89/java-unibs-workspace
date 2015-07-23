
import java.awt.*;
import java.applet.*;

/**
 * <p>
 * Title: Calcolatrice Fase 1
 * </p>
 * 
 * <p>
 * Description: Questo Applet serve a dimostrare l'uso di alcuni componenti
 * </p>
 * 
 * <p>
 * Copyright: Copyright 2009
 * </p>
 * 
 * <p>
 * Company: UNIBS
 * </p>
 * 
 * @author Riccardo Cassinis
 * @version 1.0
 */

public class LayoutManager extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12;

	// Initialize the applet
	public void init() {
		
		Label label1 = new Label("Questa e' una label");
		add(label1);

		TextField textField1 = new TextField(30);
		textField1.setText("Questo e' un testo editabile");
		add(textField1);

		Button button0 = new Button("Questo  un pulsante");
		add(button0);

		Choice scelta = new Choice();
		scelta.add("Prima voce");
		scelta.add("Seconda voce");
		scelta.add("Terza voce");
		add(scelta);

		List lst = new List(4, false);
		lst.add("Mercurio");
		lst.add("Venere");
		lst.add("Terra");
		lst.add("Marte");
		lst.add("Giove");
		lst.add("Saturno");
		lst.add("Urano");
		lst.add("Nettuno");

		add(lst);

		Checkbox cb1 = new Checkbox("Primo pulsante");
		add(cb1);

		Checkbox cb2 = new Checkbox("Secondo pulsante");
		add(cb2);

		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox cbg1 = new Checkbox("Primo pulsante del gruppo", cbg, false);

		Checkbox cbg2 = new Checkbox("Secondo pulsante del gruppo", cbg, true);

		Checkbox cbg3 = new Checkbox("Terzo pulsante del gruppo", cbg, false);
		add(cbg1);
		add(cbg2);
		add(cbg3);

		TextArea textArea1 = new TextArea("Testo breve", 10, 40,
				TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		textArea1.setText("Questo e' un testo editabile molto, ma molto, ma molto,"
						+" ma molto, ma molto, ma molto, ma molto lungo");
		add(textArea1);

	}

	/*
	 * Osserviamo che non c'e' il metodo paint!
	 */
}