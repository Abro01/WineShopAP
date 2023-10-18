package model;

import utilities.Inseribile;
import utilities.Rimovibile;

import java.io.Serializable;
public class Recensioni implements Serializable, Inseribile, Rimovibile{
    private int ID, CODVino;
    private String CODUtente, commento;
    private Enum voto;

    public Recensioni(int CODVino, String CODUtente, String commento, Enum voto) {
        this.CODVino = CODVino;
        this.CODUtente = CODUtente;
        this.commento = commento;
        this.voto = voto;
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
        return new String[]{"Voto", "Commento", "CODVino", "CODUtente"};
    }

    @Override
    public String getNomeIstanza() {
        return "Recensione";
    }

    @Override
    public String[] getValori() {
        return new String[]{"'" + this.voto + "'", "'" + this.commento + "'", "'" + this.CODVino + "'", "'" + this.CODUtente + "'"};
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

