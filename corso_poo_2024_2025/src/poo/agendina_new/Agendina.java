package poo.agendina_new;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public interface Agendina extends Iterable<Nominativo>{
	default int size() {
		Iterator<Nominativo> it=iterator();
		int c=0;
		while( it.hasNext() ) {
			it.next();
			c++;
		}
		return c;
	}//size
	default void svuota() {
		Iterator<Nominativo> it=iterator();
		while( it.hasNext() ) {
			it.next(); it.remove();
		}
	}//svuota
	void aggiungi( Nominativo n );
	default void rimuovi( Nominativo n ) {
		Iterator<Nominativo> it=iterator();
		while( it.hasNext() ) {
			Nominativo x=it.next();
			if( x.equals(n) ) { it.remove(); return; }
			if( x.compareTo(n)>0 ) return;
		}
	}//rimuovi
	default Nominativo cerca( Nominativo n ) {
		for( Nominativo x: this ) {
			if( x.equals(n) ) return x;
			if( x.compareTo(n)>0 ) break;
		}
		return null;
	}
	default Nominativo cerca( String prefisso, String telefono ) {
		for( Nominativo x: this ) {
			if( x.prefisso().equals(prefisso) && x.telefono().equals(telefono) ) return x;
		}
		return null;		
	}//cerca
	default void salva( String nomeFile ) throws IOException{
		PrintWriter pw=new PrintWriter( new FileWriter(nomeFile) ); //apertura in scrittura di un file testuale
		for( Nominativo n: this )
			pw.println(n);
		pw.close();
	}//salva
	default void ripristina( String nomeFile ) throws IOException{
		BufferedReader br=new BufferedReader( new FileReader(nomeFile) ); //apertura in lettura di un file testuale
	    String cog=null, nom=null, pre=null, tel=null;
	    this.svuota();
	    for(;;) {
	    	String linea=br.readLine();
	    	if( linea==null ) break;
	    	StringTokenizer st=new StringTokenizer(linea," -");
	    	cog=st.nextToken(); nom=st.nextToken(); pre=st.nextToken(); tel=st.nextToken();
	    	this.aggiungi( new Nominativo(cog,nom,pre,tel) );
	    }
	    br.close();
	}//ripristina
}//Agendina
