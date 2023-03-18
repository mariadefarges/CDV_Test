/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.*;
import jdbc.JDBCConditionManager;
import jdbc.JDBCDiseaseManager;
import jdbc.JDBCDoctorManager;
import jdbc.JDBCManager;
import jdbc.JDBCPatientManager;

/**
 *
 * @author mariadefarges
 */
public class FirstScreenController {

    public static JDBCManager manager = new JDBCManager();
    public static JDBCDiseaseManager diseaseManager = new JDBCDiseaseManager(manager);
    public static JDBCPatientManager patientManager = new JDBCPatientManager(manager);
    public static JDBCDoctorManager doctorManager = new JDBCDoctorManager(manager, patientManager);
    public static JDBCConditionManager conditionManager = new JDBCConditionManager(manager);

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    Button register;

    @FXML
    Button login;

    @FXML
    private void ChangeToRegister(ActionEvent e) throws IOException {
        manager.getConnection();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/register.fxml"));
        root = loader.load();
        RegisterController registerController = loader.getController();
        registerController.setJDBCdoctorManager(doctorManager);
        registerController.setButtons();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Register");
        stage.show();
    }

    @FXML
    private void ChangeToLogin(ActionEvent e) throws IOException {
        manager.getConnection();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/login.fxml"));
        root = loader.load();
        LoginController logincontroller = loader.getController();
        logincontroller.setJDBC(doctorManager, patientManager);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("Log In");
        stage.show();
    }
}
