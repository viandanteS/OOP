package poo.sistema;

import java.util.Arrays;

import poo.util.Mat;

public class GaussDiagonale extends Gauss {
	
	public GaussDiagonale( double[][] a, double[] y ) {
		super(a,y);
	}
	
	public double[] risolvi() {
		//azzero i coeff sotto la diagonale
		triangolazione();
		
		//divido riga iesima per pivot.
		pivotUnitari();
		
		//azzero i coeff sopra diag
		triangolazioneInf();
		
		
		return calcolaSoluzione();
	}
	
	protected double[] calcolaSoluzione() {
		int n=getN();
		double[] y=new double[n];
		for(int i=0;i<n;i++)
			y[i]=a[i][n];
		return y;
	}
	
	protected void pivotUnitari() {
		
		int n=getN();
		for(int j=0;j<n;j++) {
			double pivot=a[j][j];
			if( Mat.sufficientementeProssimi(pivot,0))
				throw new RuntimeException("Sistema impossibile, pivot = 0");
			for(int i=j;i<=n;i++) {
				a[j][i]= a[j][i]/pivot;
			}						
		}		
	}
	
	protected void triangolazioneInf() {
		int n=getN();
		for(int j=n-1;j>0;j--) {//con j ci muoviamo sui pivot
			//x riga da azzerare -> a[j][i]= a[j][i]-(eldaeliminare/pivot==1)*a[i
			for(int i=j-1;i>=0;i--) {//sulle righe
				if(!Mat.sufficientementeProssimi(a[i][j], 0)) {
					double coeff=a[i][j];
					for(int k=n;k>=0;k--) {//sulle colonne
						a[i][k]=a[i][k]-a[j][k]*coeff;
					}
				}
			}
		}				
	}//trianglazioneInf
			

	
	public static void main( String...arg ) {
		
		double[][] a={
				{1,5,4,3},
				{1,3,5,1},
				{2,1,8,2},
				{1,2,3,4}
		};
		double[] y= {3,7,2,3};
		Sistema s=new GaussDiagonale(a,y);
		System.out.println(s);
		
		double[] soluzioni = s.risolvi();
		System.out.println(s);
		
		for(double sol : soluzioni)
			System.out.println(String.format("%7.2f", sol));
		
		
		/**
		 try {
			double[] x=s.risolvi();
			System.out.println(s);
			System.out.println("Vettore delle incognite:");
			for( int i=0; i<a.length; ++i )
				System.out.println("x["+i+"]="+String.format("%9.2f",x[i]));
		}catch( RuntimeException e ) {
			System.out.println("Sistema Singolare.");
			System.exit(-1);
		}
		
		 */
	}//main
}
