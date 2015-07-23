package server;

import java.net.*;
import java.io.*;

//  SERVER DI CASSINIS

/**
 *  Application Java in grado di gestire connessioni multiple.
 * Per ciascuna, il programma risponde restituendo la stringa
 * ricevuta con un'aggiunta iniziale.
 * 
 * @author Patrizio Bertoni
 * 
 * @version 0.1
 * 
 */
public class Responder {
	/**
	 * Porta del modello TCP/IP sulla quale il server ascolta
	 */
	public static final int SERVERPORT = 2000;

	/**
	 * Main: apre un ServerSocket e rimane in ascolto. Ogni
	 * volta che arriva una richiesta di connessione, crea un nuovo thread e
	 * torna ad ascoltare.
	 * 
	 * @note non vengono trattate qui le eccezioni ma lanciate altrove.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		System.out.println("Apro la porta "+ SERVERPORT);
		ServerSocket portaServer = new ServerSocket(SERVERPORT);
		System.out.println("Started: " + portaServer);
		
		try {
			
			for (;;) {  

				Socket portaComm = portaServer.accept();
				
				// Arrivata una richiesta. creo  nuovo thread
				Connessione conn = new Connessione(portaComm);
			
				conn.start();
				// torno in ascolto.

			}
			
		  } finally {portaServer.close();}
	  }
 }
