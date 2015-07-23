package utilities;
import java.util.*;

public class MyString {

	private final static String spazio = " ";
	
	public static String incolonna (String s, int larghezza) {
		
		 StringBuffer res = new StringBuffer(larghezza);
		 int numCharDaStampare = Math.min(larghezza,s.length());
		 res.append(s.substring(0, numCharDaStampare));
		 for (int i=s.length()+1; i<=larghezza; i++)
			res.append(s);
		 return res.toString();
		}
		
		 public static String centrata (String s, int larghezza) {
			 
			 StringBuffer res = new StringBuffer(larghezza);
			 if (larghezza <= s.length())
				res.append(s.substring(larghezza));
			 else
				{
				 int spaziPrima = (larghezza - s.length())/2;
				 int spaziDopo = larghezza - spaziPrima - s.length();
				 for (int i=1; i<=spaziPrima; i++)
					res.append(spazio);
				 res.append(s);
				 for (int i=1; i<=spaziDopo; i++)
					res.append(spazio);
				}
			 	 return res.toString();
			}
		
		 
	/*	 public static String centrata (String s, int larghezza)
			{
			 StringBuffer res = new StringBuffer(larghezza);
			 Integer numero = new Integer(n);
			 String stringaNumero;
			 stringaNumero = numero.toString (n);
			 if (larghezza <= s.length())
				res.append(s.substring(larghezza));
			 else
				{
				 int spaziPrima = (larghezza - s.length())/2;
				 int spaziDopo = larghezza - spaziPrima - s.length();
				 for (int i=1; i<=spaziPrima; i++)
					res.append(spazio);
					
				 res.append(s);
				
				 for (int i=1; i<=spaziDopo; i++)
					res.append(spazio);
				}
			 	 return res.toString();

		}  */
	
		 public static Vector<String> permutazioni(String daPermutare) {
		
			 Vector<String> prodotto = new Vector<String>();
		
			 if (daPermutare.length() <= 1)
				 prodotto.add(daPermutare);
			 else
			  {
				 for (int i = 0; i < daPermutare.length(); i++)
				  {
					 char iniziale = daPermutare.charAt(i);
					 String unoDiMeno=daPermutare.substring(0,i) + daPermutare.substring(i+1);
					 
					 Vector<String> subProdotto = permutazioni(unoDiMeno);
					 
					 for (String subPermutazione : subProdotto)
						 prodotto.add(iniziale + subPermutazione);
				  }
			  }
			 return prodotto;
		 }
		
	
		 
		 
		 
}
