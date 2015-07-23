import java.io.Serializable;

public class Titolo implements Serializable {

	private final static long serialVersionUID = 1;
	
	private String nomeTitolo;
	
	private double valore;
	
	public Titolo( String _nome, double _valore )
	{
		nomeTitolo = _nome;
		valore = _valore;
	}
	
	public String getNomeTitolo()
	{
		return nomeTitolo;
	}
	
	public double getValore()
	{
		return valore;
	}
	
	public void setValore(double _valore)
	{
		valore = _valore;
	}
}
