package poo.giochi;
import poo.geometria.Punto;

public class MonteCarlo{

	public static double pi( int N ){
		if( N<=0 ) throw new IllegalArgumentException("N deve essere positivo.");
		int interni=0;
		Punto origine=new Punto();
		for( int colpi=0; colpi<N; ++colpi ){
			double x=Math.random()*2-1;
			double y=Math.random()*2-1;
			Punto p=new Punto(x,y);
			double d=origine.distanza(p);
			if( d<=1.0 ) interni++;
		}
		double piGreco=(double)(4*interni)/N; //casting di int a double
		return piGreco;
	}//pi

	public static void main( String []args ){
		int N=100_000_000;
		System.out.println("PI="+pi(N));
	}//main

}//MonteCarlo
