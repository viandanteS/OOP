package poo.fpfpq;
import java.util.*;

public class StatisticaLL implements Statistica{
	private class Parola implements Comparable<Parola>{
		private String parola;
		private int frequenza;
		private LinkedList<Parola> adiacenze=new LinkedList<>();
		public Parola( String parola ){
			this.parola=parola;
			frequenza=1;
		}
		public String getParola(){ return parola; }
		public int getFrequenza(){ return frequenza; }
		
		public void setFrequenza( int frequenza ){
			this.frequenza=frequenza;
		}//setFrequenza
		
		public Iterator<Parola> paroleAdiacenti(){
			return adiacenze.iterator();
		}
		
		public void parolaAdiacente( String ad ) {
			Parola q=new Parola(ad);
			ListIterator<Parola> lit=adiacenze.listIterator();
			boolean flag=false;
			while( lit.hasNext() && !flag ) {
				Parola x=lit.next();
				if( q.equals(x) ) {
					x.setFrequenza( x.getFrequenza()+1 );
					flag=true;
				}
				else if( x.compareTo(q)>0 ) {
					lit.previous(); lit.add(q); flag=true;
				}
			}
			if(!flag) lit.add(q);
		}//parolaAdiacente
		
		public int frequenzaAdiacente( Parola q ) {
			for( Parola y: adiacenze )
				if( y.equals(q) ) return y.getFrequenza();
			return 0; //fittizia
		}//frequenzaAdiacente
		
		public Parola adiacentePiuFrequente() {
			int max=0;
			Parola apf=null;
			for( Parola q: adiacenze ) {
				if( q.getFrequenza()>max ) {
					max=q.getFrequenza();
					apf=q;
				}
			}
			return apf;	
		}//adiacentePiuFrequente
		
		public Parola adiacenteMenoFrequente() {
			int min=Integer.MAX_VALUE;
			Parola amf=null;
			for( Parola q: adiacenze ) {
				if( q.getFrequenza()<min ) {
					min=q.getFrequenza();
					amf=q;
				}
			}
			return amf;				
		}//adiacenteMenoFrequente
		
		public String toString(){
			String s="fp("+parola+")="+frequenza+"\n";
			for( Parola q: adiacenze )
				s=s+"fpq("+parola+","+q+")="+q.getFrequenza();
			s=s+"\n";
			return s;
		}//toString
		public boolean equals( Object o ){
			if( !(o instanceof Parola) ) return false;
			if( o==this ) return true;
			Parola p=(Parola)o;
			return this.parola.equals(p.parola);
		}//equals
		public int hashCode(){
			return parola.hashCode();
		}//hashCode
		public int compareTo( Parola p ){
			return this.parola.compareTo(p.parola);
		}//cpmpareTo
	}//Parola
	
	private LinkedList<Parola> fp=new LinkedList<>();
	
	public void arrivoParola( String par ) {
		Parola p=new Parola(par);
		ListIterator<Parola> lit=fp.listIterator();
		boolean flag=false;
		while( lit.hasNext() && !flag ) {
			Parola x=lit.next();
			if( p.equals(x) ) {
				x.setFrequenza( x.getFrequenza()+1 );
				flag=true;
			}
			else if( x.compareTo(p)>0 ) {
				lit.previous(); lit.add(p); flag=true;
			}
		}
		if(!flag) lit.add(p);		
	}//arrivoParola
	
	public void paroleConsecutive( String par, String suc ) {
		Parola p=new Parola(par), q=new Parola(suc);
		if( !fp.contains(p) || !fp.contains(q) )
			throw new IllegalArgumentException();
		ListIterator<Parola> lit=fp.listIterator();
		while( lit.hasNext() ) {
			Parola y=lit.next();
			if( y.equals(p) ) {
				y.parolaAdiacente(suc);
				break;
			}
		}
	}//paroleConsecutive
	
	public int numTotaleParole() {
		int ntp=0;
		for( Parola p: fp )
			ntp=ntp+p.getFrequenza();
		return ntp;
	}//numTotaleParole
	
	public int frequenza( String p ) {
		Parola par=new Parola(p);
		for( Parola cor: fp )
			if( cor.equals(par) ) return cor.getFrequenza();
		return 0;
	}//frequenza
	
	public int frequenzaCoppia( String p1, String q1 ) {
		Parola p=new Parola(p1), q=new Parola(q1);
		if( !fp.contains(p) || !fp.contains(q) ) throw new IllegalArgumentException();
		for( Parola x: fp ) {
			if( x.equals(p) ) {
				return x.frequenzaAdiacente(q);
			}
		}
		return 0;
	}//frequenzaCoppia
	
	public String parolaCheSeguePiuFrequente( String target ) {
		Parola tt=new Parola(target), t=null;
		if( !fp.contains(tt) ) throw new RuntimeException(target+" inesistente");
		for( Parola p: fp )
			if( p.equals(tt) ) { t=p; break; }
		Parola ppf=t.adiacentePiuFrequente();
		return ppf.getParola();		
	}//parolaCheSeguePiuFrequente
	
	public String parolaCheSegueMenoFrequente( String target ) {
		Parola tt=new Parola(target), t=null;
		if( !fp.contains(tt) ) throw new RuntimeException(target+" inesistente");
		for( Parola p: fp )
			if( p.equals(tt) ) { t=p; break; }
		Parola pmf=t.adiacenteMenoFrequente();
		return pmf.getParola();			
	}//parolaCheSegueMenoFrequente
	
	public String toString(){
		StringBuilder sb=new StringBuilder(500);
		for( Parola p: this.fp ){
			sb.append( "f("+p.getParola()+")=" );
			sb.append( String.format("%.4f%n", ((double)frequenza(p.getParola()))/numTotaleParole()) );
			Iterator<Parola> paroleAdiacenti=p.paroleAdiacenti();
			sb.append('\t');
			while( paroleAdiacenti.hasNext() ){
			    Parola q=paroleAdiacenti.next();
				sb.append("f("+p.getParola()+","+q.getParola()+")=");
				sb.append( String.format("%.4f", ((double)frequenzaCoppia(p.getParola(),q.getParola()))/p.getFrequenza()) );
				if( paroleAdiacenti.hasNext() ) sb.append(" ");
			}
			sb.append('\n');
		}
		return sb.toString();	
	}//toString
}//StatisticaLL
