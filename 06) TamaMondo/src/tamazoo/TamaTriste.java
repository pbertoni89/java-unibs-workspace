	package tamazoo;

public class TamaTriste extends Tama {
	
	final double costanteMenoSazio = 0.5;
	final double costantePiuSazio = 0.2;
	
	public TamaTriste (String _nome) 
	 {
		super(_nome);
		setFelice(29);
	 }
	
	public void carezza(int nCarezze) 
	 {
		setSazio(getSazio() - (int) ( nCarezze*getSazio()*costanteMenoSazio ) );
	 }
	
	public void nutri(int nBiscotti) 
	 {	
		setSazio(getSazio() + (int) ( nBiscotti*getSazio()*costantePiuSazio ) );
		setFelice(getFelice() - (int) (nBiscotti*costanteMenoFelice));
	 }

	public int controllaFelice()
	 {
		return 1;  
	 }	
	
	public int controllaSazio() 
	 {
		if ( getSazio() <= minSazio )
			return 0;    
		else
			if ( getSazio() < fame ) 
				return 1;
			else
				if ( getSazio() >= maxSazio )
					return 3;
				else
					return 2;
	 }	
	
	
	public String toString()
	{
		String infoFelice = "";
		String infoSazio = "";
		String formato = "";
		String aCapo = "\n";
		
		final String vivoTriste = " sembra molto triste e abbacchiato. ";
		final String vivoFame = " è morso dall'inedia. Sazieta' : ";
		final String mortoFame = " e' morto di fame... :(:(:(:(";
		final String vivoSazio = " sembra in ottima forma.  Sazieta' : ";
		final String rutto = ". Buurp!";
		final String mortoSazio = " e' morta, ha mangiato troppo :(";
		//final String mortoTermina = " e' morto perche' non te ne fregava un cazzo di lui.";
		
		infoFelice = infoFelice + getNome();
		infoSazio = infoSazio + getNome();
		
		if (controllaSazio() == 1 || controllaSazio() == 2)
			{
			 setVivo(1);
			 infoFelice = infoFelice + vivoTriste + getFelice();
			 if (controllaSazio() == 1)
				infoSazio = infoSazio + vivoFame + getSazio();
			 else
				infoSazio = infoSazio + vivoSazio + getSazio() + rutto;
			}
		else										
			{
			 setVivo(0);
			 if (controllaSazio() == 0)
				 infoSazio = infoSazio + mortoFame;
			 else
				 infoSazio = infoSazio + mortoSazio;
			}
			
		formato = infoFelice + aCapo + infoSazio;
		return formato;
	}
	
}
