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
import jdbc.JDBCPatientManager;
import pojos.Doctor;
import pojos.Patient;

/**
 *
 * @author mariadefarges
 */
public class PatientInfoController {
    
    static JDBCDoctorManager jdbcdoctorManager;
    static JDBCPatientManager jdbcpatientManager;

    private Parent root;
    private Stage stage;
    private Scene scene;
    
    Doctor doctor;
    
    public void setJDBC(JDBCDoctorManager jdbcdoctorManager, JDBCPatientManager jdbcpatientManager) {
        this.jdbcdoctorManager = jdbcdoctorManager;
        this.jdbcpatientManager = jdbcpatientManager;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @FXML
    Button returnButton, diagnosisButton;

    @FXML
    Label nameText , surnameText, genderText, birthdateText, weightText, bloodtypeText, backgroundText;
    
    public void setInfo (Patient patient){
        nameText.setText(patient.getName());
        surnameText.setText(patient.getSurname());
        genderText.setText(patient.getGender());
        birthdateText.setText(patient.getBirthDate().toString());
        weightText.setText(patient.getWeight().toString());
        bloodtypeText.setText(patient.getBloodType());
        backgroundText.setText(patient.getBackground());       
    }
    
    
    @FXML
    private void returnToMainScreen(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/mainscreen.fxml"));
        root = loader.load();
        MainScreenController mainscreencontroller = loader.getController();
        mainscreencontroller.setDoctor(doctor);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }
}
