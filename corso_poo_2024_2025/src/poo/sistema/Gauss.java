package poo.sistema;

import poo.util.Mat;

public class Gauss extends Sistema{
	
	protected double[][] a; //n*(n+1)
	
	public Gauss( double[][] a, double[] y ) {
		super(a,y);
		int n=getN();
		this.a=new double[n][n+1]; //non vogliamo aliasing
		for( int i=0; i<n; ++i ) {
			this.a[i]=java.util.Arrays.copyOf(a[i], n+1);
			this.a[i][n]=y[i];
		}
	}
	
	public double[] risolvi() {
		triangolazione();
		return calcolaSoluzione();
	}//risolvi
	
	protected void triangolazione() {
		int n=getN();
		for( int j=0; j<n; ++j ) {//<j,j> è un elemento pivot
			if( Mat.sufficientementeProssimi(a[j][j],0) ) {//occorre eliminare lo zero dal pivot
				int p=j+1;
				for( ; p<n; ++p )
					if( !Mat.sufficientementeProssimi(a[p][j],0) ) break;
				if( p==n ) throw new RuntimeException("Sistema Singolare!");
				//scambiare a[j] con a[p]
				double[] tmp=a[j];
				a[j]=a[p]; a[p]=tmp;
			}
			//azzeriamo ora tutti i coefficienti sotto <j,j>
			for( int i=j+1; i<n; ++i ) {
				if( !Mat.sufficientementeProssimi(a[i][j],0) ) {
					//sottraiamo dalla riga i la riga j moltiplicata per coeff
					double coeff=a[i][j]/a[j][j];
					for( int k=j; k<=n; ++k )
						a[i][k]=a[i][k]-a[j][k]*coeff;
				}
			}
		}
	}//triangolazione
	
	protected double[] calcolaSoluzione() {
		int n=getN();
		double[] x=new double[n];
		for( int i=n-1; i>=0; --i ) {
			double sm=a[i][n];
			//porta a secondo membro tutti i termini di incognite già calcolate
			for( int j=i+1; j<n; ++j ) sm=sm-a[i][j]*x[j];
			x[i]=sm/a[i][i];
		}
		return x;
	}//calcolaSoluzione
	
	protected double det( ) {
		int n= getN();
		double det=a[0][0];
		for(int i=1;i<n;i++) {
			det*=a[i][i];
		}
		return det;
			
	}
	
	public String toString() {    
		var sb=new StringBuilder(200);
		int n=getN();
		for( int i=0; i<n; ++i ) {
			for( int j=0; j<=n; ++j )
				sb.append(String.format("%9.2f", a[i][j]));
			sb.append("\n");
		}
		return sb.toString();
	}//toString
	
	public static void main( String...arg ) {
		double[][] a={
				{1,5,4,3},
				{1,3,5,1},
				{2,1,8,2},
				{1,2,3,4}
		};
		double[] y= {3,7,2,3};
		var s=new Gauss(a,y);
		System.out.println(s);
		try {
			double[] x=s.risolvi();
			System.out.println(s);
			System.out.println("Vettore delle incognite:");
			for( int i=0; i<a.length; ++i )
				System.out.println("x["+i+"]="+String.format("%6.2f",x[i]));
		}catch( RuntimeException e ) {
			System.out.println("Sistema Singolare.");
			System.exit(-1);
		}
	}//main
	
}//Gauss
