package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class Server {
    static Connection conn;

    public static void main(String[] args){
        ConfigurazioneServer conf = new ConfigurazioneServer("C:/Users/andre/OneDrive/Documenti/GitHub/WineShopAP/WineShopAP/src/main/java/server/ServerConfig.json");

        System.out.println(conf + "\n");

        try{
            String url = "jdbc:mysql://" + conf.getDBHost() + ":" + conf.getDBPort() + "/" + conf.getDBName();
            String user = conf.getDBUser();
            String psw = conf.getDBPassword();
            conn = DriverManager.getConnection(url, user, psw);

            System.out.println("Database connesso\n");
            ServerSocket server = new ServerSocket(conf.getServerPort());
            server.setReuseAddress(true);
            System.out.println("Server in ascolto sulla porta: " + conf.getServerPort());

            while (true)
            {
                Socket client = server.accept();
                ClientHandler clientHandler = new ClientHandler(client, conf);
                System.out.println("Client connesso: " + client.getInetAddress().getHostAddress());
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
