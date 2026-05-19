package poo.polinomi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PolinomioAL extends PolinomioAstratto {

	private ArrayList<Monomio> contenuto=new ArrayList<>();
	
	public int size() {
		return contenuto.size();
	}
	
	public void add(Monomio m) {
		if(m.coeff()==0)return;
		int i=Collections.binarySearch(contenuto, m);
		if(i>=0) {
			Monomio x= new Monomio(contenuto.get(i).coeff()+m.coeff(),m.grado());
			if(x.coeff()!=0)contenuto.set(i, x);
			else contenuto.remove(i);
		}
		else {
			i=0;
			while(i<contenuto.size() && contenuto.get(i).compareTo(m)<0) {//se il grado di this è più piccolo di m.grado ritorna 1
				i++;
			}
			contenuto.add(i, m);
		}		
	}//add

	@Override
	public PolinomioAL factory() {return new PolinomioAL();}//factory

	@Override
	public Iterator<Monomio> iterator() {
		// TODO Auto-generated method stub
		return contenuto.iterator();
	}
	
	public static void main( String[] main ) {
		Monomio m1=new Monomio(3,5);
		Monomio m2=new Monomio(-3,3);
		Monomio m5=new Monomio(-1,0);
		Monomio m6=new Monomio(-5,0);
		var pol1=new PolinomioAL();
		
		pol1.add(m1);
		pol1.add(m5);
		pol1.add(m2);
		pol1.add(m6);
		System.out.println(pol1);
		
	}

}
