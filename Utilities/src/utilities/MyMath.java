package utilities;

	import java.util.*;

public class MyMath {
	
	// logaritmo generico
	public static double logaritmo(double base, double argomento) {
		return Math.log(argomento) / Math.log(base);
	}

	// overloading: logaritmo generico
	public static double logaritmo(int base, double argomento) {
		return Math.log(argomento) / Math.log(base);
	}

	// potenza di interi
	public static int potenza(int base, int esponente) {
		int i, pot;
		pot = base;

		for (i = 1; i < esponente; i++)
			pot *= base;

		if (esponente == 0)
			if (base == 0)
				return (-1);
			else
				return 1;

		return pot;
	}

	// overloading: potenza con float
	public static double potenza(double base, double esponente) {
		int i;
		double pot;
		pot = base;

		for (i = 1; i < esponente; i++)
			pot *= base;

		if (esponente == 0)
			if (base == 0)
				return (-1);
			else
				return 1;

		return pot;
	}

	// overloading (sostanzialmente) funzione esponenziale naturale
	public static double esponenziale(int esponente) {
		int i;
		double exp;
		exp = Math.E;

		for (i = 1; i < esponente; i++)
			exp *= Math.E;

		if (esponente == 0)
			return 1;

		return exp;
	 }
	
	//estrai intero casuale compreso in un range
	private static Random rand = new Random();
	
	public static int estraiIntero(int min, int max)
	{
	 int range = max + 1 - min;
	 int casual = rand.nextInt(range);
	 return casual + min;
	}
	/*estrai double casuale compreso in un range	
	public static double estraiDouble(int min, int max)
	{
	 int range = max + 1 - min;
	 double casual; 
	 do { 
		 casual = Math.random();
	 } while ( casual)
	 return casual + min;
	} */
	
	//fattoriale
	public static long fattoriale()
	{
		final String chiedi = " Inserisci il numero da fattorizzare: ";
		long fatt = 0;
		int numero;
		int temp;
		
		numero = MyIO.leggiInteroPos(chiedi);
		temp=numero;
		fatt=numero;
		
		while(temp-1>1)
		 {
			fatt*=(temp-1);
			temp--;
		 }

		return fatt;
	}
}
