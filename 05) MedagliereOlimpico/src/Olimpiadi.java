
import java.util.*;

import utilities.*;

public class Olimpiadi {

	static Vector <Nazione> listaNazioni = new Vector <Nazione> ();
	static Vector <Gara> listaGare = new Vector <Gara> ();
	
	final static String intestazione ="Pillars of Software 2010 - Gestione Olimpiadi";
	final static String terminazioneProg="Programma terminato, arrivederci.";
	final static int dimSceltaPrincipale = 5;
	final static String opzione1 = " Inserimento nazione";
	final static String opzione2 = " Inserimento gara";
	final static String opzione3 = " Inserimento risultato";
	final static String opzione4 = " Stampa medagliere";
	static String[] sceltaPrincipale = new String[dimSceltaPrincipale];
	static int decisione;
	
	static boolean iniziatoNazioni = false;
	final static String avvisoIniziatoNazioni= " Inserire almeno una nazione prima!";
	static boolean iniziatoGare = false;
	final static String avvisoIniziatoGare = "Inserire almeno una gara prima!";
	static boolean iniziatoRisultati = false;
	final static String avvisoIniziatoTutto = "In memoria non ci sono nazioni/gare.";
	
	final static String inserisciNomeNazione = "Inserisci il nome della nazione";
	final static String inserisciNomeGara = "Inserisci il nome della gara";
	final static String avvisoDoppione = "nome già esistente";
	
	final static String inserisciNazioneVittoriosa ="Scegliere quale nazione ha conquistato la medaglia";
	final static String inserisciGaraVittoriosa = "Scegliere in quale gara si ha conquistato una medaglia.";
	final static int dimPodio = 3;
	final static String[] inserisciPodio = new String[dimPodio];
	final static String inserisciPodioTitolo = "Inserire le informazioni sul podio";
	final static String inserisciPrimo = "Primo classificato:";
	final static String inserisciSecondo = "Secondo classificato:";
	final static String inserisciTerzo = "Terzo classificato:";
	final static String nazioneGiaVittoriosa = "Questa nazione ha già vinto una medaglia in questa gara!";
	
	final static String formatoStampa = " %d |  %s \n";
	
	final static String stampaListaNazioni = "Nazioni registrate all'Albo Olimpico: ";
	final static String stampaListaGare = "Gare registrate all'Albo Olimpico: ";
	
	final static String intestazioneMedagliere = "-----------MEDAGLIERE OLIMPICO-----------";
	final static String primaRigaMedagliere =         "---Nazione------Ori---Argenti---Bronzi---";
	final static String treSpazi = "   ";
	final static String dieciSpazi = "          ";
	final static String spazio = " ";
	final static int lunghezzaNazioneDefault = 6;
	
//**********************************************************************************************
	public static void main(String[] args) 
	{
		lanciaMenuPrincipale();
		System.out.println(terminazioneProg);
	}
//**********************************************************************************************
	
	public static void lanciaMenuPrincipale()
	{
		sceltaPrincipale[1] = opzione1;
		sceltaPrincipale[2] = opzione2;
		sceltaPrincipale[3] = opzione3;
		sceltaPrincipale[4] = opzione4;
		MyMenu menuPrincipale = new MyMenu(intestazione, sceltaPrincipale, dimSceltaPrincipale);
		decisione = menuPrincipale.scegli();
		
		switch ( decisione )
		{
		case 0: 
			break;
			
		case 1:			
			creaControllaNazione();
			lanciaMenuPrincipale();
			break;
	
		case 2:
			creaControllaGara();
			lanciaMenuPrincipale();
			break; 
			
		case 3: 
			inserisciRisultati();
			lanciaMenuPrincipale();
			break;
		
		case 4: 
			//stampaMedagliere();
			System.out.println(" IN SVILUPPO ");
			lanciaMenuPrincipale();
			break;
		}
	}
	
	//********************************************************
	public static Nazione nuovaNazione() 
	{
		String _nomeNazione;
		_nomeNazione = MyIO.leggiStringa(inserisciNomeNazione);
		return new Nazione( _nomeNazione );
 	}
	
	public static void creaControllaNazione()
	{
		boolean doppione = false;
		iniziatoNazioni = true;
		String nomeIngresso;
		String nomeCorrente = null;
		
		do {
			Nazione inIngresso = nuovaNazione();
			nomeIngresso = inIngresso.getNomeNazione();
			for ( int i =0; i < listaNazioni.size() ; i++)
				nomeCorrente = listaNazioni.get(i).getNomeNazione();
			  if ( nomeIngresso.equalsIgnoreCase( nomeCorrente ) )
			  		{
				  	 doppione = true;
					 System.out.println(avvisoDoppione);
					}
			  else
				  doppione = false;
				
	    	if (!doppione)
				listaNazioni.add( inIngresso );
		
		}while (doppione);
	}
	
//********************************************************
	public static Gara nuovaGara() 
	{
		String _nomeGara;
		_nomeGara = MyIO.leggiStringa(inserisciNomeGara);
		return new Gara( _nomeGara );
 	}
	
	public static void creaControllaGara()
	{
		boolean doppione = false;
		iniziatoGare = true;
		String nomeIngresso;
		String nomeCorrente = null;
		
		do {
			Gara inIngresso = nuovaGara();
			nomeIngresso = inIngresso.getNomeGara();
			for ( int i =0; i < listaGare.size() ; i++)
				nomeCorrente = listaGare.get(i).getNomeGara();
			  if ( nomeIngresso.equalsIgnoreCase( nomeCorrente ) )
			  		{
				  	 doppione = true;
					 System.out.println(avvisoDoppione);
					}
			  else
				  doppione = false;
				
	    	if (!doppione)
				listaGare.add( inIngresso );
		
		}while (doppione);
	}
//********************************************************
	
