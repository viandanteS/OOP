package poo.bag_adt;

import java.util.ArrayList;
import java.util.HashSet;


public abstract class AbstractBag<T> implements Bag<T> {

	public String toString() {
		StringBuilder sb=new StringBuilder();
		ArrayList<T> visti=new ArrayList<>();
		sb.append("[ ");
		for(T x:this) {
			if(!visti.contains(x)) {
				visti.add(x);
				sb.append(x+" ("+this.multiplicity(x)+"), ");
			}
		}
		sb.setLength(sb.length()-2);
		sb.append(" ]");
		return sb.toString();
	}
}
