package org.example.wordflipper;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FlipperController {
    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private Button flipButton;

    private boolean goingright = true; //-> true <- false

    public void onFlipButtonClick() {
        if (goingright) {
            String text = textField1.getText();
            textField2.setText(text);
            textField1.clear();

            flipButton.setText("<-");
            goingright = false;
        }
        else {
            String text = textField2.getText();
            textField1.setText(text);
            textField2.clear();

            flipButton.setText("->");
            goingright = true;
        }
    }
}
