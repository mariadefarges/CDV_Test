/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author carlo
 */

import javafx.event.ActionEvent;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.*;
import jdbc.JDBCConditionManager;
import jdbc.JDBCDiseaseManager;
import jdbc.JDBCDoctorManager;
import javafx.scene.control.TextField;
import jdbc.JDBCManager;
import jdbc.JDBCPatientManager;

public class ErrorPopUpController {
	@FXML
	private Label errorDisplayText;

    public ErrorPopUpController(Label errorDisplayText) {
        this.errorDisplayText = errorDisplayText;
    }

   
        
        

	public void displayErrorText(String text) {
		errorDisplayText.setText(text);
	}
}
