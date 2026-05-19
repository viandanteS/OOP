package poo.agendina;
import poo.util.Vector;
import poo.util.ArrayVector;
import java.util.Iterator;

public class AgendinaVector extends AgendinaAstratta{
	private Vector<Nominativo> tabella;
	private int n=0;
	public AgendinaVector( int n ) {
		if( n<=0 ) throw new IllegalArgumentException();
		this.n=n;
		tabella=new ArrayVector<>(n);
	}
	public AgendinaVector() { this(50); }
	
	public int size() { return tabella.size(); }
	
	public Iterator<Nominativo> iterator(){ return tabella.iterator(); }
	
	public void aggiungi( Nominativo n ) {
		int i=Vector.ricercaBinaria(tabella,n);
		if( i!=-1 ) {
			tabella.set(i, n);
		}
		else {
			i=0;
			while( i<tabella.size() && tabella.get(i).compareTo(n)<0 ) i++;
			tabella.add(i,n);
		}
	}//aggiungi
	
	public Nominativo cerca( Nominativo n ) {
		int i=Vector.ricercaBinaria(tabella, n);
		if( i!=-1 ) return tabella.get(i);
		return null;
	}//cerca
	
	public void rimuovi( Nominativo n ) {
		int i=Vector.ricercaBinaria(tabella,n);
		if( i!=-1 ) tabella.remove(i);
	}//rimuovi
	
}//Agendina
