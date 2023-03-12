/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author carme
 */
public class CorrectPopUpController {
    
    @FXML
    private Label correctText;
    
    private Parent rootCorrect;
    private Stage stageCorrect;
    private Scene sceneCorrect;

    public CorrectPopUpController() {
    }

   

    public void displayCorrectText(String text) {

        correctText.setText(text);
        correctText.setWrapText(true);
    }

    public void correctPopup(int correctType) throws IOException {
        FXMLLoader loaderCorrect;

        CorrectPopUpController correctPopupController;
        switch (correctType) {
            case 0:
                loaderCorrect = new FXMLLoader(getClass().getResource("/fxmlfiles/correctPopUp.fxml"));
                rootCorrect = loaderCorrect.load();
                correctPopupController = loaderCorrect.getController();
                correctPopupController.displayCorrectText("Successful registration.\n All the data has been registered correctly");
                sceneCorrect = new Scene(rootCorrect);
                stageCorrect = new Stage();
                stageCorrect.setScene(sceneCorrect);
                stageCorrect.setTitle("Successful registration");
                stageCorrect.setAlwaysOnTop(true);
                stageCorrect.setResizable(false);
                stageCorrect.show();
                break;
            case 1:
                loaderCorrect = new FXMLLoader(getClass().getResource("/fxmlfiles/correctPopUp.fxml"));
                rootCorrect = loaderCorrect.load();
                correctPopupController = loaderCorrect.getController();
                correctPopupController.displayCorrectText("The patient has been added successfully");
                sceneCorrect = new Scene(rootCorrect);
                stageCorrect = new Stage();
                stageCorrect.setScene(sceneCorrect);
                stageCorrect.setTitle("Add patient succesful");
                stageCorrect.setAlwaysOnTop(true);
                stageCorrect.setResizable(false);
                stageCorrect.alwaysOnTopProperty();
                stageCorrect.show();
                
                break;
     

        }
    }
    
}
