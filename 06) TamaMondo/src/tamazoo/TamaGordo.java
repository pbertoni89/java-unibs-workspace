	package tamazoo;

public class TamaGordo extends Tama {
	
	final double costanteMenoSazio = 0.75;
	final double costantePiuSazio = 0.09;
	final double costanteMenoFelice = 0.4;
	
	public TamaGordo (String _nome) 
	 {
		super(_nome);
		setSazio(29);
	 }
	
	public void carezza(int nCarezze) 
	 {
		setSazio(getSazio() - (int) ( nCarezze*getSazio()*costanteMenoSazio ) );
	 }
	
	public void nutri(int nBiscotti) 
	 {	
		setSazio(getSazio() + (int) ( nBiscotti*getSazio()*costantePiuSazio ) );
		setFelice(getFelice() - (int) (nBiscotti*costanteMenoFelice) );
	 }

	public int controllaFelice()
	 {
		return 2; 
	 }	
	
	public int controllaSazio() 
	 {
		if ( getSazio() <= minSazio )
			return 0;    
		else
			if ( getSazio() < fame ) 
				return 1;
			else
				return 2;
	 }	
	
	public String toString()
	{

		final String vivoFelice = " sembra molto allegro e idiota! Felicita' : ";
		final String vivoFame = " è morso dall'inedia. Sazieta' : ";
		final String mortoFame = " e' morto di fame... :(:(:(:(";
		final String vivoSazio = " sembra in ottima forma.  Sazieta' : ";
		final String rutto = ". Buurp!";
		
		String infoFelice = "";
		String infoSazio = "";
		String formato = "";
		String aCapo = "\n";
		
		infoFelice = infoFelice + getNome();
		infoSazio = infoSazio + getNome();
		
		if (controllaSazio() == 1 || controllaSazio() == 2)
			{
			 setVivo(1);
			 infoFelice = infoFelice + vivoFelice + getFelice();
			 if (controllaSazio() == 1)
				infoSazio = infoSazio + vivoFame + getSazio();
			 else
				infoSazio = infoSazio + vivoSazio + getSazio() + rutto;
			}
		else										
			{
			 setVivo(0);
				 infoSazio = infoSazio + mortoFame;
			}
			
		formato = infoFelice + aCapo + infoSazio;
		return formato;
	}
	
}