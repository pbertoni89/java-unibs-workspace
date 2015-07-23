import java.util.*; 
import utilities.*;

public class Driver 
{
	final static String benvenuto = "        Patrizio Bertoni  79021  INFLT1";
	final static String termina =   "Programma terminato, arrivederci.";
	final static String caricaSuccess = " Caricamento avvenuto con successo. Bentornati.";
	final static String salvaAnimeTxt = "anime.txt";

	static int decisione;	
	final static int dimMenuPr = 3; 
	final static String intestaMenu = "  Agenzia Matrimoniale ";
	final static String opz1 = " Creare una nuova agenzia ";
	final static String opz2 = " Caricare un'agenzia";
	static String[] strMenuPr = new String[dimMenuPr];
	
	final static int dimMenuSc = 5; 
	final static String opzSc1 = " Inserimento persona ";
	final static String opzSc2 = " Modifica una persona";
	final static String opzSc3 = " Elenco delle persone";
	final static String opzSc4 = " Ricerca dell'anima gemella";  //chiama elenco
	static String[] strMenuSc = new String[dimMenuSc];
	
	final static String cornice = "------------------------------------------------";
	final static String chiediNome = " Inserire il nome della persona";
	final static String chiediCognome = " Inserire il cognome";
	final static String chiediSesso = " Inserire il sesso  (M/F)";
	final static String chiediEta = " Inserire l'età (over 18!)";
	final static String addAnimaFailure =" L'elenco di persone ha raggiunto la sua dimensione massima.";
	final static String addAnimaSuccessF =" Benvenuta, %s %s ! \n";
	final static String addAnimaSuccessM =" Benvenuto, %s %s ! \n";
	final static String animaEsistente =" Esiste un omonimo nell'elenco. Usare un nickname.";
	final static String noAnime= " Inserire prima almeno una persona.";
	final static String noDueAnime= " Inserire prima almeno due persone.";
	final static String elencoAnime =" Elenco degli iscritti";
	final static String nonEsistente= " Questa persona non esiste in memoria.";
	final static String ricercaSuccess= " La ricerca dell'anima gemella ha dato ottimi frutti! sono state individuate %d persone interessanti.\n";
	final static String ricercaFailure= " Ci dispiace, ma nessuna persona sembra assomigliarti abbastanza..";
	final static String ricercaFailureXD= "      psst! ricordati che gli opposti attraggono ;)";
	
	static Vector <Anima> elenco;
	final static int dimMassima = 100;
	final static int minimiInteressiInComune = 2;
	final static int massimaDifferenzaEta = 15;
	
	public static void main(String[] args) 
	{
		System.out.println(benvenuto);
		boolean run;  do{  run = lanciaMenuPrincipale();  }while (run);
		System.out.println(termina);
	}
	
	public static boolean lanciaMenuPrincipale()
	{
		strMenuPr[1] = opz1;
		strMenuPr[2] = opz2;

		MyMenu menuPrincipale = new MyMenu(intestaMenu, strMenuPr, dimMenuPr);
		boolean esci = false;
		
		decisione = menuPrincipale.scegli();
		
		switch (decisione)
	     {
			case 0: 
				esci = true; 
				break;     
			case 1:			
				crea();
				break;
			case 2:
				carica();
				break;		
		 }
		
		if (!esci)
		{
			boolean esciSec = false;
			do { esciSec = lanciaMenuSecondario(); } while (!esciSec);
		}	
		
		return esci;
	}
	
	//***************************************************************************************************
	public static boolean lanciaMenuSecondario()
	{
		strMenuSc[1] = opzSc1;
		strMenuSc[2] = opzSc2;
		strMenuSc[3] = opzSc3;
		strMenuSc[4] = opzSc4;

		MyMenu menuSecondario = new MyMenu(intestaMenu, strMenuSc, dimMenuSc);
		boolean esci = false;
		
		decisione = menuSecondario.scegli();
		switch (decisione)
	     {
			case 0:
				esci = true;
				break;    
										
			case 1:
				addAnima();
				salva();
				break;
				
			case 2:
				if (elenco.size()>0)
 	    		 {
					caratterizza();
					salva();
 	    		 }
				else
					System.out.println(noAnime);
				break; 
				
			case 3:
				if (elenco.size()>0)
	    		 {
					stampaElenco();
	    		 }
				else
					System.out.println(noAnime);
				break; 
			
			case 4:
				if (elenco.size()>1)
	    		 {
					ricercaAnima();
					salva();
	    		 }
				else
					System.out.println(noDueAnime);
				break;
		 }
		return esci;
	}
	
	//***********************************************************************************************
	public static void crea()
	{
		elenco = new Vector <Anima> ();
	}
	
	@SuppressWarnings("unchecked")
	public static void carica()			
	{
		elenco = ( Vector <Anima> ) MyStream.leggiOggetto(salvaAnimeTxt);
		
		if ( !(elenco.equals(null) ) )
			System.out.println(caricaSuccess);
	}
	
