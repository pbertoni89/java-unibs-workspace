package server;

import java.io.*;
import java.net.Socket;

/**
*  Classe che gestisce la connessione.
*  Restituisce tutte le stringhe che arrivano
* 
* @author Patrizio Bertoni
* 
* @version 0.1
* 
*/
class Connessione extends Thread {
	
	/**
	 * Il socket su cui avviene la connessione
	 */
	Socket porta;

	/**
	 * Costruttore.
	 * 
	 * @param la porta sulla quale si instaura la connessione
	 *         
	 */
	public Connessione(Socket s) {
		porta = s;
	}

	/**
	 * Metodo principale. Termina quando viene ricevuta la stringa "END"
	 */
	public void run() {
		
		try {
			
			System.out.println("Connessione accettata sul socket: " + porta);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(porta.getInputStream() ) );

			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(porta.getOutputStream())), true);

			while (out != null) {
				
				String str = in.readLine();
				
				if (str.equals("END"))
					break;
					
				System.out.println("Sto ritrasmettendo: " + str);
				str = "Sono il responder. Tu mi hai detto: " + str;
				
				if (out != null) 
					out.println(str);
			}
			
			out.println("Ho ricevuto la stringa END o si e' chiusa la porta. Termino la connessione");
		
		} catch (IOException e) {System.out.println("Eccezione di tipo A: " + e);}
		
		finally {

			System.out.println("Chiudo il socket...");
			
			try {
				porta.close();
			} catch (Exception e) {System.out.println("Eccezione di tipo B: " + e);}
		 }

	}

}
