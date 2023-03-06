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

/**
 *
 * @author mariadefarges
 */
public class RegisterController {

    private static JDBCDoctorManager jdbcdoctorManager;

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
    

    public static void setJDBCdoctorManager(JDBCDoctorManager jdbcdoctorManager) {
        RegisterController.jdbcdoctorManager = jdbcdoctorManager;
    }
    
    @FXML
    private void register() throws IOException, NoSuchAlgorithmException, SQLException{

        String email, password, repeatpw;
        

        email = emailText.getText();
        
        String checkEmail  = jdbcdoctorManager.checkEmail(email);
        
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
       
        /*if(user == "" || cPassword == "" || nPassword == ""){
            errorPopup.errorPopup(2);
            return;
        }*/
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] hash2 = md.digest();
        String hash = new String(hash2, 0, hash2.length);
        
        

        /*if(u == null){
            errorPopup.errorPopup(5);
            return;
        }*/

        String name = nameText.getText();
        

        /*successPopup.successPopup(12);
        Stage stage = (Stage) button.getScene().getWindow();
		stage.close();
*/

    }

}
