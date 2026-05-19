package poo.util;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayVector<T> extends AbstractVector<T>{
	
	private T[] array; //rappresentazione del Vector
	private int size, n;
	private int contaModifiche=0;
	
	public ArrayVector( int n ) {
		if( n<=0 ) throw new IllegalArgumentException("Dimensione non accettabile.");
		this.n=n;
		array=(T[])new Object[n];
		size=0;
	}
	public ArrayVector() {
		this(17);
	}
	
	//dimensione effettiva
	public int size() { return size; }	

	//ritorna l’oggetto in posizione indice
	public T get( int indice ) {
		if( indice<0 || indice>=size ) throw new IndexOutOfBoundsException();
		return array[indice];
	}//get
	
	//cambia l’oggetto in pos indice e ritorna il prec
	public T set( int indice, T elem ) {
		if( indice<0 || indice>=size ) throw new IndexOutOfBoundsException();
		T x=array[indice];
		array[indice]=elem;
		return x;
	}//set

	//aggiunge elem in indice (non sovrascrittura)
	public void add( int indice, T elem ) {
		if( indice<0 || indice>size ) throw new IndexOutOfBoundsException();
		if( size==n ) {
			array=java.util.Arrays.copyOf(array, n*2);
			n=n*2;
		}
		for( int i=size-1; i>=indice; --i ) //right shift per fare spazio di un elemento
			array[i+1]=array[i];
		array[indice]=elem;
		size++;
		contaModifiche++;
	}//add
	
	//rimuove la prima occorrenza di elem, se c’è
    public void remove( T elem ) {
    	int i=0;
    	for( ; i<size; ++i )
    		if( array[i].equals(elem) ) break;
    	if( i==size ) return;
    	for( ; i<size-1; ++i ) //left shift per rimuovere la lacuna
    		array[i]=array[i+1];
    	size--;
    	if( size<n/2 ) {
    		array=java.util.Arrays.copyOf(array, n/2);
    		n=n/2;
    	}
    	contaModifiche++;
    }//remove
    
    public T remove( int indice ) {
    	if( indice<0 || indice>=size ) throw new IndexOutOfBoundsException();
    	T x=array[indice];
    	for( int i=indice+1; i<size; ++i )
    		array[i-1]=array[i];
    	array[size-1]=null;
    	size--;
    	if( size<n/2 ) {
    		array=java.util.Arrays.copyOf(array, n/2);
    		n=n/2;
    	}
    	contaModifiche++;
    	return x;
    }//remove
    
    //svuota il vector
    public void clear() {
    	for( int i=0; i<size; ++i ) array[i]=null;
    	contaModifiche++;
    	size=0;
	}//clear
    
	//ritorna true se il vector è vuoto
	public boolean isEmpty() {
		return size==0;
	}//isEmpty
	
	//ritorna un subvector con gli elementi dalla pos «da» alla posizione «a», a escluso
	public Vector<T> subVector( int da, int a ) {
		if( da<0 || da>=size || a<0 || a>size || da>=a )
			throw new IndexOutOfBoundsException();
		Vector<T> v=new ArrayVector<T>(a-da);
		for( int i=da; i<a; ++i )
			v.add(array[i]);
		return v;
	}//subVector
	
	public Iterator<T> iterator(){
		return new ArrayVectorIterator();
	}//iterator
	
	//inner class
	private class ArrayVectorIterator implements Iterator<T>{
		private int cur=-1;
		private int contaModIte=contaModifiche;
		private boolean rimuovibile=false;
		public boolean hasNext() {
			return cur<size-1;
		}//hasNext
		public T next() { 
		    if( contaModifiche!=contaModIte ) 
				throw new ConcurrentModificationException();
			if( !hasNext() ) 
				throw new NoSuchElementException();
			cur++;
			T x=array[cur];
			rimuovibile=true;
			return x;
		}//next
		public void remove() {
			if( contaModifiche!=contaModIte )
				throw new ConcurrentModificationException();
			if( !rimuovibile ) throw new IllegalArgumentException();
			rimuovibile=false;
			//rimuoviamo array[cur] e aggiorniamo cur
			/*
			for( int i=cur+1;i<size; ++i )
				array[i-1]=array[i];
			contaModifiche++;
			*/
			ArrayVector.this.remove(cur);
			//size--; array[size]=null;
			cur--; //arretriamo cur al precedente elemento, se esiste, gia' consumato
			contaModIte++;
		}//remove
	}//ArrayVectorIterator
	
	public static void main( String[] args ) {
		Vector<Integer> vi=new ArrayVector<>();
		vi.add(5); vi.add(2); vi.add(12);
		Iterator<Integer> it=vi.iterator();
		it.next();
		vi.clear();
		it.next();
	}//main
	
}//ArrayVector
