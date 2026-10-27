package org.example.number2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HandlersController {
    //объявление чекбоксов
    @FXML
    private CheckBox btnCheckBox;
    @FXML
    private CheckBox tfCheckBox;
    @FXML
    private CheckBox lblCheckBox;

    //Объявление виджетов
    @FXML
    private Button myButton;
    @FXML
    private TextField myTextField;
    @FXML
    private Label myLabel;

    @FXML
    public void initialize() {
        //привязка кнопки к чекбоксу
        myButton.visibleProperty().bind(btnCheckBox.selectedProperty());
        myButton.managedProperty().bind(btnCheckBox.selectedProperty());

        //привязка текстового поля к чекбоксу
        myTextField.visibleProperty().bind(tfCheckBox.selectedProperty());
        myTextField.managedProperty().bind(tfCheckBox.selectedProperty());

        //привязка метки к чекбоксу
        myLabel.visibleProperty().bind(lblCheckBox.selectedProperty());
        myLabel.managedProperty().bind(lblCheckBox.selectedProperty());
    }
}