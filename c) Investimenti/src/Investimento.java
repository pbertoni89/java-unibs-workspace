import utilities.MyDate;

public class Investimento {

	//attr
	double capitaleIniziale;
	double capitaleReale; //un briciolo di attenzione!
	int anno;
	int durata;
	private int i=0;
	final double tasso= 0.023;
	
	//costrct                                                   //COSTRUTTORE SEMPRE PUBLIC
	public Investimento(double _capitaleIniziale, int _anno)
	{
		capitaleIniziale = _capitaleIniziale;
		anno = _anno;
	}
	//meth
	public double accumulo()
	{		
		durata = anno - MyDate.getAnno();
		for ( i=0; i<durata; i++ );
	 	 {
		
	   	 }
		return capitaleReale;
	}
	
}