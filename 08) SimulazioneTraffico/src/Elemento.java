
public abstract class Elemento 
{
	int velocita;
	String disegno;
	
	public Elemento(String _disegno, int _velocita)
	{
		disegno = _disegno;
		velocita = _velocita;
	}
	public Elemento()  {}
	
	public int getVelocita() {
		return velocita;
	}

	public void setVelocita(int _velocita) {
		velocita = _velocita;
	}

	public String getDisegno() {
		return disegno;
	}

	public void setDisegno(String _disegno) {
		disegno = _disegno;
	}	
}
