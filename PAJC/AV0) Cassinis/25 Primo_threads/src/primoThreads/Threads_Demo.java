package primoThreads;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author Riccardo Cassinis
 * @version 1.0
 */
public class Threads_Demo {

	/**
	 * Application entry point.
	 * 
	 * @param args
	 *            String[]
	 */
	public static void main(String[] args) {
		System.out.println("Hello");

		Tic tic = new Tic();
		tic.start();
		Tac tac = new Tac();
		tac.start();
	}
}
