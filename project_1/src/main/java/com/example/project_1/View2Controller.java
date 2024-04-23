package com.example.project_1;

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



public class View2Controller {
        @FXML
        private Button CreditButton;

        @FXML
        private Button IpotekaButton;
        @FXML
        private Button DepositButton;
        @FXML
        private Button AccountButton;
        @FXML
        void initialize() {
                System.out.println("Кнопка Оформить кредит нажата!");
                CreditButton.setOnAction(event -> {
                        /// Закрываем текущее окно

                        Stage currentStage = (Stage) CreditButton.getScene().getWindow();
                        currentStage.hide();

                        // Создаем новое окно
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/com/example/project_1/view2/credit.fxml"));

                        try {
                                Parent root = loader.load();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root));
                                stage.show(); // Показываем новое окно
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                });
                IpotekaButton.setOnAction(event -> {
                        /// Закрываем текущее окно

                        Stage currentStage = (Stage) IpotekaButton.getScene().getWindow();
                        currentStage.hide();

                        // Создаем новое окно
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/com/example/project_1/view2/ipoteka.fxml"));

                        try {
                                Parent root = loader.load();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root));
                                stage.show();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                });

                DepositButton.setOnAction(event -> {

                        Stage currentStage = (Stage) DepositButton.getScene().getWindow();
                        currentStage.hide();

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/com/example/project_1/view2/deposit.fxml"));

                        try {
                                Parent root = loader.load();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root));
                                stage.show();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                });
                AccountButton.setOnAction(event ->{
                        Stage currentStage = (Stage) AccountButton.getScene().getWindow();
                        currentStage.hide();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/com/example/project_1/view2/Account.fxml"));
                        try {
                                Parent root = loader.load();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root));
                                stage.show();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                });
        }

        }


