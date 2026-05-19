package poo.recursion;

public class Permutazioni {
	private int[] a;
	public Permutazioni(int[] a) {
		this.a=java.util.Arrays.copyOf(a, a.length);
	}
	public void risolvi() {
		permutazioni(0);
	}//risolvi
	private void permutazioni(int i) {
		if( i==a.length )
			System.out.println( java.util.Arrays.toString(a) );
		else {
			for( int j=i; j<a.length; ++j ) {
				int park=a[i]; a[i]=a[j]; a[j]=park; //scambia a[i] con a[j]
				permutazioni(i+1);
				park=a[i]; a[i]=a[j]; a[j]=park;
			}
		}
	}//permutazioni
	
	public static void main( String...args ) {
		int[] v= {1,2,3,4};
		new Permutazioni(v).risolvi();
	}//main
	
}//Permutazioni
 