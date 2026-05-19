package poo.string;
import java.util.Scanner;

public class CognomeNome {
	public static void main( String[] args ) {
		
		Scanner sc=new Scanner( System.in );
		
		System.out.print("Fornisci cognome e nome: ");
		
		String linea=sc.nextLine();
		
		sc.close();
		
		linea=linea.trim(); //rimuove gli spazi prima del cognome e dopo il nome
		
		int i=linea.indexOf(' ');
		String cognome=linea.substring(0,i); //da 0 sino all'indice i ma i escluso
		
		//int j=i;
		//while( j<linea.length() && linea.charAt(j)==' ' ) ++j; //skip restanti spazi
		int j=linea.lastIndexOf(' ');
		
		//in j c'è l'indice del primo carattere del nome
		String nome=linea.substring(j+1);
		
		System.out.println(nome.charAt(0)+". "+cognome);
	}//main
}//CognomeNome
