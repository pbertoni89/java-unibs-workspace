import java.util.*;
import utilities.MyMath;

class Mazzo
{

    @SuppressWarnings("unused")
	private TipoCarta tipo;
    private Vector <Carta> carte = new Vector <Carta>  (); 

    public Mazzo(TipoCarta tipo)
    {
        this.tipo = tipo;
        for(int i = 0; i < tipo.getNumSemi(); i++)
            for(int j = 0; j < tipo.getNumCarte(); j++)
                carte.add(new Carta(tipo, i, j));
    }

    public Carta estrai()
    {
        int estratto = MyMath.estraiIntero(0, carte.size() - 1);
        return (Carta)carte.get(estratto);
    }
}
