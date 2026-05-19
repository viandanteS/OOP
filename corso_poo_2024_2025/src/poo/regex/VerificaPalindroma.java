package poo.regex;

import java.util.Scanner;
import java.util.Stack;

public class VerificaPalindroma {
	public static void main( String[] args ) {
		Scanner sc=new Scanner( System.in );
		System.out.print("Scrivi una stringa del tipo: string1$string2 ");
		String linea=sc.nextLine();
		sc.close();
		String REGEX="\\w+\\$\\w+";
		if( !linea.matches(REGEX) ) 
			throw new RuntimeException(linea+" non valida.");
		Stack<Character> stack=new Stack<>();
		int i=0;
		while( linea.charAt(i)!='$' ) {
			stack.push( linea.charAt(i) );
			++i;
		}
		i++;  //salta $
		while( i<linea.length() && !stack.empty() ) {
			char c1=linea.charAt(i);
			char c2=stack.pop();
			if( c1!=c2 ) break;
			++i;
		}
		if( i==linea.length() && stack.empty() )
			System.out.println(linea+" e' palindroma.");
		else
			System.out.println(linea+" non e' palindroma.");
	}
}
