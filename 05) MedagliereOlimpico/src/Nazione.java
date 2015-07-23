
public class Nazione {

	private String nomeNazione;
	
	private int[] medagliere = new int[3];
	
	public Nazione (String _nomeNazione)
	{
		nomeNazione = _nomeNazione;
		medagliere[0] = 0; // ORI
		medagliere[1] = 0; // ARGENTI
		medagliere[2] = 0; // BRONZI
	}
	
	public void aggiungiMedaglia (int tipoMedaglia)
	{
		medagliere[tipoMedaglia] = medagliere[tipoMedaglia] +1;
	}
	
	public String getNomeNazione()
	{
		return nomeNazione;
	}
	
	public int[] getMedagliere()
	{
		return medagliere;
	}
	
	public int getMedaglia(int posto)
	{
		return medagliere[posto];
	}
	
}
