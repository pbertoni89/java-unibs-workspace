
public class FattorialeRecorsivoFunzione {

	//definizione del metodo
	public static int fatt(int n)
	 {
	    if(n>1)
	              return n*fatt(n-1); 
	    else
	              return 1;
	 }
	
}
