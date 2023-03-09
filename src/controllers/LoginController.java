/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

//import  controllers.FirstScreenController.manager;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdbc.JDBCDoctorManager;
import pojos.Doctor;

/**
 *
 * @author mariadefarges
 */
public class LoginController {

    static JDBCDoctorManager jdbcdoctorManager;

    private Parent root;
    private Stage stage;
    private Scene scene;
    
    private ErrorPopUp ep = new ErrorPopUp();

    @FXML
    Button returnButton;

    @FXML
    private TextField emailText;

    @FXML
    private TextField passwordText;

    public void setJdbcdoctorManager(JDBCDoctorManager jdbcdoctorManager) {
        LoginController.jdbcdoctorManager = jdbcdoctorManager;
    }

    @FXML
    private void checkLogin(ActionEvent e) throws IOException, SQLException {

        String email = emailText.getText();
        String password = passwordText.getText();
        Doctor doctor = jdbcdoctorManager.checkPassword(email, password);
        System.out.println(doctor);

        if (doctor == null){
            ep.errorPopup(2);
        }
         
        //CHANGE TO MAIN SCREEN
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/mainscreen.fxml"));
        root = loader.load();
        MainScreenController maincontroller = loader.getController();
        maincontroller.setJdbcdoctorManager(jdbcdoctorManager);
        maincontroller.setDoctor(doctor);
        maincontroller.setWelcomeText("Welcome Mr/Mrs " + doctor.getName() + " " + doctor.getSurname());
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
