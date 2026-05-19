package poo.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TorriDiHanoi {
	private int N;
	public enum Pin{SX,CL,DX}
	public TorriDiHanoi( int N ) {
		if( N<1 ) throw new RuntimeException(N+" deve essere >=1");
		this.N=N;
	}
	private static void sposta1Disco( Pin da, Pin a ) {
		System.out.println("Sposta 1 disco da "+da+" a "+a);
	}//sposta1Disco
	private static void muovi( int N, Pin src, Pin aux, Pin dst ) {
		if( N==1 ) sposta1Disco(src,dst);
		else {
			muovi(N-1,src,dst,aux);
			sposta1Disco(src,dst);
			muovi(N-1,aux,src,dst);
		}
	}//muovi
	public void risolvi(Pin src,Pin aux,Pin dst) {
		muovi(N,src,aux,dst);
	}//risolvi
	
	public static void main( String...args ) throws IOException{
		System.out.println("Gioco delle torri di Hanoi");
		BufferedReader br=new BufferedReader( new InputStreamReader(System.in) );
		System.out.print("N>=1 : ");
		String linea=br.readLine();
		if( !linea.matches("\\d+") ) {
			System.out.println("Nessun intero.");
		 	System.exit(-1);
		}
		int N=Integer.parseInt(linea);
		TorriDiHanoi th=new TorriDiHanoi(N);
		th.risolvi(Pin.SX, Pin.CL, Pin.DX);
	}//main
	
}//TorriDiHanoi
