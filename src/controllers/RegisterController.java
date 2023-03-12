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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author mariadefarges
 */
public class RegisterController {

    //private static JDBCDoctorManager jdbcdoctorManager;
    private static JDBCDoctorManager jdbcdoctorManager;
    //private ErrorPopUp ep = new ErrorPopUp();
    private ErrorPopUpController ep = new ErrorPopUpController();
    private CorrectPopUpController cp = new CorrectPopUpController();
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

    @FXML
    RadioButton maleButton;

    @FXML
    RadioButton femaleButton;
    
    ToggleGroup genderGroup;

   public void setJDBCdoctorManager(JDBCDoctorManager jdbcdoctorManager) {
        RegisterController.jdbcdoctorManager = jdbcdoctorManager;
    
    }
    
    public void setButtons(){
        genderGroup = new ToggleGroup();
        maleButton.setToggleGroup(genderGroup);
        femaleButton.setToggleGroup(genderGroup);
    }

    @FXML
    private void checkRegister(ActionEvent e) throws IOException, NoSuchAlgorithmException, SQLException {

        String email="";
        String password="";
        String repeatpw= "";

        email = emailText.getText();

        String checkEmail = jdbcdoctorManager.checkEmail(email);

       
        if (!checkEmail.equals("")) {
            System.out.println("The email introduced is already registered. \n");
            ep.errorPopup(1);
           
            return;
        }
        if(email.equals("")){
            ep.errorPopup(5);
            return;
        }
        password = passwordText.getText();
        repeatpw = repeatPasswordText.getText();

        if (!password.equals(repeatpw)){
            System.out.println("The password does not coincide");
            ep.errorPopup(3);
            return;
        }
        if(password.equals("") || repeatpw.equals("")){
            ep.errorPopup(6);
            return;
        }
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] hash2 = md.digest();
        String hash = new String(hash2, 0, hash2.length);

        String name = "";
        name = nameText.getText();
         if(name.equals("")){
            ep.errorPopup(7);
            return;
        }
        String surname = "";
        surname= surnameText.getText();
         if(surname.equals("")){
            ep.errorPopup(8);
            return;
        }
        String hospital = "";
        hospital = hospitalText.getText();
         if(hospital.equals("")){
            ep.errorPopup(9);
            return;
        }

        //Gender buttons
        String gender = "";
        if (genderGroup.getSelectedToggle() == maleButton) {
            gender = "Male";
        }
        if (genderGroup.getSelectedToggle() == femaleButton) {
            gender = "Female";
        }
         if (gender.equals("")){
            System.out.println("Any gender selected");
            ep.errorPopup(4);
            return;
        }

        Doctor doctor = new Doctor(name, surname, gender, hospital, email, hash);
        jdbcdoctorManager.addDoctor(doctor);

        // successPopup.successPopup(12); USER SAVED SUCCESSFULLY
        cp.correctPopup(0);
      
        //RETURN TO FIRST SCREEN
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/firstscreen.fxml"));
        root = loader.load();
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
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("Log In");
        stage.show();

    }

}
