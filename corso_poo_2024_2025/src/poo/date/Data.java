package poo.date;
import java.util.GregorianCalendar;

public class Data implements Comparable<Data>{
	private final int G, M, A;

	public enum COSA {GIORNO, MESE, ANNO};

	public Data(){
		GregorianCalendar gc=new GregorianCalendar();
		G=gc.get(GregorianCalendar.DAY_OF_MONTH);
		M=gc.get(GregorianCalendar.MONTH)+1;
		A=gc.get(GregorianCalendar.YEAR);
	}

	public Data( final int G, final int M, final int A ){
		if( G<1 || G>durata(M,A) || M<1 || M>12 || A<0 )
			throw new IllegalArgumentException();
		this.G=G; this.M=M; this.A=A;
	}

	public Data( Data d ){
		G=d.G; M=d.M; A=d.A;
	}

	public int get( COSA cosa ){
		switch( cosa ){
			case GIORNO: return G;
			case MESE: return M;
			default: return A;
		}
	}//get

	public static boolean bisestile( final int A ){
		if( A%4!=0 ) return false;
		if( A%100==0 && A%400!=0 ) return false;
		return true;
	}//bisestile

	public static int durata( final int M, final int A ){
		int dur=0; //fittizio
		switch( M ){
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: dur=31; break;
			case 2: dur=bisestile(A)?29:28; break;
			default: dur=30;
		}//switch
		return dur;
	}//durata

	public Data giornoDopo(){
		int g=G, m=M, a=A; //del giorno dopo - inizializzazione di default
		if( g==durata(M,A) ){
			g=1;
			if( M==12 ){
				m=1; a=A+1;
			}
			else{
				m=m+1;
			}
		}
		else g=G+1;
		return new Data(g,m,a);
	}//giornoDopo

	@Override
	public String toString(){
		String s="";
		if( G<10 ) s=s+"0";
		s=s+G+"/";
		if( M<10 ) s=s+"0";
		s=s+M+"/"+A;
		return s;
	}//toString

	@Override
	public boolean equals( Object o ){
		if( !( o instanceof Data ) ) return false;
		if( o==this ) return true;
		Data d=(Data)o;
		return this.G==d.G && this.M==d.M && this.A==d.A;
	}//equals

	@Override
	public int hashCode(){
		final int PRIMO=43;
		int h=0;
		h=h*PRIMO+G;
		h=h*PRIMO+M;
		h=h*PRIMO+A;
		return h;
	}//hashCode

	public int compareTo( Data d ){
		if( this.A<d.A || this.A==d.A && this.M<d.M || this.A==d.A && this.M==d.M && this.G<d.G ) return  -1;
		if( this.A==d.A && this.M==M && this.G==d.G ) return 0;
		return 1;
	}//compareTo

	public static void main(String[] args){
		Data oggi=new Data();
		System.out.println("Oggi e' il "+oggi);
		System.out.println("Domani e' il "+oggi.giornoDopo());
		System.out.println("L'anno 2024 e' bisestile? "+Data.bisestile(2024));

		int mese=oggi.get(Data.COSA.MESE);
		System.out.println("MESE di oggi="+mese);
	}//main
}//Data