package poo.polinomi;

public record Monomio(int coeff, int grado) implements Comparable<Monomio>{
	public Monomio{
		if( grado<0 ) throw new IllegalArgumentException("Grado negativo: "+grado);
	}
	public boolean equals( Object x ) {
		if( !(x instanceof Monomio ) ) return false;
		if( x==this ) return true;
		Monomio m=(Monomio)x;
		return this.grado==m.grado;
	}//equals
	public int compareTo( Monomio m ) {
		if( this.grado<m.grado ) return 1;
		if( this.equals(m) ) return 0;
		return -1;
	}//compareTo
	public int hashCode() {
		return grado;
	}//hashCode
	public String toString() {
		String s="";
		if( coeff==0 ) s=s+"0";
		else {
			if( coeff<0 ) s=s+"-";
			if( Math.abs(coeff)!=1 || grado==0 ) s=s+Math.abs(coeff);
			if( grado>0 ) s=s+"x";
			if( grado>1 ) s=s+"^"+grado;
		}
		return s; 
	}//toStrin
	public Monomio add( Monomio m ) {
		if( !this.equals(m) ) throw new RuntimeException("add: monomi non simili.");
		return new Monomio( this.coeff+m.coeff, grado );
	}//add
	public Monomio mul( int s ) {
		return new Monomio( this.coeff*s, grado );
	}//mul
	public Monomio mul( Monomio m ) {
		return new Monomio( this.coeff*m.coeff, this.grado+m.grado );
	}//mul
	public static void main( String[] main ) {
		Monomio m1=new Monomio(3,5);
		Monomio m2=new Monomio(-3,5);
		Monomio m3=m1.add(m2);
		Monomio m4=m1.mul(m2);
		System.out.println(m1+"+"+m2+"="+m3);
		System.out.println(m1+"*"+m2+"="+m4);
		Monomio m5=new Monomio(-1,0);
		System.out.println(m5);
	}
}//Monomio
