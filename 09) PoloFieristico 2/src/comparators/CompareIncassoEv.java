package comparators;

import java.util.Comparator;
import polofieristico.Evento;

public class CompareIncassoEv  implements Comparator <Evento>  {

	public CompareIncassoEv()
	{	
	
	}
	
	public int compare (Evento primo, Evento secondo)
	{
		int valore = 0;

		if ( primo.getIncasso() > secondo.getIncasso() )
			valore =1;
		else
			if ( primo.getIncasso() < secondo.getIncasso() )
				valore = -1;
		
		return valore;
	}
}
