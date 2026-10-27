module org.example.number5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.number5 to javafx.fxml;
    exports org.example.number5;
}