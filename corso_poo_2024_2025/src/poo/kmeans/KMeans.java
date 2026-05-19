package poo.kmeans;

import java.io.BufferedReader;
import java.util.Random;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class KMeans {

	private Map<Punto,Integer> dataSet;
	private List<Punto> centroidi;
	private int K;
	
	public KMeans(String nomeFile, int K) {
		this.dataSet=new HashMap<>();
		this.K=K;
		this.centroidi=new ArrayList<>();
		File file=new File(nomeFile);
		if(!file.exists()) throw new IllegalArgumentException("File inesistente");
		try {
			BufferedReader br=new BufferedReader(new FileReader(nomeFile));
			String linea;
			double x,y;
			while((linea=br.readLine())!=null) {
				StringTokenizer st=new StringTokenizer(linea,"< >");
				x=Double.parseDouble(st.nextToken());
				y=Double.parseDouble(st.nextToken());
				dataSet.put(new Punto(x,y) , -1);
			}
			br.close();
			List<Punto> randomForCentroidi=new ArrayList<>(dataSet.keySet());
			Collections.shuffle(randomForCentroidi);
			int nCentroidiCaricamento=Math.min(K, dataSet.size());
			for(int i=0;i<nCentroidiCaricamento;i++) {
				centroidi.add(randomForCentroidi.get(i));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	void run(int maxIte) {
		
		for(int i=0;i<maxIte;i++) {
			for(Punto p:dataSet.keySet()) {
				int indexCentroide=-1;
				double distanzaMin=Double.MAX_VALUE,tmp;
				for(int l=0;l<centroidi.size();l++) {
					Punto c=centroidi.get(l);
					tmp=c.distanza(p);
					if(distanzaMin>tmp) {
						indexCentroide=l;
						distanzaMin=tmp;
					}
				}
				dataSet.put(p, indexCentroide);	//assegnamento del punto al cluster con distanza minima dal centroide		
			}
		}
		
	}
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[ ");
		for(Punto p:centroidi) {
			sb.append(p.toString()+", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(" ]");
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		DataSet.crea("dataset.txt", 1000, 500, 1500);
		KMeans km=new KMeans("dataset.txt",4);
		
		System.out.println(km);
		File f1=new File("centroidi.txt");
		if(!f1.exists()) f1.createNewFile();
		
		FileWriter fw=new FileWriter(f1);
		DataSet.crea("centroidi.txt", 4, 500, 1500);
		
		
		
	}

}
