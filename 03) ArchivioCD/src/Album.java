import java.util.*;

import utilities.*;

public class Album {

	private String titolo;
	private String artista;
	Vector <Brano> listaBrani = new Vector <Brano> ();
	
	public Album( String _titolo, String _artista)
	{
		titolo = _titolo;
		artista = _artista;
	}
	
	public String getTitolo()
	{
		return titolo;
	}
	
	public String getArtista()
	{
		return artista;
	}
	
	public void aggiungiBrano()
	{
	 	String _titolo;
	 	int[] minutiSecondi = new int[2];
	 	int _minuti;
	 	int _secondi;
	 	
	 	_titolo = MyIO.leggiStringa(ArchivioMain.inserisciTitoloBrano);
	 	minutiSecondi = MyDate.getDurata(ArchivioMain.inserisciDurataBrano);
	 	_minuti = minutiSecondi[0];
	 	_secondi = minutiSecondi[1];
		
		Brano nuovoBrano = new Brano(_titolo, _minuti, _secondi);
		listaBrani.add (nuovoBrano);
	}
	 	
	public void stampaAlbum()
	{
		final String formatoAlbum = "album %s, di %s. Contiene i seguenti brani: \n";
		
		System.out.printf(formatoAlbum, titolo, artista);		
		
		for (int i = 0; i < listaBrani.size() ; i++)
		{
		 System.out.print(" " + (i+1) + "- ");
		 listaBrani.get(i).stampaBrano();
		}
	}
	
}