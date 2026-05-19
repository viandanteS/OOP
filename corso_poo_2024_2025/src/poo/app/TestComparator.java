package poo.app;

import java.util.Comparator;

public class TestComparator {
	
	static class MioComparatore implements Comparator<String>{
		public int compare( String s1, String s2 ) {
			if( s1.length()<s2.length() ) return -1;
			if( s1.length()>s2.length() ) return 1;
			return s1.compareTo(s2);
		}
	}//MioComparatore
	
	static class MioComparatore2 implements Comparator<String>{
		public int compare( String s1, String s2 ) {
			if( s1.length()<s2.length() ) return -1;
			if( s1.length()>s2.length() ) return 1;
			return s2.compareTo(s1);
		}
	}//MioComparatore2
	
	public static void main( String[] args ) {
		String[] as= { "casa", "tana", "lupo", "dado", "abaco", "fuoco" };
		java.util.Arrays.sort( as );
		System.out.println( java.util.Arrays.toString(as) );
		java.util.Arrays.sort( as, new MioComparatore2() );
		System.out.println( java.util.Arrays.toString(as) );
	}
}
