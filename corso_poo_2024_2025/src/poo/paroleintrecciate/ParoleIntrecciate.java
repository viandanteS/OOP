package poo.paroleintrecciate;

import java.util.*;

public class ParoleIntrecciate {
	public static void main(String[] args) {
		char[][] matrice = {
				{'A', 'V', 'E', 'L', 'L', 'I', 'I', 'O'},
				{'B', 'C', 'D', 'E', 'F', 'L', 'H', 'I'},
				{'J', 'K', 'V', 'O', 'O', 'A', 'L', 'E'},
				{'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'},
				{'M', 'N', 'A', 'P', 'Q', 'R', 'S', 'T'},
				{'M', 'N', 'A', 'P', 'Q', 'R', 'S', 'T'},
				{'M', 'N', 'A', 'P', 'O', 'L', 'I', 'T'}
		};
        
		Schema schema = new Schema(matrice);
		System.out.println("Matrice iniziale:\n" + schema);
        
		Match m1 = schema.match("AVELLINO");
		Match m2 = schema.match("VOCALE");
		Match m3 = schema.match("NAPOLI");
		
		List<Match> matches= new ArrayList<>();
		if (m1 != null) {System.out.println("Match trovato: " + m1); matches.add(m1);}
		if (m2 != null) {System.out.println("Match trovato: " + m2); matches.add(m2);}
		if (m3 != null) {System.out.println("Match trovato: " + m3); matches.add(m3);}
		
		
		String risultato = schema.delete(matches);
		System.out.println("Stringa residua: " + risultato);
    }
}
