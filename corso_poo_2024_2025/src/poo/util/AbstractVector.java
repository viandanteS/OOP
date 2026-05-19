package poo.util;

import java.util.Iterator;

public abstract class AbstractVector<T> implements Vector<T>{
	
	public String toString() {
		StringBuilder sb=new StringBuilder(200);
		sb.append("[");
		for( T x: this ) {
			sb.append( x );
			sb.append(", ");
		}
		if( sb.length()>1 ) sb.setLength(sb.length()-2);
		sb.append("]");
		return sb.toString();
	}//toString
	
	public boolean equals( Object x ) {
		if( !(x instanceof Vector) ) return false;
		if( x==this ) return true;
		Vector<T> v=(Vector<T>)x;
		if( v.size()!=size() ) return false;
		/*
		for( int i=0; i<size(); ++i )
			if( !v.get(i).equals(get(i)) ) return false;
		return true;
		*/
		Iterator<T> i1=iterator(), i2=v.iterator();
		while( i1.hasNext() ) {
			T x1=i1.next(), x2=i2.next();
			if( !x1.equals(x2) ) return false;
		}
		return true;
	}//equals
	
	public int hashCode() {
		final int M=43;
		int h=0;
		for( T x: this )
			h=h*M+x.hashCode();
		return h;
	}//hashCode
	
}//AbstractVector
