package server;

import java.sql.*;
import utilities.Log;
public class ConnessioneDB {
    private static Connection c = null;
    static String url = "jdbc:mysql://localhost:3306/wine_shop";
    static String username = "root";
    static String password = "";

    public ConnessioneDB() {
    }

    public static Connection getConn()
    {
        if(c == null)
        {
            try {
                c = DriverManager.getConnection(url, username, password);
                Log.ScritturaVerboServer("Connessione al DB creata");
            }catch (Exception e)
            {
                System.err.println("ERRORE/ConnessioneDB: " + e);
                Log.ScritturaErroriServer("ERRORE/ConnessioneDB/getConn: " + e);
                c = null;
                return null;
            }
        }
        return c;
    }

    public static void closeConn()
    {
        if(c != null)
        {
            try {
                c.close();
                Log.ScritturaErroriServer("ConnDB: chiusa");
            }catch (SQLException e)
            {
                System.err.println("ERRORE/ConnessioneDB: " + e);
                Log.ScritturaErroriServer("ERRORE/ConnessioneDB/getConn: " + e);
            }
        }
    }
}
