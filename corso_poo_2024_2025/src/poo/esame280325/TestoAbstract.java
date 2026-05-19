package poo.esame280325;

public abstract class TestoAbstract implements Testo{
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(String parola:this) {
			sb.append(" ("+parola+frequenza(parola)+") \n");
		}
		sb.setLength(sb.length()-2);
		sb.append("]");
		return sb.toString();
	}
	public boolean equals(Object x) {
		if(!(x instanceof Testo)) return false;
		if(x==this) return true;
		Testo t=(Testo)x;
		for(String p:this) {
			if(!(this.frequenza(p)==t.frequenza(p)))
				return false;
		}
		return true;
	}
	
	public int hashCode() {
		int hash=0;
		for(String p:this) {
			hash+=p.hashCode();
		}
		return hash*7;
		
	}
	

}
