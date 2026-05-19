package poo.valutatore;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Valutatore {
	private String expr;
	private StringTokenizer st;

	private String OPERANDO="\\d+";
	private String OPERATORE="[\\+\\-\\*/%\\^\\(\\)]";
	private String EXPR="("+OPERANDO+"|\\()"+"("+OPERANDO+"|"+OPERATORE+")*";

	private static Set<Character> molt=new HashSet<>();
	private static Set<Character> addit=new HashSet<>();
	static { //blocco static
		molt.add('*'); molt.add('/'); molt.add('%');
		addit.add('+'); addit.add('-');
	}

	//altra possibile inizializzazione dei due set che evita il blocco static:
	/*
	private static Set<Character> molt=new HashSet<>( java.util.List.of('*','/','%') );
	private static Set<Character> addit=new HashSet<>( java.util.List.of('+','-') );
	*/

	//estensione ed instanziazione "al volo" di classe anonima
	private static Comparator<Character> c=new Comparator<>() {
		public int compare( Character c1, Character c2 ) {
			if( c1=='^' && c2!='^' ) return 1;
			if( c1!='^' && c2=='^' ) return -1;
			if( molt.contains(c1) && addit.contains(c2) ) return 1;
			if( addit.contains(c1) && molt.contains(c2) ) return -1;
			return 0;
		}//compare
	};//Comparator

	private static boolean okParentesi( String s ) {
		Stack<Character> pila=new Stack<>();
		for( int i=0; i<s.length(); ++i ) {
			char c=s.charAt(i);
			if( c=='(' ) pila.push(c);
			else if( c==')' ){
				if( pila.empty() ) return false;
				else pila.pop();
			}
		}
		return pila.empty();
	}//okParentesi

	public Valutatore( String expr ) {
		if( !expr.matches(EXPR) )
			throw new RuntimeException(expr+" malformata.");
		if( !okParentesi(expr) )
			throw new RuntimeException(expr+" malformata nelle parentesi.");
		this.expr=expr;
		this.st=new StringTokenizer(this.expr,"^+-*/%()",true);
	}

	private int termina( Stack<Integer> operandi, Stack<Character> operatori ) {
		while( !operatori.empty() ) {
			try {
				char op=operatori.pop();
				int o2=operandi.pop();
				int o1=operandi.pop();
				operandi.push( calcola(op,o1,o2) );
			}catch( Exception e ) {
				throw new RuntimeException("Espressione malformata.");
			}
		}
		if( operandi.empty() || operandi.size()>1 )
			throw new RuntimeException("Espressione malformata.");
		return operandi.pop();
	}//termina

	private int calcola( char op, int o1, int o2 ) {
		int ris=0;
		switch( op ) {
		case '^': ris=(int)Math.pow(o1,o2); break;
		case '*': ris=o1*o2; break;
		case '/': ris=o1/o2; break;
		case '%': ris=o1%o2; break;
		case '+': ris=o1+o2; break;
		case '-': ris=o1-o2;
		}
		return ris;
	}//calcola

	public int valuta() {
		Stack<Integer> operandi=new Stack<>();
		Stack<Character> operatori=new Stack<>();
		while( st.hasMoreTokens() ) {
			String tk=st.nextToken();
			if( tk.matches(OPERANDO) ) {
				operandi.push( Integer.parseInt(tk) );
			}
			else if( tk.charAt(0)=='(' ) {
				operandi.push( valuta() );
			}
			else if( tk.charAt(0)==')' ) {
				return termina( operandi, operatori );
			}
			else { //operatore
				char opc=tk.charAt(0);
				while( !operatori.empty() && c.compare( opc, operatori.peek() )<=0 ) {
					char op=operatori.pop();
					int o1=0, o2=0;
					try {
						o2=operandi.pop();
						o1=operandi.pop();
						operandi.push( calcola(op,o1,o2) );
					}catch( Exception e ) {
						throw new RuntimeException("Espressione malformata.");
					}
				}
				operatori.push(opc);
			}
		}
		return termina( operandi, operatori );
	}//valuta

	public static void main( String[] args ) {
		String expr="(((3+4)*2^2+5)-7)*2";//"4+7*(8-2*3^2)";//"(3+4)*(5+2)^2-5+8";//"(((3+4)*2^2+5)-7)*2";
		Valutatore v=new Valutatore(expr);
		System.out.println(expr+"="+v.valuta());
	}//main

}//Valutatore
