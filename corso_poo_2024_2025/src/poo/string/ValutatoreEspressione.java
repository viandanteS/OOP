package poo.string;

import java.util.StringTokenizer;

public class ValutatoreEspressione {
	
	//costanti intere e gli usuali operatori della matematica +,-,*,/
	//(-3+(7*4))-12+5
	
	private String expr;
	private StringTokenizer st;
	public ValutatoreEspressione( String expr ) {
		//validare expr con una regex
		this.expr=expr;
	}
	
	public int valuta() {
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
		String e="((-3+(7*4))-12)/5";
		ValutatoreEspressione v=new ValutatoreEspressione(e);
		int ris=v.valuta();
		System.out.println(v+"="+ris);
	}//main

}//ValutatoreEspressione
