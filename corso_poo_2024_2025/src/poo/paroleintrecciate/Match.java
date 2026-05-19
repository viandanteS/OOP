package poo.paroleintrecciate;

class Match {
	private final String parola;
    private final int riga;
    private final int colonna;
    private final Direzione direzione;

    public Match(String parola, int riga, int colonna, Direzione direzione) {
        this.parola = parola;
        this.riga = riga;
        this.colonna = colonna;
        this.direzione = direzione;
    }

    public String getParola() { return parola; }
    public int getRiga() { return riga; }
    public int getColonna() { return colonna; }
    public Direzione getDirezione() { return direzione; }

    @Override
    public String toString() {
        return String.format("%s: <%d,%d> -> %s", parola, riga, colonna, direzione);
    }
}
