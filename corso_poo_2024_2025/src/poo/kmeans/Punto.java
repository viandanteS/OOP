package poo.kmeans;

public final class Punto {
	private double x,y;
	private static final double EPS=10e-6;
	
	public Punto(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	double getX() {
		return x;
	}
	double getY() {
		return y;
	}
	public String toString() {
		return String.format("[<%.4f>,<%.4f>]",x,y);
	}
	public boolean equals(Object x) {
		if(!(x instanceof Punto)) return false;
		if(x==this)return true;
		Punto p=(Punto)x;
		return sufficientementeProssimi(this.x,p.x) && sufficientementeProssimi(this.y,p.y);
	}
	public int hashCode() {
		return (int)(x+y)*17;
	}
	public double distanza(Punto p) {
		return Math.sqrt(Math.pow(this.x-p.x, 2)+Math.pow(this.y-p.y, 2));
	}
	public Punto puntoMedio(Punto p) {
		double xM,yM;
		xM=(this.x+p.x)/2;
		yM=(this.y+p.y)/2;
		return new Punto(xM,yM);
	}
	private static boolean sufficientementeProssimi(double x1,double x2) {
		if(Math.abs(x1-x2)<=EPS) return true;
		return false;
	}
}
