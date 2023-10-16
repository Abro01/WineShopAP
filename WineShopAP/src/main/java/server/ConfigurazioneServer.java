package server;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.FileNotFoundException;
import java.io.FileReader;
public class ConfigurazioneServer {
    private final String DBHost;
    private final int ServerPort;
    private final String DBUser;
    private final String DBPassword;
    private final String DBName;
    private final int DBPort;

    public ConfigurazioneServer(String percorso)
    {
        Gson gson = new Gson();
        ConfigurazioneServer conf = null;

        try{
            conf = gson.fromJson(new FileReader(percorso), ConfigurazioneServer.class);
        }catch (JsonSyntaxException | JsonIOException | FileNotFoundException e)
        {
            e.printStackTrace();
        }

        assert conf != null;
        this.DBHost = conf.getDBHost();
        this.DBName = conf.getDBName();
        this.DBPassword = conf.getDBPassword();
        this.ServerPort = conf.getServerPort();
        this.DBPort = conf.getDBPort();
        this.DBUser = conf.getDBUser();

    }

    public String getDBHost() {
        return DBHost;
    }

    public int getServerPort() {
        return ServerPort;
    }

    public String getDBUser() {
        return DBUser;
    }

    public String getDBPassword() {
        return DBPassword;
    }

    public String getDBName() {
        return DBName;
    }

    public int getDBPort() {
        return DBPort;
    }

    @Override
    public String toString() {
        return "ConfigurazioneServer{" +
                "DBHost='" + DBHost + '\'' +
                ", ServerPort=" + ServerPort +
                ", DBUser='" + DBUser + '\'' +
                ", DBPassword='" + DBPassword + '\'' +
                ", DBName='" + DBName + '\'' +
                ", DBPort=" + DBPort +
                '}';
    }
}
