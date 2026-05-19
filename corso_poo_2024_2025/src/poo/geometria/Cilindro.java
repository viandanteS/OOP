package poo.geometria;

public class Cilindro extends Disco implements FiguraSolida{
	private double altezza;
	public Cilindro( final double x, final double y, final double raggio, final double altezza ) {
		super(x,y,raggio);
		if( altezza<=0 )
			throw new IllegalArgumentException("Altezza deve essere positiva.");
		this.altezza=altezza;
	}
	public Cilindro( final Punto p, final double raggio, final double altezza ) {
		super(p,raggio);
		if( altezza<=0 )
			throw new IllegalArgumentException("Altezza deve essere positiva.");
		this.altezza=altezza;
	}
	public Cilindro( final Disco d, final double altezza ) {
		super(d);
		if( altezza<=0 )
			throw new IllegalArgumentException("Altezza deve essere positiva.");
		this.altezza=altezza;		
	}
	public Cilindro( final Cilindro c ) {
		super(c);
		this.altezza=c.altezza;
	}
	public double getAltezza() { return altezza; }
	
	public double perimetro() {
		throw new UnsupportedOperationException();
	}//perimetro
	
	public double area() {
		return 2*areaDiBase()+areaLaterale();
	}//area
	
	public double areaDiBase() {
		return super.area();
	}//areaDiBase
	
	public double areaLaterale() {
		return super.perimetro()*altezza;
	}//areaLaterale
	
	public double volume() {
		return areaDiBase()*altezza;
	}//volume
	
	public String toString() {
		return "Cilindro("+super.toString()+","+" altezza: "+altezza+")";
	}//toString
	
	public boolean equals( Object x ) {
		if( !(x instanceof Cilindro) ) return false;
		if( x==this ) return true;
		Cilindro c=(Cilindro)x;
		return this.getRaggio()==c.getRaggio() && this.altezza==c.altezza; //ipotesi
	}//equals
	
	public int hashCode() {
		final int M=83;
		Double r=Double.valueOf(getRaggio());
		Double h=Double.valueOf(altezza);
		return r.hashCode()*M+h.hashCode();
	}//hashCode
	
}//Cilindro
