package poo.util;

import java.util.LinkedList;
import java.util.ListIterator;

public final class Array{

	private Array(){}

    public static int ricercaLineare( int[] a, int x ){
		for( int i=0; i<a.length; ++i )
			if( a[i]==x ) return i;
		return -1;
	}//ricercaLineare

	public static int ricercaBinaria( int[] a, int x ){
		//a e' ordinato per valori crescenti
		int inf=0, sup=a.length-1;
		while( inf<=sup ){
			int med=(inf+sup)/2;
			if( a[med]==x ) return med;
			else if( a[med]>x ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	 public static int ricercaLineare( double[] a, double x ){
		for( int i=0; i<a.length; ++i )
			if( Mat.sufficientementeProssimi(a[i],x) ) return i;
		return -1;
	}//ricercaLineare

	public static int ricercaBinaria( double[] a, double x ){
		//a e' ordinato per valori crescenti
		int inf=0, sup=a.length-1;
		while( inf<=sup ){
			int med=(inf+sup)/2;
			if( Mat.sufficientementeProssimi(a[med],x) ) return med;
			else if( a[med]>x ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	public static void selectionSort( int[] a ){
		for( int j=a.length-1; j>0; --j ){
			int indMax=0;
			for( int i=1; i<=j; ++i )
			   if( a[i]>a[indMax] ) indMax=i;
			//scambia a[indMax] con a[j]
			int tmp=a[j]; a[j]=a[indMax]; a[indMax]=tmp;
		}
	}//selectionSort

	public static void selectionSort( Comparable[] a ){
			for( int j=a.length-1; j>0; --j ){
				int indMax=0;
				for( int i=1; i<=j; ++i )
				   if( a[i].compareTo(a[indMax])>0 ) indMax=i;
				//scambia a[indMax] con a[j]
				Comparable tmp=a[j]; a[j]=a[indMax]; a[indMax]=tmp;
			}
	}//selectionSort
	
	public static <T extends Comparable<T>> void insertionSort( T[] a ) {
		if( a==null || a.length<=1 ) return;
		for( int i=1; i<a.length; ++i ) {
			T x=a[i]; //preleviamo a[i]
			int j=i;
			while( j>0 && a[j-1].compareTo(x)>0 ) {
				a[j]=a[j-1];
				--j;
			}
			a[j]=x;
		}
	}//insertionSort
	
	public static <T extends Comparable<T>> void bubbleSort( LinkedList<T> l ) {
		if( l.size()<=1 ) return;
		int ius=l.size()-1, limite=0;
		boolean scambi=true;
		while( scambi ) {
			scambi=false;
			ListIterator<T> lit=l.listIterator();
			T x=lit.next();
			limite=ius;
			while( lit.nextIndex()<=limite ) {
				T y=lit.next();
				if( x.compareTo(y)>0 ) {
					//scambia x con y
					lit.set(x);
					lit.previous(); lit.previous();
					lit.set(y);
					lit.next(); lit.next();
					scambi=true;
					ius=lit.previousIndex();
				}
				else x=y;
			}
		}
	}//bubbleSort
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
		if( a==null || a.length<=1 ) return;
		mergeSort( a, 0, a.length-1 );
	}//mergeSort
	
	private static <T extends Comparable<? super T>> void mergeSort(T[] a, int inf, int sup) {
		if( inf<sup ) {
			int med=(inf+sup)/2;
			mergeSort(a,inf,med);
			mergeSort(a,med+1,sup);
			merge(a,inf,med,sup);
		}
	}//mergeSort
	private static <T extends Comparable<? super T>> void merge(T[] a,int inf, int med, int sup) {
		T[] aux=(T[])new Comparable[sup-inf+1];
		int i=inf, j=med+1, k=0;
		while( i<=med && j<=sup ) {
			if( a[i].compareTo(a[j])<0 ) {
				aux[k]=a[i]; i++; k++;
			}
			else {
				aux[k]=a[j]; j++; k++;
			}
		}
		//gestione residuo
		while( i<=med ) {
			aux[k]=a[i]; i++; k++;
		}
		while( j<=sup ) {
			aux[k]=a[j]; j++; k++;
		}
		for( k=0; k<aux.length; ++k )
			a[k+inf]=aux[k];
	}//merge
	
	public static void main( String[] args ){
		
		Integer[] v={10,9,8,7,6,5,4,3,2,1};
		System.out.println(java.util.Arrays.toString(v));
		mergeSort(v);
		System.out.println(java.util.Arrays.toString(v));
/*
		System.out.println("vettore iniziale: "+java.util.Arrays.toString(v) );
		insertionSort(v);
		System.out.println("vettore finale: "+java.util.Arrays.toString(v) );
		
		LinkedList<Integer> li=new LinkedList<>( java.util.Arrays.asList(10,9,8,7,6,5,4,3,2,1) );
		System.out.println(li);
		bubbleSort(li);
		System.out.println(li);
*/
		
	}//main

}//Data