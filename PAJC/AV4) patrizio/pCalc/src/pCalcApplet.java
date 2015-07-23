import java.applet.*;
import java.awt.*;

public class pCalcApplet extends Applet  {  

	private static final long serialVersionUID = 12;
	
	/** I Layout sono 3 intanto
	 * Layout esterno: è di tipo Border e ordina banner a nord e tastiera a sud
	 * Layout del banner: è di tipo Border e ordina messaggio e casella di testo
	 * Layout tastiera: è ovviamente una grid.
	 */
	
	public void init() {  //DICHIARO GLI OGGETTI DELLA APPLET, DEI PANNELLI. LI AGGIUNGO A QUESTA
		
		setLayout( new BorderLayout() );
	
		
		Panel banner = new Panel();
		banner.setLayout( new BorderLayout() );
		banner.setBackground( Color.RED );

		Label titolo = new Label("benvenuto in pCalc");
		banner.add(titolo, BorderLayout.NORTH);
		
		TextField risultato = new TextField(30);
		banner.add(risultato, BorderLayout.SOUTH);
		
		Panel tastiera = new Panel();
		tastiera.setLayout( new GridLayout(3,3) );
		
		Button tasto0 = new Button("0");
		tastiera.add(tasto0);
		Button tasto1 = new Button("1");
		tastiera.add(tasto1);
		Button tasto2 = new Button("2");
		tastiera.add(tasto2);
		Button tasto3 = new Button("3");
		tastiera.add(tasto3);
		Button tasto4 = new Button("4");
		tastiera.add(tasto4);
		Button tasto5 = new Button("5");
		tastiera.add(tasto5);
		Button tasto6 = new Button("6");
		tastiera.add(tasto6);
		Button tasto7 = new Button("7");
		tastiera.add(tasto7);
		Button tasto8 = new Button("8");
		tastiera.add(tasto8);
		Button tasto9 = new Button("9");
		tastiera.add(tasto9);
		
		add(banner, BorderLayout.NORTH); add(tastiera,BorderLayout.SOUTH);
		
	}
	
	
}
