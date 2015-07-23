import java.io.Serializable;

public class Lotto implements Serializable {

	private final static long serialVersionUID = 1;
	
	private int dimensione;
	private Titolo[] lotto;
	
	final String formato1 = "   Lotto di ";
	final String formato2 = " azioni di \"";
	final String formato3 = "\".  Valore azionario: ";
	final String formato4 = " cadauna. ";
	
	public Lotto( Titolo _titolo, int _dimensione )
	{
		dimensione = _dimensione;
		Titolo[] lottoT = new Titolo [dimensione];
		for ( int i = 0; i < dimensione; i++ )
			lottoT[i] = _titolo;
		lotto = lottoT; 
	}
	
	public int getDimensione()
	{
		return dimensione;
	}
	
	public Titolo[] getTitoliLotto()
	{
		return lotto;
	}  
	
	public String toString()
	{
		String stampa = formato1 + dimensione + formato2 + lotto[0].getNomeTitolo() 
									+ formato3 + lotto[0].getValore() + formato4;
		return stampa;
	}
	
}
