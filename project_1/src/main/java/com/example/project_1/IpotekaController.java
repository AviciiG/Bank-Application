package com.example.project_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class IpotekaController {
    @FXML
    private TextField yearIpoteka;

    @FXML
    private TextField nameIpoteka;
    @FXML
    private TextField idIpoteka;
    @FXML
    private TextField sumIpoteka;
    @FXML
    private Label resLabel;
    @FXML
    private Button resultButton;
    @FXML
    private TextField initialPaymentField;
    @FXML
    void initialize() {
        resultButton.setOnAction(this::calculateIpoteka);
    }
    @FXML
    void calculateIpoteka(ActionEvent event) {
        try {

            if (yearIpoteka.getText().isEmpty() || sumIpoteka.getText().isEmpty() || initialPaymentField.getText().isEmpty()) {
                throw new IllegalArgumentException("Введите все необходимые данные");
            }

            BigDecimal loanAmount = new BigDecimal(sumIpoteka.getText());
            BigDecimal initialPayment = new BigDecimal(initialPaymentField.getText());
            BigDecimal annualInterestRate = BigDecimal.valueOf(0.15);
            BigDecimal monthlyInterestRate = annualInterestRate.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);
            int term = Integer.parseInt(yearIpoteka.getText()) * 12;

            BigDecimal minInitialPayment = loanAmount.multiply(BigDecimal.valueOf(0.1));
            if (initialPayment.compareTo(minInitialPayment) < 0) {
                throw new IllegalArgumentException("Первоначальный взнос должен быть не менее 10% от суммы займа");
            }

            BigDecimal numerator = monthlyInterestRate.multiply(BigDecimal.ONE.add(monthlyInterestRate).pow(term));
            BigDecimal denominator = BigDecimal.ONE.add(monthlyInterestRate).pow(term).subtract(BigDecimal.ONE);
            BigDecimal monthlyPayment = loanAmount.subtract(initialPayment).multiply(numerator).divide(denominator, 10, RoundingMode.HALF_UP);

            resLabel.setText("Ежемесячный платеж: " + monthlyPayment.setScale(2, RoundingMode.HALF_UP));
        } catch (NumberFormatException e) {
            resLabel.setText("Ошибка ввода данных: Некорректный формат числа");
        } catch (IllegalArgumentException e) {
            resLabel.setText("Ошибка ввода данных: " + e.getMessage());
        }
    }
}
