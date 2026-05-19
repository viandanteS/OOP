package poo.esame19022025;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Iterator;

public class GestoreEventiImpl extends GestoreEventiAbstract{
	    
	private Map<String, TreeSet<String>> eventi=new TreeMap<>();
	
	public void aggiungiEvento(String Nome) {	
		if(eventi.containsKey(Nome))
				throw new IllegalStateException("Evento gia esistente");
		eventi.put(Nome, new TreeSet<String>());
	}
	
	public Iterator<String> iterator(){
		return eventi.keySet().iterator();
	}

	@Override
	public void aggiungiPersonaAdEvento(String nomeEvento, String nomePersona) {
		if(eventi.containsKey(nomeEvento) && !eventi.get(nomeEvento).contains(nomePersona)) {
			eventi.get(nomeEvento).add(nomePersona);
		}else {
			throw new IllegalStateException(" Evento Inesistente o Persona già registrata");
		}
	}

	@Override
	public void cancellaPersonaDallEvento(String nomeEvento, String nomePersona) {
		
		if(eventi.containsKey(nomeEvento) && !eventi.get(nomeEvento).contains(nomePersona)) {
			eventi.get(nomeEvento).remove(nomePersona);
		}else {
			throw new IllegalStateException(" Evento Inesistente o Persona già registrata");
		}
	}

	@Override
	public Iterator<String> personePrenotateAllEvento(String nomeEvento) {
		return eventi.get(nomeEvento).iterator();
	}

	@Override
	public Set<String> eventiPrenotati(String nomePersona) {
		Set<String> ret=new TreeSet<>();
		for(String evento:eventi.keySet()) {
			if(eventi.get(evento).contains(nomePersona)) {
				ret.add(evento);
			}
		}
		return ret;
	}
	
	
}
