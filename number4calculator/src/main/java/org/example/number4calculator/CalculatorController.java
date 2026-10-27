package org.example.number4calculator;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField num1Field;

    @FXML
    private TextField num2Field;

    @FXML
    private ComboBox<String> operationCombo;

    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        //Список доступными операциями
        operationCombo.getItems().addAll("+", "-", "*", "/");
        operationCombo.setValue("+");
    }

    @FXML
    protected void onCalculateButtonClick() {
        try {
            // Считываются числа (замена запятой на точку на)
            double num1 = Double.parseDouble(num1Field.getText().trim().replace(',', '.'));
            double num2 = Double.parseDouble(num2Field.getText().trim().replace(',', '.'));
            String operation = operationCombo.getValue();
            double result = 0;

            if (operation == null) {
                resultLabel.setText("Ошибка: выберите операцию");
                return;
            }

            // Выполнение выбранного действия
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0.0) {
                        resultLabel.setText("Ошибка: деление на ноль!");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            resultLabel.setText("Результат: " + result);

        } catch (NumberFormatException e) {
            resultLabel.setText("Ошибка: введите корректные числа!");
        }
    }
}