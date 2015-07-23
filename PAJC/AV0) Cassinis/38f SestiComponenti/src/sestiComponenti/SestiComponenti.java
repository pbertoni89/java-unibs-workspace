package sestiComponenti;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * Questo programma mostra un esempio di gestione di Scrollbar
 * 
 * @author R. Cassinis
 * @version 1.0
 * 
 */

public class SestiComponenti extends Applet implements AdjustmentListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1565558643343070840L;
	Scrollbar r,g,b;
	Label lr,lg,lb;
	int nr,ng,nb;
	TextField tr,tg,tb;
	public void init(){
		setSize(800, 800);
		nr=128;
		ng=128;
		nb=128;
		setLayout(null);
		r=new Scrollbar(Scrollbar.HORIZONTAL,128,1,0,256);
		g=new Scrollbar(Scrollbar.HORIZONTAL,128,1,0,256);
		b=new Scrollbar(Scrollbar.HORIZONTAL,128,1,0,256);
		r.setBounds(100, 300, 200, 20);
		g.setBounds(100, 350, 200, 20);
		b.setBounds(100, 400, 200, 20);
		add(r);
		add(g);
		add(b);
		r.addAdjustmentListener(this);
		g.addAdjustmentListener(this);
		b.addAdjustmentListener(this);
		lr=new Label("rosso");
		lg=new Label("verde");
		lb=new Label("blu");
		lr.setBounds(10, 300, 40, 20);
		lg.setBounds(10, 350, 40, 20);
		lb.setBounds(10, 400, 40, 20);
		add(lr);
		add(lg);
		add(lb);
		tr=new TextField("128");
		tg=new TextField("128");
		tb=new TextField("128");
		tr.setBounds(350, 300, 40, 20);
		tg.setBounds(350, 350, 40, 20);
		tb.setBounds(350, 400, 40, 20);
		add(tr);
		add(tg);
		add(tb);
	}
	
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		Object source=e.getSource();
		if (source==r){
			nr=r.getValue();
			tr.setText(String.valueOf(nr));
		}
		if (source==g){
			ng=g.getValue();
			tg.setText(String.valueOf(ng));
		}
		if (source==b){
			nb=b.getValue();
			tb.setText(String.valueOf(nb));
		}
		repaint();
	}

	public void paint(Graphics g){
		g.setColor(Color.black);
		g.drawRect(0,0,400,200);
		g.fillRect(0,0,200,200);
		g.setColor(new Color(nr,ng,nb));
		g.fillRect(50, 50, 300, 100);
	}
}
