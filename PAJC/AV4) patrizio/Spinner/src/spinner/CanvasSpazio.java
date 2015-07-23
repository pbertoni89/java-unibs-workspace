package spinner;

import java.awt.*;

public class CanvasSpazio extends Canvas implements Runnable {

	final static long serialVersionUID = 7;

	private double velocita;
	int x;
	int y;
	int incremento = 5;
	int raggio = 15;
	
	public CanvasSpazio() {
		
		y = (int) (this.getHeight() /2);	
		velocita = 2;
		Thread muovi = new Thread(this);
		muovi.start();
		
		System.out.println("Valore di x:"+x);
		System.out.println("Valore di y:"+y);
	}
	
	public void setVelocita (double velocita) {
		this.velocita = velocita;
	}
	
	@Override
	public void run() {
		
		while (true) {
				repaint();
				try { Thread.sleep(20); } catch (InterruptedException e) { System.out.println("sleep error");}
		}
	}
	
	public void paint(Graphics g){
		
		double delta=0;

		g.setColor(getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		g.fillOval( getWidth()/2 , y - raggio, raggio, raggio);
			
		delta = incremento * velocita;
		y = (int) (y + delta);
		if (y >= this.getHeight() - raggio)
			incremento = -incremento;
		if (y <= 0)
			incremento = - incremento;
		System.out.println("ho disegnato ("+x+";"+y+";"+delta+")");
	}
}