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

/**
 *
 * @author mariadefarges
 */
public class DoctorInfoController {


    private Parent root;
    private Stage stage;
    private Scene scene;

    Doctor doctor;

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @FXML
    Button returnButton, changepwButton;

    @FXML
    Label nameText, surnameText, genderText, hospitalText, emailText;
    
        public void setInfo (){
        nameText.setText(this.doctor.getName());
        surnameText.setText(this.doctor.getSurname());
        genderText.setText(this.doctor.getGender());
        hospitalText.setText(this.doctor.getHospital());
        emailText.setText(this.doctor.getEmail());
           
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

    @FXML
    private void changePassword(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/changepassword.fxml"));
        root = loader.load();
        ChangePasswordController changepassword = loader.getController();
        changepassword.setDoctor(doctor);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

}
