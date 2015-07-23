import utilities.MyMenu;
import utilities.MyIO;

public class Driver
{

    public static final String NOMEFR = "FRANCESI";
    public static final String NOMI_SEMI_FR[] = {
        "CUORI", "QUADRI", "PICCHE", "FIORI"
    };
    public static final String NOMI_CARTE_FR[] = {
        "ASSO", "DUE", "TRE", "QUATTRO", "CINQUE", "SEI", "SETTE", "OTTO", "NOVE", "DIECI", 
        "JACK", "DONNA", "RE"
    };
    public static final int VALORI_FR[] = {
        14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
        11, 12, 13
    };
    public static final String NOMEIT = "ITALIANE";
    public static final String NOMI_SEMI_IT[] = {
        "SPADE", "BASTONI", "COPPE", "DENARI"
    };
    public static final String NOMI_CARTE_IT[] = {
        "ASSO", "DUE", "TRE", "QUATTRO", "CINQUE", "SEI", "SETTE", "FANTE", "CAVALLO", "RE"
    };
    public static final int VALORI_IT[] = {
        11, 2, 3, 4, 5, 6, 7, 8, 9, 10
    };
    public static final String NOMI_ESISTENTI[] = {"",
        "ITALIANE", "FRANCESI"
    };
    public static final String INTESTA_TIPI = "SELEZIONE DEL TIPO DI CARTE DA USARE";
    public static final String MESS_INIZIO = "INIZIO PARTITA";
    public static final String DOMANDA_TIPI = "Selezionare il tipo di carte da usare";
    public static final String DOMANDA_NOME = "Inserisci il tuo nome:";
    public static final String DOMANDA_PATRIMONIO = ", con quanti euro vuoi giocare ?";
    public static final String ERRORE_SELEZ = "Attenzione selezione non valida";

    public static void main(String args[])
    {
        benvenuto();
        TipoCarta francesi = new TipoCarta("FRANCESI", NOMI_SEMI_FR, NOMI_CARTE_FR, VALORI_FR);
        TipoCarta italiane = new TipoCarta("ITALIANE", NOMI_SEMI_IT, NOMI_CARTE_IT, VALORI_IT);
        MyMenu mainMenu = new MyMenu("SELEZIONE DEL TIPO DI CARTE DA USARE", NOMI_ESISTENTI,3);
        boolean fine = false;
        do
        {
            int selezione = mainMenu.scegli();
            switch(selezione)
            {
            case 1: // '\001'
                play(italiane);
                break;

            case 2: // '\002'
                play(francesi);
                break;

            case 0: // '\0'
                fine = true;
                break;

            default:
                System.out.println("Attenzione selezione non valida");
                break;
            }
        } while(!fine);
    }

    private static void benvenuto()
    {
        System.out.println("BENVENUTO AL GIOCO DELLA CARTA PIU' ALTA");
    }

    private static void play(TipoCarta tipo)
    {
        System.out.println("INIZIO PARTITA");
        String nomeUtente = MyIO.leggiStringaNonVuota("Inserisci il tuo nome:");
        int soldiIniziali = MyIO.leggiInteroPos(new StringBuilder(  String.valueOf(nomeUtente) ).append(", con quanti euro vuoi giocare ?").toString() );
        Partita p = new Partita(nomeUtente, soldiIniziali, tipo);
        p.esegui();
    }

}
