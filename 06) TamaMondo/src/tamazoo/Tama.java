	package tamazoo;
	
import utilities.MyMath;

public abstract class Tama {

	private String nome;
	private int felice, sazio;
	private boolean boolVivo;
	
	final int minimoIniziale = 10;
	final int massimoIniziale = 90;
	
	final int maxFelice = 50; 
	final int maxSazio = 100;
	final int minFelice = 0;
	final int minSazio = 0;
	
	final int tristezza = 30;
	final int fame = 30;
	
	final double costanteMenoSazio = 0.5;
	final double costantePiuSazio = 0.01;
	final double costanteMenoFelice = 0.5;
	
	//**********************************************************
	public Tama(String _nome)
	 {	
		felice = MyMath.estraiIntero(minimoIniziale, massimoIniziale);
		sazio = MyMath.estraiIntero(minimoIniziale, massimoIniziale);
		nome = _nome;
		boolVivo = true;
	 }

	//**********************************************************
	
	public String getNome() {
		
		return nome;
	}
	
	protected void setFelice(int _felice) {
		
		felice = _felice;
	}
	
	protected int getFelice() {
		
		return felice;
	}
	
	protected void setSazio(int _sazio) {
		
		sazio = _sazio;
	}
	
	protected int getSazio() {
		
		return sazio;
	}	
	
	protected boolean getVivo() {
		
		if (boolVivo)
			return true;
		else 
			return false;
	}
	
	protected void setVivo(int vita) {
		
		if (vita==1)
			boolVivo = true;
		else
			boolVivo = false;
	}
//**********************************************************
	
	public void carezza(int nCarezze) {	
		
		felice = felice + nCarezze;
		sazio = (int) ( sazio - nCarezze );
		
		if (felice > maxFelice);
			felice = felice - ( felice - maxFelice );
	 }
	
	public void nutri(int nBiscotti) {	
		
		sazio = (int) ( sazio + nBiscotti*sazio );
		felice = (int) ( felice - nBiscotti );
	 }
	//**********************************************************
	
	public int controllaFelice() {
		
		if (felice < tristezza && felice > minFelice)
			return 1;
		else
			if (felice <= minFelice)
				return 0;
			else
				return 2;
	}	
	
	public int controllaSazio() {
		
		if (sazio <= minSazio)
			return 0;
		else
			if (sazio < fame)
				return 1;
			else
				if (sazio >= maxSazio)
					return 3;
				else
					return 2;
	}	
	//**********************************************************
	public abstract String toString();
}
