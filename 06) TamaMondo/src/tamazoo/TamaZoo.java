	package tamazoo;


import java.util.Vector;

import utilities.*;

public class TamaZoo  {

	boolean iniziatoZoo;
	boolean doppione;
	
	Vector <Tama> tamaMondo = new Vector <Tama> ();
	
	final String quantiTama = "Quanti Tamagotchi si desidera far nascere ?";	
	final String inserisciNome = "Come si chiama il tuo tamagotchi ?";
	final String eNato = "E' nato: %s, un tamagotchi %s. \n\n";
	final String natoTriste ="un pò triste";
	final String natoGordo ="un pò affamato";
	
	int dimZoo;
	int minDimZoo;
	int maxDimZoo;
	byte caso;
	
	final int maxInput = 20;
	final int minInput = 5;  
	
	public TamaZoo () {
		
		iniziatoZoo = false;
		doppione = false;
		minDimZoo = 1;
	    maxDimZoo = 15;
	}
	
	public void creaZoo()
	 {
		boolean doppione = false;
		iniziatoZoo = true;
		String nomeConfronto;
		TamaTriste nuovoTamaTriste;
		TamaGordo nuovoTamaGordo;
		
		dimZoo = MyIO.leggiInteroLimiti(quantiTama, minDimZoo, maxDimZoo);
		
			for ( int i =0; i < dimZoo ; i++)
			  {
				 caso = (byte) MyMath.estraiIntero(0,1);
				 if (caso == 1)
					 {
					 	do {
					 		doppione = false;
					 		nuovoTamaTriste = nuovoTriste();
					 		for (int j = 0; j < tamaMondo.size(); j++)
					 		  {
					 			nomeConfronto = tamaMondo.get(j).getNome();
					 			if (nuovoTamaTriste.getNome().equals(nomeConfronto))
					 				doppione = true;
					 		  }
					 	}while (doppione);
					 	
				 		if (!doppione)
				 			{
				 				tamaMondo.add(nuovoTamaTriste);
				 				System.out.printf(eNato, nuovoTamaTriste.getNome(), natoTriste);
				 			}		
					 }
				 else
				 	 {
						 do {
						 		doppione = false;
						 		nuovoTamaGordo = nuovoGordo();
						 		for (int j = 0; j < tamaMondo.size(); j++)
						 		  {
						 			nomeConfronto = tamaMondo.get(j).getNome();
						 			if (nuovoTamaGordo.getNome().equals(nomeConfronto))
						 				doppione = true;
						 		  }
						 	}while (doppione);
						 
						 if (!doppione)
				 			{
				 				System.out.printf(eNato, nuovoTamaGordo.getNome(), natoGordo);
				 				tamaMondo.add(nuovoTamaGordo);
				 			}
					 }
		     }
			System.out.println();
	 }
	
	public TamaTriste nuovoTriste() 
	 {
		String _nome;
		_nome = MyIO.leggiStringa(inserisciNome);
		return new TamaTriste(_nome);
	 }
	
	public TamaGordo nuovoGordo() 
	 {
		String _nome;
		_nome = MyIO.leggiStringa(inserisciNome);
		return new TamaGordo(_nome);
	 }

	public void turno() 
	{
		final String intestazione = " Cosa si desidera fare nello zoo ?";

		final String opzione1 = " Accarezzare i tamagotchi";
		final String opzione2 = " Nutrire i tamagotchi";
		final String opzione3 = " Sopprimere un tamagotchi";
		final int dimSceltaPrincipale = 4;
		String[] sceltaPrincipale = new String[dimSceltaPrincipale];
		int decisione;
		
		sceltaPrincipale[1] = opzione1;
		sceltaPrincipale[2] = opzione2;
		sceltaPrincipale[3] = opzione3;
		
		MyMenu menuPrincipale = new MyMenu(intestazione, sceltaPrincipale, dimSceltaPrincipale);
		decisione = menuPrincipale.scegli();  
		
		switch ( decisione )
		{
			case 0: 
				break;
				
			case 1:			
				carezzaZoo();
				stampaStato();
				//lanciaMenuPrincipale();
				break;
		
			case 2:
				nutriZoo();
				stampaStato();
				//lanciaMenuPrincipale();
				break; 
				
			case 3: 
				uccidiTama();
				//lanciaMenuPrincipale();
				break;
		}
		
	}
	
	public void carezzaZoo()
	{	 
		final String decidi = "decidi di dare a %s  %d carezze. \n";
		int nCarezze;
		Tama daCarezzare;
		 for ( int k = 0; k < dimZoo; k++)
		  {
			 nCarezze = MyMath.estraiIntero(minInput, maxInput);
			 daCarezzare = tamaMondo.get(k);
			 daCarezzare.carezza(nCarezze);
			 System.out.printf(decidi, daCarezzare.getNome(), nCarezze);
		  }
 
	}
	
	public void nutriZoo()
	{
		final String decidi = "decidi di dare a %s  %d carezze. \n";
		int nBiscotti;
		Tama daNutrire;
			 for ( int k = 0; k < dimZoo; k++)
			  {
				 nBiscotti = MyMath.estraiIntero(minInput, maxInput);
				 daNutrire = tamaMondo.get(k);
				 daNutrire.nutri(nBiscotti);
				 System.out.printf(decidi, daNutrire.getNome(), nBiscotti);
			  }
			 
	}
		
	public void uccidiTama()
	{
		final String chiDeveMorire = "Inserire il nome del tamagotchi da sopprimere.";
		final String nonTrovato = " Il tamagotchi indicato non esiste nello zoo";
		String destinato;
		boolean trovato = false;
		Tama tamaPatibolo;
		int i = 0;

		destinato = MyIO.leggiStringaNonVuota(chiDeveMorire);
		do {	
		   	tamaPatibolo = tamaMondo.get(i);
		   	if (destinato.equals( tamaPatibolo.getNome() ) )
			  { 
				trovato = true;
				tamaMondo.remove(i);
			  }
		} while (!trovato && i < dimZoo );
			
		if (!trovato)
			System.out.println(nonTrovato);
	}
		
	public void stampaStato() 
	 {
		Tama daStampare;
		
		for (int i = 0; i < dimZoo; i++)
		{
			daStampare = tamaMondo.get(i);
			daStampare.toString();
		}
	}
	
}


