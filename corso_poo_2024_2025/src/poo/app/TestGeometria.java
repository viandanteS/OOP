package poo.app;
import poo.geometria.Punto;
import poo.geometria.Triangolo;
import poo.geometria.Cilindro;
import poo.geometria.Cono;
import poo.geometria.Disco;

public class TestGeometria{
    public static void main( String[] args ){
       Punto p=new Punto(3.5894321,5.123456789);
       Punto q=new Punto();

       System.out.println("p="+p);
       System.out.println("q="+q);

       System.out.println(p+" getX="+p.getX() );

       q.muovi(-7,4.2);
       System.out.println("q="+q);

       double dist=p.distanza(q); //p e' l'oggetto ricevitore del messaggio distanza == this; q e' il parametro
       System.out.println("Distanza("+p+","+q+")="+dist);

       Triangolo t1=new Triangolo( new Punto(), new Punto(3,7), new Punto(12,-18) );
       System.out.println("t1="+t1);

       System.out.println("area="+String.format("%1.2f",t1.area())+" perimetro="+String.format("%1.2f",t1.perimetro()));
/*
       Punto[] v=t1.getVertici();
       v[0].muovi(0,0); v[1].muovi(3,3); v[2].muovi(0,0);
       System.out.println(t1);

       Triangolo t2=new Triangolo( v[0], v[1], v[2] );
       System.out.println(t2);
*/
       
       Cilindro c=new Cilindro( new Punto(), 4.5, 12.8 );
       System.out.println(c+" area="+c.area()+" volume="+c.volume());
       
       Punto r=new Punto(2,6);
       
       r=c; //chi sono tipo statico e tipo dinamico di r??
       
       System.out.println("r.toString()="+r.toString());
       
       Cono z=new Cono(new Punto(), 4.2, 10);
       System.out.println(z+" area="+z.area()+" volume="+z.volume());
      // System.out.println("z.toString()="+z.toString());

    }//main
}//TestGeometria