package poo.bag_adt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

public interface Bag<T> extends Iterable<T> {
	
	default int cardinality() {
		Iterator<T> it= iterator();
		int counter=0;
		while(it.hasNext()) {
			counter++;
			it.next();
		}
		return counter;
	}
	
	default void clear() {
		Iterator<T> it=iterator();
		while(it.hasNext()) {
			it.remove();
		}
	}
	
	default int multiplicity(T x) {
		Iterator<T> it=iterator();
		int counter=0;
		while(it.hasNext()) {
			if(it.next().equals(x))
				counter++;
		}
		return counter;
	}
	void add(T x);
	
	default void add(T x, int multiplicity) {
		for(int i=0;i<multiplicity;i++) {
			this.add(x);
		}
	}
	default void addAll(Bag<T>b) {
		
		for(T x:this) {
			this.add(x,multiplicity(x));
		}
	}
	
	default boolean remove(T x) {
		Iterator<T> it=iterator();
		while(it.hasNext()) {
			if(it.next().equals(x)) {
				it.remove();
				return true;
			}
		}
		return false;
	}
	default boolean removeAll(T x) {
		Iterator<T> it=iterator();
		boolean rimossi=false;
		while(it.hasNext()) {
			if(it.next().equals(x)) {
				it.remove();
				rimossi=true;
			}
		}
		return rimossi;
	}
	Bag<T> factory();
	
	Bag<T> factory(Comparator<T> c);
	
	default boolean included(Bag<T> b) {
		for(T x:this) {
			int xMul=this.multiplicity(x);
			int bxMul=b.multiplicity(x);
			if(xMul>bxMul) {
				return false;
			}
		}
		return true;		
	}
	default Bag<T> union(Bag<T> b) {
		Bag<T> ret=factory();
		HashSet<T> visti=new HashSet<>();
		for(T x:b) {
			visti.add(x);
		}
		for(T x:this) {
			visti.add(x);
		}
		for(T x:visti) {
			for(int i=0;i<Math.max(this.multiplicity(x), b.multiplicity(x));i++) {
				ret.add(x);
			}
		}
		return ret;
	}
	default Bag<T> difference(Bag<T> b) {
		Bag<T> ret=factory();
		ArrayList<T> o=new ArrayList<>();
		for(T x:this) {
			o.add(x);
		}
		for(T x:b) {
			if(o.contains(x)) {
				o.remove(x);				
			}
		}
		for(T x:o) {
			ret.add(x);
		}
		return ret;			
	}
		
		
	
	default Bag<T> intersection(Bag<T> b) {
		Bag<T> ret=factory();
		HashSet<T> comuni=new HashSet<>();
		HashSet<T> tmp2=new HashSet<>();
		for(T x:this) {
			comuni.add(x);
		}
		for(T x:b) {
			tmp2.add(x);
		}
		comuni.retainAll(tmp2);
		for(T x:comuni) {
			for(int i=0;i<Math.min(this.multiplicity(x),this.multiplicity(x));i++) {
				ret.add(x);
			}
		}
		return ret;
	}
	
}
