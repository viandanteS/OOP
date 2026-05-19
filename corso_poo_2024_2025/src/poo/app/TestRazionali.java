package poo.app;
import poo.razionali.Razionale;

public class TestRazionali{
     public static void main( String[] args ){
 		Razionale r1=new Razionale(20,64);
 		Razionale r2=new Razionale(10,8);
 		System.out.println(r1+"+"+r2+"="+r1.add(r2));

 		//8/12+14/18-24/10*10/4
 		Razionale ris=new Razionale(8,12).add( new Razionale(14,18) );
 		Razionale pro=new Razionale(-24,10).mul( new Razionale(10,4) );
 		ris=ris.add(pro);

 		System.out.println("8/12+14/18-24/10*10/4="+ris);

 		System.out.println("contatore dei razionali="+Razionale.razionaliEsistenti());
    }//main
}//TestGeometria