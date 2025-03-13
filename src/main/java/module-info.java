module com.example.task8adao {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.task8adao to javafx.fxml;
    exports com.example.task8adao;
}