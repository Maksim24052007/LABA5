module org.example.wordflipper {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.wordflipper to javafx.fxml;
    exports org.example.wordflipper;
}