import java.util.*;
import utilities.*;

public class ArchivioMain {

	static Vector <Album> listaAlbum = new Vector <Album> ();
	static boolean iniziato = false;
	
	final static String intestazione ="Pillars of Software 2010 - Gestione Archivio CD";
	final static String terminazioneProg="Programma terminato, arrivederci.";
	
	final static int dimSceltaPrincipale = 5;
	final static String opzione1 = " Inserimento nuovo CD";
	final static String opzione2 = " Visualizzazione CD";
	final static String opzione3 = " Cancellamento CD";
	final static String opzione4 = " Ascolto di brano casuale";
	static String[] sceltaPrincipale = new String[dimSceltaPrincipale];
	static int decisione;

	final static String noIniziato = "Nessun album musicale è inserito in memoria.";
	final static String inserisciTitolo = "inserisci titolo dell'album:";
	final static String inserisciArtista = "inserisci artista:";
	final static String avvisoDoppione = "attenzione, album già presente.";
	static String _titolo;
	static String _artista;
	final static String inserisciTitoloBrano = "inserisci titolo del brano";
	final static String inserisciDurataBrano = "inserisci la sua durata (formato mm:ss)";
	final static String avvisoInserireBrano = "si desidera aggiungere un brano ?";
	static String inserireBranoSi = "(S) - prosegui";  
    static String inserireBranoNo = "(N) - ritorna al menu principale";
	final static String avvisoSceltaRicerca = "selezionare una modalità di ricerca";
    final static String titoloNonTrovato = "L'album cercato non esiste nell'archivio. ";
    final static String artistaNonTrovato = "Non esistono album di %s in archivio. ";
    final static String cancellaOK = "L'album è stato rimosso dall'archivio con successo.";
    final static String stampaAscolto = "In riproduzione da %s di %s | ";
    
