package client;
import java.net.*;
import java.io.*;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Client che spedisce stringhe al server
 * e legge ciò che il server gli restituisce.
 * 
 * @author patrizio
 * @version 0.1
 */

public class JabberClientApplet extends Applet implements ActionListener {   //parte client

	private static final long serialVersionUID = 5;
	public static final int JabberServerPORT = 2000;  //8078
	BufferedReader in = null;
	PrintWriter out = null;
	TextField t1;
	Socket socket = null;

	public void init() {

		setSize(500, 300);
		Label lab1 = new Label("Testo da inviare:");
		t1 = new TextField(40);
		Button b1 = new Button("Invia testo");
		Label lab2 = new Label("Testo ricevuto:");
		TextArea lab3 = new TextArea(10, 50);
		lab3.setText("Nessuna risposta ricevuta");

		add(lab1);
		add(t1);
		add(b1);
		add(lab2);
		add(lab3);

		try {
			System.out.println("Partito il metodo main di jabberclient");
			InetAddress addr = InetAddress.getByName("localhost");  //dcdt.ing.unibs.it

			System.out.println("addr = " + addr);
			socket = new Socket(addr, JabberServerPORT);

			System.out.println("socket = " + socket);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			// Output is automatically flushed
			// by PrintWriter:
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream())), true);

		} catch (Exception e) {
		}

		Ricevitore ric = new Ricevitore(socket, in, lab3);
		ric.start();
		b1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String str = t1.getText();
		if (!socket.isClosed()) {
			System.out.println(str);
			out.println(str);
		} else {
			t1.setText("Guarda che il socket e' chiuso!");
		}
		if (str.equals("END")) {
			try {
				t1.setText("Chiudo il socket");
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

//-- RICEVITORE: inserisce nella textfield quanto riceve dal server.

class Ricevitore extends Thread {
	BufferedReader in;
	TextArea txt;
	Socket so;

	public Ricevitore(Socket so, BufferedReader in, TextArea txt) {
		this.so = so;
		this.in = in;
		this.txt = txt;
	}

	public void run() {
		
		while (!so.isClosed()) {
			
			String str = "";

			if (in != null)
				try {
					str = in.readLine();
				} catch (SocketException e) {
					System.out.println("Socket Exception");
				} catch (IOException e) {
					System.out.println("IO Exception");
				}
			this.txt.setText(str);
		}
	}
}
