import utilities.*;

public class InvestimentoMain {

	/**
	 * @param args
	 */
	
	static double tempCapitaleIniziale;
	static int tempAnno;
	static int durata;
	final static String chiediCapitale= "Inserire il capitale che si vuole depositare";
	final static String chiediAnno= "Inserire l'anno fino al quale ci si impegna";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//Investimento Investimento1 = NuovoInvestimento();
	}
	
	public static Investimento NuovoInvestimento()
	{
		 tempCapitaleIniziale = MyIO.leggiInteroPos(chiediCapitale);
	 
	 do {
		 tempAnno = MyIO.leggiIntero(chiediCapitale);
		 durata = tempAnno - MyDate.getAnno();
	    }while(durata>0);
	 
	 return new Investimento(tempCapitaleIniziale, tempAnno);
 	}
	
}
