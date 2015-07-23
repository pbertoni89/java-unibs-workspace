package responder;

import java.net.*;
import java.io.*;

/**
 * Responder. Una semplice application Java in grado di gestire connessioni
 * multiple. Per ogni conenssione, il programma risponde rimandando la stringa
 * ricevuta con un'aggiunta iniziale.
 * 
 * @author riccardo
 * 
 * @version 1.0
 * 
 */
public class Responder {
	/**
	 * La porta su cui ascolta
	 */
	public static final int JABBERSERVERPORT = 8079;

	/**
	 * Classico metodo main. Apre un ServerSocket e rimane in ascolto. Ogni
	 * volta che arriva una richiesta di connessione, crea un nuovo thread e
	 * torna ad ascoltare.
	 * 
	 * @note Le eccezoni non vengono gestite.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		System.out.println("Partito il metodo main");
		// mettiamoci in ascolto sulla porta JABBERSERVERPORT
		ServerSocket ServS = new ServerSocket(JABBERSERVERPORT);
		System.out.println("Started: " + ServS);
		try {
			for (;;) { // Ciclo infinito

				// Occhio, perche' da qui non si schioda
				// finche' non arriva una richiesta di connessione
				Socket CommSocket = ServS.accept();
				// Arrivata: creiamo un nuovo thread
				Connessione cc = new Connessione(CommSocket);
				// Lo facciamo partire
				cc.start();
				// e torniamo ad ascoltare le richieste

			}
		} finally {
			ServS.close();
		}
	}
}

/**
 * Gestisce la connessione, rispedendo indietro tutte le stringhe che arrivano
 */
class Connessione extends Thread {
	/**
	 * Il socket su cui avviene la connessione
	 */
	Socket sock;

	/**
	 * Costruttore.
	 * 
	 * @param Il
	 *            socket su cui avviene la connessione
	 */
	public Connessione(Socket s) {
		sock = s;
	}

	/**
	 * Metodo principale. Termina quando viene ricevuta la stringa "END"
	 */
	public void run() {
		try {
			System.out.println("Connessione accettata sul socket: " + sock);
			BufferedReader in = new BufferedReader(new InputStreamReader(sock
					.getInputStream()));
			// Output is automatically flushed
			// by PrintWriter:
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(sock.getOutputStream())), true);

			while (out != null) {
				String str = in.readLine();
				if (str.equals("END")) {
					break;
				}
				System.out.println("Sto ritrasmettendo: " + str);
				str = "Sono il responder. Tu mi hai detto: " + str;
				if (out != null) {
					out.println(str);
				}
			}
			out.println("Ho ricevuto la stringa END o si e' chiuso il socket - chiudo la connessione");
			
		} catch (IOException e) {
			System.out.println("Eccezione a" + e);
		} finally {

			System.out.println("Chiudo il socket...");
			try {
				sock.close();
			} catch (Exception e) {
				System.out.println("Eccezione b" + e);
			}
		}

	}

}
