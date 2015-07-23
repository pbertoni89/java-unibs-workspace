package comparators;

import java.util.Comparator;

import polofieristico.Evento;

public class CompareData implements Comparator <Evento> 
{
	public CompareData()
	{
		
	}
	
	public int compare ( Evento primo, Evento secondo )
	{
		return ( primo.getInizio().compareTo( secondo.getFine() ) );
	}
	
}
