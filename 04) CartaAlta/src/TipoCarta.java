public class TipoCarta
{

    private String nome;
    private String semi[];
    private String nomiCarte[];
    private int valoriCarte[];

    public TipoCarta(String _nome, String _semi[], String _nomiCarte[], int _valoriCarte[])
    {
        nome = _nome;
        semi = _semi;
        nomiCarte = _nomiCarte;
        valoriCarte = _valoriCarte;
    }

    public String getNomeCarta(int indexCarta)
    {
        return nomiCarte[indexCarta];
    }

    public String getSeme(int indexSeme)
    {
        return semi[indexSeme];
    }

    public int getValore(int indexCarta)
    {
        return valoriCarte[indexCarta];
    }

    public String getNome()
    {
        return nome;
    }

    public int getNumSemi()
    {
        return semi.length;
    }

    public int getNumCarte()
    {
        return nomiCarte.length;
    }
}
