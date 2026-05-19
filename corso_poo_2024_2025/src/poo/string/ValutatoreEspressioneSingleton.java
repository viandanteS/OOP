package poo.string;

import java.util.StringTokenizer;

public final class ValutatoreEspressioneSingleton {
	//una classe di cui si può avere un solo oggetto
	
	//costanti intere e gli usuali operatori della matematica +,-,*,/
	//(3+(7*4))-12+5
	
	private String expr;
	private StringTokenizer st;
	private static ValutatoreEspressioneSingleton istanza;
	
	private ValutatoreEspressioneSingleton() {}
	
	public static ValutatoreEspressioneSingleton getIstanza() {
		if( istanza==null ) istanza=new ValutatoreEspressioneSingleton();
		return istanza;
	}//getIstanza

	public int valuta( String expr ) {
		//validare expre con una regex
//		if(!expr.matches("\\W+")) throw new IllegalArgumentException("Espressione Malformata");
		this.expr=expr;
		st=new StringTokenizer(expr,"+-*/()",true); //gli operatori sono essi stessi restituiti da successiva nextToken()
		return valutaEspressione();
	}//valuta
	
	private int valutaOperando() {
		String tk=st.nextToken();
		if( tk.charAt(0)=='(' ) return valutaEspressione();
		else return Integer.parseInt(tk);
	}//valutaOperando
	
	private int valutaEspressione() {
		int ris=valutaOperando();
		while( st.hasMoreTokens() ) {
			char op=st.nextToken().charAt(0);
			if( op==')' ) return ris;
			int opnd=valutaOperando();
			switch( op ) {
				case '+': ris=ris+opnd; break;
				case '-': ris=ris-opnd; break;
				case '*': ris=ris*opnd; break;
				case '/': ris=ris/opnd; break;
				default : throw new RuntimeException("Espressione malformata.");
			}
		}
		return ris;
	}//valutaEspressione
	
	public String toString() {
		return expr;
	}//toString
	
	public static void main( String...args ) {
		String e="(4*(6*3)/4)";
		ValutatoreEspressioneSingleton v=ValutatoreEspressioneSingleton.getIstanza();
		int ris=v.valuta(e);
		System.out.println(e+"="+ris);
	}//main

}//ValutatoreEspressione
