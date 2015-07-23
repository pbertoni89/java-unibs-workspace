package utilities;

import java.util.*;

public class MyDate implements Comparator <GregorianCalendar> 
{
	    private static Calendar adesso = new GregorianCalendar();  
	
	    private static final int annoMinimo = 1997;   //TODO implementare controlli sui giorni del mese.
	    private static final int annoMassimo = 2097;
	    
	public MyDate()
	{
		
	}
	    
	//conoscere l'anno attuale
	public static int getAnno() {
		  
		  return adesso.get( Calendar.YEAR );
	  }
	  
	//Conoscere l'ora corrente. Divisione in AM PM
	public static void oraCorrente() {
		
	  int ore = adesso.get( Calendar.HOUR );
	  int minuti = adesso.get( Calendar.MINUTE );
	  int secondi = adesso.get( Calendar.SECOND );
	  
	  String orario;
	  if(adesso.get(Calendar.AM_PM) == 0)
	  orario = "A.M.";
	  else
	  orario = "P.M.";
	  
	  System.out.println("Sono le : " + ore + ":" + minuti + ":" + secondi + " " + orario);
	  }

	//Conoscere la data corrente.        
	public static GregorianCalendar dataCorrente() {
		
	  int giorno = adesso.get( Calendar.DAY_OF_MONTH );
	  int mese = adesso.get( Calendar.MONTH );
	  int anno = adesso.get( Calendar.YEAR );
	  
	  return new GregorianCalendar ( anno, mese, giorno);
	  }   
	  
	//acquisire una durata temporale nel formato mm:ss 
	public static int[] getDurata(String richiestaDurata) {
		
		String durata;
		
	 	boolean formatoOK = true;
	 	final char duePunti = ':' ;
	 	boolean arrivatoDuePunti = false;
	 	int i = 0;

	 	String minuti = "";
	 	String secondi = "";
	 	int[] minutiSecondi = new int[2];
		
	 	do {
	 		
	 		 durata= MyIO.leggiStringa(richiestaDurata);
	 		if (durata.length() != 5)
				 formatoOK = false;
	 		else
	 		  {
	 			do{
		 			 if (!arrivatoDuePunti)
		 			   {
			 			  if ( durata.charAt(i) == duePunti) 
			 			    { 
			 			      if (i != 2)  //i minuti variano tra 0 (cmq una cifra) e 99 (due al max)
			 				    formatoOK = false;
			 				  arrivatoDuePunti = true;
			 			    }
			 			  else
			 				 minuti = minuti + durata.charAt(i);
		 			   }
		 			 else
	    	 			secondi = secondi + durata.charAt(i);	
		 			 i++;
				   } while ( i < 5 && formatoOK );
	 		    }
	 	   } while (!formatoOK);
	 	
	 	minutiSecondi[0] = Integer.parseInt(minuti);
	 	minutiSecondi[1] = Integer.parseInt(secondi);
	 	
		return minutiSecondi;
	}
	
	//creare una data come DD MM YYYY
	public static GregorianCalendar setData(String avviso)   //implementare controlli su giorni possibili.
	{												// assicurarsi caldamente che in rete non ci siano 
														//metodi equivalenti MOOOOLTO MIGLIORI.
		final String insGiorno = "Inserire il giorno del mese";
		final String insMese = "Inserire il numero del mese";
		final String insAnno = "Inserire l'anno";
		
		System.out.println(avviso);
		int giorno = MyIO.leggiInteroLimiti (insGiorno, 1, 31);  
		int mese = MyIO.leggiInteroLimiti (insMese, 1, 12) -1;  //mesi parton da zero
		int anno = MyIO.leggiInteroLimiti (insAnno, annoMinimo, annoMassimo);
	
		return new GregorianCalendar ( anno, mese, giorno);
	}
	
//***********************************************************************************************************
	public static String getData( GregorianCalendar data)   // DD/MM/YYYY
	{
		int giorno = data.get( Calendar.DAY_OF_MONTH );
		int mese = data.get( Calendar.MONTH );
		int anno = data.get( Calendar.YEAR);
		
		String formato = giorno+"/"+mese+"/"+anno;
		return formato;
	}
	
	public static String getDataCorta( GregorianCalendar data)  // DD/MM/YY
	{
		int giorno = data.get( Calendar.DAY_OF_MONTH );
		int mese = data.get( Calendar.MONTH );
		int anno = data.get( Calendar.YEAR);
		
		String formato = giorno+"/"+mese+"/"+ new Integer(anno).toString().substring(2) ;
		return formato;
		
	}
	
//***********************************************************************************************************			
	
	public int compare(GregorianCalendar primo, GregorianCalendar secondo)
	{
		return primo.compareTo(secondo);
	}						
	
	/*   //TODO CONFRONTO TRA DATE E STAMPA INTERVALLO   
	public static int intervallo(GregorianCalendar primo, GregorianCalendar secondo)
	{
		int nGiorni = 0;
		nGiorni = Math.abs(  primo.get(primo.DAY_OF_YEAR) - secondo.get(secondo.DAY_OF_YEAR)  );
		
		if ( primo.get(primo.YEAR) != secondo.get(secondo.YEAR) );
		 {
			 int anniDiff = primo.get(primo.YEAR) - secondo.get(secondo.YEAR);
			 nGiorni = nGiorni + 365*anniDiff;
		 }
		return nGiorni;
	}   */
}