package polofieristico;

import java.util.*; 
import comparators.*; 
import utilities.*;

public class Driver {

	final static String benvenuto = "        Patrizio Bertoni  79021  INFLT1";
	final static String termina =   "Programma terminato, arrivederci.";
	final static String caricaSuccess = " Caricamento avvenuto con successo. Bentornati.";
	final static String salvaFieraTxt = "fiera.txt";
	final static String salvaProgrammaTxt = "programma.txt";
	
	private static HashMap <String, Padiglione> fiera = new HashMap <String, Padiglione> ();
	private static HashMap <String, Evento> programma = new HashMap <String, Evento> ();
	
	static int decisione;
	
	final static int dimMenuPr = 3; 
	final static String intestaMenu = "  Gestione di un polo fieristico ";
	final static String opz1 = " Creare una nuova fiera ";
	final static String opz2 = " Caricare una fiera esistente";
	static String[] strMenuPr = new String[dimMenuPr];
	
	final static int dimMenuSc = 3; 
	final static String opzSc1 = " Gestione dei padiglioni ";
	final static String opzSc2 = " Gestione degli eventi";
	static String[] strMenuSc = new String[dimMenuSc];
	
	final static int dimMenuPad = 6;
	final static String intestaMenuPad = " Gestione dei padiglioni e degli stands";
	final static String opzPad1 = " Creare un nuovo padiglione";
	final static String opzPad2 = " Eliminare un padiglione";
	final static String opzPad3 = " Mostrare la lista dei padiglioni ridotta";
	final static String opzPad4 = " Mostrare la lista dei padiglioni estesa.";
	final static String opzPad5 = " Mostrare una lista ordinata";
	static String[] strMenuPad = new String[dimMenuPad];

	final static int dimMenuSortPad = 4;
	final static String intestaMenuSortPad = " Visualizzazioni ordinate dei padiglioni";
	final static String opzSortPad1 = " Ordine in base alla capienza massima";
	final static String opzSortPad2 = " Ordine in base agli stand ancora liberi";
	final static String opzSortPad3 = " Ordine in base all'incasso storico del padiglione";
	static String[] strMenuSortPad = new String[dimMenuSortPad];
	
	final static int dimMenuEv = 6;
	final static String intestaMenuEv = " Gestione degli eventi in programma";
	final static String opzEv1 = " Creare un nuovo evento";
	final static String opzEv2 = " Mostrare la lista degli eventi ridotta";
	final static String opzEv3 = " Mostrare la lista degli eventi per esteso";
	final static String opzEv4 = " Mostrare una lista ordinata";
	final static String opzEv5 = " Evolvere un evento.";
	static String[] strMenuEv = new String[dimMenuEv];
	
	final static int dimMenuSortEv = 4;
	final static String intestaMenuSortEv = " Visualizzazioni ordinate degli eventi";
	final static String opzSortEv1 = " Ordine in base alla data d'apertura";
	final static String opzSortEv2 = " Ordine in base allo stato dell'evento";
	final static String opzSortEv3 = " Ordine in base all'incasso dall'affitto";
	static String[] strMenuSortEv = new String[dimMenuSortPad];
	
