package comparators;

import java.util.Comparator;

import polofieristico.Padiglione;

public class CompareCapienza implements Comparator <Padiglione>  {
	
	public CompareCapienza()
	{
		
	}
	
	public int compare ( Padiglione primo, Padiglione secondo)
	{
		int valore = 0;

		if (primo.getCapienza() > secondo.getCapienza() )
			valore =1;
		else
			if (primo.getCapienza() < secondo.getCapienza() )
				valore = -1;
		
		return valore;
	}
	
}
