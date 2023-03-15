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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdbc.JDBCDoctorManager;
import jdbc.JDBCPatientManager;
import pojos.Doctor;

/**
 *
 * @author mariadefarges
 */
public class MainScreenController {

    private Parent root;
    private Stage stage;
    private Scene scene;

    private Doctor doctor;

    @FXML
    Button returnButton, addButton, listButton, profileButton;

    @FXML
    Label welcomeText;
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        this.welcomeText.setText("Welcome Mr/Mrs " + doctor.getName() + " " + doctor.getSurname());
    }

    @FXML
    private void ChangeToAddPatient(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/addpatientscreen.fxml"));
        root = loader.load();
        AddPatientController addpatientcontroller = loader.getController();
        addpatientcontroller.setButtons();
        addpatientcontroller.setDoctor(doctor);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

    @FXML
    private void ChangeToProfile(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/doctorinfoscreen.fxml"));
        root = loader.load();
        DoctorInfoController doctorinfocontroller = loader.getController();
        doctorinfocontroller.setDoctor(doctor);
        doctorinfocontroller.setInfo();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

    @FXML
    private void ChangeToListPatients(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/listpatientscreen.fxml"));
        root = loader.load();
        ListofPatientsController listofpatients = loader.getController();
        listofpatients.setDoctor(doctor);
        listofpatients.setTable();
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
        stage.show();

    }

}
