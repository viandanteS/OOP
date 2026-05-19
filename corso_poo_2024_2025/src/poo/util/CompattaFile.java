package poo.util;

import poo.file.DemoFileTipati;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CompattaFile {
    public static void compatta(String nomeFile) {
    	
        try {
            // Lettura del file e caricamento su LinkedList
            LinkedList<Integer> lista = new LinkedList<>();
            FileInputStream fis = new FileInputStream(nomeFile);
            DataInputStream dis = new DataInputStream(fis);
            
            while (fis.available() > 0) {                
            	lista.add(dis.readInt());
            }
            dis.close();
            fis.close();
            
            // Rimozione duplicati con LinkedList e ListIterator
            HashSet<Integer> set = new HashSet<>();
            ListIterator<Integer> iter = lista.listIterator();
            while (iter.hasNext()) {
                Integer num = iter.next();
                if (!set.add(num)) {
                   iter.remove();
                }
            }
           
            // Scrittura del file compattato
            FileOutputStream fos = new FileOutputStream(nomeFile);
            DataOutputStream dos = new DataOutputStream(fos);
            for (Integer num : lista) {
            	dos.writeInt(num);
            }
            dos.close();
            fos.close();
	        }
        	catch (IOException e) { /*| ClassNotFoundException e*/
	        	e.printStackTrace();
        	}
   }
    
    public static void main(String[] args) throws IOException {
        String nomeFile = "numeri.dat";
        
        File f1=new File(nomeFile);
        
        int[] scarico= {1,2,3,4,5,2,3,4,6,1,2,4};
        FileOutputStream fos= new FileOutputStream(nomeFile);
        DataOutputStream dos= new DataOutputStream(fos);
        for(int x:scarico) {
        	dos.writeInt(x);
        }
        dos.close();
                        
        compatta(nomeFile);
        DemoFileTipati.mostra(nomeFile);
    }
}


