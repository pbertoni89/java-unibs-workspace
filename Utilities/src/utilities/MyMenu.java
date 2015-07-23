package utilities;

public class MyMenu {
	
	int dimScelta;
	final int minima = 0;
	String intestazione;
	final String cornice = "------------------------------------------------";
	final String terminazione = "0 - esci dal ciclo/termina programma";
	private String[] scelta;
	final String richiesta ="Inserire un valore tra quelli proposti.";
	
	final static char Si = 'S';
	final static char No = 'N';
	
	public MyMenu(String intestazione, String[] scelta, int dimScelta)
	{
		this.dimScelta = dimScelta;
		this.intestazione = intestazione;
		//l'elemento di posto '0' è inizializzato a terminazione
		this.scelta = scelta;
		scelta[0] = terminazione;
	}
	
	public int scegli()
	{
		stampa();				//i valori dell'array di scelta sono shiftati
		return MyIO.leggiInteroLimiti(richiesta, minima, dimScelta-1);
	}
	
	public void stampa()
	{
		System.out.println(cornice);
		System.out.println(intestazione);
		System.out.println(terminazione);
		for (int i = 1; i < dimScelta; i++)
			System.out.println( i + " - " + scelta[i]);
		System.out.println(cornice);
	}
//*********************************************************************
	public static boolean yesOrNot(String domanda)
	{
		char temp;
		boolean ok = false;
		boolean valore = false;
		
		do {
			System.out.println(domanda);
			temp = MyIO.leggiCharDiretto();
			if (temp == Si )
			 {	ok = true;
				valore = true;
			 }
			else
				if (temp == No)
				{
					ok = true;
					valore = false;
				}
		  } while (!ok);
		return valore;
	}
	
	public static boolean yesOrNot()  //OVERLOADING: se nel quesito è necessario stampare un dato,
	{								  // lo fa un printf esterno.
		char temp;
		boolean ok = false;
		boolean valore = false;
		
		do {
			temp = MyIO.leggiCharDiretto();
			if (temp == Si )
			 {	ok = true;
				valore = true;
			 }
			else
				if (temp == No)
				{
					ok = true;
					valore = false;
				}
		  } while (!ok);
		return valore;
	}
	
	public static boolean sceltaDue(String domanda, String messSi, String messNo)
	{
		System.out.println(domanda);
		System.out.println(messSi);
		System.out.println(messNo);
		
		char temp;
		
		do 
		{
			temp = MyIO.leggiCharDiretto();
			if (temp == Si )
				return true;
			else 
				return false;
		} while ( temp != Si && temp != No);
	}
	
}