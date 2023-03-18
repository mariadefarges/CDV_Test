/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import jdbc.JDBCDoctorManager;
import jdbc.JDBCManager;
import jdbc.JDBCPatientManager;
import pojos.Doctor;
import pojos.Patient;

/**
 *
 * @author mariadefarges
 */
public class ListofPatientsController {

    private Parent root;
    private Stage stage;
    private Scene scene;

    private ErrorPopUpController ep = new ErrorPopUpController();

    @FXML
    Button returnButton;

    @FXML
    Label listText;

    Doctor doctor;

    @FXML
    TableView<Patient> ResultsTableView;

    @FXML
    TableColumn<Patient, String> tableID = new TableColumn<>("tableId");

    @FXML
    TableColumn<Patient, String> tableName = new TableColumn<>("tableName");

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setTable() throws SQLException {
        JDBCManager manager = new JDBCManager();
        JDBCPatientManager patientmanager = new JDBCPatientManager(manager);
        List<Patient> patients;
        patients = patientmanager.getPatientsOfDoctor(doctor.getDoctorId());
        listText.setText("List of Mr/Mrs " + doctor.getName() + " " + doctor.getSurname() + " patients:");
        if (!patients.isEmpty()) {
            ResultsTableView.getItems().clear();
            ResultsTableView.getColumns().clear();
            ResultsTableView.getItems().addAll(patients);
            tableID.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getPatientId())));
            tableName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName() + " " + data.getValue().getSurname()));
            ResultsTableView.getColumns().addAll(tableID, tableName);
        }
    }

    @FXML
    private void selectedPatient(MouseEvent Mevent) throws IOException {
        Patient patient = ResultsTableView.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/patientinfoscreen.fxml"));
        root = loader.load();
        PatientInfoController patientcontroller = loader.getController();
        patientcontroller.setDoctor(doctor);
        patientcontroller.setPatient(patient);
        patientcontroller.setInfo();
        //drs.DiseaseView(disease);
        stage = (Stage) ((Node) Mevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
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
