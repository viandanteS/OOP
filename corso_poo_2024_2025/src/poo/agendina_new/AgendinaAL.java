package poo.agendina_new;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class AgendinaAL extends AgendinaAstratta{
	private ArrayList<Nominativo> tabella;
	public AgendinaAL( int n ) {
		if( n<=0 ) throw new IllegalArgumentException();
		tabella=new ArrayList<>(n);
	}
	public AgendinaAL() { this(17); }
	public int size() { return tabella.size(); }
	public Iterator<Nominativo> iterator(){
		return tabella.iterator();
	}//iterator
	public void aggiungi( Nominativo n ) {
		int i=Collections.binarySearch(tabella,n);
		if( i>=0 ) tabella.set(i, n);
		else {
			i=0;
			while( i<tabella.size() && tabella.get(i).compareTo(n)<0 )
				++i;
			tabella.add(i,n);
		}
	}//aggiungi
	public Nominativo cerca( Nominativo n ) {
		int i=Collections.binarySearch(tabella,n);
		if( i>=0 ) return tabella.get(i);
		return null;
	}//cerca
	public void rimuovi( Nominativo n ) {
		int i=Collections.binarySearch(tabella,n);
		if( i>=0 ) tabella.remove(i);
	}//rimuovi
}//AgendinaAL
