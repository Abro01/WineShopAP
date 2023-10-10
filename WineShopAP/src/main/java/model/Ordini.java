package model;

public class Ordini {
    int ID, quantita_vini;
    String CODImpiegato, CODCorriere;

    public Ordini(int ID, int quantita_vini, String CODImpiegato, String CODCorriere) {
        this.ID = ID;
        this.quantita_vini = quantita_vini;
        this.CODImpiegato = CODImpiegato;
        this.CODCorriere = CODCorriere;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuantita_vini() {
        return quantita_vini;
    }

    public void setQuantita_vini(int quantita_vini) {
        this.quantita_vini = quantita_vini;
    }

    public String getCODImpiegato() {
        return CODImpiegato;
    }

    public void setCODImpiegato(String CODImpiegato) {
        this.CODImpiegato = CODImpiegato;
    }

    public String getCODCorriere() {
        return CODCorriere;
    }

    public void setCODCorriere(String CODCorriere) {
        this.CODCorriere = CODCorriere;
    }
}
