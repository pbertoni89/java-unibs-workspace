package polofieristico;
import java.io.Serializable;

public class Stand implements Serializable {

	private final static long serialVersionUID = 1;
	final static String libero = "LIBERO";
	final static String si = "si";
	final static String no = "no";
	
	private int codice, superficie, affitto;
	private boolean indoor, acqua, corrente;
	private String prenotato;
	
	public Stand (int codice, int superficie, int affitto, boolean indoor, boolean acqua, boolean corrente)
	{
		this.codice = codice;
		this.superficie = superficie;
		this.affitto = affitto;
		this.indoor = indoor;
		this.acqua = acqua;
		this.corrente = corrente;
		prenotato = libero; 
	}	
	
	public Stand (boolean indoor, boolean acqua, boolean corrente) //chiamato da Evento.setOccupati
	{
		this.indoor = indoor;
		this.acqua = acqua;
		this.corrente = corrente;
	}
	
	public boolean compareTo(Stand stand)  //overriding
	{
		boolean uguali = false;
		
		if (stand.getBoolAcqua() == this.acqua && 
				stand.getBoolIndoor() == this.indoor && 
					stand.getBoolCorrente() == this.corrente)
			uguali = true;
		
		return uguali;
	}
	
	public Integer getCodice()
	{
		Integer cod = new Integer(codice);
		return cod;	
	}
	
	public Integer getSuperficie()
	{
		Integer sup = new Integer(superficie);
		return sup;
	}

	public Integer getAffitto()
	{
		Integer aff = new Integer(affitto);
		return aff;
	}

	public String getIndoor()
	{
		if (indoor)
			return si;
		else
			return no;
	}
	
	public String getCorrente()
	{
		if (corrente)
			return si;
		else
			return no;
	}
	
	public String getAcqua()
	{
		if (acqua)
			return si;
		else
			return no;
	}

	public boolean getBoolIndoor()
	{
		if (indoor)
			return true;
		else
			return false;
	}
	
	public boolean getBoolCorrente()
	{
		if (corrente)
			return true;
		else
			return false;
	}
	
	public boolean getBoolAcqua()
	{
		if (acqua)
			return true;
		else
			return false;
	}
	
	public String getPrenotato()
	{
		return prenotato;
	}
	
	public void setPrenotato( String prenotato)
	{
		this.prenotato = prenotato;
	}
	
}