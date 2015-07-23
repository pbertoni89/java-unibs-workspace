package comparators;

import java.util.Comparator;

import polofieristico.Padiglione;

public class CompareLiberi implements Comparator <Padiglione>  {
	
	public CompareLiberi()
	{
		
	}
	
	public int compare ( Padiglione primo, Padiglione secondo)
	{
		int valore = 0;

		if ( (primo.getCapienza()-primo.getOccupati() ) > (secondo.getCapienza()-secondo.getOccupati()) )
			valore =1;
		else
			if ( (primo.getCapienza()-primo.getOccupati() ) < (secondo.getCapienza()-secondo.getOccupati()) )
				valore = -1;
		
		return valore;
	}
	
}