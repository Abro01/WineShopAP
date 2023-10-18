package server;

import utilities.Response;
import utilities.Request;
import utilities.Costanti;
import utilities.PayloadVuoto;

import server.DBManager.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
public class ClientHandler implements Runnable{
    private final Socket socket;
    private final SQLTransaltor transaltor;
    private final DBManager dbManager;

    public ClientHandler(Socket socket, SQLTransaltor transaltor, DBManager dbManager) {
        this.socket = socket;
        this.transaltor = transaltor;
        this.dbManager = dbManager;
    }

    @Override
    public void run() {
        ObjectInputStream in;
        ObjectOutputStream out;

        try {
            in = new ObjectInputStream(this.socket.getInputStream());
            out = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (IOException e)
        {
            System.out.println("Errore riscontrato nell'apertura dello stream");

            try {
                this.socket.close();
            } catch (IOException ex)
            {
                System.out.println("Errore riscontrato nella chiusura del socket");
            }
            return;
        }

        System.out.println("Client " + this.socket.getInetAddress().getHostAddress() + " " + this.socket.getPort() + " connesso");

        while (true)
        {
            try {
                utilities.Response response;

                try {
                    Request request = (Request) in.readObject();
                    if(request.getHeader() == Costanti.CloseConnessione) break;

                    String query = this.transaltor.requestToSql(request);

                    System.out.println("Tentativo esecuzione:\n" + query);

                    List<Map<String, String>> queryResult = this.dbManager.executeSQLStatement(query);
                    response = this.transaltor.sqlToResponse(queryResult);
                }catch (RequestToSQLException e)
                {
                    e.printStackTrace();
                    response = new Response(Costanti.RichiestaErrata, new PayloadVuoto("Richiesta errata"));
                }catch (SQLToResponseException e)
                {
                    e.printStackTrace();
                    response = new Response(Costanti.ErroriServer, new PayloadVuoto("Errori Interni al server"));
                }
                out.writeObject(response);
            }catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Errore riscontrato durante lo stream del socket");
                break;
            }
        }
        try {
            socket.close();
        }catch (IOException e)
        {
            System.out.println("Errore riscontrato nella chiusura del socket");
        }
        System.out.println("Client " + this.socket.getInetAddress().getHostAddress() + " " + this.socket.getPort() + " disconnesso");
    }
}
