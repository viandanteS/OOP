package poo.util;

public final class Mat{

	private static double EPSILON=1.0E-7;

	private Mat(){}

	public static int mcd( final int x, final int y ){
		if( x<=0 || y<=0 )
		   throw new IllegalArgumentException("Attesi parametri positivi.");
		return mcd_Euclide(x,y);
	}//mcd

	private static int mcd_Euclide( final int x, final int y ){
		if( y==0 ) return x;
		return mcd_Euclide(y,x%y);
	}//mcd_Euclide

	private static int mcd_Euclide_Iterativo( final int x,final int y ){
		int a=x, b=y, r=-1;
		do{
			r=a%b;
			a=b; b=r;
		}while( r!=0 );
		return a;
	}//mcd_Euclide_Iterativo

	public static int mcm( final int x, final int y ){
		if( x<=0 || y<=0 )
			throw new IllegalArgumentException("Attesi parametri positivi.");
		return (x*y)/mcd_Euclide(x,y);
	}//mcd

	public static boolean sufficientementeProssimi( final double x, final double y ){
		return Math.abs(x-y)<=EPSILON;
	}//sufficientementeProssimi

	public static void setEPSILON( final double EPS ){
		if( EPS<=0 ) throw new IllegalArgumentException("EPS atteso positivo");
		EPSILON=EPS;
	}//setEPSILON
	
}//Data