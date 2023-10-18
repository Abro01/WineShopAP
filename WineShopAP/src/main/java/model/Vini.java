package model;

import utilities.Rimovibile;
import utilities.Inseribile;

import java.io.Serializable;
public class Vini implements Inseribile, Rimovibile, Serializable{
    private String nome, CODProduttore, provenienza, descrizione, vitigno, immagine;
    private double prezzo;
    private int ID, soglia, quantita, anno;

    public Vini(String nome, String CODProduttore, String provenienza, String descrizione, String vitigno, String immagine, double prezzo, int ID, int soglia, int quantita, int anno) {
        this.nome = nome;
        this.CODProduttore = CODProduttore;
        this.provenienza = provenienza;
        this.descrizione = descrizione;
        this.vitigno = vitigno;
        this.immagine = immagine;
        this.prezzo = prezzo;
        this.ID = ID;
        this.soglia = soglia;
        this.quantita = quantita;
        this.anno = anno;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCODProduttore() {
        return CODProduttore;
    }

    public void setCODProduttore(String CODProduttore) {
        this.CODProduttore = CODProduttore;
    }

    public String getProvenienza() {
        return provenienza;
    }

    public void setProvenienza(String provenienza) {
        this.provenienza = provenienza;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getVitigno() {
        return vitigno;
    }

    public void setVitigno(String vitigno) {
        this.vitigno = vitigno;
    }

    public String getImmagine() {
        return null;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getSoglia() {
        return soglia;
    }

    public void setSoglia(int soglia) {
        this.soglia = soglia;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public String[] getAttributi() {
        return new String[]{"ID", "Nome", "Provenienza", "Anno", "Descrizione", "Vitigno", "Prezzo", "Soglia", "Quantita", "Immagine", "CODProduttore"};
    }

    @Override
    public String getNomeIstanza() {
        return "Vino";
    }

    @Override
    public String[] getValori() {
        return new String[]{String.valueOf(ID), nome, provenienza, String.valueOf(anno), descrizione, vitigno, String.valueOf(prezzo), String.valueOf(soglia), String.valueOf(quantita), immagine, CODProduttore};
    }

    @Override
    public String getPK() {
        return null;
    }

    @Override
    public String getValorePK() {
        return null;
    }
    public String toString() {
        return "Vino: " + nome + " Regione: " + provenienza + " Anno: " + anno + " Prezzo: " + prezzo + " Quantita: " + quantita + " Descrizione: " + descrizione + " Vitigno: " + vitigno + " Soglia: " + soglia + "Produttore: " + CODProduttore;
    }
}
