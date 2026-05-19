package poo.polinomi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class PolinomioLL extends PolinomioAstratto{
	private LinkedList<Monomio> contenuto=new LinkedList<>();
	
	public int size() { return contenuto.size(); }
	public Iterator<Monomio> iterator(){ return contenuto.iterator(); }
	public PolinomioLL factory() { return new PolinomioLL(); }
	
	public void add( Monomio m ) {
		if( m.coeff()==0 ) return;
		boolean flag=false; //diventa true quando m è stato aggiunto
		ListIterator<Monomio> lit=contenuto.listIterator();
		while( lit.hasNext() && !flag ) {
			Monomio x=lit.next();
			if( x.equals(m) ) {
				x=x.add(m);
				flag=true;
				if( x.coeff()==0 ) lit.remove();
				else lit.set(x);
			}
			else if( x.compareTo(m)>0 ) {
				lit.previous(); lit.add(m); flag=true;
			}
		}
		if( !flag ) lit.add(m);
	}//add
	
}//PolinomioLL
