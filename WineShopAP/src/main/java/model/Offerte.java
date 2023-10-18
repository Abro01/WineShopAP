package model;

import java.io.Serializable;
public class Offerte implements Serializable{
    private int ID, CODVino, Sconto;
    private final String Descrizione;

    public Offerte(int ID, int CODVino, int sconto, String descrizione) {
        this.ID = ID;
        this.CODVino = CODVino;
        Sconto = sconto;
        Descrizione = descrizione;
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

    public int getSconto() {
        return Sconto;
    }

    public void setSconto(int sconto) {
        Sconto = sconto;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    @Override
    public String toString() {
        return "Offerta numero " + ID + ", con sconto del " + Sconto + ", che consiste in '" + Descrizione;
    }
}
