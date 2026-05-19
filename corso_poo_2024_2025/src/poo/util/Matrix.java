package poo.util;

public final class Matrix{

	//DA COMPLETARE PER ESERCIZIO

	private Matrix(){}

	public static String toString( double[][] a ){
		String s="";
		for( int i=0; i<a.length; ++i ){
			//s=s+java.util.Arrays.toString(a[i])+"\n";
			for( int j=0; j<a[i].length; ++j )
				s=s+String.format( "%9.2f",a[i][j] );
			s=s+"\n";
		}
		return s;
	}//toString

	public static double[][] minore( double[][] a, int i, int j ){
		//FACCIAMO TUTTI I CONTROLLI
		for( int r=1; r<a.length; ++r ){
			if( a[r].length != a[0].length )
				throw new IllegalArgumentException("Matrice irregolare per il metodo minore.");
		}
		if( i<0 || i>=a.length || j<0 || j>=a[0].length )
			throw new IllegalArgumentException("Indici scorretto per il metodo minore.");

		double[][] m=new double[a.length-1][a[0].length-1];

		for( int r=0; r<a.length; ++r ){//r e c si muovono sulla matrice originale a[][]
			for( int c=0; c<a[r].length; ++c ){
				if( r<i && c<j ) m[r][c]=a[r][c];
				else if( r<i && c>j ) m[r][c-1]=a[r][c];
				else if( r>i && c<j ) m[r-1][c]=a[r][c];
				else if( r>i && c>j ) m[r-1][c-1]=a[r][c];
			}
		}
		return m;

	}//minore
	
	public static double determinante( double[][] a ) {
		
		//controllare che a sia quadrata
		if(a.length!=a[0].length) throw new IllegalArgumentException("Matrice non quadrata");
		int n=a.length;
		//copiare a in una matrice m locale
		double[][] m=new double[n][n];
		for(int i=0;i<n;i++) {
			m[i]=java.util.Arrays.copyOf(a[i], n);
		}
		double d=1;
		int cs=0;
		//triangolarizza a incrementando cs ad ogni scambio tra due righe
		for(int j=0;j<n;j++) {
			if(Mat.sufficientementeProssimi(m[j][j], 0)) {//cerco elementi 0 sulla diagonale (se lo trovo cerco una riga con elemento non nullo)
				int i=j+1;
				for(;i<n;i++) {
					if(!Mat.sufficientementeProssimi(m[i][j],0)) {
						cs++;
						break; //se trovo un elem non nullo sotto alla diagonale scambialo e cs++
					}
				double[] tmp=m[j];
				m[j]=m[i];
				m[i]=tmp;
				}
			if(i==n) return 0;
			}
			//occorre ora azzerare gli elementi sotto la diag principale
			for(int i=j+1;i<n;i++) {
				double coeff=m[i][j]/m[j][j];
				for(int k=0;k<n;k++) {
					m[i][k]=m[i][k]-coeff*m[j][k];
				}
			}
		}		
		//fai produttoria della diagonale principale di a triangolare e sia d
		for(int j=0;j<n;j++)
			d=d*m[j][j];
		//se cs è dispari, allora fai d=d*(-1)
		if(!(cs%2==0))
			d=d*-1;	

		return d;
	}//determinante


	/**
	 * 		{3.2,-5,4.7,8.9,5.6},
			{13.4,15,10.2,12,-3},
			{14.9,10.2,-4,-7.8,2.5},
			{4.8,5.9,14.2,-3.89,15.2},
			{0,5.7,7.8,89,-25.6}
			{13.2,55,34.7,98.9,-1}
	 */
	public static void main( String[] args ){
		double[][] m={
				{3.2,-5,4.7,8.9,5.6},
				{13.4,15,10.2,12,-3},
				{14.9,10.2,-4,-7.8,2.5},
				{4.8,5.9,14.2,-3.89,15.2},
				{0,5.7,7.8,89,-25.6}
//				{13.2,55,34.7,98.9,-1}
		};
		
		System.out.println("Matrice originaria:");
		System.out.println( toString(m) );
		//double[][] q=minore(m,2,3);
		//System.out.println("Minore rimuovendo la 3 riga e la 4 colonna:");
		//System.out.println( toString(q) );
		System.out.println("Det="+String.format("%9.2f", determinante(m)) );
	}//main

}//Matrix