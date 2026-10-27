module org.example.number4calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.number4calculator to javafx.fxml;
    exports org.example.number4calculator;
}