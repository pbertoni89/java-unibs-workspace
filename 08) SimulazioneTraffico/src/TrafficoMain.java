import utilities.MyIO;
import utilities.MyMenu;


public class TrafficoMain {

	final static String benvenuto = "Simulazione Traffico Urbano 1.0, Pillars of Software 2010";
	final static String inserisciNomeStrada = " Inserire il nome del tratto stradale da monitorare.";
	final static String inserisciAltezza = " Inserire le unità di larghezza della carreggiata.";
	final static String inserisciBase = " Inserire le unità di lunghezza del tratto stradale.";
	final static String benvenutaStrada = " Inizia il monitoraggio di \"%s\". \n";
	final static String continua = " Continuare la simulazione?  (S/N)";
	final static String arrivederci = " Programma terminato... arrivederci.";
	
	final static int altezzaMin = 1, altezzaMax = 4, baseMin = 5, baseMax = 100;
	
	//*******************************************************************************************
	public static void main(String[] args) {
	
		System.out.println(benvenuto);
		
		Strada stradaUno = creaStrada();
		stradaUno.statoIniziale();
		giraTurno(stradaUno);
		
		System.out.println(arrivederci);
		
	}
	//*******************************************************************************************
	public static Strada creaStrada()
	{
		String nomeCreata;
		int altezzaCreata, baseCreata;
		
		nomeCreata = MyIO.leggiStringaNonVuota( inserisciNomeStrada );				
		altezzaCreata =  MyIO.leggiInteroLimiti( inserisciAltezza, altezzaMin, altezzaMax ) *2; //ogni strada ha due carr
		baseCreata = MyIO.leggiInteroLimiti( inserisciBase, baseMin, baseMax );
		
		Strada stradaCreata = new Strada ( nomeCreata, altezzaCreata, baseCreata);
		System.out.printf(benvenutaStrada, stradaCreata.getNomeStrada());
		
		return stradaCreata;
	}
	
	//*******************************************************************************************
	public static void giraTurno(Strada _strada)
	{
		boolean avanti = true;
		do {
			_strada.turno();
			avanti = MyMenu.yesOrNot(continua);
			} while (avanti);
	}
}
