/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author carlo
 */
import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.*;
import jdbc.JDBCConditionManager;
import jdbc.JDBCDiseaseManager;
import jdbc.JDBCDoctorManager;
import jdbc.JDBCManager;
import jdbc.JDBCPatientManager;

public class ErrorPopUp {
    
    @FXML
    Label errorText = new Label();

    public ErrorPopUp() {
    }
    
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void errorPopup(int errorType) throws IOException {
        FXMLLoader loaderError;
        Parent rootError;
        Scene sceneError;
        Stage stageError;
        Image icon;
        ErrorPopUpController errorPopupController;
        switch (errorType) {
            case 0:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Something went wrong, please check everything and try again.");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);

                icon = new Image("CVD_Test/images/errorIcon.png");
                stageError.getIcons().add(icon);
                stageError.setTitle("Error 0");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 1:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                //errorText.setText("The email already exists. Please log in or introduce a new one"); 
                //errorPopupController = new ErrorPopUpController(errorText);
                errorPopupController.displayErrorText("The email already exists. \n Please log in or introduce a new one");
                sceneError = new Scene(rootError);
                stageError = new Stage();

                //icon = new Image("CVD_Test/images/errorIcon.png");
                //stageError.getIcons().add(icon);

                stageError.setScene(sceneError);
                stageError.setTitle("Error: Email is already registered");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 2:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                //errorText.setText("The email already exists. Please log in or introduce a new one"); 
                //errorPopupController = new ErrorPopUpController(errorText);
                errorPopupController.displayErrorText("The email or password is incorrect. \n Please try again");
                sceneError = new Scene(rootError);
                stageError = new Stage();

                //icon = new Image("CVD_Test/images/errorIcon.png");
                //stageError.getIcons().add(icon);

                stageError.setScene(sceneError);
                stageError.setTitle("Error: Incorrect email or password");
                stageError.setResizable(false);
                stageError.show();
                break;

        }
    }
}
