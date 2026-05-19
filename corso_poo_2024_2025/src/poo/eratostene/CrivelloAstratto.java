package poo.eratostene;

import java.util.Iterator;

public abstract class CrivelloAstratto implements Crivello{
	
	public String toString(){
		StringBuilder sb=new StringBuilder(1000);
		int c=0;
	    for( int x: this ){ //for-each con auto unboxing
		   sb.append( String.format("%8d",x) );
		   c++;
		   if( c%8==0 ) sb.append('\n');
        }
        return sb.toString();
	}//toString
	
	public boolean equals(Object x) {
		if(!(x instanceof Crivello)) return false;
		if(x==this) return true;
		Crivello c=(Crivello)x;
		if(c.size()!=this.size()) return false;
		Iterator<Integer> it= iterator();Iterator<Integer> it2= c.iterator();
		
		while(it.hasNext()) {
			if(!(it.next().equals(it2.next()))) {
				return false;
			}
		}
		return true;
	}//equals
	
	public int hashCode() {
		final int x=43;
		int h=0;
		for(Integer y:this) {
			h=h*x+y.hashCode();
		}
		return h;		
	}//hashCode
	
}//CrivelloAstratto
