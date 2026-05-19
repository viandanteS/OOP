package poo.figure;
import poo.util.Mat;

public class Cerchio extends Figura{ //esempio di classe CONCRETA erede di Figura
	public Cerchio( final double raggio ) {
		super(raggio);
	}
	public Cerchio( Cerchio c ) {
		this(c.getRaggio());
	}
	public double getRaggio() { return getDimensione(); }
	public double perimetro() {
		return 2*Math.PI*getDimensione();
	}//perimetro
	public double area() {
		double r=getDimensione();
		return r*r*Math.PI;
	}//area
	@Override
	public String toString() {
		return "Cerchio("+String.format("%1.2f", getDimensione())+")";
	}//String
	@Override
	public boolean equals( Object z ) {
		if( !(z instanceof Cerchio) ) return false;
		if( z==this ) return true;
		Cerchio c=(Cerchio)z;
		return Mat.sufficientementeProssimi(getDimensione(),c.getRaggio());
	}//equals
	@Override
	public int hashCode() {
		Double d=Double.valueOf(getRaggio()); //mediatore
		return d.hashCode();
	}//hashCode
}//Cerchio
