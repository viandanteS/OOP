package poo.figure;

public class Rombo extends Figura{
	private double diagMaggiore;
	public Rombo( final double diagMinore, final double diagMaggiore ) {
		super(diagMinore);
		if( diagMaggiore<=0 )
			throw new IllegalArgumentException("Le diagonali devono essere positive");
		this.diagMaggiore=diagMaggiore;
	}
	public double getLato() {
		double c1=getDimensione()/2, c2=diagMaggiore/2;
		return Math.sqrt(c1*c1+c2*c2);
	}//getLato
	public double getDiagonaleMinore() { return getDimensione(); }
	public double getDiagonaleMaggiore() { return diagMaggiore; }
	
	public double perimetro() { return 4*getLato(); }
	public double area() {
		return (getDimensione()*diagMaggiore)/2;
	}//area
	
	public String toString() {
		return "Rombo("+String.format("%1.2f", getDimensione())+","+String.format("%1.2f", diagMaggiore)+")";
	}//toString
	
}//Rombo
