//
import java.io.*; import java.util.*;

import utilities.MyIO;
import utilities.MyMenu;

public class Anima implements Serializable {

	final static long serialVersionUID = 1;
	final static String cornice = "------------------------------------------------";
	final static String caratterizza1 = " Sono ora presentate tre aree di interesse, più una caratteriale.";
	final static String caratterizza2 = " Siete pregati di inserire almeno una voce per almeno due aree, e di descrivervi con un aggettivo.";
	final static String presentaSports = " Area Sports"; 
	final static String addSportQ= "si desidera aggiungere una disciplina sportiva? (s/n)";
	final static String addSport= "digitare la disciplina:";
	final static String presentaFilms = " Area Cinema:";
	final static String addFilmQ = "si desidera aggiungere un genere cinematografico? (s/n)";
	final static String addFilm= "digitare il genere:";
	final static String presentaHobbies = " Area Hobby:";
	final static String addHobbyQ = "si desidera aggiungere un hobby preferito? (s/n)";
	final static String addHobby= "digitare l'hobby:";
	final static String presentaCarattere = " Area Caratteriale:";
	final static String addCarattereQ = "si desidera descriversi con un aggettivo? (s/n)";
	final static String addCarattere= "digitare il termine:";
	final static String addPrimoCarattere = "è necessario almeno un termine.";
	final static String caratterizzaFailure= " Dati inseriti insufficienti. "; // /n/n
	final static String caratterizzaSuccess =" %s %s, i tuoi dati sono stati inseriti con successo. I nostri auguri..  ;) \n";
	final static String giaInserito= " Campo già inserito.";
	final static int interessiMinimi = 2;
	final static String formato= " %s %s, %s %d anni \n";
	final static String uomo=" uomo di ";
	final static String donna=" donna di ";
	final static String interessiSport= "Interessi sportivi:";
	final static String interessiFilm= "Interessi cinematografici:";
	final static String interessiHobby= "Interessi hobbystici:";
	final static String aggettiviCarattere= "Carattere:";
	
	private String nome, cognome;
	private char sesso;
	private int eta;
	
	private boolean esiste; private int inseriti;

	private Vector <String> sports = new Vector <String> ();
	private Vector <String> films = new Vector <String> ();
	private Vector <String> hobbies = new Vector <String> ();
	private Vector <String> carattere = new Vector <String> ();
	
