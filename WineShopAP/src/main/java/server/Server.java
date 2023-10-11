package server;

import java.io.*;
import java.net.*;
import java.sql.*;

public class Server {

    ServerSocket server = null;
    Socket socketClient = null;
    int porta= 1234;
    DataOutputStream out;
    DataInputStream in;
    String letto;
    String url = "jdbc:mysql://localhost:3306/wine_shop";
    String username = "root";
    String password = "";

    public void Comunica()
    {
        try {

            do {
                System.out.println("[3] - Aspetto un messaggio dal client");
                letto = in.readLine();
                System.out.println("[4] - Messaggio ricevuto: " + letto);
                String risposta = letto.toUpperCase();
                System.out.println("[5] - Rispondo con: " + risposta);
                out.writeBytes(risposta + "\n");
            }while (!letto.toLowerCase().equals("esci"));

            System.out.println("[5] - Chiudo la connessione");
            socketClient.close();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public Socket attendi()
    {
        try {

            System.out.println("[0] - Inzializzo il server...");
            server = new ServerSocket(porta);

            System.out.println("[1] - Server pronto, in ascolto sulla porta: " + porta);
            socketClient = server.accept();

            System.out.println("[2] - Connessione stabilita con il client");

            server.close();
            in = new DataInputStream(socketClient.getInputStream());
            out = new DataOutputStream(socketClient.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return socketClient;
    }



    /*public void ConnessioneDB()
    {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM utenti");

            while(resultSet.next())
            {
                System.out.println("DataBase connesso");
            }

            //connection.close();
        } catch (Exception e) {
                System.err.println(e);
        }
    }*/

    public static void main(String[] args)
    {
        Server s = new Server();
        //s.attendi();
        //s.Comunica();

        //s.ConnessioneDB();
    }
}
