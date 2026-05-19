package poo.app;

import java.util.Scanner;

import poo.string.ValutatoreEspressioneSingleton;

public class ValutatoreInterattivo {
	
	public static void main( String...args ) {
		System.out.println("Valutatore interattivo di espressioni aritmeriche intere.");
		System.out.println("Gli operatori sono +,-,*,/ ed e' possibile racchiudere una sotto espressione tra ( e ).");
		System.out.println("A fronte del prompt >>  inserire una espressione e INVIO o solo INVIO per terminare.");
		var sc=new Scanner( System.in );		
		var v=ValutatoreEspressioneSingleton.getIstanza();
		for(;;) {
			System.out.print(">> ");
			String expr=sc.nextLine();
			if( expr.length()==0 ) break;
			try {
				System.out.println(expr+"="+v.valuta(expr));
			}catch( RuntimeException e ) {
				System.out.println("Espressione malformata.");
			}
		}
		System.out.println("Bye.");
		sc.close();
	}//main
	
}//ValutatoreInterattivo