	public static Nazione scegliNazione()
	{  
		int nNazioneVittoriosa;
	    Nazione nazioneVittoriosa;
		Nazione nazioneCorrente;
		
		System.out.println(stampaListaNazioni);
		for (int i = 0; i < listaNazioni.size(); i++)
		  {	
			nazioneCorrente = listaNazioni.get(i);
			System.out.printf(formatoStampa, i+1, nazioneCorrente.getNomeNazione() );
		  }
		
		nNazioneVittoriosa = MyIO.leggiInteroLimiti(inserisciNazioneVittoriosa, 0, listaNazioni.size() );
		nNazioneVittoriosa = nNazioneVittoriosa -1;
		nazioneVittoriosa = listaNazioni.get( nNazioneVittoriosa);

		return nazioneVittoriosa;
	}
	
	public static Gara scegliGara()
	{
		int nGaraVittoriosa;
		Gara garaVittoriosa;
		Gara garaCorrente;
		
		System.out.println(stampaListaGare);
		for (int i = 0; i < listaGare.size(); i++)
		  {	
			garaCorrente = listaGare.get(i);
			System.out.printf(formatoStampa, i+1, garaCorrente.getNomeGara() );
		  }
		
		nGaraVittoriosa = MyIO.leggiInteroLimiti(inserisciGaraVittoriosa, 0, listaGare.size() );
		nGaraVittoriosa = nGaraVittoriosa -1;
		garaVittoriosa = listaGare.get( nGaraVittoriosa);
		
		return garaVittoriosa;
	}
//********************************************************
	public static void inserisciRisultati()  {	
		
		inserisciPodio[0] = inserisciPrimo;
		inserisciPodio[1] = inserisciSecondo;
		inserisciPodio[2] = inserisciTerzo;
		
		String[] giaVinto = new String[2];

		Nazione nazioneScelta;
		if (iniziatoNazioni && iniziatoGare)
		  { 
			iniziatoRisultati = true;
			Gara garaScelta = scegliGara();
			boolean esciGiaVinto = true;
	
			System.out.println(inserisciPodioTitolo);
			for (int i = 0; i < dimPodio; i++)
			  {
				System.out.println(inserisciPodio[i]);
						do {
							nazioneScelta = scegliNazione();
							if (i<2)
								giaVinto[i] = nazioneScelta.getNomeNazione();
							if (i>1)
								if (giaVinto[i-1].equalsIgnoreCase( nazioneScelta.getNomeNazione() ) )
								{
									System.out.println(nazioneGiaVittoriosa);
									esciGiaVinto = false;
								}
								else
									esciGiaVinto = true;
						   }while (!esciGiaVinto); 	
						nazioneScelta.aggiungiMedaglia(i);
						garaScelta.setPodio( nazioneScelta, i);
			   }
		  }
		else
			if (!iniziatoNazioni && iniziatoGare)
				System.out.println(avvisoIniziatoNazioni);
			else
				if (iniziatoNazioni && !iniziatoGare)
					System.out.println(avvisoIniziatoGare); 
				else
					System.out.println(avvisoIniziatoTutto); 
	}
		
//********************************************************
	/*
	// TODO Medagliere Ordinato.				//   ---Burkina Faso-----
	public static void stampaMedagliere()   //   ---Nazione----------Ori---Argenti---Bronzi---
	{							
		Vector <Nazione> listaOrdinata = new Vector <Nazione> ();
		Nazione scambio;
		int z = 0;
		
		int[][] medagliereCorrente = new int[3][];			
		StringBuffer bufferRiga = new StringBuffer(treSpazi);
		int avanzo;
		int scarto;
		int dimNazioneCorrente;
		String nomeNazioneCorrente;
		//TODO SORTING
		/*
		 do {
		for ( int i = 0; i < listaNazioni.size()-1; i++)
		  {
			medagliereCorrente[z][i] = listaNazioni.get(i).getMedaglia(z);
			for (int j = 0; j < listaNazioni.size(); j++)
			  {
				medagliereCorrente[z][j] = listaNazioni.get(j).getMedaglia(z);
				if ( medagliereCorrente[z][i] < medagliereCorrente[z][j] )
				 {
				//	scambiomedagliereCorrente[z][]
				 }
			  }
		  }
		 }while(true);   
		
		
		
		//TODO STAMPA
		do {
			for ( int i = 0; i < listaNazioni.size(); i++)
				{
					 bufferRiga.append(treSpazi);
					 
					 nomeNazioneCorrente = listaNazioni.get(i).getNomeNazione();
					 bufferRiga.append(nomeNazioneCorrente);
					 
					 dimNazioneCorrente = nomeNazioneCorrente.length();
					 avanzo = lunghezzaNazioneDefault - dimNazioneCorrente;
					 
					 if (avanzo >= 0)
					  {
						for ( int k = 0; k < avanzo; k++)
							bufferRiga.append(spazio);
						bufferRiga.append(dieciSpazi);
				      }
					 else
					  {
						scarto = dieciSpazi.length() + avanzo;
						for ( int w = 0; w < scarto; w++)
							bufferRiga.append(spazio);
					  }
					 
				}
		  }while(true);
	}
				*/
						  
					/* 
        //... 1. Sort strings - or any other Comparable objects.
        String[] names = {"Zoe", "Alison", "David"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));

        //... 2. Sort doubles or other primitives.
        double[] lengths = {120.0, 0.5, 0.0, 999.0, 77.3};
        Arrays.sort(lengths);
        System.out.println(Arrays.toString(lengths));
      */

}	// fine Classbody	
