package model;

import utilities.Rimovibile;
import utilities.Inseribile;

import java.io.Serializable;
public class Utenti implements Inseribile, Rimovibile, Serializable{
    private static final long serialVersionUID = 1L;
    private String nome, cognome, cf, email, telefono, indirizzo_consegna, username, password;

    public Utenti(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Utenti(String nome, String cognome, String cf, String email, String telefono, String indirizzo_consegna, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.telefono = telefono;
        this.indirizzo_consegna = indirizzo_consegna;
        this.username = username;
        this.password = password;
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

    public String getIndirizzo_consegna() {
        return indirizzo_consegna;
    }

    public void setIndirizzo_consegna(String indirizzo_consegna) {
        this.indirizzo_consegna = indirizzo_consegna;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getAttributi() {
        return new String[]{"Username", "Password", "Email", "CodiceFiscale"};
    }

    @Override
    public String getNomeIstanza() {
        return "Cliente";
    }

    @Override
    public String[] getValori() {
        return new String[]{"'" + this.cf + "'", "'" + this.username + "'", "'" + this.password + "'", "'" + this.email + "'"};
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
        return "Login: " + this.username + ", password: " + this.password + ", email: " + this.email + ", codice fiscale: " + this.cf;
    }
}
