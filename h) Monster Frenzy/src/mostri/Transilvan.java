package mostri;

public class Transilvan implements Vampire {
	
	final String morso = " ora ti mordo...";
	final String vampirizzato = " vampirizzato! ";
	final String ucciso = " dissanguato! ";
	final String bevi = " glu...glu.....glu..";
	
	public void menace()
	{
		System.out.println(morso);
	}
	
	public void destroy()
	{
		System.out.println(vampirizzato);
	}
	
	public void kill()
	{
		System.out.println(ucciso);
	}
	
	public void drinkBlood()
	{
		System.out.println(bevi);
	}

}
