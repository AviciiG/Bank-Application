package com.example.project_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.PrintStream;
import java.text.DecimalFormat;

public class AccountController {
    @FXML
    private TextField replenishAccountField;//внести сумму
    @FXML
    private TextField tookWithdrawAccountField;//снять сумму
    @FXML
    private Label myAccount;//мой счет
    @FXML
    private Button replenish;//кнопка для ввода
    @FXML
    private Button tookOut;//кнопка для вывода
    @FXML
    void initialize() {
        replenish.setOnAction(event -> {
            try{
                double replenAcc=Double.parseDouble(replenishAccountField.getText());
                double tookOut=Double.parseDouble(replenishAccountField.getText());
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                double accountFool=0;

                if(accountFool>0){
                    accountFool+=replenAcc;
                    String formattedAccount = decimalFormat.format(accountFool);
                    System.out.println("Мой счет: "+ formattedAccount);
                    myAccount.setText("Мой счет: "+formattedAccount);
                }
                if(accountFool>0 && accountFool<=replenAcc){
                    accountFool-=replenAcc;
                    String formattedAccount = decimalFormat.format(accountFool);
                    System.out.println("Мой счет: "+ formattedAccount);
                    myAccount.setText("Мой счет: "+formattedAccount);
                }else if(accountFool<=0){
                    String formattedAccount = decimalFormat.format(accountFool);
                    System.out.println("Недостаточно средств для снятия!");
                    myAccount.setText("Недостаточно средств для снятия!");
                }
            } catch (NumberFormatException e) {
                // Выводим сообщение об ошибке, если введены некорректные данные
                myAccount.setText("Ошибка ввода данных");
            }
        });
        tookOut.setOnAction(event ->{
            try {
                double replenAcc = Double.parseDouble(tookWithdrawAccountField.getText());
                double tookOut = Double.parseDouble(tookWithdrawAccountField.getText());
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                double accountFool = 0;
                if (accountFool > 0 && accountFool <= replenAcc) {
                    accountFool -= replenAcc;
                    String formattedAccount = decimalFormat.format(accountFool);
                    System.out.println("Мой счет: " + formattedAccount);
                    myAccount.setText("Мой счет: " + formattedAccount);
                } else if (accountFool <= 0) {
                    String formattedAccount = decimalFormat.format(accountFool);
                    System.out.println("Недостаточно средств для снятия!");
                    myAccount.setText("Недостаточно средств для снятия!");
                }
            }catch (NumberFormatException e) {
                // Выводим сообщение об ошибке, если введены некорректные данные
                myAccount.setText("Ошибка ввода данных");
            }
        });
    }
}