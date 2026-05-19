package poo.util;

import java.util.Comparator;
import java.util.Iterator;

public interface Vector<T> extends Iterable<T>{ //Vector<T> ora e' un tipo generico
	//dimensione effettiva
	default int size() {
		Iterator<T> it=this.iterator();
		int c=0;
		while( it.hasNext() ) {
			it.next();
			c++;
		}
		return c;
	}//size
	
	//ritorna l’indice della prima occ di elem o -1
	default int indexOf( T elem ) {
		int i=0;
		for( T x: this ) {
			if( x.equals(elem) ) return i;
			i++;
		}
		return -1;
	}//indexOf
	
	//ritorna true se elem è presente
	default boolean contains( T elem ) {
		return indexOf(elem)!=-1;
	}//contains
	
	//ritorna l’oggetto in posizione indice
	T get( int indice );	
	//cambia l’oggetto in pos indice e ritorna il prec
	T set( int indice, T elem );
	
	//aggiunge elem alla fine
	default void add( T elem ){
		add( size(), elem );
	}//add
	//aggiunge elem in indice (non sovrascrittura)
	void add( int indice, T elem );	
	
	//rimuove la prima occorrenza di elem, se c’è
    default void remove( T elem ) {
    	Iterator<T> it=iterator();
    	while( it.hasNext() ) {
    		T x=it.next();
    		if( x.equals(elem) ) {
    			it.remove();
    			return;
    		}
    	}
    }//remove
    
    //rimuove e ritorna l’oggetto in pos indice
    default T remove( int indice ) { 
    	if( indice<0 || indice>=size() )
    		throw new IndexOutOfBoundsException();
    	Iterator<T> it=iterator();
    	int i=0;
    	T x=null;
    	while( it.hasNext() ) {
    		x=it.next();
    		if( i==indice ) {
    			it.remove();
    			break;
    		}
    		i++;
    	}
    	return x;
    }//remove
    
    //svuota il vector
	default void clear() {
		Iterator<T> it=iterator();
		while( it.hasNext() ) {
			it.next();
			it.remove();
		}
	}//clear
	
	//ritorna true se il vector è vuoto
	default boolean isEmpty() {
		return !iterator().hasNext();
	}//isEmpty
	
	//ritorna un subvector con gli elementi dalla pos «da» alla posizione «a», a escluso
	Vector<T> subVector( int da, int a );	
	
	static <T> void sort( Vector<T> v, Comparator<T> c ) {
		if( v.size()<2 ) return;
		boolean scambi=true; 
		int limite=v.size()-1, ius=0;
		while( scambi ) {
			scambi=false;
			for( int i=0; i<limite; ++i )
				if( c.compare(v.get(i), v.get(i+1) )>0 ) {
					T tmp=v.set(i, v.get(i+1));
					v.set(i+1, tmp);
					scambi=true;
					ius=i;
				}
			limite=ius;
		}
	}//sort
	
	static <T extends Comparable<T>> void sort( Vector<T> v ) {
		if( v.size()<2 ) return;
		boolean scambi=true; 
		int limite=v.size()-1, ius=0;
		while( scambi ) {
			scambi=false;
			for( int i=0; i<limite; ++i )
				if( v.get(i).compareTo(v.get(i+1))>0 ) {
					T tmp=v.set(i, v.get(i+1));
					v.set(i+1, tmp);
					scambi=true;
					ius=i;
				}
			limite=ius;
		}
	}//sort
	
	static <T> int ricercaBinaria( Vector<T> v, T elem, Comparator<T> c ) {
		//PRE: v e' ordinato secondo c
		int inf=0, sup=v.size()-1;
		while( inf<=sup ) {
			int med=(inf+sup)/2;
			if( v.get(med).equals(elem) ) return med;
			if( c.compare(v.get(med),elem)>0 ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria
	
	static <T extends Comparable<T>> int ricercaBinaria( Vector<T> v, T elem ) {
		//PRE: v e' ordinato secondo c
		int inf=0, sup=v.size()-1;
		while( inf<=sup ) {
			int med=(inf+sup)/2;
			if( v.get(med).equals(elem) ) return med;
			if( v.get(med).compareTo(elem)>0 ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria
	
}//Vector