	final static String cornice = "------------------------------------------------";
	final static String insCodPadiglione = " Inserire il codice alfanumerico del padiglione. (massimo %d caratteri)";
	final static String decidiSovrascritturaPad = " Questo padiglione esiste già. Sovrascrivere?  (s/n)";
	final static String addPadSuccess =" Padiglione \"%s\" creato con successo. \n";
	final static String addPadFailure =" Lo spazio per ulteriori padiglioni è esaurito.";
	final static String addEvSuccess =" Evento \"%s\" prenotato con successo. Si terrà nel padiglione \"%s\". \n";
	final static String stampaIncassoTot= " Prenotare questo evento costerà complessivamente %d. Confermare? (s/n)\n";
	final static String addEvFailure1 =" Non si dispone di padiglioni sufficientemente liberi o grandi da contenere l'evento desiderato. \n";
	final static String addEvFailure2= " Non si dispone di padiglioni liberi e con le caratteristiche richieste.";
	final static String cambiaEsigenzeDomanda= " Si desidera modificare le caratteristiche richieste? (s/n)";
	final static String cambiaEsigenzeDomanda2= " (in caso contrario, la prenotazione verrà cancellata)";
	final static String addEvUnconfirmed= "Prenotazione dell'evento cancellata.";
	final static String decidiSovrascritturaEvento = " Questo evento esiste già. Sovrascrivere?  (s/n)";
	final static String insCapienza = " Inserire il massimo numero di stand contenibili. (max 30)";  //*
	final static String insCodEvento = " Inserire il codice alfanumerico dell'evento. (massimi %d caratteri)";
	final static String sceltoLibero= "La parola \"%s\" è riservata. Sceglierne un'altra.\n";
	final static String insNecessari = " Inserire il numero di stand necessari all'evento. (max 30)"; //
	final static String insDescrizione = " Inserire la descrizione dell'evento. (massimo %d caratteri)";
	final static String insOrganizzatore = " Inserire l'organizzatore dell'evento. (massimo %d caratteri)";
	final static String insInizio = " Data di inizio";
	final static String insFine = " Data della fine";
	final static String dateFailure1= " Tra la data d'inizio e quella odierna deve intercorrere almeno un mese.";
	final static String dateFailure2= " La data d'inizio dev'essere antecedente a quella di chiusura!";
	final static String dateFailure3= " La data scelta per l'evento si sovrappone ad altri elementi in programma";
	final static String presenzaTerminati= " Nella lista sono presenti %d eventi terminati. Si desidera rimuoverli? (s/n)\n";
	final static String scegliPadElimina= "Selezionare dalla lista il codice del padiglione (LIBERO) da rimuovere.";
	final static String sceltoOccupato= " Non è possibile eliminare un padiglione occupato anche parzialmente.";
	final static String sceltoOccupato2= " Assicurarsi di rimuovere gli eventi terminati al suo interno!";
	final static String rimuoviPadSuccess= " Padiglione \"%s\" rimosso con successo dalla memoria.\n";
	final static String padNonEsistente= " Il padiglione selezionato non è presente in memoria.";
	final static String scegliEvolvi= " Selezionare dalla lista il codice dell'evento da evolvere.";
	final static String giaInCorso= " Non è possibile dare il via a un evento mentre un altro è già in svolgimento.";
	final static String sceltoTerminato= " Non è possibile evolvere un evento terminato. Si consiglia di rimuoverlo dal programma.";
	final static String evNonEsistente= " L'evento selezionato non è presente in memoria.";
	final static String listaEvVuota= " Non ci sono eventi in programma.";
	final static String listaPadVuota= " Non ci sono padiglioni registrati.";
	final static String listaPadiglioni ="  Lista dei padiglioni";
	final static String listaEventi ="  Lista degli eventi";
	final static String formatoTabellaEv = "   Codice   |     Descrizione     |  Organizzatore  |  Inizio  |  Termine  |      Stato      | Padiglione | Stands | Incasso";
	final static String inRimozione = "REMOVE";
	
	final static int Lcodice = 9, Lnome = 18, Lorganizzatore = 15; //in funzione della formattazione 
	final static int capienzaMax = 30;
	final static int padiglioniMax = 10;
	
	
	//***************************************************************************************************
	public static void main(String[] args) 
	 {
		System.out.println(benvenuto);
		
		boolean run;  do{  run = lanciaMenuPrincipale();  }while (run);
		
		System.out.println(termina);
	 }
	
	//********************************************************************************************************   
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

		MyMenu menuSecondario = new MyMenu(intestaMenu, strMenuSc, dimMenuSc);
		boolean esci = false;
		
