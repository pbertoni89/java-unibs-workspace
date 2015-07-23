package facePackage;
import java.awt.Color;
import java.awt.Graphics;


public class Faccia {
	private int R;
	private int XCF;
	private int YCF;
	
	private Cerchio base;
	private Occhio OcchioSx;
	private Occhio OcchioDx;
	
	final Color contorno= Color.BLACK;
	final Color pelle = Color.PINK;
	final Color iride = Color.BLUE;
	final Color labbra = Color.BLACK;
	final Color dentroBocca = Color.RED;
	
	public Faccia(int XC, int YC, int R){
		
		this.XCF=XC;
		this.YCF=YC;
		this.R=R;
	}
	
	public void inizializza(){
		
		base = new Cerchio( (int) (XCF), (int) (YCF), R, contorno, pelle);
		OcchioSx = new Occhio(XCF-R/2, YCF-R/4, R/4);
		OcchioDx = new Occhio(XCF+R/2, YCF-R/4, R/4);
	}
	
	public void disegna(Graphics g){  // le coords passate ai cerchi SONO SEMPRE quelle del centro. Poi lui ricalcola l orgine
		
		base.disegnaTutto(g);
		
		OcchioSx.disegna(g);
		OcchioDx.disegna(g);
		
		g.setColor(dentroBocca);
		g.fillArc( (int) (XCF-R/2), (int) (YCF+R/6), (int) (R), (int) (R/2), 0, -180 );
		
		g.setColor(labbra);
		g.drawArc( (int) (XCF-R/2), (int) (YCF+R/6), (int) (R), (int) (R/2), 0, -180 );
		//g.drawLine( (int) (XCF-R/2), (int) (YCF+R/4), (int) (XCF+R/2), (int) (YCF+R/4) );
		
	}
	
	public void draggaFaccia(int xMouse, int yMouse) {
		XCF = xMouse;
		YCF = yMouse;
		inizializza();  //passo a occhi e cerchio esterno le nuove coords
	}
	
	public void muoviPupille(int xMouse, int yMouse){
		OcchioSx.riposiziona(xMouse, yMouse);
		OcchioDx.riposiziona(xMouse, yMouse);
	}
}