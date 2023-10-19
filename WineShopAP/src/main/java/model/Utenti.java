package model;

import utilities.Rimovibile;
import utilities.Inseribile;

import java.io.Serializable;
public class Utenti implements Inseribile, Rimovibile, Serializable{
    private static final long serialVersionUID = 1L;
    private final String username;
    private String nome, cognome, cf, email, telefono, indirizzo, password, tipo;

    public Utenti(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Utenti(String username, String cf, String password, String tipo) {
        this.username = username;
        this.cf = cf;
        this.password = password;
        this.tipo = tipo;
    }

    public Utenti(String username, String nome, String cognome, String cf, String email, String telefono, String indirizzo, String password, String tipo) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
        this.password = password;
        this.tipo = tipo;
    }

    public Utenti(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTipo() {
        return tipo;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String[] getAttributi() {
        return new String[]{"username", "password", "email", "tipo", "cf"};
    }

    @Override
    public String getNomeIstanza() {
        return "utente";
    }

    @Override
    public String[] getValori() {
        return new String[]{"'" + this.cf + "'", "'" + this.username + "'", "'" + this.password + "'", "'" + this.tipo + "'", "'" + this.email + "'"};
    }

    @Override
    public String getPK() {
        return "Username";
    }

    @Override
    public String getValorePK() {
        return "'" + this.getUsername() + "'";
    }

    public String toString() {
        return "Login: " + this.username + ", tipo account: " + this.tipo + ", password: " + this.password + ", email: " + this.email + ", codice fiscale: " + this.cf;
    }
}
