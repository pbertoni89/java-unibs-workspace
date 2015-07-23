import java.util.Vector;

import utilities.*;

public class BorsaMain {

	final static String benvenuto = "       Pillars of Software 2010";
	final static String terminazioneProg = "Programma terminato, arrivederci.";
	final static String borsaChiude = "";
	
	final static String salvataggio = "prova.txt";
	final static String salvaOK = " < Salvataggio dei dati avvenuto correttamente. >";
	final static String caricaOK = " < Caricamento dati avvenuto correttamente. Bentornato, %s. > \n";
	
	final static String aCasa = " Decidi di andare a riposarti dalla giornata lavorativa.";
	final static String alLavoro = " Un nuovo giorno sorge! Buona fortuna!";
	final static String chiusura = " La borsa chiude!";
	final static String acquistano = " i titoli \"%s\" acquistano %f punti percentuali.";
	final static String perdono = " i titoli \"%s\" perdono %f punti percentuali.";
	
	final static String inserisciAzionista = "Inserire il nome dell'azionista";
	final static String benvenutoAzionista = "			Buona fortuna, %s! ;) \n\n";
	
	final static int dimMenuPrincipale = 3;
	final static String intestaMenuPr = " Piazza Affari Milano";
	final static String opz1 = " Crea un nuovo profilo azionista";
	final static String opz2 = " Carica un profilo esistente";
	static String[] strMenuPrincipale = new String[dimMenuPrincipale];
	static int decisionePr;
	
	final static int dimMenuAzionista = 5;
	final static String intestaMenuAz = "Cosa si desidera fare oggi?";
	final static String opzione1 = " Acquista un lotto";
	final static String opzione2 = " Vendi un lotto";
	final static String opzione3 = " Visualizza il tuo stato finanziario";
	final static String opzione4 = " Lascia la borsa e vai a casa";
	static String[] strMenuAzionista = new String[dimMenuAzionista];
	static int decisioneAz;
	
//********************************************************************************************************	
	public static void main(String[] args) 
	{
		System.out.println(benvenuto);
		lanciaMenuPrincipale();
		System.out.println(terminazioneProg);
	}
	
//********************************************************************************************************   
	public static void lanciaMenuPrincipale()
	{
		Azionista primo;
		
		strMenuPrincipale[1] = opz1;
		strMenuPrincipale[2] = opz2;

		MyMenu menuPrincipale = new MyMenu(intestaMenuPr, strMenuPrincipale, dimMenuPrincipale);
		
		boolean esci;
		
		do {
			 esci = false;
			 decisionePr = menuPrincipale.scegli();
			switch ( decisionePr )
		     {
				case 0: esci = true;      break;
					
				case 1:			
					primo = creaAzionista();
					lanciaMenuAzionista(primo);
					break;
			
				case 2:
					primo = caricaAzionista();
					lanciaMenuAzionista(primo);
					break; 
			 }
		  } while (!esci);
	}
	
//*****************************************************************************************************   
	public static Azionista creaAzionista()
	{
		String _azionista;
	
		_azionista = MyIO.leggiStringaNonVuota( inserisciAzionista );				
	
		Azionista creato = new Azionista (_azionista);
		System.out.printf(benvenutoAzionista, _azionista);
		
		salvaStato(creato, true);
		return creato;
	}
	
	public static Azionista caricaAzionista()
	{
		Azionista caricato = (Azionista) MyStream.leggiOggetto( salvataggio );
		System.out.printf(caricaOK, caricato.getNomeAzionista() );
		return caricato;
	}
	
//*****************************************************************************************************
	public static void lanciaMenuAzionista( Azionista persona)
	{
			strMenuAzionista[1] = opzione1;
			strMenuAzionista[2] = opzione2;
			strMenuAzionista[3] = opzione3;
			strMenuAzionista[4] = opzione4;

			MyMenu menuAzionista = new MyMenu(intestaMenuAz, strMenuAzionista, dimMenuAzionista);
			
			boolean esci;
			
			do {
				
				esci = false;
				decisioneAz = menuAzionista.scegli();
			
				switch ( decisioneAz )
				 {
				  case 0:
					  esci = true;      break;
				
				  case 1:			
					  persona.acquista();
					  salvaStato(persona, false);      break;

				  case 2:
					  persona.stampa();
					  persona.vendi();
					  salvaStato(persona, false);      break; 
				
				  case 3:
					  persona.stampa();   break;
					  
				  case 4:
					  giornata(persona);
					  salvaStato(persona, true);      break;
				 }
			} while (!esci);
	}
	
//*****************************************************************************************************
	public static void giornata( Azionista persona ) 
	{
		final int moltiplicatore = 5;   // massima oscillazione titoli:  -5%  - +5%
		double fluttuazione;
		double effettiva;
		int caso; 
		
		Vector <Lotto> persPortafoglio = persona.getPortafoglio();
		int dimPortafoglio = persPortafoglio.size();
		
		System.out.println(aCasa);
		System.out.println();
		System.out.println(chiusura);
		
		for ( int i = 0; i < dimPortafoglio; i++)
			{
				Lotto persLotto = persPortafoglio.get(i);
				Titolo[] persTitolo = persLotto.getTitoliLotto();
				fluttuazione = Math.random()*moltiplicatore;
				
				caso = MyMath.estraiIntero(0,1);
				if (caso == 0)
				 { 
					fluttuazione = 0-fluttuazione;
					System.out.printf(perdono, persTitolo[0].getNomeTitolo(), fluttuazione);
				 }
				else
					System.out.printf(acquistano, persTitolo[0].getNomeTitolo(), fluttuazione);
				
				effettiva = (fluttuazione * persTitolo[0].getValore()) /100 + persTitolo[0].getValore();
						System.out.println(persTitolo[0].getValore());
				for ( int j = 0; j < persLotto.getDimensione(); j++)
						persTitolo[j].setValore(effettiva);
						//System.out.println(persTitolo[j].getValore());   }
			}
		System.out.println();
		System.out.println(alLavoro);
	}
	
//*****************************************************************************************************
	public static void salvaStato ( Azionista _persona, boolean _show)
	{
		MyStream.scriviOggetto( _persona, salvataggio);
		if (_show)
			System.out.println(salvaOK);
	}
	
	
}
