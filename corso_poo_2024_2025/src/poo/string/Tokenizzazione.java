package poo.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Tokenizzazione {
	
	public static void main( String...args ) {
		Scanner sc=new Scanner( System.in ) ;
		System.out.print("Fornisci una linea di parole: "); 
		String linea=sc.nextLine();
		sc.close();
		//scomporre la linea nelle sue parole costituenti
		//1 soluzione: uso uno StringTokenizer
		System.out.println("Tokenizzazione mediante StringTokenizer");
		StringTokenizer st=new StringTokenizer(linea," ,.;:!",true); //classe legacy
		while( st.hasMoreTokens() ) {
			String tk=st.nextToken().toUpperCase();
			System.out.println(tk);
		}
		//2 soluzione: uso del metodo split di String
		System.out.println("Tokenizzazione mediante split con regex");
		String[] as=linea.split("\\W+"); //i delimitatori sono tutti i possibili caratteri NON di word anche ripetuti
		for( int i=0; i<as.length; ++i ) {
			System.out.println( as[i].toUpperCase() );
		}
		//3 soluzione mediante uno scanner
		System.out.println("Tokenizzazione mediante scanner");
		Scanner sl=new Scanner( linea );
		sl.useDelimiter("\\W+");
		while( sl.hasNext() ) {
			String par=sl.next().toUpperCase();
			System.out.println(par);
		}
		sl.close();
	}
	
}//Tokenizzazione
