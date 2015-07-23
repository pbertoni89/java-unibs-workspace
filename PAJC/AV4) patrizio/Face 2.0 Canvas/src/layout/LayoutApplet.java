package layout;

import java.applet.*;
import java.awt.*;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LayoutApplet extends Applet {

	final static long serialVersionUID = 12;
	Panel grigliaDati;
	Panel grigliaTel;
	CanvasFace canvFaccia;
	static JFrame messages;
	
	public void init() {  //DICHIARO GLI OGGETTI DELLA APPLET, DEI PANNELLI. LI AGGIUNGO A QUESTA
		
		msgBox("inizia init", "init");
		
		setLayout( new GridLayout(3,1) );   //rows, columns
	
		grigliaDati = new Panel();
		grigliaTel = new Panel();
		canvFaccia = new CanvasFace();

		grigliaDati.setLayout(new GridLayout(4,1));
		grigliaDati.setBackground( Color.RED );

		Label titolo = new Label("benvenuto");
		
			
			Panel flowRiga1 = new Panel();
			flowRiga1.setBackground( Color.RED );
			
			Label askNome = new Label("Nome:");
			flowRiga1.add(askNome);
		
			TextField typeNome = new TextField("10",50);
			flowRiga1.add(typeNome);
		
		//--
			Panel flowRiga2 = new Panel();
			flowRiga1.setBackground( Color.RED );
			
			Label askCognome = new Label("Cognome:");
			flowRiga2.add(askCognome);
		
			TextField typeCognome = new TextField(10);
			flowRiga2.add(typeCognome);
		//--
			Panel flowRiga3 = new Panel();
			flowRiga3.setBackground( Color.RED );
			
			Label askSesso = new Label("Sesso:");
			flowRiga3.add(askSesso);
			
			CheckboxGroup sesso = new CheckboxGroup();
			Checkbox sessoM = new Checkbox("M", sesso, false);

			Checkbox sessoF = new Checkbox("F", sesso, false);

			flowRiga3.add(sessoM);
			flowRiga3.add(sessoF);
		
		grigliaDati.add(titolo);  //flowRiga0
		grigliaDati.add(flowRiga1);
		grigliaDati.add(flowRiga2);
		grigliaDati.add(flowRiga3);
		
		
		grigliaTel.setLayout( new GridLayout(4,3) );
		grigliaTel.setBackground( Color.BLUE );
		
		Button tasto7 = new Button("7");
		grigliaTel.add(tasto7);
		Button tasto8 = new Button("8");
		grigliaTel.add(tasto8);
		Button tasto9 = new Button("9");
		grigliaTel.add(tasto9);
		Button tasto4 = new Button("4");
		grigliaTel.add(tasto4);
		Button tasto5 = new Button("5");
		grigliaTel.add(tasto5);
		Button tasto6 = new Button("6");
		grigliaTel.add(tasto6);
		Button tasto1 = new Button("1");
		grigliaTel.add(tasto1);
		Button tasto2 = new Button("2");
		grigliaTel.add(tasto2);
		Button tasto3 = new Button("3");
		grigliaTel.add(tasto3);
		Button tastoAst = new Button("*");
		grigliaTel.add(tastoAst);
		Button tasto0 = new Button("0");
		grigliaTel.add(tasto0);
		Button tastoCanc = new Button("#");
		grigliaTel.add(tastoCanc);
		
		add(grigliaDati); 
		add(grigliaTel);
		add(canvFaccia);

	}
	
public void prepareMessages() {
		
		messages = null;
		messages = new JFrame("test dei messaggi");
	    messages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    messages.setBounds(50,50,250,150);
	    messages.setContentPane(new JDesktopPane());
	}
	
	/** Apre un frame informativo indipendente dall'applet, mostrando una determinata stringa.
	 * 
	 * @param text  Il messaggio
	 * @param title  Il titolo del frame
	 */
	public static void msgBox(String text, String title) {
		
		JOptionPane.showMessageDialog(messages, text, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
}
