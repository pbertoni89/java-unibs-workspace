package mostri;

public class DragoZilla implements DangerousMonster {

	final String minaccia = " Ora ti mangio...";
	final String distrutto = " Mangiato! ";
	
	public void menace()
	{
		System.out.println(minaccia);
	}
	
	public void destroy()
	{
		System.out.println(distrutto);
	}
}
