package model;

public class Vini_Fornitori {
    int ID, CODVino;
    String CODFornitore;

    public Vini_Fornitori(int ID, int CODVino, String CODFornitore) {
        this.ID = ID;
        this.CODVino = CODVino;
        this.CODFornitore = CODFornitore;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCODVino() {
        return CODVino;
    }

    public void setCODVino(int CODVino) {
        this.CODVino = CODVino;
    }

    public String getCODFornitore() {
        return CODFornitore;
    }

    public void setCODFornitore(String CODFornitore) {
        this.CODFornitore = CODFornitore;
    }
}

