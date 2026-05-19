package poo.agendina_new;
import java.util.Iterator;

public abstract class AgendinaAstratta implements Agendina{
	public String toString() {
		StringBuilder sb=new StringBuilder(200);
		for( Nominativo n: this ) {
			sb.append( n );
			sb.append("\n");
		}
		return sb.toString();
	}//toString
	
	public boolean equals( Object x ) {
		if( !(x instanceof Agendina) ) return false;
		if( x==this ) return true;
		Agendina v=(Agendina)x;
		if( v.size()!=size() ) return false;
		/*
		for( int i=0; i<size(); ++i )
			if( !v.get(i).equals(get(i)) ) return false;
		return true;
		*/
		Iterator<Nominativo> i1=iterator(), i2=v.iterator();
		while( i1.hasNext() ) {
			Nominativo x1=i1.next(), x2=i2.next();
			if( !x1.equals(x2) ) return false;
		}
		return true;
	}//equals
	
	public int hashCode() {
		final int M=43;
		int h=0;
		for( Nominativo x: this )
			h=h*M+x.hashCode();
		return h;
	}//hashCode
}//AgendinaAstratta
