package poo.recursion;

public final class Recursion {
	private Recursion() {}
	
	public static boolean palindroma( String s ) {
		if( s==null ) throw new IllegalArgumentException();
		return ePalindroma(s);
	}//palindroma
	private static boolean ePalindroma(String s) {
		if( s.length()<=1 ) return true;
		if( s.charAt(0)!=s.charAt(s.length()-1) ) return false;
		return ePalindroma( s.substring(1,s.length()-1) );
	}//ePalindroma
	private static boolean ePalindromaIte( String s ) {
		int i=0, j=s.length()-1;
		while( i<j ) {
			if( s.charAt(i)!=s.charAt(j) ) return false;
			i++; j--;
		}
		return true;
	}//ePalindromaIte
	
	public static void scriviInverso( int x ) {
		//TODO
	}//scriviInverso
	
	public static int max( int[] a ) {
		if( a==null ) throw new IllegalArgumentException();
		return max(a,0,a.length-1);
	}//max
	private static int max( int[] a, int inf, int sup ) {
		if( inf==sup ) return a[inf];
		int med=(inf+sup)/2;
		int max1=max(a,inf,med);
		int max2=max(a,med+1,sup);
		return max1>max2?max1:max2;
	}//max
	
	public static int sum( int[] a ) {
		
		return sum(a,a.length); 
	}//sum
	private static int sum(int[]a,int index) {//non ricorsivo
		if(index==0)
			return 0;
		return a[index-1]+sum(a,index-1);
		
	}
//
//	public static int sumD( int[] a ) {
//		int inf=0;
//		int sup=a.length/2-1;
//		return sumD(a,inf,sup); 
//	}//sum
//	private static int sumD(int[] a,int inf,int sup) {
//		if(inf==a.length/2 && sup==a.length-1) {
//			return a[inf]+a[sup];
//		}
//		int somma=a[inf]+a[sup];
//		return somma+sumD(a,inf+1,sup+1);		
//	}
	
	public static void main( String...args ) {
		int[] v= {8,-1,5,12,34,4,7,8};
		System.out.println("Somma= "+sum(v));
		System.out.println("max="+max(v));
		System.out.println("palindroma radar? "+palindroma("radar"));
	}//main
	
}//Recursion
