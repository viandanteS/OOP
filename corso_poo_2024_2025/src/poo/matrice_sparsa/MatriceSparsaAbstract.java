package poo.matrice_sparsa;

public abstract class MatriceSparsaAbstract implements MatriceSparsa {
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<nr_righe();i++) {
			sb.append("[");
			for(int j=0;j<nr_colonne();j++) {
				sb.append(this.get(i, j)+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("]\n");
		}		
		return sb.toString();
	}
	
	public boolean equals(Object x) {
		if(!(x instanceof MatriceSparsa)) return false;
		if(x==this) return true;
		MatriceSparsa m=(MatriceSparsa)x;
		if(m.nr_righe()!=this.nr_righe() || m.nr_colonne()!=this.nr_colonne()) return false;
		
		for(int i=0;i<nr_righe();i++) {
			for(int j=0;j<nr_colonne();j++) {
				if(this.get(i, j)!=m.get(i, j))
					return false;
			}
		}
		return true;
	}

}
