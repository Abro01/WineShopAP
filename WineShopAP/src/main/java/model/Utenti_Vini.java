package model;

public class Utenti_Vini {
    int ID, CODVino;
    String CODUtente;

    public Utenti_Vini(int ID, int CODVino, String CODUtente) {
        this.ID = ID;
        this.CODVino = CODVino;
        this.CODUtente = CODUtente;
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

    public String getCODUtente() {
        return CODUtente;
    }

    public void setCODUtente(String CODUtente) {
        this.CODUtente = CODUtente;
    }
}
