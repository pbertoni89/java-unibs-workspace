package utilities;
	import java.util.*;

public class MyVectorMenu {

		final int minima = 0;
		String intestazione;
		final String cornice = "------------------------------------------------";
		final String terminazione = "0 - esci dal ciclo/termina programma";
		private Vector <String> scelta = new Vector <String> ();
		final String richiesta ="Inserire un valore tra quelli proposti.";
		
		final static char Si = 'S';
		final static char No = 'N';
		
		
		//costruttore
		public MyVectorMenu(String _intestazione, Vector <String> _scelta)
		{
			intestazione = _intestazione;
			//l'elemento di posto '0' è inizializzato a terminazione
			scelta = _scelta;
			scelta.add(terminazione);
		}
		
		public int scegli()
		{
			stampa();
			return MyIO.leggiInteroLimiti(richiesta, minima, scelta.size() );
		}
		
		public void stampa()
		{
			System.out.println(cornice);
			System.out.println(intestazione);
			System.out.println(terminazione);
			for (int i = 1; i < scelta.size(); i++)
				System.out.println( i + " - " + scelta.get(i) );
			System.out.println(cornice);
		}
}
