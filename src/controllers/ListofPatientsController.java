/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
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
import javafx.stage.Stage;
import jdbc.JDBCDoctorManager;
import jdbc.JDBCPatientManager;
import pojos.Doctor;
import pojos.Patient;

/**
 *
 * @author mariadefarges
 */
public class ListofPatientsController {

    static JDBCDoctorManager jdbcdoctorManager;
    static JDBCPatientManager jdbcpatientManager;

    private Parent root;
    private Stage stage;
    private Scene scene;

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

    public void setJDBC(JDBCDoctorManager jdbcdoctorManager, JDBCPatientManager jdbcpatientManager) {
        this.jdbcdoctorManager = jdbcdoctorManager;
        this.jdbcpatientManager = jdbcpatientManager;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setTable() {
        try {
            List<Patient> patients;
            patients = jdbcpatientManager.getPatientsOfDoctor(doctor.getDoctorId());
            listText.setText("List of Mr/Mrs " + doctor.getName() + " " + doctor.getSurname() + " patients:");
            if (!patients.isEmpty()) {
                ResultsTableView.getItems().clear();
                ResultsTableView.getColumns().clear();
                ResultsTableView.getItems().addAll(patients);
                tableID.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getPatientId())));
                tableName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName() + " " + data.getValue().getSurname()));
                ResultsTableView.getColumns().addAll(tableID, tableName);

            }
        } catch (Exception e) {
            e.printStackTrace();
            // ErrorPopup.errorPopup(0);
            return;
        }
    }

    @FXML
    private void selectedPatient(MouseEvent Mevent) throws IOException {
        Patient patient = ResultsTableView.getSelectionModel().getSelectedItem();
        if (patient == null) {
            //Error POP UP
            //System.out.println("Nothing selected");
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/patientinfoscreen.fxml"));
            root = loader.load();
            //DiseaseViewController drs = loader.getController();
            //drs.DiseaseView(disease);
            stage = (Stage) ((Node) Mevent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
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
