package poo.string;

import java.util.Scanner;

public class Argomenti {
	
	public static void main( String[] args ) {
		int[] a;
		if( args.length>0 ) {
			//ci sono argumenti per il programma
			System.out.println("Interi provenienti da riga di comando.");
			a=new int[args.length];
			for( int i=0; i<args.length; ++i )
				a[i]=Integer.parseInt( args[i] );
		}
		else {
			//non ci sono argomenti e usiamo uno scanner
			System.out.println("Interi provenienti da tastiera mediante uno scanner.");
			Scanner sc=new Scanner( System.in );
			System.out.print("N=");
			int N=sc.nextInt(); sc.nextLine();
			//String linea=sc.nextLine();
			//int N=Integer.parseInt(linea);
			a=new int[N];
			System.out.println("Fornisci "+N+" interi uno per linea");
			for( int i=0; i<N; ++i ) {
				a[i]=sc.nextInt(); sc.nextLine();
			}
			sc.close();
		}
		System.out.println("Array letto:");
		System.out.println( java.util.Arrays.toString(a) );
	}//main

}//Argomenti
