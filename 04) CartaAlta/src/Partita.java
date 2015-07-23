import utilities.*;

class Partita
{

    private int soldi;
    private String player;
    private TipoCarta tipo;
    @SuppressWarnings("unused") 
    private static final String DOMANDA_CONTINUA = "Vuoi continuare a giocare?  (s/n) ";
    @SuppressWarnings("unused")
	private static final String MESS_PATRIMONIO = "Il tuo patrimonio attuale e' di euro: ";
    @SuppressWarnings("unused")
	private static final String MESS_PATRIMONIO_FIN = "Il tuo patrimonio finale e' di euro: ";
    @SuppressWarnings("unused")
	private static final String MESS_FINITI = "Mi spiace la partita non puo' continuare";
    @SuppressWarnings("unused")
	private static final String MESS_CARTA_UT = "Hai pescato: ";
    @SuppressWarnings("unused")
	private static final String MESS_CARTA_PC = "Il computer ha pescato: ";
    @SuppressWarnings("unused")
	private static final String MESS_GIOCATA = "Quanti euro vuoi scommettere ? ";
    @SuppressWarnings("unused")
	private static final String MESS_VINTO = " hai vinto !";
    @SuppressWarnings("unused")
	private static final String MESS_PERSO = " hai perso !";
    @SuppressWarnings("unused")
	private static final String MESS_PARI = "Carte pari: procediamo ad un'altra estrazione dallo stesso mazzo";
    
    public Partita(String _player, int _soldi, TipoCarta _tipo)
    {
        player = _player;
        soldi = _soldi;
        tipo = _tipo;
    }

    private void giocaUnaMano()
    {
        Mazzo mazzo = new Mazzo(tipo);
        boolean finito = false;
        do
        {
            Carta utente = mazzo.estrai();
            System.out.println((new StringBuilder("Hai pescato: ")).append(utente.toString()).toString());
            int scommessa = MyIO.leggiInteroLimiti("Quanti euro vuoi scommettere ? ", 1, soldi);
            Carta computer = mazzo.estrai();
            System.out.println((new StringBuilder("Il computer ha pescato: ")).append(computer.toString()).toString());
            int confronto = utente.compareTo(computer);
            if(confronto > 0)
            {
                soldi += scommessa;
                System.out.println((new StringBuilder(String.valueOf(player))).append(" hai vinto !").toString());
                finito = true;
            } else
            if(confronto < 0)
            {
                soldi -= scommessa;
                System.out.println((new StringBuilder(String.valueOf(player))).append(" hai perso !").toString());
                finito = true;
            } else
            {
                System.out.println("Carte pari: procediamo ad un'altra estrazione dallo stesso mazzo");
            }
            System.out.println((new StringBuilder("Il tuo patrimonio attuale e' di euro: ")).append(soldi).toString());
        } while(!finito);
    }

    public void esegui()
    {
        boolean continua = true;
        do
        {
            giocaUnaMano();
            if(soldi == 0)
            {
                continua = false;
                System.out.println("Mi spiace la partita non puo' continuare");
            } else
            {
                continua = MyMenu.yesOrNot("Vuoi continuare a giocare ?");
            }
        } while(continua);
        System.out.println((new StringBuilder("Il tuo patrimonio finale e' di euro: ")).append(soldi).toString());
    }
}
