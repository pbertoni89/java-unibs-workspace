package layout_managers;

import java.awt.*;
import java.applet.*;

/**
 * <p>
 * Title: Calcolatrice fase 2
 * </p>
 * 
 * <p>
 * Description: Questo Applet serve a dimostrare l'uso dei layout manager
 * GridLayout senza interazione con l'utente

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

public class LayoutManagerDemo extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8492310915372240050L;

	// Initialize the applet
	public void init() {
		Label label1 = new Label("Calcolatrice");
		Label label2 = new Label("Risultato");
		TextField textField1 = new TextField(30);

		Button vuoto = new Button();
		Button button0 = new Button("0");
		Button button1 = new Button("1");
		Button button2 = new Button("2");
		Button button3 = new Button("3");
		Button button4 = new Button("4");
		Button button5 = new Button("5");
		Button button6 = new Button("6");
		Button button7 = new Button("7");
		Button button8 = new Button("8");
		Button button9 = new Button("9");
		Button buttonPlus = new Button("+");
		Button buttonMinus = new Button("-");
		Button buttonMultiply = new Button("*");
		Button buttonDivide = new Button("/");
		Button buttonEquals = new Button("=");
		Button buttonClearAll = new Button("C");
		Button buttonClearError = new Button("CE");

		// Proviamo ad usare un GridLayout manager
		GridLayout layout = new GridLayout(0, 4);
		setLayout(layout);

		add(label1);
		add(label2);
		add(textField1);
		add(vuoto);

		add(button1);
		add(button2);
		add(button3);
		add(buttonPlus);
		add(button4);
		add(button5);
		add(button6);
		add(buttonMinus);
		add(button7);
		add(button8);
		add(button9);
		add(buttonMultiply);
		add(button0);
		add(buttonEquals);
		add(buttonClearAll);
		add(buttonDivide);
		add(buttonClearError);

	}
}
