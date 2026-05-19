package poo.esame19022025;

import java.util.Iterator;

public abstract class GestoreEventiAbstract implements GestoreEventi {

	public String toString() {
		StringBuilder sb=new StringBuilder(200);
		for(String ev:this) {
			sb.append(ev+"[");
			Iterator<String> itPers = personePrenotateAllEvento(ev);
			while(itPers.hasNext()) {
				sb.append(itPers.next() +", ");
			}
			sb.setLength(sb.length()-2);
			sb.append("]\n");
		}
		return sb.toString();
	}
}
