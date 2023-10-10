package model;

public class Corriere_Fornitore {
    String nome, cognome, cf, email, telefono, indirizzo_azienda;

    public Corriere_Fornitore(String nome, String cognome, String cf, String email, String telefono, String indirizzo_azienda) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.telefono = telefono;
        this.indirizzo_azienda = indirizzo_azienda;
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
}
