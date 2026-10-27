package org.example.number5;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TextFlagController {
    @FXML private ToggleGroup stripe1Group;
    @FXML private ToggleGroup stripe2Group;
    @FXML private ToggleGroup stripe3Group;
    @FXML private Label FinishOutColour;

    @FXML
    protected void onDrawClick() {
        RadioButton selected1 = (RadioButton) stripe1Group.getSelectedToggle();
        RadioButton selected2 = (RadioButton) stripe2Group.getSelectedToggle();
        RadioButton selected3 = (RadioButton) stripe3Group.getSelectedToggle();

        if (selected1 != null && selected2 != null && selected3 != null) {
            String color1 = selected1.getText();
            String color2 = selected2.getText();
            String color3 = selected3.getText();
            FinishOutColour.setText(color1 + "," + color2 + "," + color3);
        } else {
            FinishOutColour.setText("Пожалуйста, выберите цвета для всех полос.");
        }
    }
    }