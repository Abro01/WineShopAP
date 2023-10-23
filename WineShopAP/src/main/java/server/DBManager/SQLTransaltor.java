package server.DBManager;

import utilities.Costanti;
import utilities.Request;
import utilities.Response;
import utilities.Inseribile;
import utilities.PayloadVuoto;

import model.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
public class SQLTransaltor {
    private int UltimaRichiesta;
    private final DateTimeFormatter dateFormatter;
    private final DateTimeFormatter dateTimeFormatter;
    private Utenti UtenteLoggato;

    public SQLTransaltor() {
        this.UltimaRichiesta = -1;
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public String RequestToSQL(Request request) throws RequestToSQLException, IOException{
        String query = "";
        Object model = request.getPayload();

        switch (request.getHeader())
        {
            case Costanti.Login ->
            {
                query += "SELECT * " +
                         "FROM utenti " +
                         "WHERE Username = '" + ((Utenti) model).getUsername() + "' AND Passwrod = '" + ((Utenti) model).getPassword() + "'; " +
                         "UPDATE utenti SET Online = 1 " +
                         "WHERE Username = '" + ((Utenti) model).getUsername() + "';";
            }

            case Costanti.Logout ->
            {
                query += "UPDATE utenti SET LastLogin = '" + LocalDateTime.now().format(dateTimeFormatter) + "' " +
                        "WHERE Username = '" + ((Utenti) model).getUsername() + "'; " +
                        "UPDATE utenti SET Online = 0 " +
                        "WHERE Username = '" + ((Utenti) model).getUsername() + "';";
            }

            /*case Costanti.AddWine ->
            {
                Inseribile ModelInseribile = (Inseribile) model;

                query += "INSERT INTO " + ModelInseribile.getAttributi() + "(" +
                         String.join(",", ModelInseribile.getAttributi()) + ") VALUES (" +
                         String.join(",", ModelInseribile.getValori()) + ");";

                if (!Arrays.asList(ModelInseribile.getAttributi()).contains(ModelInseribile.getPK()))
                {
                    query += "SELECT LAST_INSERT_ID() AS last_id;";
                }
            }

            case Costanti.getViniDisponibili ->
            {
                query += "SELECT * FROM vini;";
            }

            case Costanti.AddOfferta ->
            {
                query += "INSERT INTO offerta(descrizione) VALUES ('" + request.getPayload().toString() + "')";
            }

            case Costanti.RimuoviOfferta ->
            {
                query += "DELETE FROM offerta WHERE id = '" + request.getPayload().toString() + "'";
            }

            case Costanti.MostraOfferta ->
            {
                query += "SELECT * FROM offerta;";
            }

            case Costanti.SpedizioneOrdine ->
            {
                query += "UPDATE ordini SET Spedito = 1 WHERE id = '" + request.getPayload().toString() + "';";
            }

            case Costanti.MostraOrdini ->
            {
                query += "SSELECT * FROM ordini WHERE Spedito = false;";
            }

            case Costanti.MostraViniDaRifornire ->
            {
                query += "SELECT * FROM vini WHERE quantita < 10;";
                System.out.println(query);
            }

            case Costanti.RifornireVino ->
            {
                query += "UPDATE vini SET quantita = quantita + 20 WHERE id = '" + request.getPayload().toString() + "';";
            }

            case Costanti.Registrazione ->
            {
                Inseribile NewUser = (Inseribile) model;
                query += "INSERT INTO utenti " + "(" +
                         String.join(",", NewUser.getAttributi()) + ") VALUES (" +
                         String.join(",", NewUser.getValori()) + ");";
            }

            case Costanti.VendiVino ->
            {
                Ordini o = (Ordini) model;
                query += "UPDATE vini SET quantita = quantita - " + o.getQuantita_vini() + " WHERE vini.id = '" + /*idvini + "';";
            }

            case Costanti.getOnlineVenditori ->
            {
                query += "SELECT * FROM";
            }*/
            default ->
                throw new RequestToSQLException();
        }
        return query;
    }

    public Response sqlToResponse(List<Map<String, String>> queryResult) throws SQLToResponseException{
        Response response = null;

        switch (this.UltimaRichiesta)
        {
            case Costanti.Login:
                if(queryResult.isEmpty())
                {
                    response = new Response(Costanti.RichiestaErrata, new PayloadVuoto("Login Errato"));
                    break;
                }

                Map<String, String> uRes = queryResult.get(0);
                Utenti user = new Utenti(uRes.get("username"), uRes.get("cf"), uRes.get("password"), uRes.get("tipo"));

                response = new Response(Costanti.Successo, user);
                this.UtenteLoggato = user;

                break;
            default:
                throw new SQLToResponseException();
        }

        return response;
    }
}
