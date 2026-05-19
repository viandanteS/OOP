package poo.polinomi;

public interface Polinomio extends Iterable<Monomio>{
	
	default int size() {
		int c=0;
		for( Monomio m: this ) c++;
		return c;
	}//size
	void add( Monomio m );
	
	default Polinomio add( Polinomio p ) {
		Polinomio somma=factory();
		for( Monomio m: this ) somma.add(m);
		for( Monomio m: p ) somma.add(m);
		return somma;
	}//add
	
	default Polinomio mul( Monomio m ) {
		Polinomio prodotto=factory();
		for( Monomio m1: this ) prodotto.add(m1.mul(m));
		return prodotto;
	}//mul
	
	default Polinomio mul( Polinomio p ) {
		Polinomio prodotto=factory();
		for( Monomio m: this ) {
			prodotto=prodotto.add( p.mul(m) );
		}
		return prodotto;
	}//mul
	
	Polinomio factory(); //delega ad un erede concreto il costruire un polinomio //Metodo factory
	//non vogliamo che sia pubblico ma vogliamo che sia ad uso del framework nell'esempio di furfaro quindi questo no e nemmeno le implementazioni
	// dei metodi dove creiamo polinomi
	
	default Polinomio derivata() {
		Polinomio dp=factory();
		for( Monomio m: this )
			if( m.grado()>0 ) //monomio non termine noto
				dp.add( new Monomio(m.grado()*m.coeff(), m.grado()-1) );
		return dp;
	}//derivata
	
	default double valore( double x ) {
		double v=0;
		for( Monomio m: this )
			v=v+m.coeff()*Math.pow(x, m.grado());
		return v;
	}//valore

}//Polinomio
