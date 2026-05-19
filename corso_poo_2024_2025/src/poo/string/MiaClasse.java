package poo.string;

public class MiaClasse {
	private int[] a;
	public MiaClasse( int[] a ) {
		this.a=java.util.Arrays.copyOf(a, a.length);
		/* EQUIVALENTE A:
		this.a=new int[a.length];
		for( int i=0; i<a.length; ++i )
			this.a[i]=a[i];
		*/
	}
	//...
	public String toString() {
		/*
		String s="[";
		for( int i=0; i<a.length; ++i ) {
			s=s+a[i]; //a[i] e' convertito a String automaticamente
			if( i<a.length-1 ) s=s+", ";
		}
		s=s+"]";
		return s;
		*/
		StringBuilder sb=new StringBuilder(200);
		String comma=", ";
		sb.append(" ");
		for( int i=0; i<a.length; ++i ) {
			sb.append( a[i] );
			sb.append( comma );		
		}
		if( sb.length()>1 ) sb.setLength( sb.length()-2 );
		sb.append("]");
		return sb.toString();
	}//toString
	
	public static void main( String...args ) {
		int[] v= {13,5,12,19,4};
		MiaClasse o=new MiaClasse(v);
		System.out.println(o);
	}//main
	
}//MiaClasse
