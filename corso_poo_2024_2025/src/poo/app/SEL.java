package poo.app;

import java.util.Scanner;
import poo.sistema.Sistema;
import poo.sistema.Gauss;
import poo.sistema.GaussDiagonale;

public class SEL {
	
	public static void main( String[] args ) {
		System.out.println("Risoluzione di un sistema di equazioni lineari di ordine n");
		Scanner sc=new Scanner( System.in );
		System.out.print("Fornisci l'ordine del sistema n=");
		int n=sc.nextInt();  sc.nextLine();
		double[][] a=new double[n][n];
		double[] y=new double[n];
		for( int i=0; i<n; ++i ) {
			for( int j=0; j<n; ++j ) {
				System.out.print("a["+i+"]["+j+"]=");
				a[i][j]=sc.nextDouble(); sc.nextLine();
			}
			System.out.print("y["+i+"]=");
			y[i]=sc.nextDouble(); sc.nextLine();
		}
		Sistema s=new GaussDiagonale(a,y);
		System.out.println("Sistema iniziale:");
		System.out.println(s);
		double[] x=null;
		try {
			x=s.risolvi();
			System.out.println("Sistema GaussDiagonale:");
			System.out.println(s);
			System.out.println("Vettore Incognite:");
			for( int i=0; i<n; ++i )
				System.out.println("x["+i+"]="+String.format("%6.2f", x[i]));
		}catch( RuntimeException e ) {
			System.out.println("Sistema Singolare.");
			System.exit(-1);
		}
	}//main

}//SEL
