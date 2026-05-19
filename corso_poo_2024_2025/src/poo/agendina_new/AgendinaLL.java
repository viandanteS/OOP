package poo.agendina_new;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AgendinaLL extends AgendinaAstratta{
	private LinkedList<Nominativo> tabella=new LinkedList<>();
	public int size() { return tabella.size(); }
	public Iterator<Nominativo> iterator(){ return tabella.iterator(); }
	public void aggiungi( Nominativo n ) {
		/*ListIterator<Nominativo>*/var lit=tabella.listIterator();
		boolean flag=false;
		while( lit.hasNext() && !flag ) {
			Nominativo x=lit.next();
			if( x.equals(n) ) { flag=true; lit.set(n); }
			if( x.compareTo(n)>0 ) {
				lit.previous(); lit.add(n); flag=true;
			}
		}
		if( !flag ) lit.add(n);
	}//aggiungi
}//AgendinaLL
