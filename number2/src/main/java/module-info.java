module org.example.number2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.number2 to javafx.fxml;
    exports org.example.number2;
}