package tamazoo;
//import utilities.MyIO;

// Pillars of software 2010
// Gestione di uno zoo di tamagotchi
// Classi ereditate dal progetto Tamagotchi

public class TamaMain {

	final static String benvenuto = "TamaMondo 2.0, Pillars of Software 2010";
	final static String terminazioneProg="Programma terminato, arrivederci.";

	final static String spiegaTurno1 = " 'C' accarezza ";
	final static String spiegaTurno2 = ", 'N' lo nutre, 'Q' termina il gioco (";
	final static String spiegaTurno3 = " muore).";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lanciaCreazione();
		System.out.println(terminazioneProg);
	}

	
	public static void lanciaCreazione() {
		
		TamaZoo zooBertoni = new TamaZoo();
		zooBertoni.creaZoo();
	}
	
}


/*
	
	
	
	static//min
	
	static boolean casoFelice; // mortoFelice, vivoFelice
	static int casoSazio;  //perch√® gli stati qua son tre: mortoFame, vivoSazio, mortoSazio
	
	static boolean boolVivo = true;
	static boolean boolTermina = false;  //falso quando viene premuto Q
	
	//stati possibili
	final static String mortoFelice = " e' morto di tristezza! Non te ne fregava un cazzo di lui, complimenti...";
	final static String vivoFelice = " sembra molto allegro e idiota! Felicita'†: ";
	final static String mortoFame = " e' morto di fame... :(:(:(:(";
	final static String vivoSazio = " sembra in ottima forma.  Sazieta'†: ";
	final static String rutto = ". Buurp!";
	final static String mortoSazio = " e' morta, ha mangiato troppo :(";
	final static String mortoTermina = " e' morto perche' non te ne fregava un cazzo di lui."; //solo per terminazione da tastiera
	
	
	
						public static void main(String[] args) {
					
							System.out.println(benvenuto);
							do  {
								turno(tama1);
								} while (boolVivo && !boolTermina);		
						}
							
	
	//ciclo che restituisce una stringa formattata con lo stato del tama
	public static void turno(Tama tama) {
	
		//ingresso: compiere un'azione
		do {
			tasto = MyIO.leggiStringa(spiegaTurno1 + tama.nome + spiegaTurno2 + tama.nome + spiegaTurno3);
			tasto = tasto.toUpperCase();
			selezione = tasto.charAt(0);
			} while (selezione != carattereCarezza && selezione != carattereNutrimento && selezione != carattereTermina);
		
		
		switch(selezione) {
		
			case carattereCarezza:
				nCarezze = minimi + (int) ( Math.random()*massimi );
				tama.accarezza(nCarezze);
				System.out.println("Decidi di dare " + nCarezze + " carezze a " + tama.nome + ".");
				controllo(tama);
			break;
			
			case carattereNutrimento:
				nBiscotti = minimi + (int) ( Math.random()*massimi );
				tama.nutri(nBiscotti);
				System.out.println("Decidi di dare " + nBiscotti + " biscottini a " + tama.nome + ".");
				controllo(tama);
			break;
				
			case carattereTermina:	
				System.out.println(tama.nome + mortoTermina);
				boolTermina = true;
			break;
	    }
		
	}

*/