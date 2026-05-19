package poo.matrice_sparsa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatriceSparsaImpl extends MatriceSparsaAbstract{

	private Map<Integer, Map<Integer,Double>> mappaElementi;
	private int nr_righe,nr_colonne;
	private String nomeFile;
	private static Pattern pattern=Pattern.compile("i=(\\d+)\\s+j=(\\d+)\\s+v=(-?[0-9]+\\.?[0-9]*)");

//			i=(\\d+)
//			i= → indica che la stringa deve iniziare con 'i='
//			(\\d+) → \d+ significa "una o più cifre", quindi cattura un numero intero (es. 10 o 15).
//
//			Le parentesi () servono per creare un gruppo catturante, ossia memorizzare il valore.
//
//			\\s+
//			\\s+ → uno o più spazi tra i valori (j potrebbe essere separato da uno o più spazi)
//	
//			j=(\\d+)
//			j= → indica che dopo lo spazio deve comparire 'j='
//
//			(\\d+) → cattura un altro numero intero (20 o 25).
//
//			v=([0-9]+\\.?[0-9]*)
//			v= → indica che dopo lo spazio deve esserci 'v='
//
//			[0-9]+ → significa "una o più cifre", cattura la parte intera (3 in 3.14)
//
//			\\.? → il \\. significa "il carattere punto", ma è opzionale (? indica "zero o una volta").
//
//			[0-9]* → cattura eventuali cifre decimali dopo il punto (14 in 3.14).
//
//			Complessivamente, permette di catturare sia numeri interi (2) che numeri decimali (3.14).


	
	
	public MatriceSparsaImpl(int nr_righe,int nr_colonne, String nomeFile) {
		this.mappaElementi=new HashMap<Integer, Map<Integer,Double>>();
		this.nr_righe=nr_righe;
		this.nr_colonne=nr_colonne;
		File file=new File(nomeFile);
		if(!file.exists()) throw new IllegalArgumentException("File non esistente");
		try {
			FileReader fr=new FileReader(file);
			BufferedReader bf=new BufferedReader(fr);
			String linea=bf.readLine();
			while(linea!=null) {
				Matcher matcher=pattern.matcher(linea);
				if(!matcher.find()) throw new IllegalArgumentException("Linea di input non valida.");
				int i=Integer.parseInt(matcher.group(1));
				int j=Integer.parseInt(matcher.group(2));
				double value=Double.parseDouble(matcher.group(3));
				this.set(i, j, value);
				linea=bf.readLine();
			}
			
			bf.close();
			fr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private MatriceSparsaImpl(int nr_righe,int nr_colonne) {
		this.mappaElementi=new HashMap<Integer, Map<Integer,Double>>();
		this.nr_righe=nr_righe;
		this.nr_colonne=nr_colonne;
	}
	
	@Override
	public int nr_righe() {
		return nr_righe;
	}

	@Override
	public int nr_colonne() {
		return nr_colonne;
	}

	@Override
	public double get(int i, int j) {
		Map<Integer,Double> riga=mappaElementi.get(i);
		try {	
			double d=riga.get(j);
			return d;
		}catch(NullPointerException e){
			return 0;
		}
		
		
	}

	@Override
	public void set(int i, int j, double v) {
		if(v==0) {
			mappaElementi.remove(i,mappaElementi.get(i));
			return;
		}
		Map<Integer,Double> addMap;
		if((addMap=mappaElementi.get(i))==null);
			addMap=new HashMap<Integer,Double>();
		addMap.put(j, v);
		mappaElementi.put(i, addMap);
		
	}

	@Override
	public MatriceSparsa factory(int nr_righe, int nr_colonne) {
		return new MatriceSparsaImpl(nr_righe,nr_colonne);
		
	}
	
	
	
	public static void main(String[] args) {
	
		MatriceSparsaImpl m1=new MatriceSparsaImpl(3,3,"indiciMat.txt");
		MatriceSparsaImpl m2=new MatriceSparsaImpl(6,5,"indiciMat.txt");
		System.out.println(m1);
		System.out.println(m2);
		
		System.out.print(m1.mul(0));
		
		

	}

}
