import java.net.*;
import java.io.*;

/**
 * 
 * JabberClient.java -  * Very simple client that just sends
 * lines to the server and reads lines
 * that the server sends.
 * @author riccardo
 * @version 1.1
 * @see JabberServer
 *
 */
public class JabberClient {
		
	public static final int JabberServerPORT = 2000;
	
	public static void main(String[] args)
		
		throws IOException {
			System.out.println("Partito il metodo main di jabberclient");
			// Passing null to getByName() produces the
			// special "Local Loopback" IP address, for
			// testing on one machine w/o a network:
			InetAddress addr =  InetAddress.getByName("localhost");  //10.11.8.148"
			//InetAddress addr =  InetAddress.getByName("localhost");
			// Alternatively, you can use
			// the address or name:
			// InetAddress addr = InetAddress.getByName("127.0.0.1");
			// InetAddress addr =
			// InetAddress.getByName("localhost");
	
			System.out.println("addr = " + addr);
			Socket socket = new Socket(addr, JabberServerPORT);
	
			// Guard everything in a try-finally to make
			// sure that the socket is closed:
			try {
				System.out.println("socket = " + socket);
				BufferedReader in =
					new BufferedReader(
							new InputStreamReader(
									socket.getInputStream()));
				// Output is automatically flushed
				// by PrintWriter:
				PrintWriter out =
					new PrintWriter(
							new BufferedWriter(
									new OutputStreamWriter(
											socket.getOutputStream())),true);
				for(int i = 0; i < 10; i ++) {
					out.println("hello" + i);
					String str = in.readLine();
					System.out.println(str);
				}
				out.println("END");
			}
				catch (ConnectException e) { System.out.println("errore di connessione"); }
			finally {
				System.out.println("closing...");
				socket.close();
			}
		}
} // /:~