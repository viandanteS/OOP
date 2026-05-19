package poo.lambda_stream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class DemoLambda {
	
	private static class Comparatore1 implements Comparator<String>{
		public int compare( String s1, String s2 ){
			if( s1.length()<s2.length() ) return -1;
			if( s1.length()==s2.length() ) return s1.compareTo(s2);
			return 1;
		}
	}//Comparatore1
	
	private static class MyString{
		public int confronto( String s1, String s2 ){
			if( s1.length()<s2.length() ) return -1;
			if( s1.length()==s2.length() ) return s1.compareTo(s2);
			return 1;
		}//confronto

		public static int compare( String s1, String s2 ){
			if( s1.length()<s2.length() ) return -1;
			if( s1.length()==s2.length() ) return s1.compareTo(s2);
			return 1;
		}//compare
		/*…*/
	}// MyString
	
	public static void main( String[] args ) {
		LinkedList<String> lis=new LinkedList<>( List.of("cane","gatto","aratro","zaino","dado") );
		System.out.println(lis);
		System.out.println("1 Soluzione: comparatore fornito da classe esplicita");
		Collections.sort( lis, new Comparatore1() );
		System.out.println(lis);
		
		lis=lis.reversed();
		System.out.println("2 Soluzione: comparatore fornito da classe anonima 'on-the-fly' ");
		Collections.sort( lis, new Comparator<String>(){
			public int compare( String s1, String s2 ){
				if( s1.length()<s2.length() ) return -1;
				if( s1.length()==s2.length() ) return s1.compareTo(s2);
				return 1;
			}
		} );
		System.out.println(lis);
		
		lis=lis.reversed();
		System.out.println("3 Soluzione: comparatore fornito da lambda expression");
		Collections.sort( lis, 
			(String s1, String s2) -> {
				if( s1.length()<s2.length() ) return -1;
				if( s1.length()==s2.length() ) return s1.compareTo(s2);
				return 1;
			}
		);
		System.out.println(lis);
		lis=lis.reversed();
		System.out.println("3 Soluzione bis: comparatore fornito da lambda expression");
		//Collections.<String>sort( lis, ...
		Collections.sort( lis, 
			(s1,s2) -> {
				if( s1.length()<s2.length() ) return -1;
				if( s1.length()==s2.length() ) return s1.compareTo(s2);
				return 1;
			}
		);
		System.out.println(lis);		
		
		lis=lis.reversed();
		Comparator<String> c=(s1, s2) ->{
			if( s1.length()<s2.length() ) return -1;
			if( s1.length()==s2.length() ) return s1.compareTo(s2);
			return 1;
		};
		System.out.println("3 Soluzione ter: comparatore fornito da lambda expression");
		Collections.sort( lis, c );
		System.out.println(lis);	
		
		lis=lis.reversed();
		System.out.println("4 Soluzione: con Comparator.comparing( con reference method )");
		Collections.sort( lis, 
			//Comparator.comparing(String::length)
			Comparator.comparing(String::length).thenComparing(String::compareTo) );
		System.out.println(lis);
		
		lis=lis.reversed();
		System.out.println("5 Soluzione: confronto fornito da reference method non static");
		Collections.sort( lis, new MyString()::confronto );
		System.out.println(lis);
		
		lis=lis.reversed();
		System.out.println("5 Soluzione bis: confronto fornito da reference method static");
		Collections.sort( lis, MyString::compare );
		System.out.println(lis);
		
		lis=lis.reversed();
		System.out.println("5 Soluzione ter: confronto fornito da reference method non static");
		Collections.sort( lis, String::compareToIgnoreCase );
		System.out.println(lis);		
		//Equivalenza a: (s1,s2)->s1.compareIgnoreCase(s2)
		
	}//main
	
}//DemoLambda
