package mostri;

public class Main {

	public static void main(String[] args) 
	{	
		firstWave();
	}
	
	//*****************************************************
	static void firstWave()
	{
		DragoZilla zergling = new DragoZilla();
		Vampire dracula = new Transilvan();
		Transilvan nosferatu = new Transilvan();
		
		inoffensive(zergling);
		reliable(zergling);
		// offensive(zergling);   NON PERMESSO
		
		inoffensive(dracula);
		reliable(dracula);
		offensive(dracula);
		
		inoffensive(nosferatu);
		reliable(nosferatu);
		offensive(nosferatu);
	}
	
	static void inoffensive(Monster low)
	{
		low.menace();
		
		System.out.println();
	}

	static void reliable (DangerousMonster med)
	{
		med.menace();
		med.destroy();
		
		System.out.println();
	}
	
	static void offensive (Vampire high)
	{
		high.menace();
		high.destroy();
		high.drinkBlood();
		high.kill();
		
		System.out.println();
	}
	//*****************************************************
}
