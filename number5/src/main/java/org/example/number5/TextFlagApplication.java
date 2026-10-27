package org.example.number5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TextFlagApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TextFlagApplication.class.getResource("textflag-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 380);
        stage.setTitle("TextFlag");
        stage.setScene(scene);
        stage.show();

        stage.setResizable(false);
    }
}
