package com.example.project_1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import java.text.DecimalFormat;
public class CreditController{

    @FXML
    private TextField creditAmountField;

    @FXML
    private TextField interestRateField;

    @FXML
    private TextField termField;

    @FXML
    private Label resultLabel;
    @FXML
    private Button res_button;
    @FXML
    void initialize() {
      res_button.setOnAction(this::calculateLoan);
    }
    @FXML
    void calculateLoan(ActionEvent event) {
        try {
            double creditAmount = Double.parseDouble(creditAmountField.getText());
            double interestRate = 0.20 / 12; // Процентная ставка в месяц
            int term = Integer.parseInt(termField.getText());

            DecimalFormat decimalFormat = new DecimalFormat("#");

            double monthlyPayment = (creditAmount * interestRate) / (1 - Math.pow(1 + interestRate, -term));

            String formattedMonthlyPayment = decimalFormat.format(monthlyPayment);

            System.out.println("Ежемесячный платеж: " + formattedMonthlyPayment);

            resultLabel.setText("Ежемесячный платеж: " + formattedMonthlyPayment);
        } catch (NumberFormatException e) {
            // Выводим сообщение об ошибке, если введены некорректные данные
            resultLabel.setText("Ошибка ввода данных");
        }
    }
}
