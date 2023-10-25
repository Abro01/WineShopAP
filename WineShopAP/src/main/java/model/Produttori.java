package model;

import utilities.Rimovibile;
import utilities.Inseribile;

import java.io.Serializable;
public class Produttori implements Inseribile, Rimovibile, Serializable{
    private int id;
    private String nome, cognome, cf, email, telefono, indirizzo_azienda, tipo;

    public Produttori(int id, String tipo, String nome, String cognome, String cf, String email, String telefono, String indirizzo_azienda) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.telefono = telefono;
        this.indirizzo_azienda = indirizzo_azienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String ruolo) {
        this.tipo = ruolo;
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
        return new String[]{"'" + this.cf + "'", "'" + this.nome + "'", "'" + this.cognome + "'", "'" + this.email + "'", "'" + this.telefono + "'", "'" + this.indirizzo_azienda + "'", "'" + this.tipo + "'"};
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

