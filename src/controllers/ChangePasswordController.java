/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdbc.JDBCDoctorManager;
import jdbc.JDBCManager;
import jdbc.JDBCPatientManager;
import pojos.Doctor;

/**
 *
 * @author mariadefarges
 */
public class ChangePasswordController {

    private Parent root;
    private Stage stage;
    private Scene scene;
    
    private ErrorPopUpController ep = new ErrorPopUpController();
    private CorrectPopUpController cp = new CorrectPopUpController();

    Doctor doctor;

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @FXML
    TextField previousPassword, newPassword, repeatPassword;

    @FXML
    private void changePassword(ActionEvent e) throws IOException, SQLException, NoSuchAlgorithmException {
        String previousp = previousPassword.getText();
        String newp = newPassword.getText();
        String repeatp = repeatPassword.getText();

        JDBCManager manager = new JDBCManager();
        JDBCPatientManager patientmanager = new JDBCPatientManager(manager);
        JDBCDoctorManager doctormanager = new JDBCDoctorManager(manager, patientmanager);
        int checkdoctorId = doctormanager.checkPassword(previousp);
        if (checkdoctorId != doctor.getDoctorId()) {
            ep.errorPopup(14);
            return;
        }
        if (!newp.equals(repeatp)) {
            ep.errorPopup(3);
            return;
        } else {
            doctormanager.changePassword(newp, doctor.getDoctorId());
            cp.correctPopup(2);
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
