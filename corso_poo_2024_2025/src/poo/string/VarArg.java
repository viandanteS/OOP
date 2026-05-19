package poo.string;

public class VarArg {
	
	static int max( int...x ) { //x e' var-arg
		//x di fatto e' un array di int
		if( x.length<=0 ) throw new IllegalArgumentException("Nessun argomento.");
		int m=x[0];
		for( int i=1; i<x.length; ++i )
			if( x[i]>m ) m=x[i];
		return m;
	}//max
	
	public static void main( String...args ) {
		int m1=max( 10, 2, 7, 12, 14, -1, 24, 5  );
		System.out.println("m1="+m1);
		int m2=max( 20, 30 );
		System.out.println("m2="+m2);
	}//main

}//VarArg
