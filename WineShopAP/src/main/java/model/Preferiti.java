package model;

import utilities.Inseribile;
import utilities.Rimovibile;

import java.io.Serializable;
public class Preferiti implements Serializable, Inseribile, Rimovibile{
    private int ID, CODVino;
    private String CODUtente;

    public Preferiti(int ID, int CODVino, String CODUtente) {
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

    @Override
    public String[] getAttributi() {
        return new String[]{"CODVino", "CODUtente"};
    }

    @Override
    public String getNomeIstanza() {
        return "Preferito";
    }

    @Override
    public String[] getValori() {
        return new String[]{"'" + this.CODVino + "'", "'" + this.CODUtente + "'"};
    }

    @Override
    public String getPK() {
        return null;
    }

    @Override
    public String getValorePK() {
        return null;
    }
}