	public static void salva ()
	{
		MyStream.scriviOggetto( elenco, salvaAnimeTxt);
	}
	//***********************************************************************************************
	public static void addAnima()   
	{								
		boolean esistente;
		String nome, cognome;
		char sesso; int eta;
		Anima creata;
		
		if (elenco.size() >= dimMassima)
			System.out.println(addAnimaFailure);
		else
		 {
			if ( elenco.size()>0)
			 {
				
				do { 
					esistente = false;
					nome = MyIO.leggiStringaNonVuota(chiediNome);		
					cognome = MyIO.leggiStringaNonVuota(chiediCognome);
					for (int i=0; i<elenco.size(); i++)
						if ( elenco.get(i).getNome().equalsIgnoreCase(nome) &&
								elenco.get(i).getCognome().equalsIgnoreCase(cognome) )
							esistente = true;
					if (esistente)
						System.out.println(animaEsistente);
				}while (esistente);
			 }
			else
			 {
				nome = MyIO.leggiStringaNonVuota(chiediNome);		
				cognome = MyIO.leggiStringaNonVuota(chiediCognome);
			 }
		
			do {
				sesso = MyIO.leggiChar(chiediSesso);
			  } while ( ! (sesso=='M' || sesso=='F') );
		
			do {
				eta = MyIO.leggiIntero(chiediEta);
			  } while ( eta < 18 );
			
			creata = new Anima (nome, cognome, sesso, eta);
			
			if (sesso=='M')
				System.out.printf(addAnimaSuccessM, nome, cognome );
			else
				System.out.printf(addAnimaSuccessF, nome, cognome );
		
			creata.caratterizza();
		    elenco.add(creata);	    
		 }
	}
	
	//***********************************************************************************************
	public static void stampaElenco()
	{
		System.out.println(elencoAnime);
		System.out.println(cornice);
		for ( int w=0; w<elenco.size(); w++)
			elenco.get(w).stampa();
	}
	
	//***********************************************************************************************
	public static void caratterizza()
	{
		Anima daModificare = cerca();
		if ( daModificare.getEsiste() ) 
			daModificare.caratterizza();
	}
	
	//***********************************************************************************************
	public static Anima cerca()
	{
		Anima cercata;
		Anima temp;
		boolean trovata;
		
		stampaElenco();
		
		String nomeCercato = MyIO.leggiStringaNonVuota(chiediNome);	
		String cognomeCercato = MyIO.leggiStringaNonVuota(chiediCognome);

		int g=0; trovata = false;
		
		do {
			temp = elenco.get(g);
			if ( nomeCercato.equalsIgnoreCase(temp.getNome()) && 
					cognomeCercato.equalsIgnoreCase(temp.getCognome()) )
			 {
				trovata = true;
			 }
			g++;
		 } while ( g<elenco.size() && (!trovata) );
		
		if (!trovata)
		 {
			System.out.println(nonEsistente);
			cercata = new Anima();
		 }
		else
			cercata = temp;
		
		return cercata;
	}
	
	//***********************************************************************************************
	public static void ricercaAnima()
	{
		Anima daAccoppiare = cerca();
		Anima possibile;
		if ( daAccoppiare.getEsiste() )
		{         
			int differenzaMinima=0;
			int inComuneMassimi = 0;
			int inComune;
			int differenza;
			Vector <Anima> papabili = new Vector <Anima> ();
			
			for ( int p=0; p<elenco.size(); p++)
			 {                             //non è la stessa persona
				if ( !( (elenco.get(p).getNome().equalsIgnoreCase(daAccoppiare.getNome()) ) &&
						(elenco.get(p).getCognome().equalsIgnoreCase(daAccoppiare.getCognome() ) ) )) 
				   {
						possibile = elenco.get(p);
						inComune = 0;
				
						for ( int a=0; a < daAccoppiare.getSports().size(); a++)
							for ( int b=0; b < possibile.getSports().size(); b++)
									if ( daAccoppiare.getSports().get(a).equalsIgnoreCase
										( possibile.getSports().get(b) ) )
												inComune++;
						
						for ( int a=0; a < daAccoppiare.getFilms().size(); a++)
							for ( int b=0; b < possibile.getFilms().size(); b++)
									if ( daAccoppiare.getFilms().get(a).equalsIgnoreCase
										( possibile.getFilms().get(b) ) )
												inComune++;
						
						for ( int a=0; a < daAccoppiare.getHobbies().size(); a++)
							for ( int b=0; b < possibile.getHobbies().size(); b++)
									if ( daAccoppiare.getHobbies().get(a).equalsIgnoreCase
										( possibile.getHobbies().get(b) ) )
												inComune++;
						
						for ( int a=0; a < daAccoppiare.getCarattere().size(); a++)
							for ( int b=0; b < possibile.getCarattere().size(); b++)
									if ( daAccoppiare.getCarattere().get(a).equalsIgnoreCase
										( possibile.getCarattere().get(b) ) )
												inComune++;
						
						if ( inComune >= minimiInteressiInComune)
						 {	
							if (papabili.size()==0)
							 {
								differenzaMinima = Math.abs( daAccoppiare.getEta() - elenco.get(p).getEta() );
								inComuneMassimi = inComune;
								papabili.add(possibile);
							 }
							else
							 {
								differenza= Math.abs( daAccoppiare.getEta() - possibile.getEta() );
								if ( differenza <= massimaDifferenzaEta && 
										differenza <= differenzaMinima &&
											inComune >= inComuneMassimi )
									papabili.add(possibile);
							 }
						 }		
				   }
			 }
			
			if (papabili.size()>0)
			 {
				System.out.println(cornice);
				System.out.printf(ricercaSuccess, papabili.size() );
				for (int v=0; v < papabili.size(); v++)
					papabili.get(v).stampa();
			 }
			else
			 {
				System.out.println(ricercaFailure);
				System.out.println(ricercaFailureXD);
			 }
		}
	}
	
}
