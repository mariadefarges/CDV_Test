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

    private Parent root;
    private Stage stage;
    private Scene scene;
    Patient patient;
    
    Doctor doctor;


    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }

    @FXML
    Button returnButton, diagnosisButton;

    @FXML
    Label nameText , surnameText, genderText, birthdateText, weightText, bloodtypeText, backgroundText;
    
    public void setInfo (){
        nameText.setText(this.patient.getName());
        surnameText.setText(this.patient.getSurname());
        genderText.setText(this.patient.getGender());
        birthdateText.setText(this.patient.getBirthDate().toString());
        weightText.setText(this.patient.getWeight().toString());
        bloodtypeText.setText(this.patient.getBloodType());
        backgroundText.setText(this.patient.getBackground());       
    }
    
    
    
     @FXML
    private void changeToQuestionnaire(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/questionnairescreen.fxml"));
        root = loader.load();
        QuestionnaireController questionnairecontroller = loader.getController();
        questionnairecontroller.setDoctor(doctor);
        questionnairecontroller.setPatient(patient);
        questionnairecontroller.setButtons();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
    
    @FXML
    private void returnToMainScreen(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/mainscreen.fxml"));
        root = loader.load();
        MainScreenController maincontroller = loader.getController();
        maincontroller.setDoctor(doctor);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }
}
