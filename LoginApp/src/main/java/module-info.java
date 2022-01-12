module sample.loginapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.java;
    opens sample.loginapp to javafx.fxml;
    exports sample.loginapp;
}