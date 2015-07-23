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
public class Tic extends Thread {

	public void run() {
		for (;;) {
			System.out.println("Tic cycled");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
