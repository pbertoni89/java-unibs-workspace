
public class Gara {

	private String nomeGara;
	private String[] podio = new String[3];
	
	public Gara (String _nomeGara)
	{
		nomeGara = _nomeGara;
	}
	
	public String getNomeGara()
	{
		return nomeGara;
	}
	
	public void setPodio( Nazione nazioneVittoriosa, int posizione)
	{
		podio [posizione] = nazioneVittoriosa.getNomeNazione(); 
	}

}
