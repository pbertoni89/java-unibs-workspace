
/* Consegna dell'esercizio

Si richiede lo sviluppo di un programma che verifica la possibile affinit� tra due 
�cuori solitari� in base ad alcuni dati personali

Nella prima versione si suppone che i dati richiesti a ciascuno siano:
� uno pseudonimo
� il sesso
� l�et�

Il programma, dopo aver presentato un saluto iniziale, 
richiede i dati di due soggetti e presenta a video un messaggio del tipo: 
�XXX (non) � potenzialmente affine con YYY� 
dove XXX e YYY sono gli pseudonimi dei due soggetti

Nella versione 0.0 due soggetti sono affini se:
� sono di sesso diverso
� la differenza di et� � minore di una certa soglia 
(stabilita come costante a discrezione del programmatore)
 
 */

// !!!
import utilities.*;

public class MioCuoriSolitariMain {

	/**
	 * @param args
	 */

	
	final static String benvenuto="diffidate di sedicenti ciarlatani televisivi..";
	final static String benvenuto2="Agenzia CuoriSolitari vi aiuta a trovare l'anima gemella!";
	final static String benvenuto3="Il servizio si intende riservato ai soli maggiorenni.";
	final static String secondo="Ora inserisca i dati della persona desiderata.";
	
	final static String messaggioNick="Prego inserisca il suo pseudonimo:";
	final static String messaggioEta=", inserisca la sua et�:";
	final static String messaggioSesso=", inserisca il suo sesso: (digitare M o F)";
	
	final static String messaggioCompatibile=", Lei � compatibile con ";
	final static String messaggioNonCompatibile=", Lei purtroppo non � compatibile con ";
	
	static String temp_nick;
	static int temp_eta;
	
	/* getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
    Copies characters from this string into the destination character array. */
	static String stringa_sesso; //molto pi� semplice acquisire una stringa 
	static char temp_sesso;  //e poi castare
	
	//necessari per l'inserimento di valori plausibili
	static char maschio='M';
	static char femmina='F';
	final static int etaMinima=18;
	final static int etaMassima=99;
	
	public static void main(String[] args) 
	 {
		System.out.println(benvenuto);
		System.out.println(benvenuto2);
		System.out.println(benvenuto3);
		
		CuoreSolitario X=creaNuovoCuore();
		
		System.out.println(secondo);
		CuoreSolitario Y=creaNuovoCuore();

		if(X.feeling(Y))
			System.out.println(X.nick + messaggioCompatibile + Y.nick + ".");
		else
			System.out.println(X.nick + messaggioNonCompatibile + Y.nick + ".");	
		

	 }
    
	/*IMPORTANTE
	  metodo che invoca un costruttore per creare un'istanza.
	  questo ci consente di non dover dichiarare mille volte lo quasi-stesso metodo..*/
	private static CuoreSolitario creaNuovoCuore()
	{
		String controlloNick;
	//controllo nick
		do{
			temp_nick= MyIO.leggiStringa(messaggioNick);
			controlloNick= temp_nick.trim(); //restituisce temp_nick SE_SOLO_SE 
		 }                               //temp_nick inizia con uno spazio o � vuota
		while(!controlloNick.equals(temp_nick)); 
		
	//controllo et�
	    do
			temp_eta= MyIO.leggiIntero(temp_nick + messaggioEta);
		while(etaMinima>temp_eta||etaMassima<temp_eta);
		
	//controllo sesso	
		do{
			stringa_sesso= MyIO.leggiStringa(temp_nick + messaggioSesso);
			stringa_sesso.toUpperCase();
			temp_sesso=(char)stringa_sesso.charAt(0);
		 }
		while(temp_sesso!=maschio && temp_sesso!=femmina);
		
		return new CuoreSolitario(temp_nick,temp_eta,temp_sesso);
	}
	
	/* private static void controlla()
	{
		 inserendo qua i controlli su et�/sesso, il compilatore non riesca a risolvere X e Y.
	} */
}
	

