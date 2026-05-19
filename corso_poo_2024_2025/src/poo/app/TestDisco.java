package poo.app;
import poo.geometria.Punto;
import poo.geometria.Disco;

public class TestDisco{
    public static void main( String[] args ){
		Punto p=new Punto(2,3);
		System.out.println(p);
		Disco d=new Disco(-2,5,4);
		System.out.println(d);

		double x=d.getX();
		double dist=p.distanza(d);
		System.out.println("distanza tra "+p+" e "+d+" ="+dist);

		//d=p; //NON SI PUO' FARE

		p=d;

		System.out.println("p instanceof Disco ? "+(p instanceof Disco) );

		System.out.println(p);
		double r=((Disco)p).getRaggio();

    }//main
}//TestDisco