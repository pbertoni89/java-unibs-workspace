import utilities.*;

public class Driver {

    private static final String MSG_BENVENUTO = "Benvenuto nel mondo dei quadrati magici !";
    private static final String MSG_DIMENSIONE = "Inserire il lato del quadrato:";
    private static final String MSG_VALORE = "Inserire il valore presente nella posizione riga %d,colonna %d:";
    private static final String MSG_MAGIC = "Il quadrato e' magico con costante magica pari a %d%n";
    private static final String MSG_NON_MAGIC = "Il quadrato non e' magico";
    private static final String MSG_CONTINUA = "Vuoi continuare con l'inserimento di un nuovo quadrato?";
    private static final String MSG_RIPETUTI = "Il quadrato contiene numeri ripetuti";
    private static final String MSG_NON_RIPETUTI = "Il quadrato contiene numeri tutti diversi";
    private static final String MSG_CONSECUTIVI = "Il quadrato contiene solo numeri consecutivi a partire a 1";
    private static final String MSG_NON_CONSECUTIVI = "Il quadrato non contiene numeri consecutivi a partire a 1";
    private static final String MSG_PANMAGIC = "Il quadrato e' anche panmagico";
    private static final String MSG_NON_PANMAGIC = "Il quadrato non e' panmagico";
    private static final int MAX_DIMENSIONE = 3;

    public static void main(String args[])
    {
        System.out.println(MSG_BENVENUTO);
        do
        {
            Matrice quadrato = creaMatrice();
            System.out.println(quadrato.toString());
            if(quadrato.isMagic())
            {
                System.out.printf(MSG_MAGIC, new Object[] {
                    Integer.valueOf(quadrato.costanteMagica())
                });
            } else
            {
                System.out.println(MSG_NON_MAGIC);
            }
            if(quadrato.ripetuti())
            {
                System.out.println(MSG_RIPETUTI);
            } else
            {
                System.out.println(MSG_NON_RIPETUTI);
            }
            if(quadrato.consecutivi())
            {
                System.out.println(MSG_CONSECUTIVI);
            } else
            {
                System.out.println(MSG_NON_CONSECUTIVI);
            }
            if(quadrato.isPanMagic())
            {
                System.out.println(MSG_PANMAGIC);
            } else
            {
                System.out.println(MSG_NON_PANMAGIC);
            }
        } while(MyMenu.yesOrNot(MSG_CONTINUA));
    }

    public static Matrice creaMatrice()
    {
        int dimensione = MyIO.leggiInteroLimiti(MSG_DIMENSIONE,1, MAX_DIMENSIONE);
        int valori[][] = new int[dimensione][dimensione];
        String messaggio;
        
        for(int i = 0; i < dimensione; i++)
            for(int j = 0; j < dimensione; j++)
            {
            	messaggio= String.format(MSG_VALORE, 
            		new Object[] { Integer.valueOf(i + 1), Integer.valueOf(j + 1) } );
            	
                valori[i][j] = MyIO.leggiInteroLimiti(messaggio, 1, 100);
            }

        return new Matrice(valori);
    }
}
