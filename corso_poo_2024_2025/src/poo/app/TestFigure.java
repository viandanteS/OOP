package poo.app;
import poo.figure.Cerchio;
import poo.figure.Rettangolo;
import poo.figure.Rombo;
import poo.geometria.FiguraPiana;
import poo.geometria.Triangolo;
import poo.geometria.Disco;
import poo.geometria.Punto;

public class TestFigure {
	public static void main( String[] args ) {
		FiguraPiana[] af= {
			new Cerchio(12.784),
			new Rombo(4.7,12.5),
			new Rettangolo( 2.9,45.3),
			new Cerchio( 25.8),
			new Rombo( 5, 14 ),
			new Triangolo( new Punto(), new Punto(2,5), new Punto(-3,7)),
			new Disco( new Punto(),32)
		};

		//troviamo la figura di area massima
		FiguraPiana fam=null;
		double am=0;
		for( int i=0; i<af.length; ++i ) {
			if( af[i].area()>am ) {
				am=af[i].area();
				fam=af[i];
			}
		}
		System.out.println("Figura di area massima: "+fam+" area massima: "+String.format("%1.2f",am));
	}//main
}//TestFigure
