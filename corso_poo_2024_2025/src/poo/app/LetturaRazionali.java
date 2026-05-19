package poo.app;

import java.util.Scanner;

import poo.razionali.DenominatoreNullo;
import poo.razionali.Razionale;

public class LetturaRazionali {
	public static void main(String...args){
		Razionale[] a=new Razionale[5];
		var sc=new Scanner( System.in );
		int i=0;
		while( i<a.length ) {
			System.out.print("Numeratore=");
			int num=sc.nextInt(); sc.nextLine();
			System.out.print("Denominatore=");
			int den=sc.nextInt(); sc.nextLine();
			try {
				a[i]=new Razionale(num,den);
			}catch( RuntimeException e ) {
				System.out.println("Denominatore nullo! Ridai il razionale.");
				continue;
			}
			/*
			if( den==0 ) {
				System.out.println("Denominatore nullo! Ridai il razionale.");
				continue;				
			}
			else a[i]=new Razionale(num,den);
			*/
			i++;
		}
	}
}//LetturaRazionali
