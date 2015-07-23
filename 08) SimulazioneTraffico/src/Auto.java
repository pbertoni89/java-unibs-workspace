import utilities.MyMath;


public class Auto extends Elemento {

	public static final String DISEGNO = "M";
	final static int velMax = 3;
	final static int velMin = 2;
	private int velAuto = MyMath.estraiIntero(velMin, velMax);
	
	public Auto() 
	{
		super();
		setVelocita(velAuto);
		setDisegno(DISEGNO);
		
	}
	
	public int getVelAuto()
	{
		return velAuto;
	}
	
}
