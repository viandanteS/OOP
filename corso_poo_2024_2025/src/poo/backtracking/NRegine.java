package poo.backtracking;

public class NRegine {
	private int N;
	private boolean[][] board;
	private int numSol;
	private int ultimaSol=Integer.MAX_VALUE;
	public NRegine( final int N ) {
		if( N<=3 ) throw new IllegalArgumentException();
		this.N=N;
		board=new boolean[N][N]; //all false by default
	}
	public NRegine( final int N, final int US ) {
		if( N<=3 || US<=0 ) throw new IllegalArgumentException();
		this.N=N; this.ultimaSol=US;
		board=new boolean[N][N]; //all false by default
	}
	private void collocaRegina( int r ) {//r e' punto di scelta, ossia riga
		for( int c=0; c<N; ++c ) { //ciclo su tutte le possibile scelte c
			if( assegnabile(r,c) ) {
				assegna(r,c);
				if( r==N-1 ) {
					scriviSoluzione();
					if( numSol==ultimaSol ) return;
				}
				else collocaRegina(r+1);
				deassegna(r,c);
			}
		}
	}//collocaRegina
	private boolean assegnabile( int r, int c ) {
		//verifica vincoli
		//a nord
		for( int i=r-1; i>=0; --i )
			if( board[i][c] ) return false;
		//a nord-est
		for( int i=r-1,j=c+1; i>=0&&j<N; --i,++j )
			if( board[i][j] ) return false;
		//a nord-ovest
		for( int i=r-1,j=c-1; i>=0&&j>=0; --i,--j )
			if( board[i][j] ) return false;
		return true;
	}//assegnabile
	private void assegna( int r, int c ) {
		board[r][c]=true;
	}//assegna
	private void deassegna( int r, int c ) {
		board[r][c]=false;
	}//deassegna
	private void scriviSoluzione() {
		numSol++; 
		System.out.print( String.format("%4d ",numSol) );
		for( int i=0; i<N; ++i ) {
			for( int j=0; j<N; ++j )
				if( board[i][j] ) {
					System.out.print("<"+i+","+j+">");
					break;
				}
		}
		System.out.println();
		if( numSol==ultimaSol ) {
			System.out.println("Fine soluzioni.");
			System.exit(0);
		}
	}//scriviSoluzione
	public void risolvi() {
		collocaRegina(0);
	}//risolvi
	
	public static void main( String[] args ) {
		new NRegine(8).risolvi();
		System.out.println("Fine soluzioni.");
	}//main
	
}//NRegine
