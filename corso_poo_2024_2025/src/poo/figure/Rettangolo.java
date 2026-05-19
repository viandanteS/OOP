package poo.figure;

import poo.util.Mat;

public class Rettangolo extends Figura{
	private double altezza;
	public Rettangolo( final double base, final double altezza ) {
		super( base ); //deve essere la prima linea del costruttore
		if( altezza<=0 )
			throw new IllegalArgumentException("Altezza deve essere positiva.");
		this.altezza=altezza;
	}
	public Rettangolo( Rettangolo r ) {
		this( r.getBase(), r.getAltezza() );
	}
	public double getBase() {
		return getDimensione();
	}
	public double getAltezza() { return altezza; }
	
	public double perimetro() { return 2*getBase()+2*getAltezza(); }
	public double area() { return getBase()*getAltezza(); }
	
	public String toString() {
		return "Rettangolo("+String.format("%1.2f",getBase()+","+String.format("%1.2f", getAltezza()))+")";
	}//String
	
	public boolean equals( Object x ) {
		if( !(x instanceof Rettangolo) ) return false;
		if( x==this ) return true;
		Rettangolo r=(Rettangolo)x;
		return Mat.sufficientementeProssimi(this.getBase(), r.getBase()) &&
			   Mat.sufficientementeProssimi(this.altezza,r.altezza);
	}//equals
	
	public int hashCode() {
		final int M=83;
		Double b=Double.valueOf(getBase());
		Double a=Double.valueOf(altezza);
		int h=b.hashCode()*M+a.hashCode();
		return h;
	}//hashCode
	
}//Rettangolo
