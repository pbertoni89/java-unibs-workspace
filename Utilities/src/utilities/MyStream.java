package utilities;
import java.io.*;

public class MyStream {
	
	final static String fileEsiste = "Il file esiste ed è di dimensione %d bytes. \n";
	final static String fileNonEsiste = "Il file non esiste. \n";
	final static String eccIO = " WARNING : errore input/output!";
	final static String eccFileNonTrovato = " WARNING : file non trovato!";
	final static String eccClasseNonTrovata = " WARNING : errato casting tra classi!";
	final static String loadingSuccess = " Caricamento avvenuto con successo. Bentornati.";
	/*************************************************************************************
	public static void esistenza ( File f )
	 {
		if ( f.exists() )
			System.out.printf(fileEsiste, f.length() );
		else
			System.out.printf(fileNonEsiste);
	 } 
	//*************************************************************************************/
	public static void scriviOggetto( Object _oggetto, String _path )
	{
		ObjectOutputStream sorgente=null;

		try 
		 { 
			sorgente = new ObjectOutputStream(
										new BufferedOutputStream(
												new FileOutputStream(_path) ) );
			sorgente.writeObject( _oggetto);
		 }
		
		catch (FileNotFoundException exc) {System.out.println(eccFileNonTrovato);}
		catch (IOException exc2) {System.out.println(eccIO);}
		
		finally 
		 {
			if (sorgente != null)
				try {sorgente.close();} 
				catch (IOException e) {e.printStackTrace();}
		 }
	}
	
	//*************************************************************************************
	public static Object leggiOggetto( String _path )
	{
		ObjectInputStream sorgente = null;
		Object caricato = null;

		try 
		 {
			sorgente = new ObjectInputStream(
										new BufferedInputStream(
												new FileInputStream(_path) ) );
			caricato = sorgente.readObject();
		 }
		
		catch (FileNotFoundException exc1) {System.out.println(eccFileNonTrovato);}
		catch (ClassNotFoundException exc2) {System.out.println(eccClasseNonTrovata);}
		catch (IOException exc3) {System.out.println(eccIO);}
		
		finally 
		 {
			if (sorgente != null)
				try { 
					sorgente.close();
					//System.out.println(loadingSuccess);
					} 
				catch (IOException e) { e.printStackTrace(); }
		 }
		
		return caricato;
	}
	
}