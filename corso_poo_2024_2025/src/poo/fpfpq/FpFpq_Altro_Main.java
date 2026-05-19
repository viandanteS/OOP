package poo.fpfpq;
import java.util.*;
import java.io.*;

public class FpFpq_Altro_Main{
	public static void main( String[] args ) throws IOException{

		Scanner sc=new Scanner(System.in);
		String nomeFile=null;
		File f=null;
		do{
			System.out.print("Nome file testo: ");
			nomeFile=sc.nextLine();
			f=new File( nomeFile );
			if( !f.exists() ) 
				System.out.println("File "+nomeFile+" inesistente! Ridarlo");
		}while( !f.exists() );

		Statistica stat=new StatisticaMap();
		
		String ppre=null; //parola precedente
		try( BufferedReader br=new BufferedReader( new FileReader(f)) ){
			for(;;) {
				String linea=br.readLine();
				if( linea==null ) break;
				linea=linea.toUpperCase(); 
				if( linea.length()==0 ) continue;
				String[] parole=linea.split("\\W+");
				for( String pcor: parole ) {
					if( pcor.length()==0 ) continue;
					stat.arrivoParola(pcor);
					if( ppre!=null ) stat.paroleConsecutive( ppre, pcor );
					ppre=pcor;
				}
			}
		}

		System.out.print("Parola target=");
		String target=sc.nextLine().toUpperCase();
		sc.close();

		System.out.println("Statistica d'uso delle parole:");
		System.out.println(stat);
		
		PrintWriter pw=new PrintWriter( new FileWriter("c:\\poo-file\\statistica.txt"));
        pw.println( stat );
		pw.close();

		System.out.println("Parola che piu' verosimilmente segue "+target+"="+
		                   stat.parolaCheSeguePiuFrequente(target));
		System.out.println("Parola che meno verosimilmente segue "+target+"="+
		                   stat.parolaCheSegueMenoFrequente(target));

	}//main
}//FpFpq_Altro_Main