package poo.paroleintrecciate;

import java.util.Arrays;
import java.util.List;

class Schema {
	private final char[][] matrice;

    public Schema(char[][] matrice) {
        if (matrice == null || matrice.length == 0 || matrice[0].length == 0) {
            throw new IllegalArgumentException("Matrice non valida");
        }
        this.matrice = new char[matrice.length][matrice[0].length];
        for (int i = 0; i < matrice.length; i++) {
            if (matrice[i].length != matrice[0].length) {
                throw new IllegalArgumentException("Righe di lunghezza diversa");
            }
            this.matrice[i] = Arrays.copyOf(matrice[i], matrice[i].length);
        }
    }

    public Match match(String parola) {
        if (parola == null || parola.isEmpty()) return null;
        int rows = matrice.length;
        int cols = matrice[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (Direzione dir : Direzione.values()) {
                    if (trovataParola(parola, i, j, dir)) {
                        return new Match(parola, i, j, dir);
                    }
                }
            }
        }
        return null;
    }

    private boolean trovataParola(String parola, int r, int c, Direzione dir) {
        int len = parola.length();
        int rows = matrice.length, cols = matrice[0].length;
        for (int i = 0; i < len; i++) {
            int nr = r + i * dir.deltaR;
            int nc = c + i * dir.deltaC;
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || matrice[nr][nc] != parola.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String delete(List<Match> matches) {
    	
        char[][] tempMatrice = new char[matrice.length][];
        
        for (int i = 0; i < matrice.length; i++) {
            tempMatrice[i] = Arrays.copyOf(matrice[i], matrice[i].length);
        }
        
        for (Match match : matches) {
            int r = match.getRiga(), c = match.getColonna();
            Direzione dir = match.getDirezione();
            for (char ch : match.getParola().toCharArray()) {
                tempMatrice[r][c] = ' ';
                r += dir.deltaR;
                c += dir.deltaC;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char[] row : tempMatrice) {
            for (char ch : row) {
                if (ch != ' ') result.append(ch);
            }
        }
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : matrice) {
            sb.append(new String(row)).append("\n");
        }
        return sb.toString();
    }
}
