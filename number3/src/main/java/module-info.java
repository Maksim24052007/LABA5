module org.example.number3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.number3 to javafx.fxml;
    exports org.example.number3;
}