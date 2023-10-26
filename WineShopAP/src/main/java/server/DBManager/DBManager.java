package server.DBManager;

import server.ConfigurazioneServer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
public class DBManager {
    private final String user, password;

    public DBManager(String user, String password) {
        this.user = user;
        this.password = password;
    }

    private List<Map<String, String>> wrapQueryResult(ResultSet rs) throws SQLException {
        List<Map<String, String>> tabella = new ArrayList<Map<String, String>>();
        ResultSetMetaData meta = rs.getMetaData();
        while (rs.next()){
            Map<String, String> map = new HashMap<String, String>();
            for(int i = 1; i <= meta.getColumnCount(); i++)
            {
                String key = meta.getColumnName(i);
                String valore = rs.getString(key);
                map.put(key, valore);
            }
            tabella.add(map);
        }
        return tabella;
    }

    public List<Map<String, String>> executeSQLStatement(String query) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        ConfigurazioneServer conf = new ConfigurazioneServer("src/main/java/server/serverConfig.json");
        String url = "jdbc:mysql://" + conf.getDBHost() + ":" + conf.getDBPort() + "/" + conf.getDBName() + "?allowMultiQueries=true";
        String user = conf.getDBUser();
        String password = conf.getDBPassword();
        conn = DriverManager.getConnection(url, user, password);
        Statement statement = conn.createStatement();
        boolean isResultSet = statement.execute(query);
        boolean hasToBeWrapped = true;

        if(!isResultSet)
        {
            hasToBeWrapped = statement.getMoreResults();
        }

        ResultSet rs = statement.getResultSet();

        List<Map<String, String>> wr = null;

        if(hasToBeWrapped)
        {
            wr = wrapQueryResult(rs);
            rs.close();
        }
        conn.close();

        return wr;
    }
}
