import utilities.MyMath;

public class Strada {

	private String nomeStrada;
	
	private int altezza;
	private int base;
	
	final String LIMITESX = "     | ";
	final String LIMITEDX = " |";
	
	final String MORTI = " Si sono verificate %d collisioni. \n\n";
	final String INIZIANO = " Macchine e pedoni iniziano a transitare.";
	
	Elemento[][] mappa;
	Elemento[][] mappaT;
	
	int morti;
	
	// i limiti di velocità per le macchine sono definiti per ogni strada
	// il pedone si muove sempre di uno e dunque è una costante propria della sua classe.
	int LimiteVelocita;
	
	public Strada (String _nomeStrada, int _altezza, int _base)
	{
		nomeStrada = _nomeStrada;
		altezza = _altezza;
		base = _base;
		mappa = new Elemento[altezza][base];
		mappaT = new Elemento[altezza][base];
	}	
														//    | -|------>  |	ORDINE DI 
	//*******************************************		//    |  |         |    ATTRAVERSAMENTO
	public void statoIniziale()							//	  |  |         |
	{													//    |  v         |
		for ( int i = 0; i < altezza; i++)
			for ( int j = 0; j < base; j++)
				 mappa[i][j] = nascita(); 
		 
		stampaStato();
		System.out.println(INIZIANO);
	}
	//*****************************************************************
	public Elemento nascita()
	{
		int casoVuota = 80; 
		int casoAuto = 95; 								//    | -|-1---->  |	ORDINE DI 
		int min = 1;									//    |  2         |    STAMPA E
		int max = 100;									//	  |  |         |	SCORRIMENTO
		int casoCorrente;		
		
		casoCorrente = MyMath.estraiIntero(min, max);
		 
		 if (casoCorrente <= casoVuota)
		 	{
			 Vuota nuovaVuota = new Vuota(); 
			 return nuovaVuota; 
		 	}
		 else
			 if (casoCorrente <= casoAuto)
			    {
				 Auto nuovaAuto = new Auto();
				 return nuovaAuto;
			    }
			 else
			    {
				 Pedone nuovoPedone = new Pedone();
				 return nuovoPedone;
			    }
	}
	// overloading: metodo per la generazione specifica di auto/vuote  O   pedoni/vuote
	public Elemento nascita(int chi)					  // param 0	    param 1
	{
		int scelto;
		scelto = MyMath.estraiIntero(1, 10);
		//System.out.println("SCELTO"+ scelto);
		 if (chi == 0)
		 	{
			 int chiAuto = 8;		// riflette la probabilità che da Ovest giunga una macchina.  (0.2)

			 if ( scelto < chiAuto)
			  {
				 Auto nuovaAuto = new Auto();
				 return nuovaAuto;
			  }
			 else
			  {		
				 Vuota nuovaVuota = new Vuota();
				 return nuovaVuota;
			  }
		 	}
		 else
		 {
			 int chiPedone = 8;    // riflette la probabilità che da Nord giunga un pedone.  (0.2)
			 if ( scelto < chiPedone)
			  {
				 Pedone nuovoPedone = new Pedone();
				 return nuovoPedone;
			  }
			 else
			  {
				 Vuota nuovaVuota = new Vuota();
				 return nuovaVuota;
			  }
		 }
	}
	//*****************************************************************
	public void collisioni()
	{
		int i=0, j=0;
		morti = 0;
		for ( i = 1; i < altezza; i++)
			for ( j = 0; j < base-1; j++)
				if ( mappa[i][j].disegno.equals( Auto.DISEGNO ) && mappa[i-1][j+1].disegno.equals( Pedone.DISEGNO) )
					{ 
					  mappaT[i][j] = new Vuota();
					  morti++;
					}
	}
	//*****************************************************************   
	/*
	public void muovi()
	{
		Elemento eleCorrente;

		int i = 0;
		int j = 0;
		int paramNascita;
		
		for ( i = 0; i < altezza; i++)
			for ( j = 0; j < base; j++)
				mappaT[i][j] = new Vuota();
		
		collisioni();
	
		for ( i = altezza-1; i > 0; i--)
			for ( j = base-1; j > 0; j--)
			 {
				eleCorrente = mappa[i][j];
				if ( eleCorrente.getDisegno().equals(Auto.DISEGNO) )
						if ( j == base-1)
							mappaT[i][j] = mappa[i][j-1];
						else
						  {
							mappaT[i][j+1] = mappa[i][j];
							mappaT[i][j] = new Vuota();    // mappa[i][j-1];
						  }
				else
					if ( eleCorrente.getDisegno().equals(Pedone.DISEGNO) )
							
							if ( i == altezza-1)
								mappaT[i][j] = mappa[i-1][j];
							else
							  {
								mappaT[i+1][j] = mappa[i][j];
								mappaT[i][j] = mappa[i-1][j];
							  }
			 }
		
		paramNascita = 0;
		for ( i = 0; i < altezza; i++)
		 {	
			eleCorrente = mappa[i][0];
			if ( eleCorrente.getDisegno().equals(Auto.DISEGNO) )
			 {
				mappaT[i][1] = mappa[i][0];
				mappaT[i][0] = nascita(paramNascita);
			 }
		 }
		
		paramNascita = 1;
		for ( j = 0; i < base; i++)
		 {	
			eleCorrente = mappa[0][j];
			if ( eleCorrente.getDisegno().equals(Pedone.DISEGNO) )
			 {
				mappaT[1][j] = mappa[0][j];
				mappaT[0][j] = nascita(paramNascita);
			 }
		 }
		
	} */
	
	
	 public void muovi()
	{
		Elemento eleCorrente;

		int i = 0;
		int j = 0;
		int paramNascita;
		
		for ( i = 0; i < altezza; i++)
			for ( j = 0; j < base; j++)
				mappaT[i][j] = new Vuota();
		
		collisioni();
	
		for ( i = altezza-1; i >= 0; i--)
			for ( j = base-1; j >= 0; j--)
			 {
				eleCorrente = mappa[i][j];
				if ( eleCorrente.getDisegno().equals(Auto.DISEGNO) )
				  {
					paramNascita = 0;
					if ( j == 0 )
					{		
						mappaT[i][j+1] = mappa[i][j];
						//mappaT[i][j] = nascita(paramNascita);
					}
					else	
						if ( j == base-1)
							mappaT[i][j] = mappa[i][j-1];
						else
						  {
							mappaT[i][j+1] = mappa[i][j];
							mappaT[i][0] = nascita(paramNascita);    // mappa[i][j-1];
						  }
				  }
				else
				  {
					paramNascita = 1;
					if ( eleCorrente.getDisegno().equals(Pedone.DISEGNO) )
						if ( i == 0 )
						{
							paramNascita = 1;
							mappaT[i+1][j] = mappa[i][j];
							//mappaT[i][j] = nascita(paramNascita);
						}
						else		
							if ( i == altezza-1)
								mappaT[i][j] = mappa[i-1][j];
							else
							  {
								mappaT[i+1][j] = mappa[i][j];
								mappaT[0][j] = nascita(paramNascita); //mappaT[i][j] = mappa[i-1][j];
							  }
				  }
			 }
	} 
	 
	 
	//*****************************************************************
	public void ripristina()
	{
		for ( int i = 0; i < altezza; i++)
			for ( int j = 0; j < base; j++)
			  { 
				mappa[i][j] = mappaT[i][j];
				mappaT[i][j] = new Vuota();
			  }
	}
	//*****************************************************************																					
	public void stampaStato()
	{	
		Elemento eleCorrente;
		String riga = LIMITESX;
		
		System.out.println();
		for ( int i = 0; i < altezza; i++)
		 {
			for ( int j = 0; j < base; j++)
			 { 
				eleCorrente = mappa[i][j];
				riga = riga + eleCorrente.getDisegno();			
			 }													 
			riga = riga + LIMITEDX;
			System.out.println (riga);	
			riga = LIMITESX;										  
		 }															
		System.out.println();	
	}																	
	//*****************************************************************
	public void turno()
	{
		muovi();
		ripristina();
		stampaStato();
		System.out.printf(MORTI, morti);
	}
	//*****************************************************************
	public String getNomeStrada()
	{
		return nomeStrada;
	}
}
