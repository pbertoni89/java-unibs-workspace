package comparators;

import java.util.Comparator;

import polofieristico.Evento;

public class CompareStato implements Comparator <Evento> 
{
	final static String stato1= "in preparazione";
	final static String stato2= "in corso";
	final static String stato3= "terminato";
	
	public CompareStato()
	{
		
	}
	
	public int compare ( Evento primo, Evento secondo )
	{
		int valore = 1;
		String statoPrimo = primo.getStato();   //FIXME controllare correttezza
		String statoSecondo = secondo.getStato();
		
		if ( ( statoPrimo.equals(stato2) && statoSecondo.equals(stato1) ) ||
			 ( statoPrimo.equals(stato3) && statoSecondo.equals(stato1) ) ||
			 ( statoPrimo.equals(stato3) && statoSecondo.equals(stato2) ) )
			 	valore = -1;
		else
			if ( statoPrimo.equals(statoSecondo) )
				valore = 0;
					
			
		return valore;
	}
	
}