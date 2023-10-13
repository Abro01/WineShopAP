package server;

import utilities.Log;
import utilities.Operation;
import utilities.Response;
import utilities.Request;

import java.io.*;
import java.net.Socket;
import static utilities.Response.State.OK;
public class ServerThread implements Runnable{
    private final Socket socket;
    private final ControllerServer cs;
    private final ManageDB mdb;

    public ServerThread(Socket socket, ControllerServer cs) {
        this.socket = socket;
        this.cs = cs;
        mdb = new ManageDB();
    }
    private void writeLog(String where, String s)
    {
        Log.ScritturaVerboServer("ServerThread/" + where + ": " + s);
    }
    private void writeErrorLog(String where, Exception e)
    {
        Log.ScritturaErroriServer("ERROR/ServerThread/" + where + ": " + e.toString());
        System.err.println("ERROR/ServerThread/" + where + ": " + e);
        cs.writeGUI("ERROR: " + e);
    }

    public void run()
    {
        String IDThread = Thread.currentThread().getName();
        ObjectInputStream in;
        ObjectOutputStream out = null;

        try {
            in = new ObjectInputStream(new BufferedInputStream(this.socket.getInputStream()));
        }catch (EOFException e)
        {
            writeLog("RunIN", "Connessione chiusa all'inizio");
            cs.writeGUI("Test client ok");
            return;
        }catch (IOException e)
        {
            writeErrorLog("RunIN", e);
            return;
        }

        while (true)
        {
            boolean close = false;

            try {
                Object i = in.readObject();

                if(i instanceof Request<?> req)
                {
                    writeLog("Run", IDThread + "Ricevuto: " + req.getRichiesta());
                    Response<?> resp;

                    if (req.getRichiesta() == Operation.CloseConn)
                    {
                        resp = new Response<>(req.getRichiesta(), OK, "Connessione chiusa");
                        close = true;
                    }else
                    {
                        cs.writeGUI(IDThread + "Ricevuto: " + req.getRichiesta());
                        resp = mdb.exec(req);
                    }

                    if (out == null)
                    {
                        out = new ObjectOutputStream(new BufferedOutputStream(this.socket.getOutputStream())):
                    }

                    writeLog("Run", IDThread + "@" + req.getRichiesta() + " risponde con: " + resp.getInfo());
                    out.writeObject(resp);
                    out.flush();

                    if(close)
                    {
                        this.socket.close();
                        writeLog("Run", IDThread + "chiuso");
                        break;
                    }
                }
            }catch (Exception e)
            {
                writeErrorLog("RunSwitch", e);
                break;
            }
        }
        writeLog("Run", "Thread chiuso");
    }
}
