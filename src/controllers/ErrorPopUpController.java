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

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.stage.*;

public class ErrorPopUpController {

    @FXML
    private Label errorText;

    private Parent rootError;
    private Stage stageError;
    private Scene sceneError;

    public ErrorPopUpController() {
    }

    public void displayErrorText(String text) {

        errorText.setText(text);
        errorText.setWrapText(true);
    }

    public void errorPopup(int errorType) throws IOException {
        FXMLLoader loaderError;

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
                stageError.setTitle("Error 0");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 1:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("The email already exists.\nPlease log in or introduce a new one");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: Email is already registered");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 2:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("The email is not registered.\nPlease register");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: Email not registered");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 3:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("The passwords do not match.\nPlease repeat your password");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: Incorrect passwords");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 4:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Any gender was selected \nPlease select the gender");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: Gender selection");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 5:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Any email was introduced \nPlease introduce yor email");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: No email");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 6:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Any password was introduced \nPlease introduce a password");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: No password");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 7:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Any name was introduced \nPlease introduce your name");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: No name");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 8:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Any surname was introduced \nPlease introduce your surname");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: No surname");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 9:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Any hospital was introduced \nPlease introduce your hospital");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: No hospital");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 10:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Any name was introduced \nPlease introduce the patient's name");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: No name");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 11:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Any surname was introduced \nPlease introduce the patient's surname");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: No surname");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 12:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Any weight was introduced \nPlease introduce the patient's weight");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: No weigth");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 13:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Any background was introduced \nPlease introduce the patient's background");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: No background");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 14:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Incorrect previous password.");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: Incorrect previous password");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 15:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("No diagnosis has been done yet");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: No previous diagnosis");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 16:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Incomplete questionnaire.\nPlease select every symptom");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: Incomplete questionnaire");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 17:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Incorrect password.\nPlease try again");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: Incorrect password");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 18:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Invalid birth date.\nPlease select a valid (past) date");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: Invalid birth date");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 19:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Invalid weight.\nPlease introduce the weight as a number");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: Invalid weight");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 20:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("Please select the group and the Rh factor of the bloodtype");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: Invalid bloodtype");
                stageError.setResizable(false);
                stageError.show();
                break;
            case 21:
                loaderError = new FXMLLoader(getClass().getResource("/fxmlfiles/errorPopUp.fxml"));
                rootError = loaderError.load();
                errorPopupController = loaderError.getController();
                errorPopupController.displayErrorText("SQL Exception");
                sceneError = new Scene(rootError);
                stageError = new Stage();
                stageError.setScene(sceneError);
                stageError.setTitle("Error: SQL Exception");
                stageError.setResizable(false);
                stageError.show();
                break;
        }
    }
}
