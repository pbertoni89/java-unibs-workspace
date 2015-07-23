public class Carta
{

    private TipoCarta tipo;
    private int indexSeme;
    private int indexPosizione;

    public Carta(TipoCarta _tipo, int _indexSeme, int _indexPosizione)
    {
        tipo = _tipo;
        indexSeme = _indexSeme;
        indexPosizione = _indexPosizione;
    }

    public int compareTo(Carta altra)
    {
        return getValore() - altra.getValore();
    }

    public int getValore()
    {
        return tipo.getValore(indexPosizione);
    }

    public String toString()
    {
        return (new StringBuilder(String.valueOf(tipo.getNomeCarta(indexPosizione)))).append(" DI ").append(tipo.getSeme(indexSeme)).toString();
    }
}
