package comparators;

import java.util.Comparator;

import polofieristico.Padiglione;

public class CompareIncassoPad  implements Comparator <Padiglione>  {

	public CompareIncassoPad()
	{
		
	}
	
	public int compare ( Padiglione primo, Padiglione secondo)
	{
		int valore = 0;

		if ( primo.getIncassoStorico() > secondo.getIncassoStorico() )
			valore =1;
		else
			if ( primo.getIncassoStorico() < secondo.getIncassoStorico() )
				valore = -1;
		
		return valore;
	}

	
}
