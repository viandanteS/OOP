package poo.esame280325;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Applicazione {

	public static void main(String...Args) {
    
		String file1,file2;
		Scanner sc=new Scanner(System.in);
		System.out.println("Inserisci nome del primo file: ");
		file1=sc.nextLine();
		System.out.println("Inserisci nome del secondo file: ");
		file2=sc.nextLine();
		
		File f1=new File(file1);
		File f2=new File(file2);
		
		if(!f1.exists()) throw new RuntimeException("File inesistente.");
		if(!f2.exists()) throw new RuntimeException("File inesistente.");
		
		Testo t1=leggiFile(file1);
		Testo t2=leggiFile(file2);
		
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		
		//t1.similaritaCoseno(t2); //non completato nell'esercizio 1. :(
		
		
    }
	private static Testo leggiFile(String file) {
		Testo ret=new TestoImpl();
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			String linea;
			while((linea=br.readLine())!=null) {
				String[] tokens = linea.split("\\W+");
				for(String token:tokens) {
					ret.add(token.toUpperCase());
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
