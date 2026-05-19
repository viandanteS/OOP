package poo.bag_adt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class BagImpl<T> extends AbstractBag<T> {

	private Map<T,Integer> bag;
	
	
	
	public BagImpl() {
		this.bag=new TreeMap<>();		
	}
	private BagImpl(Comparator<T> c) {
		this.bag=new TreeMap<>(c);
	}
	
	public int multiplicity(T x) {
		return bag.get(x);
	}

	@Override
	public void add(T x) {
		if(bag.containsKey(x)) {
			bag.put(x, bag.get(x)+1);
			return;
		}
		bag.put(x, 1);		
	}

	@Override
	public Bag<T> factory() {
		return new BagImpl();
	}

	@Override
	public Bag<T> factory(Comparator<T> c) {
		return new BagImpl(c);
	}
	
	@Override
	public Iterator<T> iterator() {
		return bag.keySet().iterator();
	}

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		Bag<String> bag=new BagImpl<>(new Comparator<String> () {
			public int compare(String arg0, String arg1) {
				if(arg0.length()<arg1.length()) return -1;
				else if(arg0.length()>arg1.length()) return 1;
				return arg0.compareTo(arg1);
			}
		});
		Bag<Integer> bagInteger=new BagImpl<>();
		
		bagInteger.add(5, 3);
		bagInteger.add(2,6);
		bagInteger.add(5);
		System.out.println(bagInteger);
		bagInteger.remove(2);
		System.out.println(bagInteger);
//		System.out.println("Inserire nome file: ");
//		String nomeFile=sc.nextLine();
//		File f=new File(nomeFile+".txt");		
//		BufferedReader br=new BufferedReader(new FileReader(f));
//		String linea;
//		
//		for(;;) {
//			linea=br.readLine();
//			if(linea==null)break;
//			bag.add(linea);
//		}
//		
//		
//		sc.close();
//		System.out.println(bag);

	}



}
