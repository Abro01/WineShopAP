package model;

public class Vino {
    private String nome, produttore, provenienza, anno, note_tecniche, vitigno_provenienza, immagine;
    private double prezzo, prezzo_saldo;
    private int soglia, quantita;

    public Vino(String nome, String produttore, String provenienza, String anno, String note_tecniche, String vitigno_provenienza, double prezzo, String immagine, int quantita, int soglia, double prezzo_saldo) {
        this.nome = nome;
        this.produttore = produttore;
        this.provenienza = provenienza;
        this.anno = anno;
        this.note_tecniche = note_tecniche;
        this.vitigno_provenienza = vitigno_provenienza;
        this.prezzo = prezzo;
        this.immagine = immagine;
        this.soglia = soglia;
        this.quantita = quantita;
        this.prezzo_saldo = prezzo_saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getProvenienza() {
        return provenienza;
    }

    public void setProvenienza(String provenienza) {
        this.provenienza = provenienza;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getNote_tecniche() {
        return note_tecniche;
    }

    public void setNote_tecniche(String note_tecniche) {
        this.note_tecniche = note_tecniche;
    }

    public String getVitigno_provenienza() {
        return vitigno_provenienza;
    }

    public void setVitigno_provenienza(String vitigno_provenienza) {
        this.vitigno_provenienza = vitigno_provenienza;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public double getPrezzo_saldo() {
        return prezzo_saldo;
    }

    public void setPrezzo_saldo(double prezzo_saldo) {
        this.prezzo_saldo = prezzo_saldo;
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
}
