package fisicaAB;

import java.applet.*;
import java.awt.*;

public class ElasticApplet extends Applet {

	static final long serialVersionUID = -4014880316326374291L;
	InsiemeSistemi canovaccio;
	
	public void init() {
		
		this.setSize(500,500);  //da impostare nella pag html
		this.setLayout( new GridLayout(1,1));
		
		canovaccio = new InsiemeSistemi();
		canovaccio.setBackground(Color.WHITE);
	}
	
	public void start() { 
		
		this.add(canovaccio); 
		canovaccio.init_sistemi(); 
	} 
}//end of class