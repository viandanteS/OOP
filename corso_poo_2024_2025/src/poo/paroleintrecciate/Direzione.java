package poo.paroleintrecciate;

enum Direzione {
    NORD(-1, 0), SUD(1, 0), EST(0, 1), OVEST(0, -1),
    NORD_EST(-1, 1), NORD_OVEST(-1, -1), SUD_EST(1, 1), SUD_OVEST(1, -1);
    
    final int deltaR, deltaC;
    
    Direzione(int deltaR, int deltaC) {
        this.deltaR = deltaR;
        this.deltaC = deltaC;
    }
}