package poo.esame280325;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public interface Testo extends Iterable<String> {
	
	default int size() {
		Iterator<String> it=iterator();
		int c=0;
		while(it.hasNext()) {
			it.next();
			c++;
		}
		return c;
	}
	void add(String parola);
	
	int frequenza(String parola);
	
	default String moda() { // ritorna la parola più frequente ripetuta nel testo this
		Iterator<String> it=iterator();
		String parola=it.next();
		int maxFr=frequenza(parola);
		while(it.hasNext()) {
			String tmp=it.next();
			int ftmp=frequenza(tmp);
			if(ftmp>maxFr) {
				maxFr=ftmp;
				parola=tmp;
			}
		}
		return parola;
	}
	Testo factory();
	
	default Testo paroleInComuneCon(Testo t) {
		Testo ret=factory();
		Iterator<String> thisIt= iterator();
		Iterator<String> tIt= t.iterator();
		Set<String> intersezione=new HashSet<>();
		
		while(thisIt.hasNext()) {
			intersezione.add(thisIt.next());
		}
		
		while(tIt.hasNext()) {
			String parola=tIt.next();
			if(intersezione.contains(parola)){
				ret.add(parola);
			}
		}
		return ret;		
	}
//	
//	default double similaritaCoseno(Testo t) {
//		Testo paroleincomune=paroleInComuneCon(t);
//		double prodotto=0;
//		double quoziente=0;
//		for (String parola:paroleincomune) {
//			prodotto+= this.frequenza(parola) * t.frequenza(parola);
//		}
//		for (String p:t) {
//			quoziente=Math.sqrt().frequenza(parola);
//		}
//	}
}
