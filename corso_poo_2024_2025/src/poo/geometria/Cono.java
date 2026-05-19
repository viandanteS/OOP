package poo.geometria;

public class Cono extends Disco implements FiguraSolida {
	
	private double altezza;
	
	public Cono(final double x, final double y, final double raggio, final double altezza ) {
		super(x,y,raggio);
		if( altezza<=0 )
			throw new IllegalArgumentException("Altezza deve essere positiva.");
		this.altezza=altezza;
	}
	public Cono( final Punto p, final double raggio, final double altezza ) {
		super(p,raggio);
		if( altezza<=0 )
			throw new IllegalArgumentException("Altezza deve essere positiva.");
		this.altezza=altezza;
	}
	public Cono( final Disco d, final double altezza ) {
		super(d);
		if( altezza<=0 )
			throw new IllegalArgumentException("Altezza deve essere positiva.");
		this.altezza=altezza;		
	}//cono
	
	public Cono( final Cono c ) {
		super(c);
		this.altezza=c.altezza;
	}//cono
	
	/*public double perimetro() {
		throw new UnsupportedOperationException();
	}//perimetro
	*/
	public double area() {
		return areaDiBase()+areaLaterale();
	}//area
	
	
	@Override
	public double areaDiBase() {
		return super.area();
	}//areadibase

	@Override
	public double areaLaterale() {
		double apotema = Math.sqrt((altezza*altezza) + (this.getRaggio()*this.getRaggio()));
		return Math.PI*getRaggio()*apotema;
	}//areaLaterale

	@Override
	public double volume() {
		return (Math.PI*getRaggio()*getRaggio()*altezza)/3;
	}//volume
	
	public String toString() {
		return "Cono("+super.toString()+","+" altezza: "+altezza+")";
	}//toString

}
