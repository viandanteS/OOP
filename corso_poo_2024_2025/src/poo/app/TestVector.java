package poo.app;

import java.util.Comparator;
import java.util.Iterator;

import poo.util.ArrayVector;
import poo.util.Vector;

public class TestVector {
	
	static class Comparatore implements Comparator<String>{
		public int compare( String s1, String s2 ) {
			return s2.compareTo(s1); //per ordinamento decrescente
		}
	}
	
	public static void main( String...args ) {
		Vector<String> vs=new ArrayVector<String>();
		for( int i=0; i<args.length; ++i ) {
/*
			int j=0;
			String s=args[i];
			for( ; j<vs.size(); ++j ) {
				String x=vs.get(j);
				if( x.compareTo(s)>=0 ) break;
			}
*/
			vs.add(args[i]);				
		}
		System.out.println(vs);
		System.out.println("L'iteratore funziona? SI.");
/*
		Iterator<String> is=vs.iterator();
		while( is.hasNext() ) {
			String s=is.next();
			System.out.println(s);
			is.remove();
			System.out.println(vs);
		}
*/
		for(String s: vs )
			System.out.println(s);
		
		Vector.sort( vs, new Comparatore() );
		System.out.println(vs+" size="+vs.size());
		System.out.println("fuoco si trova in posizione: "+Vector.ricercaBinaria(vs,"fuoco",new Comparatore()));
		
		
/*		
		Vector<Integer> vi=new ArrayVector<>();
		vi.add( 3 ); //vi.add( Integer.valueOf(3) );
		int x=vi.get(0);
		System.out.println("x="+x);
		vi.add(5);
		System.out.println(vi);
*/
		Iterator<String> it=vs.iterator();
		//sapendo che ci sono almeno 5 elementi...
		String x1=it.next();
		String x2=it.next();
		
		vs.add("modifica");
		
		String x3=it.next(); //qui dovrebbe sollevarsi ConcurrentModificationException
		
	}//main
}//TestVector
