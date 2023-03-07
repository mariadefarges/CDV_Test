/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jdbc.JDBCDoctorManager;
import pojos.Doctor;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author mariadefarges
 */
public class RegisterController {

    private static JDBCDoctorManager jdbcdoctorManager;

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField emailText;
    @FXML
    private TextField passwordText;
    @FXML
    private TextField repeatPasswordText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField surnameText;

    @FXML
    private TextField hospitalText;

    @FXML
    Button returnButton;

    public static void setJDBCdoctorManager(JDBCDoctorManager jdbcdoctorManager) {
        RegisterController.jdbcdoctorManager = jdbcdoctorManager;
    }

    @FXML
    private void checkRegister(ActionEvent e) throws IOException, NoSuchAlgorithmException, SQLException {

        String email, password, repeatpw;

        email = emailText.getText();

        String checkEmail = jdbcdoctorManager.checkEmail(email);

        /*if (!checkEmail.equals("")) {
            System.out.println("The email introduced is already registered. \n");
            return;
        }*/
        password = passwordText.getText();
        repeatpw = repeatPasswordText.getText();

        /*if (!password.equals(repeatpw)){
            System.out.println("The password does not coincide");
            errorPopup.errorPopup(17);
            return;
        }*/
 /*if(password.equals("") || repeatpassword.equals("")){
            errorPopup.errorPopup(2);
            return;
        }*/
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] hash2 = md.digest();
        String hash = new String(hash2, 0, hash2.length);

        String name = nameText.getText();
        String surname = surnameText.getText();
        String hospital = hospitalText.getText();
        String gender = "";
        //gender buttons
        Doctor doctor = new Doctor(name, surname, gender, hospital, email, hash);
        jdbcdoctorManager.addDoctor(doctor);

        // successPopup.successPopup(12); USER SAVED SUCCESSFULLY
        //RETURN TO FIRST SCREEN
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/firstscreen.fxml"));
        root = loader.load();
        //LoginController logincontroller = loader.getController();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    @FXML
    private void returnToFirstScreen(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/firstscreen.fxml"));
        root = loader.load();
        //LoginController logincontroller = loader.getController();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("Log In");
        stage.show();

    }

}
