package wineshop.client;

import java.io.*;
import java.net.*;

public class ClientConnection {

    Socket mioSocket = null;
    int porta = 1234;
    DataOutputStream out;
    DataInputStream in;
    BufferedReader tastiera;
    String messaggio;

    public void Comunica()
    {
        try {

            do {

                System.out.print("[2] - Messaggio da inviare al server: ");
                tastiera = new BufferedReader(new InputStreamReader(System.in));
                messaggio = tastiera.readLine();
                System.out.println("[3] - Invio: " + messaggio);
                out.writeBytes(messaggio + "\n");
                System.out.println("[4] - In attesa di una risposta...");
                String ricevuta = in.readLine();
                System.out.println("[5] - Risposta del server ricevuta: " + ricevuta);

            }while (!messaggio.toLowerCase().equals("esci"));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket Connetti()
    {
        try {
            System.out.println("[0] - Provo a connettermi al server...");
            Socket mioSocket = new Socket(InetAddress.getLocalHost(), porta);

            System.out.println("[1] - Connesso");
            in = new DataInputStream(mioSocket.getInputStream());
            out = new DataOutputStream(mioSocket.getOutputStream());
        } catch (UnknownHostException e)
        {
            System.out.println("Host sconosciuto");
        }catch (Exception e) {
            System.err.println("Impossibile stabilire la connessione");
        }

        return mioSocket;
    }

    private void close()
    {
        try {
            mioSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ClientConnection c = new ClientConnection();
        c.Connetti();
        c.Comunica();
    }
}
