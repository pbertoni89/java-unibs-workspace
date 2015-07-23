package utilities;

	import java.util.Scanner;
	import java.util.InputMismatchException;

public class MyIO {
	
	private static Scanner creaScanner ()
	  {
	   Scanner creato = new Scanner(System.in);
	   creato.useDelimiter(System.getProperty("line.separator"));
	   return creato;
	  }
	
	private static Scanner miaTastiera = creaScanner();
	
	private final static String erroreStringaVuota = " Attenzione, è stato immesso un campo vuoto.";
	private final static String erroreNumerico = "Attenzione: il dato inserito non e' un formato numerico";
	private final static String erroreLimiti = "Attenzione, inserire un numero appartenente al range.";
	private final static String errorePositivo = "Attenzione, inserire un numero positivo.";

	
	// interi con controllo correttezza
	public static int leggiIntero (String messaggioRichiesta) {
		
		boolean esci = false;
		int valoreLetto = 0;
		do
		{
				System.out.println(messaggioRichiesta);
			try
			 {
				valoreLetto = miaTastiera.nextInt();
				esci = true;
			 }
			catch (InputMismatchException err)
			 {
				System.out.println(erroreNumerico);
				@SuppressWarnings("unused")
				String daButtare = miaTastiera.next();
			 }
	   	} while (!esci);
		return valoreLetto;
	}
	
	//interi positivi
	public static int leggiInteroPos(String messaggioRichiesta) {
		
		int temporaneo;
		boolean esci = false;
		do {
			temporaneo = leggiIntero(messaggioRichiesta);
			if (temporaneo > 0)
				esci = true;
			else
				System.out.println(errorePositivo);
		  }while (!esci);
		return temporaneo;
	}
	//interi in un range
	public static int leggiInteroLimiti(String messaggioRichiesta, int minimo, int massimo) {
		
		boolean esci = false;
		int scelta = 0;
		do {
			scelta = leggiIntero(messaggioRichiesta);
			if( scelta>=minimo && scelta <= massimo )
				esci = true;
			else
				System.out.println(erroreLimiti);
		} while(!esci);
		return scelta;
	}
	
	// caratteri
	public static char leggiChar(String messaggioRichiesta) {
		
		System.out.println(messaggioRichiesta);
		String tempStringa = miaTastiera.next();
		return tempStringa.charAt(0);
	}
	// stringhe
	public static String leggiStringa(String messaggioRichiesta) {
		
		System.out.println(messaggioRichiesta);
		return miaTastiera.next();
	}
	// stringhe che stampano un intero
	public static String leggiStringa(String messaggioRichiesta, int parametro) {
		
		System.out.printf(messaggioRichiesta+"\n", parametro);
		return miaTastiera.next();
	}
	
	public static String leggiStringa() {
		
		return miaTastiera.next();
	}
	
	// stringhe non vuote
    public static String leggiStringaNonVuota(String messaggioRichiesta) {
	    
    	boolean finito=false;
        String lettura = null;
	    do
		   {
		     lettura = leggiStringa(messaggioRichiesta);
			 lettura = lettura.trim();
			 if (lettura.length() > 0)
			  finito=true;
			 else
			  System.out.println(erroreStringaVuota);
		   } while (!finito);
		   
		   return lettura;
    }
    // stringhe non vuote che stampano un intero.
    public static String leggiStringaNonVuota(String messaggioRichiesta, int parametro) {
	    
    	boolean finito=false;
        String lettura = null;
	    do
		   {
		     lettura = leggiStringa(messaggioRichiesta, parametro);
			 lettura = lettura.trim();
			 if (lettura.length() > 0)
			  finito=true;
			 else
			  System.out.println(erroreStringaVuota);
		   } while (!finito);
		   
		   return lettura;
    }
    
    
	// stringhe senza stampare richiesta (vedi metodo SceltaDue della classe MyMenu)
    public static String leggiStringaDiretta() {
	    
    	boolean finito=false;
        String lettura = null;
	    do
		   {
		     lettura = leggiStringa();
			 lettura = lettura.trim();
			 if (lettura.length() > 0)
			  finito=true;
			 else
			  System.out.println(erroreStringaVuota);
		   } while (!finito);
		   
		   return lettura;
    }
	// caratteri senza stampare richiesta (vedi metodo SceltaDue della classe MyMenu)
	public static char leggiCharDiretto() {
		
		String tempStringa = leggiStringaDiretta();
		tempStringa = tempStringa.toUpperCase();
		return tempStringa.charAt(0);
	}
	
	
	// double con controllo correttezza
	public static double leggiDouble (String messaggioRichiesta) {
		
		boolean esci = false;
		double valoreLetto = 0;
		do
		{
				System.out.println(messaggioRichiesta);
			try
			 {
				valoreLetto = miaTastiera.nextDouble();
				esci = true;
			 }
			catch (InputMismatchException err)
			 {
				System.out.println(erroreNumerico);
				@SuppressWarnings("unused")
				String daButtare = miaTastiera.next();
			 }
	   	} while (!esci);
		return valoreLetto;
	}
	// doubles positivi
	public static double leggiDoublePos(String messaggioRichiesta) {
		
		double temporaneo;
		boolean esci = false;
		do {
			temporaneo = leggiDouble(messaggioRichiesta);
			if (temporaneo > 0)
				esci = true;
			else
				System.out.println(errorePositivo);
		  }while (!esci);
		return temporaneo;
	}
//----------------------------------------------------------------------------OUTPUT
	
}
