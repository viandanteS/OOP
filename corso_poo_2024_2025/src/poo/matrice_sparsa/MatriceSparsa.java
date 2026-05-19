package poo.matrice_sparsa;

import poo.util.*;

public interface MatriceSparsa{
	
	int nr_righe();
	
	int nr_colonne();
	
	double get( int i, int j ); //restituisce il valore dell’elemento <i,j>
	
	void set( int i, int j, double v ); //assegna v all’elemento <i,j>. Attne se v=0.
	
	default MatriceSparsa add( MatriceSparsa ms ) {//crea e ritorna una nuova matrice this+ms
		if(this.nr_righe()!=ms.nr_righe() && this.nr_colonne()!=ms.nr_colonne()) {
			throw new IllegalArgumentException("Matrici di ordine diverso");
		}
		MatriceSparsa ret = factory(this.nr_righe(),this.nr_colonne());
		
		for(int i=0;i<this.nr_righe();i++) {
			for(int j=0;j<this.nr_colonne();j++) {
				double v=this.get(i, j)+ms.get(i, j);
				if(v!=0) {
					ret.set(i, j, v);
				}
			}
		}
		return ret;
		
	}
	default MatriceSparsa mul( MatriceSparsa ms ) {	//crea e ritorna una nuova matrice this*ms (colonna*riga) mxn * nxk = m*k;
		if(this.nr_colonne()!=ms.nr_righe())
			throw new IllegalArgumentException("Operazione non supportata! nr righe diverso dal nr colonne");
		MatriceSparsa ret=factory(this.nr_righe(),ms.nr_colonne());
		for(int i=0;i<this.nr_righe();i++) {
			for(int j=0;j<this.nr_colonne();j++) {
				double somma=0;
				for(int k=0;k<ms.nr_righe();j++) {//qua effettuo riga*colonna
					somma+=this.get(i, k)*ms.get(k,j);
				}
				if(somma!=0) {
					ret.set(i, i, somma);					
				}
			}
			
		}
		return ret;
	
	}

//	1 2 3 | 3 6 5
//	1 2 3 | 3 6 5
//	1 2 3 | 3 6 5
	
	
	default MatriceSparsa mul( double scalare ){//crea e ritorna una nuova matrice this*scalare
		MatriceSparsa ret=copia();
		for(int i=0;i<ret.nr_righe();i++) {
			for(int j=0;j<ret.nr_colonne();j++) {
				double d=(scalare*ret.get(i, j));
				if(d!=0)
					ret.set( i, j, d );
			}
		}
		return ret;
	}
	MatriceSparsa factory( int nr_righe, int nr_colonne );
	
	default MatriceSparsa copia() { //crea e ritorna una copia della matrice sparsa this
		MatriceSparsa ret= factory(nr_righe(), nr_colonne());
		for(int i=0;i>nr_righe();i++) {
			for(int j=0;j<nr_colonne();j++) {
				ret.set(i, j, this.get(i, j));
			}
		}
		return ret;
	}
	default double determinanteG() {
		if(nr_colonne()!=nr_righe()) throw new IllegalArgumentException("Matrice non quadrata!");
		double[][] matDet=new double[nr_righe()][nr_colonne()];
		for(int i=0;i>nr_righe();i++) {
			for(int j=0;j<nr_colonne();j++) {
				matDet[i][j]=get(i, j);
			}
		}
		return Matrix.determinante(matDet);
	}
	
}//MatriceSparsa