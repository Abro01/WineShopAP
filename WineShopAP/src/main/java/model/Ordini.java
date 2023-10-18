package model;

import utilities.Inseribile;

import java.io.Serializable;

public class Ordini implements Serializable, Inseribile{
    private int ID;
    private double totale;
    private Enum MetodoPagamento;
    private String CODUtente;
    private boolean pagato;
    private boolean spedito;

    public Ordini(int ID, double totale, Enum metodoPagamento, String CODUtente, boolean pagato) {
        this.ID = ID;
        this.totale = totale;
        MetodoPagamento = metodoPagamento;
        this.CODUtente = CODUtente;
        this.pagato = pagato;
    }

    public Ordini(int ID, double totale, Enum metodoPagamento, String CODUtente, boolean pagato, boolean spedito) {
        this.ID = ID;
        this.totale = totale;
        MetodoPagamento = metodoPagamento;
        this.CODUtente = CODUtente;
        this.pagato = pagato;
        this.spedito = spedito;
    }

    public Ordini(int ID, double totale, boolean pagato) {
        this.ID = ID;
        this.totale = totale;
        this.pagato = pagato;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public Enum getMetodoPagamento() {
        return MetodoPagamento;
    }

    public void setMetodoPagamento(Enum metodoPagamento) {
        MetodoPagamento = metodoPagamento;
    }

    public String getCODUtente() {
        return CODUtente;
    }

    public void setCODUtente(String CODUtente) {
        this.CODUtente = CODUtente;
    }

    public boolean isPagato() {
        return pagato;
    }

    public void setPagato(boolean pagato) {
        this.pagato = pagato;
    }

    public boolean isSpedito() {
        return spedito;
    }

    public void setSpedito(boolean spedito) {
        this.spedito = spedito;
    }

    @Override
    public String[] getAttributi() {
        return new String[]{"ID", "CODUtente", "Totale", "Pagato", "Metodo_Pagamento"};
    }

    @Override
    public String getNomeIstanza() {
        return "null";
    }

    @Override
    public String[] getValori() {
        int ValorePagato = this.pagato ? 1 : 0;
        return new String[]{this.ID + ", " + this.CODUtente + ", " + this.totale + ", " + ValorePagato + ", '" + this.MetodoPagamento + "' "};
    }

    @Override
    public String getPK() {
        return "null";
    }

    @Override
    public String toString() {
        return "Ordini{" +
                "ID=" + ID +
                ", totale=" + totale +
                ", MetodoPagamento=" + MetodoPagamento +
                ", CODUtente='" + CODUtente + '\'' +
                ", pagato=" + pagato +
                ", spedito=" + spedito +
                '}';
    }
}
