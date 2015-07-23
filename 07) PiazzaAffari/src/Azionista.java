import java.io.Serializable;
import java.util.Vector;

import utilities.MyIO;

public class Azionista implements Serializable {
	
	private final static long serialVersionUID = 1;

	private String nomeAzionista;
	
	private boolean nonVuoto = false;
	
	private long credito;
	final static long creditoIniz = 1000;
	
	Vector <Lotto> portafoglio = new Vector <Lotto> ();
	int dimPortafoglio = 0;
	
	final static String portafoglioVuoto = "Non possiedi lotti";
	final static String buy = "Acquisto di un lotto azionario";
	final static String sell = "Vendita di un lotto azionario";
	final static String buyTitolo = "Inserire il nome del titolo o della società.";
	final static String nonEsiste = "Il titolo inserito non è contenuto nel proprio portafoglio!";
	final static String buyValore = "Inserire il valore del titolo.";
	final static String buyDimensione = "Inserire il numero di azioni.";
	final static String stampSpesa = "Sono stati spesi %1.2f euro nell'acquisto del lotto di %s.\n\n";
	final static String noDenaroSuff= "Non si dispone di denaro sufficiente a concludere la transazione.";
	final static String stampRicavo = "Sono stati ricavati %1.2f euro dalla vendita del lotto di %s.\n\n";
	
	final static String cornice = "-----------------------------------------";
	final static String situazione = "Situazione finanziaria di %s \n";
	final static String situazione2 = "Credito disponibile: ";
	final static String situazione3 = "Portafoglio azionario:";
	
	public Azionista ( String _nome )
	{
		nomeAzionista = _nome;
		credito = creditoIniz;
	}
	
	public void acquista()
	{
		double spesa = 0;
		
		System.out.println(buy);
		String titolo = MyIO.leggiStringaNonVuota(buyTitolo);
		double valore = MyIO.leggiDoublePos(buyValore);  
		Titolo tempTitolo = new Titolo (titolo, valore);
		int dimensione = MyIO.leggiInteroPos(buyDimensione);
		
		spesa = valore * dimensione;
		if ( spesa < credito)
		{ 
			Lotto tempLotto = new Lotto ( tempTitolo, dimensione );
			portafoglio.add(tempLotto);
			dimPortafoglio++;
			credito = credito - (long) spesa;
			if (!nonVuoto)
				nonVuoto = true;
			System.out.printf( stampSpesa, spesa, titolo);
		}
		else
		{
			System.out.println(noDenaroSuff);
		}
	}
	
	public void vendi()
	{
		double ricavo = 0;
		boolean esiste = false;
		String titolo;
		double valore;
		int dimensione;
		
		System.out.println(sell);
		
		if (nonVuoto)
		 {
			titolo = MyIO.leggiStringaNonVuota(buyTitolo);
			for ( int i = 0; i < dimPortafoglio; i++)
			{ Titolo[] temp = portafoglio.get(i).getTitoliLotto();
			  if ( titolo.equalsIgnoreCase ( temp[0].getNomeTitolo() ) )
			    {
				 esiste = true;
				 
				 valore = temp[0].getValore();
				 dimensione = portafoglio.get(i).getDimensione();
				 ricavo = valore * dimensione;
				 
				 portafoglio.remove(i);
				 dimPortafoglio--;
				 if (dimPortafoglio == 0)
					nonVuoto = false;
				 
				 System.out.printf( stampRicavo, ricavo, titolo);
				 credito = credito - (long) ricavo;
			    }
			}
			if (!esiste)
				System.out.println(nonEsiste);
		 }
		else
			System.out.println(portafoglioVuoto);
	}
	
	public String getNomeAzionista()
	{
		return nomeAzionista;
	}
	/*
	public long getCredito()
	{
		return credito;
	}
	public void setCredito(long _credito)
	{
		credito = _credito;
	}        */
	
	public Vector <Lotto> getPortafoglio ()
	{
		return portafoglio;
	}  
	
	public void stampa()
	{
		System.out.println(cornice);
		System.out.printf(situazione, nomeAzionista);
		System.out.print(situazione2);
		System.out.println(credito);

		if ( dimPortafoglio != 0 )
		{   System.out.println(situazione3);
			for ( int i = 0; i < dimPortafoglio; i++)
				System.out.println( portafoglio.get(i).toString() );
		}
	}
}
