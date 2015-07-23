package face;
import java.awt.Color;
import java.awt.Graphics;


public class Ovale {

	private int xCentro; //Ascissa del centro
	private int yCentro; //Ordinata del centro
	private int semialtezza;
	private int semibase; 
	
	Color bordo = Color.BLACK;
	Color interno = new Color(100, 100, 100);  //random grey by default
	
	public Ovale(int xCentro, int yCentro, int semibase, int semialtezza){
		this.xCentro=xCentro;
		this.yCentro=yCentro;
		this.semibase=semibase;
		this.semialtezza=semialtezza;
	}
	
	public Ovale(int xCentro, int yCentro, int semibase, int semialtezza, Color bordo, Color interno){
		this.xCentro=xCentro;
		this.yCentro=yCentro;
		this.semibase=semibase;
		this.semialtezza=semialtezza;
		this.bordo=bordo;
		this.interno=interno;
	}
	
	public void disegnaPieno(Graphics g){
		g.setColor(interno);
		g.fillOval(xCentro-semibase, yCentro-semialtezza, semibase*2, semialtezza*2);
	}
	
	public void disegnaVuoto(Graphics g){
		g.setColor(bordo);
		g.drawOval(xCentro-semibase, yCentro-semialtezza, semibase*2, semialtezza*2);
	}
	
	public void disegnaTutto(Graphics g){
		disegnaPieno(g);
		disegnaVuoto(g);
	}

	public int getXCentro(){
		return xCentro;
	}
	
	public int getYCentro(){
		return yCentro;
	}
	
	public int getBase(){
		return semibase;
	}
	
	public int getAltezza(){
		return semialtezza;
	}

	public Color getInterno(){
		return interno;
	}
	
	public Color getBordo(){
		return bordo;
	}
	
	public void setXCentro(int xCentro){
		this.xCentro = xCentro;
	}
	
	public void setYCentro(int yCentro){
		this.yCentro = yCentro;	
	}
	
}
