package poo.geometria;

public class Punto{
    private double x, y; //variabili di istanza - campi o attributi
    public Punto(){//costruttore di default
		this(0,0);
    }
    public Punto( double x, double y ){//costruttore canonico o normale
		this.x=x; this.y=y;
    }
    public Punto( Punto p ){//costruttore di copia
        this.x=p.x; this.y=p.y;
    }
    //metodi accessori
    public double getX(){
        return this.x;
    }//getX
    public double getY(){
        return this.y;
    }//getY

    public double distanza( Punto p ){//metodo accessore
        return Math.sqrt( (p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y) );
    }//distanza

    public void muovi( double x, double y ){ //metodo mutatore
        this.x=x; this.y=y;
    }//muovi

    public String toString(){
        return "Punto("+String.format("%1.2f",x)+","+String.format("%1.2f",y)+")";
    }//toString

}//Punto