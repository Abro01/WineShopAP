module wineshop.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.desktop;
    requires mysql.connector.j;
    requires java.sql;

    opens wineshop.client to javafx.fxml;
    exports wineshop.client;
}