	public Anima ( String nome, String cognome, char sesso, int eta)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.eta = eta;
		esiste = true;
		inseriti =0;
	}
	
	public Anima()
	{
		esiste = false;
	}
	
	public void caratterizza()
	{
		
		System.out.println(caratterizza1);
		
		if (carattere.size()==0) 
			System.out.println(caratterizza2);
		
		System.out.println();
		
		do{
			addSports();
			addFilms();
			addHobbies();
			
			if (inseriti < interessiMinimi)
				{
					System.out.println(caratterizzaFailure);
					System.out.println();
				}
		  } while (inseriti < interessiMinimi && carattere.size()==0 );  //cioè al primo inserimento
		
		 addCarattere();
		
		System.out.printf(caratterizzaSuccess, nome, cognome);
	} 
	
	public void stampa()
	{
		if ( sesso=='M')
			System.out.printf (formato, nome, cognome, uomo, eta );
		else
			System.out.printf (formato, nome, cognome, donna, eta );
		
		System.out.println();
		
		if (sports.size()>0)
		{
			System.out.println(interessiSport);
			System.out.print(" ");
			for ( int j=0; j< sports.size(); j++)
			 {
				if (sports.size()-j==1)
					System.out.printf(sports.get(j) );
				else
					System.out.printf(sports.get(j) + ", "  );
			 }
			System.out.printf("\n\n");
		}
		
		if (films.size()>0)
		{
			System.out.println(interessiFilm);
			System.out.print(" ");
			for ( int j=0; j< films.size(); j++)
			 {
				if (films.size()-j==1)
					System.out.printf(films.get(j) );
				else
					System.out.printf(films.get(j) + ", "  );
			 }
			System.out.printf("\n\n");
		}
		
		if (hobbies.size()>0)
		{
			System.out.println(interessiHobby);
			System.out.print(" ");
			for ( int j=0; j< hobbies.size(); j++)
			 {
				if (hobbies.size()-j==1)
					System.out.printf(hobbies.get(j) );
				else
					System.out.printf(hobbies.get(j) + ", "  );
			 }
			System.out.printf("\n\n");
		}
		
		System.out.println(aggettiviCarattere);
		System.out.print(" ");
		for ( int j=0; j< carattere.size(); j++)
		 {
			if (carattere.size()-j==1)
				System.out.printf(carattere.get(j) );
			else
				System.out.printf(carattere.get(j) + ", "  );
		 }
		System.out.printf("\n");
		
		System.out.println(cornice);
	}
	
	//***********************************************************************************
	public String getNome()
	{
		return nome;
	}
	
	public String getCognome()
	{
		return cognome;
	}
	
	public int getEta()
	{
		return eta;
	}
	
	public char getSesso()
	{
		return sesso;
	}
	
	//***********************************************************************************
	public Vector <String> getSports()
	{
		return sports;
	}
	
	public Vector <String> getFilms()
	{
		return films;
	}

	public Vector <String> getHobbies()
	{
		return hobbies;
	}
	
	public Vector <String> getCarattere()
	{
		return carattere;
	}

	public boolean getEsiste()
	{
		return esiste;
	}
	
	public void setEsiste( boolean esiste)
	{
		this.esiste = esiste;
	}
	
	//***********************************************************************************
	private void addSports()
	{
		boolean esistente;
		String temp;
		System.out.println(presentaSports);
		while ( MyMenu.yesOrNot(addSportQ) )
		  {
			do {
				esistente = false;
				temp = MyIO.leggiStringaNonVuota(addSport);
		
				for (int k=0; k<sports.size(); k++)
					if ( temp.equalsIgnoreCase(sports.get(k)) )
							esistente=true;
				if (esistente)
					System.out.println(giaInserito);
				
			  } while (esistente);
			
				if ( sports.size()==0 )
					inseriti++;
				sports.add(temp);	
	      }
	}
	
	//***********************************************************************************
	private void addFilms()
	{
		boolean esistente;
		String temp;
		System.out.println(presentaFilms);
		while ( MyMenu.yesOrNot(addFilmQ) )
		  {
			do {
				esistente = false;
				temp = MyIO.leggiStringaNonVuota(addFilm);
				
				for (int k=0; k<films.size(); k++)
					if ( temp.equalsIgnoreCase(films.get(k)) )
							esistente=true;
				if (esistente)
					System.out.println(giaInserito);
				
			  } while (esistente);
			
				if ( films.size()==0 )
					inseriti++;
				films.add(temp);	
	      }
	}
	
	//***********************************************************************************
	private void addHobbies()
	 {
		boolean esistente;
		String temp;
		System.out.println(presentaHobbies);
		while ( MyMenu.yesOrNot(addHobbyQ) )
		  {
			do {
				esistente = false;
				temp = MyIO.leggiStringaNonVuota(addHobby);
				
				for (int k=0; k<hobbies.size(); k++)
					if ( temp.equalsIgnoreCase(hobbies.get(k)) )
							esistente=true;
				if (esistente)
					System.out.println(giaInserito);
				
			  } while (esistente);
			
				if ( hobbies.size()==0 )
					inseriti++;
				hobbies.add(temp);	
	      }
	}
	
	//***********************************************************************************
	private void addCarattere()
	{
		boolean esistente;
		String temp;
		
		do {		
			System.out.println(presentaCarattere);	
		
			while ( MyMenu.yesOrNot(addCarattereQ) )
			  { 
				 do{ 
					esistente=false;
					temp = MyIO.leggiStringaNonVuota(addCarattere);
					for (int k=0; k<carattere.size(); k++)
						if ( temp.equalsIgnoreCase(carattere.get(k)) )
								esistente=true;
					if (esistente)
						System.out.println(giaInserito);
					
				  } while (esistente);
					
					carattere.add(temp);
		      }
			if ( carattere.size() == 0)
				System.out.println(addPrimoCarattere);
			
		 } while ( carattere.size() == 0);
	}
}

