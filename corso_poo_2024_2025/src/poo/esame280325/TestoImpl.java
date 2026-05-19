package poo.esame280325;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TestoImpl extends TestoAbstract {
    
	private final TreeMap<String, Integer> parole;
    
    public TestoImpl() {
        this.parole = new TreeMap<>();
    }
    
    public void add(String parola) {
        if (parola == null || parola.isEmpty()) {
            throw new IllegalArgumentException("La parola non può essere nulla o vuota");
        }
        if(parole.containsKey(parola)) {
        	parole.put(parola, parole.get(parola)+1);
        	return;
        }
        parole.put(parola, 1);
    }
    
    public int frequenza(String parola) {
        return parole.get(parola);
    }
    
	    
    @Override
    public Iterator<String> iterator() {
        return parole.keySet().iterator();
    }
    
    public Testo factory() {
    	return new TestoImpl();
    }
    
    public Testo paroleInComuneCon(Testo t) {
    	Testo ret=factory();
    	for(String par:t) {
    		if( this.parole.containsKey(par) && !(ret.frequenza(par)==0) ) {
    			ret.add(par);
    		}
    	}
    	return ret;
    }
    
    

}
