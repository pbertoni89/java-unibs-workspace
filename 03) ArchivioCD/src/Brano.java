
public class Brano {

	private String titolo;
	private int minuti;
	private int secondi;

	public Brano (String titolo, int minuti, int secondi)
	{
		this.titolo = titolo;
		this.minuti = minuti;
		this.secondi = secondi;
	}
	
	public void stampaBrano()
	{
		final String formatoBrano =" %s | %d minuti e %d secondi \n";
		System.out.printf(formatoBrano, titolo, minuti, secondi);
	}
}
