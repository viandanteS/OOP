package poo.esame19022025;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public interface GestoreEventi extends Iterable<String> {
	
	//aggiunge un evento alla programmazione solleva un eccezione se l'evento esiste
	void aggiungiEvento(String nome);
	
	//cancella un evento dalla programmazione. solleva un'eccezione se l'evento non esiste
	default void cancellaEvento(String nome) {
		
		Iterator<String> it=iterator();
		while(it.hasNext()) {
			String ev = it.next();
			if(ev.equals(nome)) {
				it.remove();
				return;
			}
		}
		throw new IllegalStateException("evento inesistente");		
	}
	
	// aggiunge un partecipante da un evento. Solleva un'eccezione se l'evento non esiste o la persona è già registrata;
	void aggiungiPersonaAdEvento(String nomeEvento,String nomePersona);
	
	
	default void cancellaPersonaDallEvento(String nomeEvento, String nomePersona) {
		for(String evento:this) {
			if(evento.equals(nomeEvento)) {
				Iterator<String> persone = personePrenotateAllEvento(nomeEvento);
				while(persone.hasNext()) {
					if(persone.next().equals(nomePersona))
						persone.remove();
						return;
				}
			}
		}
		throw new IllegalStateException("Evento inesistente o persona non registrata");
		
	}
	//cancella un partecipante da un evento. Solleva un'eccezione se l'evento non esiste o la persona non è registrata
	
	Iterator<String> personePrenotateAllEvento(String nomeEvento);
	
	//restituisce gli eventi programmati sui quali una persona è prenotata mediante un set ordinato
	default Set<String> eventiPrenotati(String nomePersona){
		Set<String> ret=new TreeSet<>();
		Iterator<String> itevento=this.iterator();
		while(itevento.hasNext()) {
			Iterator<String> itpersone=personePrenotateAllEvento(itevento.next());
			while(itpersone.hasNext()) {
				if(itpersone.next().equals(nomePersona))
					ret.add(nomePersona);
			}
		}
		return ret;
		
	}
	
	
	//restituisce un set ordinato delle persone che partecipano a tutti gli eventi.
	default Set<String> personeChePartecipanoATuttiGliEventi(){
		Iterator<String> evIt=iterator();
		if(!evIt.hasNext()) throw new IllegalArgumentException("Nessun evento esistente!");
		Iterator<String> personeTmp= personePrenotateAllEvento(evIt.next());
		Set<String> ret= new HashSet<>();
		while(personeTmp.hasNext()) {
			ret.add(personeTmp.next());
		}
		while(evIt.hasNext()) {
			personeTmp= personePrenotateAllEvento(evIt.next());
			Set<String> tmp= new HashSet<>();
			while(personeTmp.hasNext()) {
				tmp.add(personeTmp.next());
			}
			ret.retainAll(tmp);
		}
		return ret;
	}
	

}
