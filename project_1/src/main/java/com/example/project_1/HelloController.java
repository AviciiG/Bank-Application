package com.example.project_1;

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
public class HelloController {


        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label BankName;

        @FXML
        private Button SignInButton;

        @FXML
        private ImageView iconUser;

        @FXML
        private TextField idField;

        @FXML
        private TextField nameField;
    @FXML
    private CheckBox man;
    @FXML
    private CheckBox woman;
    @FXML
    private TextField lastnameField;

    @FXML
    private PasswordField passField;
    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        SignInButton.setOnAction(event -> {
//            dbHandler.signUpUser(nameField.getText(), lastnameField.getText(),passField.getText(),gendidField.getText() );
            String loginText = nameField.getText().trim();
            String loginPassword = passField.getText().trim();
            if(!loginText.equals("")&& !loginPassword.equals(""))
                loginUser(loginText,loginPassword);
            else
                System.out.println("error data");

            Stage currentStage = (Stage) SignInButton.getScene().getWindow();
            currentStage.hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/project_1/view2/view2.fxml"));

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

    private void loginUser(String loginText, String loginPassword) {

    }
}

