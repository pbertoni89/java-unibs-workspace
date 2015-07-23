package polofieristico;

import java.util.*;
import java.io.Serializable;
import utilities.*;

public class Padiglione implements Serializable {

	private final static long serialVersionUID = 1;
		
	private Vector <Stand> contenuto = new Vector <Stand> ();
	
	private String codice;
	private int capienza;
	private int occupati;
	private int incassoStorico;
	private int errore;
	
	final static String domandaIdentici = " Gli stand sono identici tra loro?  (s/n) ";
	final static String domandaCorrente =" C'è allacciamento elettrico?   (s/n)";
	final static String domandaAcqua =" C'è presenza di impianto idrico?   (s/n)";
	final static String domandaIndoor =" lo stand è all'interno (s) o all'esterno (n) ?";
	final static String domandaAffitto =" Ammontare dell'affitto giornaliero? (intero)";
	final static String domandaSuperficie =" Superficie dello stand?";
	final static String infoNStand =" Registrazione stand %d di %d.\n";
	final static String registraStand =" Registrazione degli stand del padiglione \"%s\". \n";
	final static String intestaTabella = " Padiglione \"%s\", %d stand totali, %d liberi e %d occupati.\n";
	final static String formatoTabella = "  Codice    | Indoor | Superficie | Corrente | Acqua | Affitto | Prenotato";
	final static String stampaIncassoStorico= " Il padiglione ha finora generato %d euro in prenotazioni. \n";
	
	public Padiglione ( String codice, int capienza )
	{
		this.codice = codice;
		this.capienza = capienza;
		occupati = 0;
		incassoStorico = 0;
	}
	
	public Padiglione (String codice) //necessario in removePadiglione
	{
		this.codice = codice;
		errore = 0;
		occupati = 0;
		incassoStorico = 0;
	}
	
	public Padiglione ()  //necessario in prenota evento
	{
		errore = 0;
		occupati = 0;
		incassoStorico = 0;
	}
	
	public void addStand ()
	{
		int superficie, affitto;
		boolean identici = false;
		boolean corrente, acqua, indoor;
		int codiceStand = 0;
		
		System.out.printf(registraStand, codice);
		identici = MyMenu.yesOrNot(domandaIdentici);
		
		if (identici)
		 {
			indoor =MyMenu.yesOrNot(domandaIndoor);
			corrente =MyMenu.yesOrNot(domandaCorrente);
			acqua =MyMenu.yesOrNot(domandaAcqua);
			superficie = MyIO.leggiInteroPos(domandaSuperficie);
			affitto = MyIO.leggiInteroPos(domandaAffitto);
			
			for (int i = contenuto.size(); i < capienza; i++)
			{
				codiceStand ++;
				Stand standNuovo = new Stand ( codiceStand, superficie, affitto, indoor, acqua, corrente);
				contenuto.add(standNuovo);
			}	
		 }
		else
		 {
			for (int i = contenuto.size(); i < capienza; i++)
			{	
				System.out.printf(infoNStand, i+1, capienza);
				indoor =MyMenu.yesOrNot(domandaIndoor);
				corrente =MyMenu.yesOrNot(domandaCorrente);
				acqua =MyMenu.yesOrNot(domandaAcqua);
				superficie = MyIO.leggiInteroPos(domandaSuperficie); 
				affitto = MyIO.leggiInteroPos(domandaAffitto); 
				
				codiceStand++;
				Stand standNuovo = new Stand (codiceStand, superficie, affitto, indoor, acqua, corrente);
				contenuto.add(standNuovo);
			}
		 }
	}
	
	public Vector <Stand> getContenuto()
	{
		return contenuto;
	}
	
	public int superficieTot()
	{
		int surface = 0;
		for (int i = 0; i < occupati; i++)
			surface = surface + contenuto.get(i).getSuperficie().intValue();		
		return surface;
	}
	
	public void stampaPadiglione(boolean ridotta)  
	{                                 
						
 		String temp;				
		int scarto;
		Stand tempStand;
		System.out.println();
		System.out.printf(intestaTabella, codice, capienza, capienza-occupati, occupati);
		
		if (!ridotta)
		 {
			System.out.println(formatoTabella);	
			for ( int i = 0; i < capienza; i++)
		   	 {
		   		tempStand = contenuto.get(i);
		   		temp=" ";
		   		
		   		scarto = Math.abs( Driver.Lcodice - tempStand.getCodice().toString().length() );
				temp = temp + tempStand.getCodice().toString();
				for (int k=0; k<scarto; k++)
					temp = temp + " ";
				
				temp = temp + "  |   " + tempStand.getIndoor() + "   |    ";
				
				scarto = Math.abs( 5 - tempStand.getSuperficie().toString().length() );
				temp = temp + tempStand.getSuperficie().toString(); 
				for (int k=0; k<scarto; k++)
					temp = temp + " ";
				
				temp = temp +"   |    " + tempStand.getCorrente() + "    |   ";
				temp = temp + tempStand.getAcqua() + "  |  ";
				
				scarto = 7 - tempStand.getAffitto().toString().length();
				temp = temp + tempStand.getAffitto().toString();
				for (int k=0; k<scarto; k++)
					temp = temp + " ";
				
				scarto = 5 - tempStand.getPrenotato().length();
				temp = temp + "| " + tempStand.getPrenotato();
				for (int k=0; k<scarto; k++)
					temp = temp + " ";
				
				System.out.println(temp);
			 }
		 } 
		System.out.printf ( stampaIncassoStorico, incassoStorico);
	}
	
	public int getCapienza()
	{
		return capienza;
	}

	public int getOccupati()
	{
		return occupati;
	}
	
	public void aggiornaOccupati(int addOccupati)
	{
		occupati = occupati + addOccupati;
	}
	
	public void aggiornaIncassoStorico (int addIncasso)
	{
		incassoStorico = incassoStorico + addIncasso;
	}

	public int getIncassoStorico()
	{
		return incassoStorico;
	}
	
	public String getCodice()
	{
		return codice;
	}

	public void setErrore(int tipo)
	{
		errore=tipo;
	}
	
	public int getErrore()
	{
		return errore;
	}
}
