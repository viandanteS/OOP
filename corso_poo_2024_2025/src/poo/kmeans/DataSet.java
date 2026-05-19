package poo.kmeans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class DataSet {
	
	private static double x,y;

	public static void crea(String file,int N,int MAX,int MIN) {
		Map<Punto,Integer> dataSetRet=new HashMap<>();
		File f=new File(file);
		
		try {
			if(!f.exists()) { f.createNewFile();}
			BufferedWriter bw= new BufferedWriter(new FileWriter(file));
			for(int i=0;i<N;i++) {
				x=Math.random()*(MAX-MIN)+MIN;
				y=Math.random()*(MAX-MIN)+MIN;
				bw.write("<"+x+">"+"<"+y+">");
				bw.newLine();
				bw.flush();
			}
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
