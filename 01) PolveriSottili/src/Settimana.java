public class Settimana {

	final int giorniTotali = 7;

	public int anno;  
	public int nSettimana;
	private int[] valoreGiorno = new int[giorniTotali];

	public Settimana(int _anno, int _nSettimana, int[] _valoreGiorno) {

		anno = _anno;
		nSettimana = _nSettimana;
		for (int i = 0; i < giorniTotali; i++)
			valoreGiorno[i] = _valoreGiorno[i];
	}
	
	// i valori MASSIMI e MEDI , PER ORAA, vengono calcolati sulla base settimanale.
	// in seguito verrà aggiunto un array "History" nel main, per tenere una cronologia 
	// e magari delle statistiche.
	
	private int[] reportMassimo = new int[2];
	//alla posizione 0 ho il giorno della settimana dove si è verificato
	//alla 1 ho il massimo di tale giorno
	
	public int[] massimo() {  //restituisce il massimo della settimana e in quale giorno è avvenuto
		
		reportMassimo[1] = valoreGiorno[0];
		
		for (int i = 0; i < giorniTotali; i++)
			if (valoreGiorno[i] > reportMassimo[1]) {
				reportMassimo[0] = i;
				reportMassimo[1] = valoreGiorno[i];
	
				}
		return reportMassimo;
	}
	
	public int medio() {
		
		int somma = 0;
		int media;
		for (int i = 0; i < giorniTotali; i++)
			somma += valoreGiorno[i];
		media = (int) ( somma / giorniTotali );
		return media;
	}
}