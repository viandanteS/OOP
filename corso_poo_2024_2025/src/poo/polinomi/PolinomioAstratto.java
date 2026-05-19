package poo.polinomi;

import java.util.Iterator;

public abstract class PolinomioAstratto implements Polinomio{
	
	public String toString() {
		StringBuilder sb=new StringBuilder(200);
		boolean flag=true; //indica il primo monomio
		for( Monomio m: this ) {
			if( !flag && m.coeff()>0 ) sb.append("+");
			sb.append(m);
			if( flag ) flag=!flag;
		}
		return sb.toString();
	}
	//TODO come esercizio: aggiungere equals() e hashCode
	public boolean equals( Object x ) {
		if( !(x instanceof Polinomio) ) return false;
		if( x==this ) return true;
		Polinomio p=(Polinomio)x;
		if( p.size()!=size() ) return false;
		Iterator<Monomio> i1=iterator(), i2=p.iterator();
		while( i1.hasNext() ) {
			Monomio x1=i1.next(), x2=i2.next();
			if( !x1.equals(x2) ) return false;
		}
		return true;
	}//equals
	
	public int hashCode() {
		final int M=43;
		int h=0;
		for( Monomio x: this )
			h=h*M+x.hashCode();
		return h;
	}//hashCode
	
}//PolinomioAstratto
