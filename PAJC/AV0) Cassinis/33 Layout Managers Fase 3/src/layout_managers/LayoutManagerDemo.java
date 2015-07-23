package layout_managers;

import java.awt.*;
import java.applet.*;

/**
 * <p>
 * Title: Calcolatrice fase 3
 * </p>
 * 
 * <p>
 * Description: Questo Applet serve a dimostrare l'uso dei layout manager
 * Panel e Canvas
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
	private static final long serialVersionUID = 7433778565335888335L;

	// Initialize the applet
	public void init() {

		GridLayout layout1 = new GridLayout(0, 1);
		GridLayout layout2 = new GridLayout(0, 4);

		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel(layout2);

		CanvasMio canvas1 = new CanvasMio();

		setLayout(layout1);
		Label label1 = new Label("Calcolatrice");
		Label label2 = new Label("Risultato");
		TextField textField1 = new TextField(30);

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

		p1.setBackground(Color.pink);
		p1.add(label1);
		
		p2.setBackground(Color.lightGray);
		p2.add(label2);
		p2.add(textField1);

		p3.setBackground(Color.cyan);
		p3.add(button1);
		p3.add(button2);
		p3.add(button3);
		p3.add(buttonPlus);
		p3.add(button4);
		p3.add(button5);
		p3.add(button6);
		p3.add(buttonMinus);
		p3.add(button7);
		p3.add(button8);
		p3.add(button9);
		p3.add(buttonMultiply);
		p3.add(button0);
		p3.add(buttonEquals);
		p3.add(buttonClearAll);
		p3.add(buttonDivide);
		p3.add(buttonClearError);

		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(canvas1);

	}

	public void paint(Graphics g) {
		System.out.println("Passato da Paint");

	}
}

class CanvasMio extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6031412457557233474L;

	public void paint(Graphics g) {
		System.out.println("Passato da Paint di canvasMio");
		g.setColor(Color.BLUE);
		g.fillOval(10, 10, 100, 100);

	}
}
