

//necessario per la classe Scanner
import java.util.*;

//si accetta in input una stringa che verr� convertita in Integer.
//il tasto Q causa la terminazione del programma.


public class FattorialeRecorsivoMain {

	//gli attributi, cio� qua le variabili, vanno fuori dal main.
	public static String ingresso;
	public static int numero;
	public static int temp;
	public static long fattoriale=0;
	public static int continua=1;
	
	//non mettere static alle stringhe mi crea problemi nel System.out
	 //evidentemente perch� essendo nel main non sono in una classe istanziabile
	public static String CHIEDI_NUMERO="Inserire un numero intero: ";
	public static String STAMPA_FATT="Fattoriale: ";
	
	public static String ESCI="Il tasto Q genera sequenza di escape";
	public static String ESCI_KEY="Q";
	public static String TERM="Terminazione";
	
	public static void main(String[] args){
		
		Scanner leggi = new Scanner(System.in);
		
		System.out.println(ESCI);
		do{
			System.out.print(CHIEDI_NUMERO);
			ingresso=leggi.nextLine();
			
			//? condizione vera per ogni carattere non solo Q
			
			if(ingresso.equals(ESCI_KEY))
			{
				continua=0;
				System.out.println(TERM);
			}
			else
			{		//conversione in intero
					numero=Integer.parseInt(ingresso);

					System.out.println(STAMPA_FATT + FattorialeRecorsivoFunzione.fatt(numero));
					System.out.println();
			}
			
		}while(continua==1);
	}
	
}
