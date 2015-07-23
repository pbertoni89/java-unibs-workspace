
public class CuoreSolitario {

	//attributi
	public String nick;
	public int eta;
	public char sesso;
	
	//necessari al controllo affinità
	final static int differenza = 5;
	final static char maschio='M';
	final static char femmina='F';
	
	//costruttore
	public CuoreSolitario(String _nick,int _eta,char _sesso)
	{
		nick=_nick;
		eta= _eta;
		sesso= _sesso;
	}
	
	//metodo dell affinità
	public boolean feeling(CuoreSolitario partner)
	{
		boolean etaCompatibili=false;
		boolean eterosessuali=false;
		
		if(Math.abs(eta-partner.eta)<differenza)
			etaCompatibili=true;
		if( (sesso==maschio&&partner.sesso==femmina) || (sesso==femmina&&partner.sesso==maschio) )
			eterosessuali=true;
		if(etaCompatibili&&eterosessuali)
			return true;
		else
			return false;
	}
	
}
