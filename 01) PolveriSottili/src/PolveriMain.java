import utilities.MyIO;


public class PolveriMain {

	final static String benvenuto = "PolveriSottili 0.1, Pillars of Software 2010";
	final static String inserisciAnno = "Inserisci l'anno corrente (1950-2099)";
	final static String inserisciNSettimana = "Inserisci il numero della settimana (1-53)";
	final static String inserisciValoreGiorno = "Inserisci il valore giornaliero di polveri sottili (1-120)";  
	
	final static int giorniTotali = 7;
	
	final static int massimoConsentito = 75;
	final static int medioStorico = 50;
	static int oltrepassoMassimo;  //quanto si ha oltrepassato il massimo consentito.
	static int oltrepassoMedio;
	final static String stampaOltrepassoMassimo= "Il massimo valore della settimana numero %d dell'anno %d è stato riscontrato nel giorno numero %d e supera di %d unità la soglia consentita. \n";
	final static String stampaOltrepassoMedio= "Il valore medio di polveri durante la settimana numero %d dell'anno %d ha superato di %d unità la media storica. \n";
	
	
	static int _anno;								
	static int _nSettimana;								
	private static int[] _valoreGiorno = new int[giorniTotali];	
	
	final static int settimaneMassime = 1; //dimensione dell'array che contiene la storia. 2 x testing
	private static Settimana[] storia = new Settimana[settimaneMassime];
	
	public static void main(String[] args) {
		System.out.println(benvenuto);
		genera();
		controllaMassimi(storia);
		controllaMedi(storia);
	}
	
	public static Settimana nuovaSettimana() {
		
		_anno = MyIO.leggiInteroPos(inserisciAnno);
		_nSettimana = MyIO.leggiInteroPos(inserisciNSettimana);
		for (int i = 0; i < giorniTotali; i++)
			_valoreGiorno[i] = MyIO.leggiIntero(inserisciValoreGiorno);
		return new Settimana(_anno, _nSettimana, _valoreGiorno);
 	}

	public static void genera() {
		
		for (int i = 0; i < settimaneMassime; i++)
		storia[i] = nuovaSettimana();
 	}

	public static void controllaMassimi( Settimana[] storia) {
	
		for (int i = 0; i < settimaneMassime; i++) 
		{
			int[] arrayTemp = storia[i].massimo();
			
			if ( arrayTemp[1] > massimoConsentito)
			 {
				oltrepassoMassimo = arrayTemp[1] - massimoConsentito;
				System.out.printf(stampaOltrepassoMassimo, storia[i].nSettimana, storia[i].anno, arrayTemp[0]+1, oltrepassoMassimo );
			 }
		}	
 	}
	
	public static void controllaMedi( Settimana[] storia) 
	{
		for (int i = 0; i < settimaneMassime; i++)
			if ( storia[i].medio() > medioStorico) 
			 {
				oltrepassoMedio = storia[i].medio() - medioStorico;
				System.out.printf(stampaOltrepassoMedio, storia[i].nSettimana, storia[i].anno, oltrepassoMedio );
			 }
 	}
}
