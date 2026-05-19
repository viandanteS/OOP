package poo.backtracking;

import java.util.HashSet;
import java.util.Set;

public class ColorazioneMappa2{ 
	enum Colore{ROSSO,VERDE,GIALLO,NERO} 
	private int n; //numero delle nazioni/celle 
	private Set<Integer> confinanti[]; 
	private Set<Integer> stessoColore[]; 
	private int numSol; 
	public ColorazioneMappa2( Set<Integer> []confinanti ) { 
		this.n=confinanti.length; 
		this.confinanti=new HashSet[n]; 
		this.stessoColore=new HashSet[Colore.values().length]; 
		for( int i=0; i<n; ++i ) 
			this.confinanti[i]=new HashSet<>( confinanti[i] ); 
		for( int i=0; i<Colore.values().length; ++i ) 
			this.stessoColore[i]=new HashSet<>(); 
		
	}
	
    // Metodo principale per avviare la soluzione
    public void risolvi() {
        assegnaColore(0);
        System.out.println("Numero di soluzioni trovate: " + numSol);
    }

    // Metodo ricorsivo per assegnare colori
    private void assegnaColore(int i) {
        if (i == n) { // Caso base: tutte le celle colorate
            scriviSoluzione();
            numSol++;
            return;
        }

        for (Colore c : Colore.values()) { // Prova tutti i colori
            if (assegnabile(i, c)) {
                assegna(i, c); // Assegna il colore
                assegnaColore(i + 1); // Passa alla cella successiva
                deassegna(i, c); // Backtracking
            }
        }
    }

    // Controlla se un colore è assegnabile alla cella i
    private boolean assegnabile(int i, Colore c) {
        Set<Integer> confinantiCella = confinanti[i];
        Set<Integer> celleStessoColore = stessoColore[c.ordinal()];
        
        // Verifica che nessuna cella confinante abbia lo stesso colore
        for (int confinante : confinantiCella) {
            if (celleStessoColore.contains(confinante)) {
                return false;
            }
        }
        return true;
    }

    // Assegna un colore alla cella i
    private void assegna(int i, Colore c) {
        stessoColore[c.ordinal()].add(i);
    }

    // Deassegna un colore dalla cella i
    private void deassegna(int i, Colore c) {
        stessoColore[c.ordinal()].remove(i);
    }

    // Scrive la soluzione corrente
    private void scriviSoluzione() {
        StringBuilder sb = new StringBuilder("Soluzione trovata:\n");
        for (int i = 0; i < Colore.values().length; ++i) {
            Colore c = Colore.values()[i];
            sb.append(c.name()).append(": ").append(stessoColore[i]).append("\n");
        }
        System.out.println(sb);
    }
	//punti di scelta: gli indici delle celle, da 0 ad n-1
	//scelte per ogni punto di scelta: i 4 possibili colori

	/*private void assegnaColore( int i ) {
		//TODO
	}//assegnaColore
	private boolean assegnabile(int i, Colore c) {
		//verifica i vincoli
		return false; //TODO
	}//assegnabile
	private void assegna(int i, Colore c) {
		//TODO
	}//assegna
	private void deassegna(int i, Colore c) {
		//TODO
	}//deassegna
	private void scriviSoluzione() {
		//TODO
	}//scriviSoluzione
	public void risolvi(){ 
		assegnaColore(0); 
	}//risolvi*/
    
	public static void main( String[] args ) { 
		int n=6; //esempio 
		Set<Integer> conf[]=new HashSet[n]; 
		//esempio di confinanze 
		conf[0]=new HashSet<>( java.util.Arrays.asList(1,4)); 
		conf[1]=new HashSet<>( java.util.Arrays.asList(0,4,5,2)); 
		conf[2]=new HashSet<>( java.util.Arrays.asList(1,5,3)); 
		conf[3]=new HashSet<>( java.util.Arrays.asList(2)); 
		conf[4]=new HashSet<>( java.util.Arrays.asList(0,1,5)); 
		conf[5]=new HashSet<>( java.util.Arrays.asList(1,2,4)); 
		ColorazioneMappa2 cm=new ColorazioneMappa2( conf ); 
		cm.risolvi(); 
	}//main 
}//ColorazioneMappa
