/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jdbc.JDBCDoctorManager;
import pojos.Doctor;

/**
 *
 * @author mariadefarges
 */
public class MainScreenController {
    
    private static JDBCDoctorManager jdbcdoctorManager;

    private Parent root;
    private Stage stage;
    private Scene scene;
    
    private Doctor doctor;
    
    @FXML
    Button returnButton;
    
    @FXML
    Button addButton;
    
    @FXML
    Button existingButton;
    
    @FXML
    Label welcomeText;
    
    public void setJdbcdoctorManager(JDBCDoctorManager jdbcdoctorManager) {
        LoginController.jdbcdoctorManager = jdbcdoctorManager;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText.setText(welcomeText);
    }
    
    
    @FXML
    private void ChangeToAddPatient(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/addpatientscreen.fxml"));
        root = loader.load();
        //LoginController logincontroller = loader.getController();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
        
    }
    

    @FXML
    private void ChangeToExistingPatient(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/existingpatientscreen.fxml"));
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
        stage.show();

    }
    
    
    
}
