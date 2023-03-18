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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdbc.JDBCDoctorManager;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import jdbc.JDBCManager;
import jdbc.JDBCPatientManager;
import pojos.Doctor;
import pojos.Patient;

/**
 *
 * @author mariadefarges
 */
public class AddPatientController {

    private ErrorPopUpController ep = new ErrorPopUpController();
    private CorrectPopUpController cp = new CorrectPopUpController();

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    Button returnButton, okButton;

    @FXML
    TextField nameText;

    @FXML
    TextField surnameText;

    @FXML
    DatePicker dob;

    @FXML
    TextField weightText;

    @FXML
    TextField backgroundText;

    String group = null;
    String rh = null;

    @FXML
    private void Agroup(ActionEvent e) {
        group = "A";
    }

    @FXML
    private void Bgroup(ActionEvent e) {
        group = "B";
    }

    @FXML
    private void ABgroup(ActionEvent e) {
        group = "AB";
    }

    @FXML
    private void Ogroup(ActionEvent e) {
        group = "O";
    }

    @FXML
    private void plusrh(ActionEvent e) {
        rh = "+";
    }

    @FXML
    private void minusrh(ActionEvent e) {
        rh = "-";
    }

    @FXML
    RadioButton maleButton, femaleButton;

    ToggleGroup genderGroup;

    Doctor doctor;

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setButtons() {
        this.genderGroup = new ToggleGroup();
        maleButton.setToggleGroup(this.genderGroup);
        femaleButton.setToggleGroup(this.genderGroup);
    }

    @FXML
    private void addpatient(ActionEvent e) throws IOException, SQLException {

        String name = "";
        name = nameText.getText();
        if (name.equals("")) {
            ep.errorPopup(10);
            return;
        }
        String surname = "";
        surname = surnameText.getText();
        if (surname.equals("")) {
            ep.errorPopup(11);
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
        if (gender.equals("")) {
            System.out.println("Any gender selected");
            ep.errorPopup(4);
            return;
        }
        //Date Picker
        LocalDate date = dob.getValue();
        Date birthdate = Date.valueOf(date);
        if (birthdate.after(Date.valueOf(LocalDate.now()))) {
            ep.errorPopup(18);
            return;
        }

        String weighttext = "";
        weighttext = weightText.getText();
        if (weighttext.equals("")) {
            ep.errorPopup(12);
            return;
        }
        boolean isNumeric = ( weighttext != null &&   weighttext.matches("[0-9]+"));
        if (isNumeric == false) {
            ep.errorPopup(19);
            return;
        }

        Float weight = Float.parseFloat(weighttext);
       
        if (group == null || rh == null) {
            ep.errorPopup(20);
            return;
        }

        String bloodtype = group + " " + rh;

        String background = "";
        background = backgroundText.getText();
        if (background.equals("")) {
            ep.errorPopup(13);
            return;
        }

        Patient patient = new Patient(name, surname, gender, birthdate, weight, bloodtype, background);
        JDBCManager manager = new JDBCManager();
        JDBCPatientManager patientmanager = new JDBCPatientManager(manager);
        patientmanager.addPatient(patient, doctor.getDoctorId());

        //SUCESS POP UP
        cp.correctPopup(1);
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
