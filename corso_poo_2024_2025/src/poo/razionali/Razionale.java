package poo.razionali;
import poo.util.Mat;

public class Razionale implements Comparable<Razionale>{
	public final int NUM, DEN;
	private static int contatore=0; //variabile di classe

	public Razionale( final int num, final int den ){
		if( den==0 ) throw new IllegalArgumentException("Denominatore nullo!");
		int nu=num, de=den;
		if( nu!=0 ){
			int cd=Mat.mcd( Math.abs(nu), Math.abs(de) );
			nu=nu/cd; de=de/cd;
		}
		if( de<0 ){
			nu=nu*(-1);
			de=de*(-1);
		}
		NUM=nu; DEN=de;
		contatore++;
	}
	public Razionale( Razionale r ){
		NUM=r.NUM; DEN=r.DEN;
		contatore++;
	}

	public static int razionaliEsistenti(){
		return contatore;
	}//razionaliCreati

	public Razionale add( Razionale r ){
		int mcm=Mat.mcm(this.DEN,r.DEN);
		return new Razionale( (mcm/DEN)*NUM+(mcm/r.DEN)*r.NUM, mcm );
	}//add
	public Razionale sub( Razionale r ){
		return this.add( r.mul(-1) );
	}//sub

	public Razionale mul( Razionale r ){
		return new Razionale( NUM*r.NUM, DEN*r.DEN );
	}//mul

	public Razionale div( Razionale r ){
		return new Razionale( NUM*r.DEN, DEN*r.NUM );
	}//div
	public Razionale mul( int s ){
		return new Razionale( NUM*s, DEN );
	}//mul

	@Override
	public String toString(){
		if( NUM==0 ) return "0";
		if( DEN==1 ) return ""+NUM;
		return ""+NUM+"/"+DEN;
	}//toString

	@Override
	public boolean equals( Object x ){
		if( !( x instanceof Razionale ) ) return false; //include anche il caso x==null
		if( x==this ) return true;
		Razionale r=(Razionale)x; //casting corretto in questi casi
		return this.NUM==r.NUM && this.DEN==r.DEN;
	}//equals

	@Override
	public int hashCode(){
		final int M=83;
		return NUM*M+DEN;
	}//hashCode

	protected void finalize(){
		contatore--;
	}//finalize

	@Override
	public int compareTo( Razionale r ){
		int cd=Mat.mcm(this.DEN,r.DEN);
		int n1=(cd/this.DEN)*this.NUM;
		int n2=(cd/r.DEN)*r.NUM;
		if( n1<n2 ) return -1;
		if( n1==n2 ) return 0;
		return 1;
	}//compareTo


}//Razionale




