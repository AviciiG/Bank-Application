package com.example.project_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DepositController {
    @FXML
    private TextField idDeposit;
    @FXML
    private TextField firstDeposit;//вклад начальный
    @FXML
    private TextField monthDeposit;
    @FXML
    private Label resDeposit;//результат
    @FXML
    private Button resButton;//кнопка для вывода

    @FXML
    void initialize() {
        resButton.setOnAction(this::calculateDeposit);
    }
    @FXML
    void calculateDeposit(ActionEvent event) {
        try {
            if (monthDeposit.getText().isEmpty() || idDeposit.getText().isEmpty() || firstDeposit.getText().isEmpty()) {
                throw new IllegalArgumentException("Введите все необходимые данные");
            }
            double initialDeposit = Double.parseDouble(firstDeposit.getText());
            int months = Integer.parseInt(monthDeposit.getText());
            double annualInterestRate = 0.14; // 14% годовых

            double totalAmount = initialDeposit * Math.pow(1 + annualInterestRate / 12, months);

            totalAmount = Math.round(totalAmount * 100) / 100.0;

            resDeposit.setText("Сумма депозита через " + months + " месяцев: " + totalAmount);
        } catch (NumberFormatException e) {
            resDeposit.setText("Пожалуйста, введите корректные значения.");
        }
    }
    }


