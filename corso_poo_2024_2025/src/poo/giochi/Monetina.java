
package poo.giochi;

public class Monetina{

	public static final int TESTA=0, CROCE=1;
	private int faccia;

	public Monetina(){ lancia(); }//costruttore di default

	public void lancia(){
		faccia=(Math.random()<0.5) ? TESTA : CROCE;
	}//lancia

	public int getFaccia(){ return faccia; }

	public String toString(){
		return (faccia==TESTA)? "testa":"croce";
	}//toString



	public static void main( String []args ){ //es. appartenente alla classe Monetina
		final int OBIETTIVO=3;
		Monetina m1=new Monetina();
		Monetina m2=new Monetina();
		int conta1=0, conta2=0;
		//esperimento casuale
		while( conta1<OBIETTIVO && conta2<OBIETTIVO ){
			m1.lancia(); m2.lancia();
			System.out.println("m1 = "+m1);
			System.out.println("m2 = "+m2);
			conta1=(m1.getFaccia()==m1.TESTA) ? conta1+1 : 0;
			conta2=(m2.getFaccia()==m2.TESTA) ? conta2+1 : 0;
		}//while
		if( conta1<OBIETTIVO ) System.out.println("m2 vince!");
		else if( conta2<OBIETTIVO ) System.out.println("m1 vince!");
		else System.out.println("Parita'!");
	}//main

}//Monetina
