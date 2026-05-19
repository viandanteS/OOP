package poo.app;

import poo.polinomi.Monomio;
import poo.polinomi.PolinomioLL;

public class TestPoli {
	public static void main( String[] args ) {
		var p1=new PolinomioLL();
		p1.add( new Monomio(2,3) );
		p1.add( new Monomio(-3,2) );
		p1.add( new Monomio(2,0) );
		p1.add( new Monomio(1,5) );
		p1.add( new Monomio(-5,3) );
		p1.add( new Monomio(3,2) );
		
		var p2=new PolinomioLL();
		p2.add( new Monomio(-1,5) );
		p2.add( new Monomio(3,2) );
		p2.add( new Monomio(4,0) );
		p2.add( new Monomio(-2,4) );
		
		var p3=p1.add(p2);
		var p4=p1.mul(p2);
		System.out.println("("+p1+")+"+"("+p2+")="+p3);
		System.out.println("("+p1+")*"+"("+p2+")="+p4);
		
		var dp=p4.derivata();
		System.out.println("("+p4+")'="+dp);
		System.out.println(dp.valore(0));
	}//main
}//TestPoli
