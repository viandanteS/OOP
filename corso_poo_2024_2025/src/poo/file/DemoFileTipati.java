package poo.file;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class DemoFileTipati {
	//ambiente globale
	static enum Dir{ FORW, BACK }
	static Scanner sc=new Scanner( System.in);
	
	static void crea( String nomeF ) throws IOException{
		System.out.println("Creazione di un file di interi da tastiera");
		System.out.println("Fornisci un intero per linea e chiudi solo con INVIO.");
		try( FileOutputStream fos=new FileOutputStream(nomeF);
			 DataOutputStream dos=new DataOutputStream(fos) ){
			 for(;;) {
				 System.out.print("int> ");
				 String linea=sc.nextLine();
				 if( linea.length()==0 ) break;
				 if( linea.matches("\\-?\\d+") )
					 dos.writeInt( Integer.parseInt(linea) );
				 else
					 System.out.println(linea+" nessun intero.");
			 }
		}
	}//Crea
	
	public static void mostra( String nomeF ) throws IOException{
		System.out.println("Contenuto del file: ");
		try (FileInputStream fis=new FileInputStream(nomeF);
			 DataInputStream dis=new DataInputStream(fis) ){
			for(;;) {
				try {
					int x=dis.readInt();
					System.out.println(x);
				}catch(EOFException e) { break; }
			}
		}		
	}//mostra
	
	static boolean trovaMin( String fSource, String fTemp2, DataOutputStream temp1 ) throws IOException{
		try ( FileInputStream fs=new FileInputStream(fSource);
			  DataInputStream source=new DataInputStream(fs);
			  FileOutputStream ft2=new FileOutputStream(fTemp2);
			  DataOutputStream temp2=new DataOutputStream(ft2) ) {
			  if( source.available()==0 ) return false;
			  int min=source.readInt(), x=0;
			  for(;;) {
				 try {
					x=source.readInt();									  
					if( x<min ) {
						temp2.writeInt(min);
						min=x;
					}
					else temp2.writeInt(x);							  
				 }catch( EOFException e ) { break; }
			  }
			  temp1.writeInt(min);
		}
		return true;
	}//trovaMin
	
	static void selectionSortEsterno( String nomeF ) throws IOException{
		Dir dir=Dir.FORW;
		try ( FileOutputStream ft1=new FileOutputStream("c:\\poo-file\\temp1");
			  DataOutputStream temp1=new DataOutputStream(ft1) ) {
			boolean finito=false;
			while( !finito ) {
				switch( dir ) {
				case FORW:
					finito=!trovaMin( nomeF, "c:\\poo-file\\temp2", temp1 );
					dir=Dir.BACK;
					break;
				default:
					finito=!trovaMin( "c:\\poo-file\\temp2", nomeF, temp1 );
					dir=Dir.FORW;
				}//switch( dir )
			}//while(!finito)
		}//try esterno
		
		//manutenzione esterna dei file dopo ordinamento
		File ft2=new File("c:\\poo-file\\temp2");
		ft2.delete();
		File fs=new File(nomeF);
		fs.delete();
		File ft1=new File("c:\\poo-file\\temp1");
		ft1.renameTo(fs);
		
	}//selectionSortEsterno
	
	static boolean esiste( String nome, int x ) throws IOException{
		boolean result=false;
		try( RandomAccessFile f=new RandomAccessFile( nome, "r" ); ){
			int inf=0, sup=(int)(f.length()/4)-1; 
			for(;;){
				if( inf>sup ) break;
				int med=(inf+sup)/2;
				f.seek( med*4 );
				int elem=f.readInt();
				if( elem==x ){ result=true; break; }
				if( elem>x ) sup=med-1;
				else inf=med+1;
			}
		}
	    return result;
	}//esiste

	
	public static void main( String[] args ) throws IOException{
		System.out.println("Gestione di un file tipato di interi.");
		System.out.print("Nome file? ");
		String nomeFile=sc.nextLine();
		System.out.println("cC(rea) Invio - mM(ostra) Invio - oO(rdina) Invio - rR int Invio - solo Invio termina.");
		for(;;) {
			System.out.print(">> ");
			String command=sc.nextLine();
			if( command.length()==0 ) break;
			if( command.matches("([cCmMoO]|[rR]\\s+\\-?\\d+)") ) {
				char com=command.charAt(0); 
				com=Character.toUpperCase(com);
				switch( com ) {
					case 'C': crea(nomeFile); break;
					case 'M': mostra(nomeFile); break;
					case 'R': int i=command.lastIndexOf(' ');
					          String sx=command.substring(i+1);
					          int x=Integer.parseInt(sx);
					          boolean flag=esiste(nomeFile,x);
					          if( flag ) System.out.println(x+" e' presente.");
					          else System.out.println(x+" e' assente.");
					          break;
					default : selectionSortEsterno(nomeFile);
				}
			}
			else {
				System.out.println("Comando sconosciuto.");
			}
		}
		sc.close();
		System.out.println("Bye.");
	}//main
}//DemoFileTipati
