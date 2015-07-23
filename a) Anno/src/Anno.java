
public class Anno {

	public int n_anno;
	
	public final int  inizio_solare=-9;
	public final int periodo_solare=28;

	public Anno(int _n_anno)
	{
		n_anno=_n_anno;
	}
	
	public boolean bisestile()
	{
		return(((n_anno%4==0)&&(n_anno%100!=0))||(n_anno%400==0));
	}
	
	public int solare()
	{	
		return( 1+( (n_anno-inizio_solare) / periodo_solare ) );
	}
	
}
