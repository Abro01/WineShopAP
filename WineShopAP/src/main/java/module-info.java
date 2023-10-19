module wineshop.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;
    requires java.desktop;
    requires mysql.connector.j;


    opens wineshop.client to javafx.fxml;
    exports wineshop.client;
}