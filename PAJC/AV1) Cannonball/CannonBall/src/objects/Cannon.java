package objects;

public class Cannon extends ObjectImage {
	
	//final static String iconPath = "objects/cannon.png";  //LINUX
	final static String iconPath = "cannon.png";  //WINDOWS doppia \\ per escape avoid
	
	public Cannon( int x, int y) {
		
		super(x,y,iconPath);  
	}
	
}
