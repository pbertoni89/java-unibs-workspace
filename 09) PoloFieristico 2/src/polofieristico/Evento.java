package polofieristico;

import java.util.*;
import java.io.Serializable;
import utilities.*;

/** @doc ipotesi aggiuntiva: ogni evento richiede x stand TUTTI uguali e TUTTI compresi nello stesso pad 
 *  
 *  @author Giskard
 */

public class Evento implements Serializable {

	private final static long serialVersionUID = 1;
	
	final static String libero = "LIBERO";
	final static String cornice = "-----------------------------------------------------------";
	final static String stCodice= "Codice evento: %s\n";
	final static String stDescrizione= "Descrizione: %s\n";
	final static String stOrganizzatore= "Organizzatore: %s\n";
	final static String stPadOccupato= "Padiglione prenotato: %s\n";
	final static String stStandOccupati= "Stands riservati: %d\n";
	final static String stDataInizio= "Data di inizio: %s\n";
	final static String stDataFine= "Data di chiusura: %s\n";
	final static String stIncasso= "Incasso dalla prenotazione: %d \n\n";
	final static String stEvento="Evento %s \n";
	final static String stato1= "in preparazione";
	final static String stato2= "in corso";
	final static String stato3= "terminato";
	final static String eventoPrintf="L'evento %s è ora %s.\n";
	final static String carattPrenotazione= "Caratteristiche desiderate";
	
	private String codice;
	private String nome;
	private String organizzatore;
	private String stato;
	private GregorianCalendar inizio;
	private GregorianCalendar fine;
	private int necessari;
	
	private Padiglione daOccupare;
	private Padiglione temporaneo;
	
	//********************************************************************************************************
	public Evento(String codice, String descrizione, String organizzatore, GregorianCalendar inizio, GregorianCalendar fine)
	{
		this.codice = codice;	
		this.nome = descrizione;
		this.organizzatore = organizzatore;
		this.inizio = inizio;
		this.fine = fine;
		daOccupare = new Padiglione() ;
		stato = stato1;
	}
	
	public Evento()
	{
		
	}
	
	public Vector <Padiglione>  prenota(int necessari)
	{
		String chiaveCorrente;
		this.necessari = necessari;
		
		Set<String> chiaviPads = Driver.getFiera().keySet();
		Iterator<String> iterator = chiaviPads.iterator();
		Vector <Padiglione> coppia = new Vector <Padiglione> ();

		System.out.println(carattPrenotazione);
		
		boolean indoor =MyMenu.yesOrNot(Padiglione.domandaIndoor);
		boolean corrente =MyMenu.yesOrNot(Padiglione.domandaCorrente);
		boolean acqua =MyMenu.yesOrNot(Padiglione.domandaAcqua);
		
		Stand richiesto = new Stand ( indoor, acqua, corrente);

		do {
			chiaveCorrente = iterator.next();
			temporaneo = Driver.getFiera().get(chiaveCorrente);
			int primoLibero = -1;
			int h =0;
			 
			do{
				if ( temporaneo.getContenuto().get(h).getPrenotato().equalsIgnoreCase(libero) ) 
					 primoLibero = h;
			 	h++;
			  }while ( h < temporaneo.getCapienza() && primoLibero == -1);
			temporaneo.setErrore(1); // suppongo la prenotazione fallisca.
			
			if ( primoLibero != -1)  //almeno un posto libero c'è.
				if ( temporaneo.getCapienza()-primoLibero >= necessari )  //ce ne sono abbastanza
					{ 			
						int a = primoLibero;
						int azzeccati=0; 
						
						do {
							if ( temporaneo.getContenuto().get(a).compareTo(richiesto) ) 
									azzeccati++; 
							a++;
					    } while ( a<temporaneo.getContenuto().size() && azzeccati != necessari );

						if (azzeccati==necessari) //ce ne sono abbastanza giusti
						 { 
							temporaneo.setErrore(0); 
							daOccupare = temporaneo;
							int k = primoLibero;
							do {	
								if ( temporaneo.getContenuto().get(k).compareTo(richiesto) )
								  {  // scrittura effettiva nella tabella padiglione
									daOccupare.getContenuto().get(k).setPrenotato(codice);
									azzeccati--;
								  }
								k++;
							   } while (k < daOccupare.getContenuto().size() && azzeccati>0);
							daOccupare.aggiornaOccupati(necessari); 
						 }
						else temporaneo.setErrore(2);  //no giusti
					}
		} while( iterator.hasNext() && temporaneo.getErrore()!=0);
		
		coppia.add(temporaneo); coppia.add(daOccupare);
		
		return coppia;
	}
	
