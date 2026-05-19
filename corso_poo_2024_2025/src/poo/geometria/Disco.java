package poo.geometria;

public class Disco extends Punto implements FiguraPiana{
	private double raggio;

	//PER SEMPLICITA' NON SI FANNO CONTROLLI ...
	public Disco( double raggio ){
		super(); //invoca il costruttore di default di Punto
		this.raggio=raggio;
	}
	public Disco( double x, double y, double raggio ){
		super(x,y);
		this.raggio=raggio;
	}
	public Disco( Punto p, double raggio ){
		super(p);
		this.raggio=raggio;
	}
	public Disco( Disco d ){
		super( d.getX(),d.getY() );
		this.raggio=d.raggio;
	}

	public double getRaggio(){ return raggio; }

	@Override
	public double perimetro(){ return 2*Math.PI*raggio; }
	public double area(){ return raggio*raggio*Math.PI; }

	@Override
	public String toString(){
		return "Disco("+super.toString()+" raggio="+raggio+")";
	}//toString

}//Disco