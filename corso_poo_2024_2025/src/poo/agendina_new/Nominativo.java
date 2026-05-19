package poo.agendina_new;

public record Nominativo( String cognome, String nome, String prefisso, String telefono) implements Comparable<Nominativo> {
	
	public Nominativo {//costruttore compatto - mostrato solo per scopi dimostrativi qui
		if( cognome==null || nome==null )
			throw new IllegalArgumentException();
		cognome=cognome.toUpperCase();
		nome=nome.toUpperCase();
	}
	
	public int compareTo( Nominativo n ) {
		if( cognome.compareTo(n.cognome)<0 ) return -1;
		if( cognome.equals(n.cognome) && nome.compareTo(n.nome)<0 ) return -1;
		if( this.equals(n) ) return 0;
		return 1;
	}//compareTo
	
	public boolean equals( Object x ) {
		if( !(x instanceof Nominativo) ) return false;
		if( x==this ) return true;
		Nominativo n=(Nominativo)x;
		return cognome.equals(n.cognome) && nome.equals(n.nome);
	}//equals
	
	public int hashCode() {
		final int M=83;
		int h=cognome.hashCode()*M+nome.hashCode();
		return h;
	}//hashCode

	public String toString() {
		return cognome+" "+nome+" "+prefisso+"-"+telefono;
	}//toString
	
	public static void main( String[] args ) {
		Nominativo n=new Nominativo("nigro","libero","0984","654321");
		System.out.println(n);
		Nominativo m=new Nominativo("rossi","fabio","","");
		System.out.println(n+" uguale "+m+" ? "+n.equals(m));
		System.out.println(n+" precede "+m+" ? "+ (n.compareTo(m)<0) );
	}
	
}//Nominativo