	final static int dimSceltaRicerca = 3;
	static String[] sceltaRicerca = new String[dimSceltaRicerca];
	static String opzioneR1 = " - per titolo";  
    static String opzioneR2 = " - per artista";
    static int decisioneR;

//********************************************************	
		public static void main(String[] args) 
		{	
			lanciaMenuPrincipale();
			System.out.println(terminazioneProg);	
		}
//********************************************************
	public static void lanciaMenuPrincipale()
	{
		sceltaPrincipale[1] = opzione1;
		sceltaPrincipale[2] = opzione2;
		sceltaPrincipale[3] = opzione3;
		sceltaPrincipale[4] = opzione4;
		MyMenu menuPrincipale = new MyMenu(intestazione, sceltaPrincipale, dimSceltaPrincipale);
		decisione = menuPrincipale.scegli();
		
		switch ( decisione )
		{
		case 0:
			break;
			
		case 1:			
			creaControllaAlbum();
			lanciaMenuPrincipale();
			break;
	
		case 2:
			cercaAlbum(1);
			lanciaMenuPrincipale();
			break; 
			
		case 3: 
			cercaAlbum(2);
			lanciaMenuPrincipale();
			break;
		
		case 4: 
			ascoltaCasuale();
			lanciaMenuPrincipale();
			break;
		}
	}
	
//********************************************************
	public static Album nuovoAlbum() 
	{
		_titolo = MyIO.leggiStringa(inserisciTitolo);
		_artista = MyIO.leggiStringa(inserisciArtista);
		return new Album( _titolo, _artista );
 	}
	
//********************************************************
	public static void creaControllaAlbum()
	{
		boolean doppione = false;
		iniziato = true;
		String titoloIngresso;
		String titoloCorrente = null;
		
		do {
			Album inIngresso = nuovoAlbum();
			titoloIngresso = inIngresso.getTitolo();
			for ( int i =0; i < listaAlbum.size() ; i++)
				titoloCorrente = listaAlbum.get(i).getTitolo();
			  if ( titoloIngresso.equalsIgnoreCase( titoloCorrente ) )
			  		{
				  	 doppione = true;
					 System.out.println(avvisoDoppione);
					}
			  else
				  doppione = false;
				
	    	if (!doppione)
				listaAlbum.add( inIngresso );
		
		}while (doppione);
			
		do { 									
			listaAlbum.get(listaAlbum.size() -1).aggiungiBrano();
		} while ( MyMenu.sceltaDue(avvisoInserireBrano, inserireBranoSi, inserireBranoNo) );
	}
	
//********************************************************
	public static void cercaAlbum(int scopo)
	{
		if (iniziato)
		{
			sceltaRicerca[1] = opzioneR1;
			sceltaRicerca[2] = opzioneR2;
			MyMenu menuRicerca = new MyMenu(avvisoSceltaRicerca, sceltaRicerca, dimSceltaRicerca);
			decisioneR = menuRicerca.scegli();
			
			switch( decisioneR )
			 {
				case 0: 
					lanciaMenuPrincipale();
					break;
				
				case 1:
					operaTitolo(scopo);
					lanciaMenuPrincipale();
					break;
				
				case 2:
					operaArtista(scopo);
					lanciaMenuPrincipale();
					break;
			 }	
		}
		else
			System.out.println(noIniziato);
	}

//********************************************************
	 public static void operaTitolo(int scopo)
	 {	
		int j = 0;
		boolean titoloTrovato = false;
		String titoloCerca = MyIO.leggiStringa(inserisciTitolo);
		String tempTitolo;
		
		do
		{	
			tempTitolo = listaAlbum.get(j).getTitolo();
			if ( titoloCerca.equalsIgnoreCase(tempTitolo) )  
				{ 
				  titoloTrovato = true;
				  listaAlbum.get(j).stampaAlbum();
				  if (scopo == 2)
				   {
					  listaAlbum.remove(j);
					  System.out.println(cancellaOK);
					  if ( listaAlbum.size() == 0)
						  iniziato = false;
				   }
				}
			j++;
		} while( ( j < listaAlbum.size() || !titoloTrovato ) && iniziato );
		
		if (!titoloTrovato)
			System.out.println(titoloNonTrovato);
	 }
 
//********************************************************
	 public static void operaArtista(int scopo)
	 {
		 int k = 0;
		 boolean artistaTrovato = false;

		 String artistaCerca = MyIO.leggiStringa(inserisciArtista);
		 Album stampaArtista;
		 System.out.println();
		 
			do {
				if( artistaCerca.equalsIgnoreCase( listaAlbum.get(k).getArtista() ) )  
					{ artistaTrovato = true;
					  stampaArtista = listaAlbum.get(k);
					  stampaArtista.stampaAlbum();
					  
					  System.out.println();
					  if ( scopo == 2 )
					   {   
						  listaAlbum.remove(k);
						  k--;
						  System.out.println(cancellaOK);
						  if ( listaAlbum.size() == 0)
							  iniziato = false; 	  
		         	   }
					}
				k++;
		        } while ( k < listaAlbum.size() && iniziato );
				
			if ( !artistaTrovato )
				System.out.printf(artistaNonTrovato, artistaCerca);
	 }
	 
//********************************************************
	 public static void ascoltaCasuale()
	 {
		    int randomAlbum;
		    int randomBrano;
		    Album albumScelto;
		    int nBraniPossibili;
		    int nAlbumPossibili;
		    Brano riprodurreBrano;
		    
		    if (iniziato)
     		    {
		    	  nAlbumPossibili = listaAlbum.size()-1;
		    	  randomAlbum = MyMath.estraiIntero(0, nAlbumPossibili );
		    	  albumScelto = listaAlbum.get(randomAlbum);
		    	  
		    	  nBraniPossibili = albumScelto.listaBrani.size()-1 ;
		    	  randomBrano = MyMath.estraiIntero(0, nBraniPossibili) ;
		    	  riprodurreBrano = albumScelto.listaBrani.get(randomBrano);
		    	  
		    	  System.out.printf(stampaAscolto, albumScelto.getTitolo(), albumScelto.getArtista() ); 
		    	  riprodurreBrano.stampaBrano();
	    	    }
		    else
		    	System.out.println(noIniziato);
	 }
//********************************************************
}