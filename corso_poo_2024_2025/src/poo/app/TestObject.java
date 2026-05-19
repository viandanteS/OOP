package poo.app;
import poo.geometria.Punto;
import poo.razionali.Razionale;
import poo.date.Data;

public class TestObject{
    public static void main( String[] args ){
		Object x=new Object();
		Punto q=new Punto(2,4);
		x=q;

		Object[] a={ "Java is Fantastic", new Punto(-5,7), new Razionale(20,12), new Data() }; //ESEMPIO DI ARRAY ETEROGENEO

		for( int i=0; i<a.length; ++i )
			System.out.println(a[i]);

		for( int i=0; i<a.length; ++i ){
			if( a[i] instanceof Punto ){ //indagine sul tipo dinamico di a[i]
				Punto p=(Punto)a[i];
				p.muovi(p.getX()+5,p.getY()+10);

				double d=((Punto)a[i]).distanza(new Punto());
				System.out.println("distanza="+d);
			}
		}

    }//main
}//TestGeometria