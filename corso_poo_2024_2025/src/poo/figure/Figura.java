package poo.figure;
import poo.geometria.FiguraPiana;

public abstract class Figura implements FiguraPiana {//classe base o antenato di figure piane
	private double dimensione;
	protected Figura( final double dimensione ) {
		if( dimensione<=0 ) 
			throw new IllegalArgumentException("La dimensione deve essere positiva.");
		this.dimensione=dimensione;
	}
	protected double getDimensione() {
		return dimensione;
	}//getDimensione
/*	
	public abstract double perimetro(); //esempio di metodo astratto
	public abstract double area();
*/	
}//Figura