		decisione = menuSecondario.scegli();
		switch (decisione)
	     {
			case 0: esci = true; break;    
										
			case 1:
				boolean esciPad = false;
				do { esciPad = lanciaMenuPadiglione(); } while (!esciPad);
				break;
		
			case 2:
				boolean esciEv = false;
				do { esciEv = lanciaMenuEvento(); } while (!esciEv);
				break; 		
		 }
		return esci;
	}
	
	//********************************************************************************************************
	public static boolean lanciaMenuEvento()
	{
		boolean esci = false; boolean ridotta;
		strMenuEv[1] = opzEv1;
		strMenuEv[2] = opzEv2;
		strMenuEv[3] = opzEv3;
		strMenuEv[4] = opzEv4;
		strMenuEv[5] = opzEv5;
		
		MyMenu menuEv = new MyMenu(intestaMenuEv, strMenuEv, dimMenuEv);
		
		decisione = menuEv.scegli();
		
		switch (decisione)
		 {
		  case 0: 
			  esci = true;  
			  break;
		  case 1:	addEvento();
			  break;
		  case 2:	
			  ridotta = true;
			  stampaProgramma(ridotta);
			  break; 
		  case 3:
			  ridotta = false;
			  stampaProgramma(ridotta);
			  break;	
		  case 4:
			  	boolean esciSortEv = false;
				do { esciSortEv = lanciaMenuSortEvento(); } while (!esciSortEv);
			  break;
		  case 5:
			  evolviUnEvento();
			  break;
		 }
			salva();
			
		return esci;
	}
	
	public static boolean lanciaMenuPadiglione()
	{
		boolean esci = false;
		boolean ridotta;
		
		strMenuPad[1] = opzPad1;
		strMenuPad[2] = opzPad2;
		strMenuPad[3] = opzPad3;
		strMenuPad[4] = opzPad4;
		strMenuPad[5] = opzPad5;
		
		MyMenu menuPad = new MyMenu(intestaMenuPad, strMenuPad, dimMenuPad);
		
		decisione = menuPad.scegli();
		
		switch (decisione)
		 {
		  case 0: 
			  esci = true;  
			  break;
		  case 1:	
			  addPadiglione();
			  break;
		  case 2:
			  removePadiglione();
			  break;	
		  case 3:   
			  ridotta = true;
			  stampaFiera(ridotta);
			  break;
		  case 4:    
			  ridotta = false;
			  stampaFiera(ridotta);
			  break;
		  case 5:
				boolean esciSortPad = false;
				do { esciSortPad = lanciaMenuSortPadiglione(); } while (!esciSortPad);
			  break;
		 }
			salva();
			
		return esci;
	}
	
	//********************************************************************************************************
	public static boolean lanciaMenuSortPadiglione()
	{
		boolean esci = false;
		
		strMenuSortPad[1] = opzSortPad1;
		strMenuSortPad[2] = opzSortPad2;
		strMenuSortPad[3] = opzSortPad3;
		
		MyMenu menuSortPad = new MyMenu(intestaMenuSortPad, strMenuSortPad, dimMenuSortPad);
		
		decisione = menuSortPad.scegli();
		
		switch (decisione)
		 {
		  case 0: 
			  esci = true;  
			  break;
		  case 1:	
			  ordinaCapienza();
			  break;
		  case 2:
			  ordinaLiberi();
			  break;	
		  case 3:   
			  ordinaIncassoPad();
			  break;
		 }
		return esci;
	}
	
	public static boolean lanciaMenuSortEvento()
	{
		boolean esci = false;
		
		strMenuSortEv[1] = opzSortEv1;
		strMenuSortEv[2] = opzSortEv2;
		strMenuSortEv[3] = opzSortEv3;
		
		MyMenu menuSortEv = new MyMenu(intestaMenuSortEv, strMenuSortEv, dimMenuSortEv);
		
		decisione = menuSortEv.scegli();
		
		switch (decisione)
		 {
		  case 0: 
			  esci = true;  
			  break;
		  case 1:	
			  ordinaData();
			  break;
		  case 2:
			  ordinaStato();
			  break;	
		  case 3:   
			  ordinaIncassoEv();
			  break;
		 }
		return esci;
	}
	
	//********************************************************************************************************
	public static void crea()
	{
		fiera = new HashMap <String,Padiglione> ();
		programma = new HashMap <String,Evento> ();
	}
	
	@SuppressWarnings("unchecked")
	public static void carica()			
	{
		fiera = ( HashMap <String,Padiglione> ) MyStream.leggiOggetto(salvaFieraTxt);
		programma = ( HashMap <String,Evento> ) MyStream.leggiOggetto(salvaProgrammaTxt);
		
		if ( !(fiera.equals(null)) && !(programma.equals(null)) )
			System.out.println(caricaSuccess);
	}
	
	public static void salva ()
	{
		MyStream.scriviOggetto( fiera, salvaFieraTxt);
		MyStream.scriviOggetto( programma, salvaProgrammaTxt);
	}

	//***************************************************************************************************
	public static void addPadiglione()   
	{								
		boolean esistente, sovrascrivi;
		int capienza;
		String codice;
		Padiglione creato;
		
		if (fiera.size() >= padiglioniMax)
			System.out.println(addPadFailure);
		else
		 {
			if ( fiera.size()>0)
			 {
				Set<String> chiavi = fiera.keySet();
				
				do { 
					esistente = false;
					sovrascrivi = false;
					codice = MyIO.leggiStringaNonVuota(insCodPadiglione,Lcodice);					
					if ( chiavi.contains(codice) )
					  { 
						esistente = true;
						sovrascrivi = MyMenu.yesOrNot(decidiSovrascritturaPad);
					  }
				}while (esistente && !sovrascrivi || codice.length()>Lcodice);
			 }
			else
				do {
					codice = MyIO.leggiStringaNonVuota(insCodPadiglione, Lcodice);
				} while (codice.length()>Lcodice);
					
			capienza = MyIO.leggiInteroLimiti(insCapienza, 1, capienzaMax);
		
			creato = new Padiglione (codice, capienza);
			creato.addStand();
			fiera.put (creato.getCodice(), creato);
			System.out.printf(addPadSuccess,creato.getCodice() );
		  }
	}
	
	public static void removePadiglione() 
	{
		Set<String> chiavi = fiera.keySet();
		Iterator<String> iterator = chiavi.iterator();
		
		boolean esistente = false, nonLibero = false;
		
		Padiglione rimosso = new Padiglione(inRimozione);
		Vector <Stand> interni = new Vector <Stand> ();

		stampaFiera(true);  //stampa ridotta
		System.out.println();
		
		String daEliminare = MyIO.leggiStringaNonVuota(scegliPadElimina);
		
		while ( rimosso.getCodice()== inRimozione && iterator.hasNext())
		 {
			String chiaveCorrente = iterator.next();
			if (fiera.get(chiaveCorrente).getCodice().equalsIgnoreCase(daEliminare) )
			  {
				esistente = true;
				interni = fiera.get(chiaveCorrente).getContenuto();
				for ( int w=0; w < interni.size(); w++)
					if ( !(interni.get(w).getPrenotato().equals(Stand.libero)) )
						nonLibero = true;
				if (!nonLibero)
				 {
					rimosso = fiera.remove(chiaveCorrente);
					System.out.printf(rimuoviPadSuccess, rimosso.getCodice());
				 }
				else
				 {
					System.out.println(sceltoOccupato);
					System.out.println(sceltoOccupato2);
				 }
			  }
		  }
		
		if (rimosso.getCodice() == inRimozione && !esistente)
			System.out.println(padNonEsistente);
	}
	
	//***************************************************************************************************
	public static void addEvento()
	{
		boolean esistente, sovrascrivi, procedi, cambiaEsigenze, sovrapponi;
		String codice; String nome; String organizzatore;
		int standNecessari;
		
		Evento creato;
		
		GregorianCalendar inizio = new GregorianCalendar ();
		GregorianCalendar fine = new GregorianCalendar ();
		
		if ( programma.size()>0)
		 {
			Set<String> chiavi = programma.keySet();
			do { 
				esistente = false;
				sovrascrivi = false;
				do {
					codice = MyIO.leggiStringaNonVuota(insCodEvento, Lcodice);
					if (codice.equalsIgnoreCase(Evento.libero))
						System.out.printf(sceltoLibero,Evento.libero);
				   } while (codice.equalsIgnoreCase(Evento.libero) || codice.length()>Lcodice);
					
				if ( chiavi.contains(codice) )
				  { 
					esistente = true;
					sovrascrivi = MyMenu.yesOrNot(decidiSovrascritturaEvento);
				  }
	
				}while (esistente && !sovrascrivi);
		 }
		else
			do {
					codice = MyIO.leggiStringaNonVuota(insCodEvento, Lcodice);
					if (codice.equalsIgnoreCase(Evento.libero))
						System.out.printf(sceltoLibero,Evento.libero);
			   } while (codice.equalsIgnoreCase(Evento.libero) || codice.length()>Lcodice);
			     
		do {
			nome = MyIO.leggiStringaNonVuota(insDescrizione, Lnome);
		   } while (nome.length()>Lnome);
		
		do {
			organizzatore = MyIO.leggiStringaNonVuota(insOrganizzatore, Lorganizzatore);
		   } while (organizzatore.length()>Lorganizzatore);

		do {
			 standNecessari = MyIO.leggiInteroLimiti(insNecessari, 1, capienzaMax);
		   } while (standNecessari > capienzaMax);

		do {
			procedi = false;
			inizio = MyDate.setData(insInizio);   //controllo parta almeno tra un mese
			
			if ( inizio.get(Calendar.YEAR) == fine.get(Calendar.YEAR) &&  inizio.get(Calendar.MONTH) > fine.get(Calendar.MONTH) )
					procedi = true;
			else
				if ( inizio.get(Calendar.YEAR) > fine.get(Calendar.YEAR) )
					procedi = true;
				else
				{
					procedi = false;
					System.out.println(dateFailure1);
				}
	 	  } while (!procedi);
			
		do{ 
			fine = MyDate.setData(insFine);    //controllo finisca dopo che parta
			if (inizio.after(fine) )
				{
					procedi = false;
					System.out.println(dateFailure2);
				}
			else 
				procedi=true;
		  } while (!procedi);
		
		if ( programma.size()>0)
		{
			// controllo nessun altro evento sia in corso in quella data.
			Set<String> chiaviEv = programma.keySet();
			Iterator<String> iteratoree = chiaviEv.iterator();
			sovrapponi = false;
			do {
				String chiaveTemp = iteratoree.next();
				Evento corrente = programma.get(chiaveTemp);
				
				if ( !( fine.before(corrente.getInizio()) || inizio.after(corrente.getFine()) ) )
					sovrapponi = true;
				
			  } while (iteratoree.hasNext() && !sovrapponi );
			
			if (sovrapponi)
			  {
				System.out.println(dateFailure3);
				procedi = false;
			  }
		 }
		
		if (procedi)
		 {
			creato = new Evento (codice, nome, organizzatore, inizio, fine);
			do {
				cambiaEsigenze = false;
				Vector <Padiglione> contenente = creato.prenota(standNecessari);
			
				if (contenente.get(0).getErrore()==0)
				 {
					System.out.printf(stampaIncassoTot, creato.getIncasso() );
						if (MyMenu.yesOrNot())	
						 {
							programma.put(creato.getCodice(), creato);
							contenente.get(1).aggiornaIncassoStorico( creato.getIncasso() );
							System.out.printf(addEvSuccess, creato.getCodice(),contenente.get(1).getCodice() );
						 }
						else
							System.out.println(addEvUnconfirmed);
				 }
				else
					if ( contenente.get(0).getErrore()==1) 
						System.out.println(addEvFailure1);
					else
					  {
						System.out.println(addEvFailure2); 
						System.out.println(cambiaEsigenzeDomanda);
						if ( MyMenu.yesOrNot(cambiaEsigenzeDomanda2) )//modificare???
							cambiaEsigenze = true;
					  }
				contenente = new Vector <Padiglione> ();
			} while (cambiaEsigenze);
		 }
	}
	
	//***************************************************************************************************
	public static void removeTerminati()  
	{			
		Set<String> chiaviRem = programma.keySet();
		Iterator<String> iteratorz = chiaviRem.iterator();
		
		while(iteratorz.hasNext())
		 {
			String chiaveCorrent = iteratorz.next();
			Evento corrente = programma.get(chiaveCorrent);
			if ( corrente.getStato().equals(Evento.stato3) )
				{
					Padiglione togliPrenotazione = corrente.getPadDaOccupare();
					
					for ( int r=0; r< togliPrenotazione.getContenuto().size(); r++)
					  {
						Stand prenota = togliPrenotazione.getContenuto().get(r);
						if ( prenota.getPrenotato().equals( corrente.getCodice()) )
						  {
							prenota.setPrenotato(Stand.libero); 
						  }
					  }
					
					iteratorz.remove();
				}
		 }
	}
	
	//***************************************************************************************************
	public static void evolviUnEvento()
	{	
		Set<String> chiavi = programma.keySet();
		Iterator<String> iterator = chiavi.iterator();
		int terminati=0;
		boolean esistente = false, inCorso = false;
		
		while(iterator.hasNext())
		 {
			String chiaveCorrente = iterator.next();
			if ( programma.get(chiaveCorrente).getStato().equalsIgnoreCase(Evento.stato3) )
				terminati++;
		 }
		
		if (terminati>0)
		  {
			System.out.printf(presenzaTerminati, terminati);
			if ( MyMenu.yesOrNot() )
				removeTerminati();
		  }
		
		stampaProgramma(true);
		
		if ( programma.size()>0)
		 {
			Iterator <String> iterator2 = chiavi.iterator();
			String daEliminare = MyIO.leggiStringaNonVuota(scegliEvolvi);
			
			while (!esistente && iterator2.hasNext())
			  {
				String chiaveCorrente = iterator2.next();
				if (programma.get(chiaveCorrente).getCodice().equals(daEliminare) )
				 {
					esistente = true;
					
					Iterator <String> iterator3 = chiavi.iterator();
					while ( iterator3.hasNext()) // controllo non ci siano altri eventi in svolgimento.
					 {
						String chiaveCheScorre = iterator3.next();
						if ( programma.get(chiaveCorrente).getStato().equals(Evento.stato1) && 
							programma.get(chiaveCheScorre).getStato().equals(Evento.stato2) )
							inCorso = true;
					 }
							
					if ( programma.get(chiaveCorrente).getStato().equals(Evento.stato3) )
						System.out.println(sceltoTerminato);
					else
						if (inCorso)
							System.out.println(giaInCorso);
						else
							programma.get(chiaveCorrente).evolviEvento();
				 }
		      }
			if (!esistente)
				System.out.println(evNonEsistente);
		 }		
	}
	
	//***************************************************************************************************
	public static void stampaFiera(boolean ridotta)
	{
		if (fiera.size()>0)
		 {
			System.out.println(listaPadiglioni);
			Set<String> chiavi = fiera.keySet();
			Iterator<String> iterator = chiavi.iterator();
			while(iterator.hasNext())
			{
				String chiaveCorrente = iterator.next();
				fiera.get(chiaveCorrente).stampaPadiglione(ridotta);
			}
			System.out.println();
		 }
		else System.out.println(listaPadVuota);
	}
	
	public static void stampaProgramma(boolean ridotta)
	{
		if (programma.size()>0)
		 {
			System.out.println(listaEventi);
			if (ridotta)
				System.out.println(formatoTabellaEv); 
			Set<String> chiaviEventi = programma.keySet();
			Iterator<String> iteratore = chiaviEventi.iterator();
			while(iteratore.hasNext())
			 {
				String chiaveCorrente = iteratore.next();
				programma.get(chiaveCorrente).stampaEvento(ridotta);
			 }
			System.out.println();
		 }
		else System.out.println(listaEvVuota);		
	}

	//***************************************************************************************************
	public static HashMap <String,Padiglione> getFiera()
	{
		return fiera;
	}
	
	public static HashMap <String,Evento> getProgramma()
	{
		return programma;
	}
	
	//***************************************************************************************************
	public static void ordinaCapienza()
	{
		CompareCapienza compara = new CompareCapienza();
		List <Padiglione> listaPad = new ArrayList <Padiglione> ( fiera.values() );
		Collections.sort( listaPad, compara);
		
		for(int i=0; i < listaPad.size();i++)
		{
			listaPad.get(i).stampaPadiglione(true);
		}
	}
	
	public static void ordinaLiberi()
	{
		CompareLiberi compara = new CompareLiberi();
		List <Padiglione> listaPad = new ArrayList <Padiglione> ( fiera.values() );
		Collections.sort( listaPad, compara);
		
		for(int i=0; i < listaPad.size();i++)
		{
			listaPad.get(i).stampaPadiglione(true);
		}
	}
	
	public static void ordinaIncassoPad()
	{
		CompareIncassoPad compara = new CompareIncassoPad(); 
		List <Padiglione> listaPad = new ArrayList <Padiglione> ( fiera.values() );
		Collections.sort( listaPad, compara);
		
		for(int i=0; i < listaPad.size();i++)
		{
			listaPad.get(i).stampaPadiglione(true);
		}
	}
	
	//*******************************************************************************************************
	public static void ordinaData()
	{
			CompareData compara = new CompareData(); 
			List <Evento> listaEv = new ArrayList <Evento> ( programma.values() );
			Collections.sort( listaEv, compara);
			
			System.out.println(formatoTabellaEv); 
			for(int i=0; i < listaEv.size();i++)
			{
				listaEv.get(i).stampaEvento(true);
			}
	}           
	
	public static void ordinaStato()
	{
		CompareData compara = new CompareData();
		List <Evento> listaEv = new ArrayList <Evento> ( programma.values() );
		Collections.sort( listaEv, compara);
		
		System.out.println(formatoTabellaEv); 
		for(int i=0; i < listaEv.size();i++)
		{
			listaEv.get(i).stampaEvento(true);
		}
	}
	
	public static void ordinaIncassoEv() 
	{
		CompareIncassoEv compara = new CompareIncassoEv();
		List <Evento> listaEv = new ArrayList <Evento> ( programma.values() );
		Collections.sort( listaEv, compara);
		
		System.out.println(formatoTabellaEv); 
		for(int i=0; i < listaEv.size();i++)
		{
			listaEv.get(i).stampaEvento(true);
		}
	}
	
//********************************************************************************************fine driver
}