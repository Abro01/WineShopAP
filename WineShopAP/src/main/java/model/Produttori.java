package model;

import utilities.Rimovibile;
import utilities.Inseribile;

import java.io.Serializable;
public class Produttori implements Inseribile, Rimovibile, Serializable{
    private Enum ruolo;
    private String nome, cognome, cf, email, telefono, indirizzo_azienda;

    public Produttori(Enum ruolo, String nome, String cognome, String cf, String email, String telefono, String indirizzo_azienda) {
        this.ruolo = ruolo;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.telefono = telefono;
        this.indirizzo_azienda = indirizzo_azienda;
    }

    public Enum getRuolo() {
        return ruolo;
    }

    public void setRuolo(Enum ruolo) {
        this.ruolo = ruolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIndirizzo_azienda() {
        return indirizzo_azienda;
    }

    public void setIndirizzo_azienda(String indirizzo_azienda) {
        this.indirizzo_azienda = indirizzo_azienda;
    }

    @Override
    public String[] getAttributi() {
        return new String[]{"CF", "Nome", "Cognome", "Email", "Telefono", "IndirizzoAzienda", "Ruolo"};
    }

    @Override
    public String getNomeIstanza() {
        return "Produttori";
    }

    @Override
    public String[] getValori() {
        return new String[]{"'" + this.cf + "'", "'" + this.nome + "'", "'" + this.cognome + "'", "'" + this.email + "'", "'" + this.telefono + "'", "'" + this.indirizzo_azienda + "'", "'" + this.ruolo + "'"};
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

