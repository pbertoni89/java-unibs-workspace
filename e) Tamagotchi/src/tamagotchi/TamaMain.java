package tamagotchi;
import utilities.MyIO;

public class TamaMain {
	
	final static String benvenuto = "Tamagotchi 1.11, Pillars of Software 2010";
	final static String inserisciNome = "Come si chiama il tuo tamagotchi ?";
	final static String spiegaTurno1 = " 'C' accarezza ";
	final static String spiegaTurno2 = ", 'N' lo nutre, 'Q' termina il gioco (";
	final static String spiegaTurno3 = " muore).";
	
	static String nomePassato;
	
	static String tasto;
	static char selezione;
	
	final static char carattereCarezza = 'C';
	final static char carattereNutrimento = 'N';
	final static char carattereTermina = 'Q';
	
	static int nCarezze;
	static int nBiscotti;
	final static int massimi = 20;
	final static int minimi = 5; 
	
	static boolean casoFelice;
	static int casoSazio; 
	
	static boolean boolVivo = true;
	static boolean boolTermina = false;
	
	final static String mortoFelice = " e' morto di tristezza! Non te ne fregava un cazzo di lui, complimenti...";
	final static String vivoFelice = " sembra molto allegro e idiota! Felicita' : ";
	final static String mortoFame = " e' morto di fame... :(:(:(:(";
	final static String vivoSazio = " sembra in ottima forma.  Sazieta' : ";
	final static String rutto = ". Buurp!";
	final static String mortoSazio = " e' morta, ha mangiato troppo :(";
	final static String mortoTermina = " e' morto perche' non te ne fregava un cazzo di lui."; //solo per terminazione da tastiera
	
	
	
	public static void main(String[] args) {

		System.out.println(benvenuto);
		Tama tama1 = nuovoTama();

		do{   turno(tama1);  }while ( boolVivo && !boolTermina);		
	}
						
	public static Tama nuovoTama() {
		nomePassato = MyIO.leggiStringa(inserisciNome);
		return new Tama(nomePassato);
 	}
	
	public static void turno(Tama tama)
	{
		do {
			tasto = MyIO.leggiStringa(spiegaTurno1 + tama.getNome() + spiegaTurno2 + tama.getNome() + spiegaTurno3);
			tasto = tasto.toUpperCase();
			selezione = tasto.charAt(0);
			} while (selezione != carattereCarezza && selezione != carattereNutrimento && selezione != carattereTermina);
		
		switch(selezione) {
		
			case carattereCarezza:
				nCarezze = minimi + (int) ( Math.random()*massimi );
				tama.accarezza(nCarezze);
				System.out.println("Decidi di dare " + nCarezze + " carezze a " + tama.getNome() + ".");
				controllo(tama);
			break;
			
			case carattereNutrimento:
				nBiscotti = minimi + (int) ( Math.random()*massimi );
				tama.nutri(nBiscotti);
				System.out.println("Decidi di dare " + nBiscotti + " biscottini a " + tama.getNome() + ".");
				controllo(tama);
			break;
				
			case carattereTermina:	
				System.out.println(tama.getNome() + mortoTermina);
				boolTermina = true;
			break;
	    }
		
	}
	
	public static void controllo(Tama tama) 
	{

			if (tama.getFelice() > tama.minFelice)
				casoFelice = true;
			else
				casoFelice = false;
	
			if (tama.getSazio() <= tama.minSazio)
				casoSazio = 0;  //mortoFame
			else
				if (tama.getSazio() >= tama.maxSazio)
					casoSazio = 2; //mortoSazio  
				else
					casoSazio = 1; //vivoSazio
		if (casoFelice && casoSazio == 1) 
			boolVivo = true;								
		else										
			boolVivo = false;		
			
		if (boolVivo) {
				System.out.println(tama.getNome() + vivoFelice + tama.getFelice());
			    System.out.println(tama.getNome() + vivoSazio + tama.getSazio() + rutto);
				}
		else {
			if (!casoFelice)
				System.out.println(tama.getNome() + mortoFelice);
			else
				if (casoSazio == 0) 
					System.out.println(tama.getNome() + mortoFame);
				else
					System.out.println(tama.getNome() + mortoSazio);
		   }
		
		System.out.println();
		
	} 
} 

