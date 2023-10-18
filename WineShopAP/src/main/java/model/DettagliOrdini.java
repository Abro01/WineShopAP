package model;

import java.io.Serializable;

import utilities.Inseribile;
public class DettagliOrdini implements Serializable, Inseribile{
    private int ID, quantita, CODOrdine, CODVino;

    public DettagliOrdini(int ID, int quantita, int CODOrdine, int CODVino) {
        this.ID = ID;
        this.quantita = quantita;
        this.CODOrdine = CODOrdine;
        this.CODVino = CODVino;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getCODOrdine() {
        return CODOrdine;
    }

    public void setCODOrdine(int CODOrdine) {
        this.CODOrdine = CODOrdine;
    }

    public int getCODVino() {
        return CODVino;
    }

    public void setCODVino(int CODVino) {
        this.CODVino = CODVino;
    }

    @Override
    public String[] getAttributi() {
        return new String[]{"ID", "Quantita", "CODOrdine", "CODVino"};
    }

    @Override
    public String getNomeIstanza() {
        return "null";
    }

    @Override
    public String[] getValori() {
        return new String[]{"'" + this.ID + "'" , "'" + this.quantita + "'", "'" + this.CODOrdine + "'", "'" + this.CODVino + "' "};
    }

    @Override
    public String getPK() {
        return "null";
    }
}