	//********************************************************************************************************	
	public void evolviEvento()
	{
		if ( stato.equals(stato1) )
			stato = stato2;
		else
			stato = stato3;
		System.out.printf(eventoPrintf, codice, stato);
	}
	
	/*public int evolviSimula()  //codice sviluppato per versione con data reale
	{							 // algoritmo stupido, utilizzare after.() e before()
		GregorianCalendar adesso = new GregorianCalendar(); 
		boolean iniziato = false;							
		boolean finito = false;
		int ritorna;
		
		if ( adesso.compareTo(inizio) >= 1)
			iniziato = true;
		if ( adesso.compareTo(fine) >= 1)
			finito = true;
		
		if (iniziato && finito)
			ritorna= 2;  //terminato
		else
			if (iniziato)
				ritorna= 1;  //in corso
			else
				ritorna = 0;
		return ritorna;
	} */
	
	//********************************************************************************************************
	public void stampaEvento(boolean ridotta)
	{
		if (!ridotta)
		{ 
			System.out.println(cornice);
			System.out.printf(stCodice,codice);
			System.out.printf(stDescrizione,nome);
			System.out.printf(stOrganizzatore,organizzatore);
			System.out.printf(stEvento,stato);
			System.out.printf(stDataInizio,MyDate.getData(inizio) );
			System.out.printf(stDataFine,MyDate.getData(fine) );
			System.out.printf(stPadOccupato,daOccupare.getCodice() );
			System.out.printf(stStandOccupati,necessari);
			System.out.printf(stIncasso,getIncasso() );
		}
		else
		{
			String temp=" ";  //"   Codice   |   Descrizione  | Organizzatore | Inizio | Termine |    Stato    | Padiglione | Stands | Incasso";
			int scarto;
			
	   		scarto = Math.abs( Driver.Lcodice - codice.length() );
			temp = temp + codice;
			for (int k=0; k<scarto; k++)
				temp = temp + " "; 
			temp = temp + "  | ";
			
			scarto = Math.abs( Driver.Lnome - nome.length() );
			temp = temp + nome;
			for (int k=0; k<scarto; k++)
				temp = temp + " ";
			temp = temp + "  |  ";
			
			scarto = Math.abs( Driver.Lorganizzatore - organizzatore.length() );
			temp = temp + organizzatore;
			for (int k=0; k<scarto; k++)
				temp = temp + " ";
			temp = temp + "| ";
												
			scarto = Math.abs( 9 - MyDate.getDataCorta(inizio).length() );
			temp = temp + MyDate.getDataCorta(inizio);
			for (int k=0; k<scarto; k++)
				temp = temp + " ";
			temp = temp + "|  ";
			
			scarto = Math.abs( 9 - MyDate.getDataCorta(fine).length() );
			temp = temp + MyDate.getDataCorta(fine);
			for (int k=0; k<scarto; k++)
				temp = temp + " ";
			temp = temp + "| ";
		
			scarto = Math.abs( 16 - stato.length() );
			temp = temp + stato;
			for (int k=0; k<scarto; k++)
				temp = temp + " ";
			temp = temp + "|  ";
			
			scarto = Math.abs( 10 - daOccupare.getCodice().length() );
			temp = temp + daOccupare.getCodice();
			for (int k=0; k<scarto; k++)
				temp = temp + " ";
			temp = temp + "|   ";
			
			scarto = Math.abs( 5 - ( ( new Integer(necessari).toString().length() )  ));
			temp = temp + necessari;
			for (int k=0; k<scarto; k++)
				temp = temp + " ";
			temp = temp + "|  " + getIncasso();
			
			System.out.println(temp);
		}
	}
	
	public String getCodice()
	{
		return codice;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public int getIncasso()
	{
		int incasso=0;
		for (int f=0; f < daOccupare.getCapienza(); f++)
		{
			Stand corrente = daOccupare.getContenuto().get(f);
			if ( corrente.getPrenotato().equals(codice) )
				 incasso = incasso + corrente.getAffitto(); 
		}
		return incasso;
	}

	public String getStato()
	{
		return stato;
	}

	public Padiglione getPadDaOccupare()
	{
		return daOccupare;
	}
	
	public GregorianCalendar getInizio()
	{
		return inizio;
	}
	
	public GregorianCalendar getFine()
	{
		return fine;
	}
	
}
