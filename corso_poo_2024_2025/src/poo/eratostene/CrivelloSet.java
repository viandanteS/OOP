package poo.eratostene;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CrivelloSet extends CrivelloAstratto{
	private final int N;
	private Set<Integer> crivello=new LinkedHashSet<>();
	public CrivelloSet( final int N ) {
		if( N<2 ) throw new IllegalArgumentException();
		this.N=N;
		for( int i=2; i<=N; ++i )
			crivello.add(i);
	}
	public Iterator<Integer> iterator(){
		return crivello.iterator();
	}//iterator
	public void filtra() {
		for( int i=2; i<=Math.round(Math.sqrt(N)); i=i==2?i+1:i+2 ) {
			if( crivello.contains(i) ) {
				//i certamente e' il prossimo minimo ossia un numero primo
				int multiplo=i*2;
				while( multiplo<=N ) {
					crivello.remove(multiplo);
					multiplo=multiplo+i;
				}
			}
		}
	}//filtra
	public static void main( String[] args ) {
		System.out.println("Numeri primi tra 2 ed N col Crivello di Eratostene");
		Scanner sc=new Scanner( System.in );
		System.out.print("N=");
		int N=sc.nextInt(); sc.nextLine();
		sc.close();
		Crivello criv=new CrivelloSet(N);
		criv.filtra();
		System.out.println(criv);
	}//main
	
}//CrivelloSet
