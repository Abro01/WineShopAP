module wineshop.client.wineshopap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens wineshop.client to javafx.fxml;
    exports wineshop.client;
}