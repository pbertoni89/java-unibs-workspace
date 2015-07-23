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
public class Tac extends Thread {

	public void run() {
		for (;;) {
			System.out.println("                   Tac cycled");
			try {
				sleep(750);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
