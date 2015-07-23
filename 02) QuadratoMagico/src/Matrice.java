
public class Matrice
{

   /* private static final char SEP_VERTICALE = 124;
    private static final char SEP_ORIZZONTALE = 45;
    private static final char ACAPO = 10;
    public static final int VALORE_NON_MAGICO = -1; */
    private int valori[][];

    public Matrice(int valori[][])
    {
        this.valori = valori;
    }

    public int costanteMagica()
    {
        if(isMagic())
        {
            return sommaRiga(0);
        } else
        {
            return -1;
        }
    }

    public boolean isPanMagic()
    {
        int costante = costanteMagica();
        if(costante == -1)
        {
            return false;
        }
        return checkDiagonali(costante) && checkAntiDiagonali(costante);
    }

    public boolean checkDiagonali(int costante)
    {
        for(int i = 1; i < valori.length; i++)
        {
            int somma = 0;
            int numRiga = 0;
            for(int numColonna = i; numColonna < valori[0].length; numColonna++)
            {
                somma += valori[numRiga][numColonna];
                numRiga++;
            }

            int inizioDiagonaleComplementare = valori.length - i;
            numRiga = inizioDiagonaleComplementare;
            for(int numColonna = 0; numRiga < valori.length; numColonna++)
            {
                somma += valori[numRiga][numColonna];
                numRiga++;
            }

            if(somma != costante)
            {
                return false;
            }
        }

        return true;
    }

    public boolean checkAntiDiagonali(int costante)
    {
        for(int i = 0; i < valori.length - 1; i++)
        {
            int somma = 0;
            int numRiga = 0;
            for(int numColonna = i; numColonna >= 0; numColonna--)
            {
                somma += valori[numRiga][numColonna];
                numRiga++;
            }

            int inizioAntiDiagonaleComplementare = i + 1;
            numRiga = inizioAntiDiagonaleComplementare;
            for(int numColonna = valori[numRiga].length - 1; numRiga < valori.length; numColonna--)
            {
                somma += valori[numRiga][numColonna];
                numRiga++;
            }

            if(somma != costante)
            {
                return false;
            }
        }

        return true;
    }

    public boolean isMagic()
    {
        int costante = sommaRiga(0);
        for(int numRiga = 1; numRiga < valori.length; numRiga++)
        {
            if(sommaRiga(numRiga) != costante)
            {
                return false;
            }
        }

        for(int numColonna = 0; numColonna < valori[0].length; numColonna++)
        {
            if(sommaColonna(numColonna) != costante)
            {
                return false;
            }
        }

        if(sommaDiagonale() != costante)
        {
            return false;
        }
        return sommaAntiDiagonale() == costante;
    }

    public int sommaRiga(int numRiga)
    {
        int somma = 0;
        for(int numColonna = 0; numColonna < valori[numRiga].length; numColonna++)
        {
            somma += valori[numRiga][numColonna];
        }

        return somma;
    }

    public int sommaColonna(int numColonna)
    {
        int somma = 0;
        for(int numRiga = 0; numRiga < valori[numColonna].length; numRiga++)
        {
            somma += valori[numRiga][numColonna];
        }

        return somma;
    }

    public int sommaDiagonale()
    {
        int somma = 0;
        for(int i = 0; i < valori.length; i++)
        {
            somma += valori[i][i];
        }

        return somma;
    }

    public int sommaAntiDiagonale()
    {
        int somma = 0;
        int numRiga = 0;
        for(int numColonna = valori[0].length - 1; numRiga < valori.length; numColonna--)
        {
            somma += valori[numRiga][numColonna];
            numRiga++;
        }

        return somma;
    }

    public int valoreMassimo()
    {
        int massimo = valori[0][0];
        for(int i = 0; i < valori.length; i++)
        {
            for(int j = 0; j < valori[i].length; j++)
            {
                if(valori[i][j] > massimo)
                {
                    massimo = valori[i][j];
                }
            }

        }

        return massimo;
    }

    public int numeroRipetizioni(int valore)
    {
        int presenze = 0;
        for(int i = 0; i < valori.length; i++)
        {
            for(int j = 0; j < valori[i].length; j++)
            {
                if(valori[i][j] == valore)
                {
                    presenze++;
                }
            }

        }

        return presenze;
    }

    public boolean ripetuti()
    {
        for(int i = 0; i < valori.length; i++)
        {
            for(int j = 0; j < valori[i].length; j++)
            {
                if(numeroRipetizioni(valori[i][j]) > 1)
                {
                    return true;
                }
            }

        }

        return false;
    }

    public boolean consecutivi()
    {
        int numeroCaselle = valori.length * valori[0].length;
        for(int i = 1; i <= numeroCaselle; i++)
        {
            if(numeroRipetizioni(i) != 1)
            {
                return false;
            }
        }

        return true;
    }

    private String rigaOrizzontale(int lunghezza, char elemento)
    {
        StringBuffer risultato = new StringBuffer();
        for(int i = 1; i <= lunghezza; i++)
        {
            risultato.append(elemento);
        }

        return risultato.toString();
    }

    public String toString()
    {
        String casellaMassima = (new StringBuilder(" ")).append(String.valueOf(valoreMassimo())).toString();
        int larghezzaCasella = 1 + casellaMassima.length();
        int lunghezzaRiga = 1 + larghezzaCasella * valori[0].length;
        String stringaFormattazioneCasella = (new StringBuilder("%")).append(casellaMassima.length()).append("d").toString();
        StringBuffer risultato = new StringBuffer();
        risultato.append(rigaOrizzontale(lunghezzaRiga, '-'));
        risultato.append('\n');
        for(int i = 0; i < valori.length; i++)
        {
            risultato.append('|');
            for(int j = 0; j < valori[i].length; j++)
            {
                risultato.append(String.format(stringaFormattazioneCasella, new Object[] {
                    Integer.valueOf(valori[i][j])
                }));
                risultato.append('|');
            }

            risultato.append('\n');
            risultato.append(rigaOrizzontale(lunghezzaRiga, '-'));
            risultato.append('\n');
        }

        return risultato.toString();
    }
}
