package org.example.number3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RestaurantController {
    @FXML private CheckBox cbBorsch;
    @FXML private CheckBox cbCarbonara;
    @FXML private CheckBox cbCaesar;
    @FXML private CheckBox cbTea;

    @FXML private TextField tfBorschQty;
    @FXML private TextField tfCarbonaraQty;
    @FXML private TextField tfCaesarQty;
    @FXML private TextField tfTeaQty;

    @FXML private TextArea taReceipt;


    @FXML
    public void initialize() {
        // Реализация требования: "По умолчанию, если блюдо выбрано, количество становится равным 1"
        setupCheckboxListener(cbBorsch, tfBorschQty);
        setupCheckboxListener(cbCarbonara, tfCarbonaraQty);
        setupCheckboxListener(cbCaesar, tfCaesarQty);
        setupCheckboxListener(cbTea, tfTeaQty);
    }

    private void setupCheckboxListener(CheckBox cb, TextField tf) {
        cb.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                if (tf.getText().isEmpty() || tf.getText().equals("0")) {
                    tf.setText("1");
                }
            } else {
                // Убрали галку обратно 0
                tf.setText("0");
            }
        });
    }

    @FXML
    public void ClickforCheck(ActionEvent event) {
        StringBuilder receipt = new StringBuilder("=== ЧЕК ЗАКАЗА ===\n");
        double totalOrder = 0.0;
        boolean hasItems = false;

        // Фиксированные цены блюд
        double priceBorsch = 150.0;
        double priceCarbonara = 300.0;
        double priceCaesar = 200.0;
        double priceTea = 50.0;

        // 1. Проверка Борща
        if (cbBorsch.isSelected()) {
            int qty = parseQuantity(tfBorschQty.getText());
            if (qty > 0) {
                double itemTotal = qty * priceBorsch;
                totalOrder += itemTotal;
                receipt.append(String.format("Борщ | Кол-во: %d | Сумма: %.2f руб.\n", qty, itemTotal));
                hasItems = true;
            }
        }

        // 2. Проверка Пасты Карбонары
        if (cbCarbonara.isSelected()) {
            int qty = parseQuantity(tfCarbonaraQty.getText());
            if (qty > 0) {
                double itemTotal = qty * priceCarbonara;
                totalOrder += itemTotal;
                receipt.append(String.format("Паста Карбонара | Кол-во: %d | Сумма: %.2f руб.\n", qty, itemTotal));
                hasItems = true;
            }
        }

        // 3. Проверка Салата Цезарь
        if (cbCaesar.isSelected()) {
            int qty = parseQuantity(tfCaesarQty.getText());
            if (qty > 0) {
                double itemTotal = qty * priceCaesar;
                totalOrder += itemTotal;
                receipt.append(String.format("Цезарь салат | Кол-во: %d | Сумма: %.2f руб.\n", qty, itemTotal));
                hasItems = true;
            }
        }

        // 4. Проверка Чая зеленого
        if (cbTea.isSelected()) {
            int qty = parseQuantity(tfTeaQty.getText());
            if (qty > 0) {
                double itemTotal = qty * priceTea;
                totalOrder += itemTotal;
                receipt.append(String.format("Чай зеленый | Кол-во: %d | Сумма: %.2f руб.\n", qty, itemTotal));
                hasItems = true;
            }
        }

        // Вывод результатов в чек
        if (!hasItems) {
            receipt.append("\nВы не выбрали ни одного блюда!");
        } else {
            receipt.append("----------------------------------------\n");
            receipt.append(String.format("Суммарная стоимость заказа: %.2f руб.", totalOrder));
        }

        // Помещается сформированный текст в TextArea
        taReceipt.setText(receipt.toString());
    }

    private int parseQuantity(String text) {
        try {
            int val = Integer.parseInt(text.trim());
            return Math.max(val, 0); // Защита от отрицательных чисел
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}