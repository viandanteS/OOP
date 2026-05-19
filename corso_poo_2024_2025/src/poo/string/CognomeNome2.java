package poo.string;

public class CognomeNome2 {
	public static void main( String[] args ) {
		//qui la stringa è presa dagli argomenti del programma
		//in particolare dal primo argomento
		
		if( args.length!=1 ) //o meno di 1 o piu' di 1 argomenti non va bene
			throw new IllegalArgumentException("Argomento atteso.");
		
		String linea=args[0];
		
		linea=linea.trim(); //rimuove gli spazi prima del cognome e dopo il nome
		
		int i=linea.indexOf(' ');
		String cognome=linea.substring(0,i); //da 0 sino all'indice i ma i escluso

		int j=linea.lastIndexOf(' ');
		
		//in j+1 c'è l'indice del primo carattere del nome
		String nome=linea.substring(j+1);
		
		System.out.println(nome.charAt(0)+". "+cognome);
	}//main
}//CognomeNome2

