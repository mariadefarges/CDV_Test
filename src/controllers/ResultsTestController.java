/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static menu.Menu.execute;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import pojos.Condition;
import pojos.Doctor;
import pojos.Patient;

/**
 *
 * @author mariadefarges
 */
public class ResultsTestController {

    private Parent root;
    private Stage stage;
    private Scene scene;
    
    Doctor doctor;
    Patient patient;

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @FXML
    Label resultMI, resultHF, resultPAD, resultHB, resultH, resultS, resultA;

    @FXML
    Label resultsText;

    @FXML
    Hyperlink myocardialLink, heartfailureLink, PADLink, heartburnLink, hypertensionLink, strokeLink, arrythmiaLink;

    public void setResults() {
        resultsText.setText("Mr/Mrs " + patient.getName() + " " + patient.getSurname() + " possible diagnosis:");
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        execute(kc);
        KieSession ksession = kc.newKieSession("CardiovascularDiagnosisKS");
        ksession.insert(patient);
        ksession.fireAllRules();
        resultMI.setText("" + patient.getDisease().getMyocardialInfarction() + "%");
        resultHF.setText("" + patient.getDisease().getHeartFailure() + "%");
        resultPAD.setText("" + patient.getDisease().getpArterialDisease() + "%");
        resultHB.setText("" + patient.getDisease().getHeartBurn() + "%");
        resultH.setText("" + patient.getDisease().getHypertension() + "%");
        resultS.setText("" + patient.getDisease().getStroke() + "%");
        resultA.setText("" + patient.getDisease().getArrythmia() + "%");

    }

    @FXML
    private void myocardialInfarctionLink(MouseEvent Mevent) throws IOException {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI("https://www.ncbi.nlm.nih.gov/books/NBK537076/"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void heartfailureLink(MouseEvent Mevent) throws IOException {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI("https://medlineplus.gov/heartfailure.html"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void padLink(MouseEvent Mevent) throws IOException {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI("https://www.ncbi.nlm.nih.gov/books/NBK430745/"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void heartBurnLink(MouseEvent Mevent) throws IOException {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI("https://my.clevelandclinic.org/health/diseases/9617-heartburn-overview"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void hypertensionLink(MouseEvent Mevent) throws IOException {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI("https://www.nhs.uk/conditions/high-blood-pressure-hypertension/"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void strokeLink(MouseEvent Mevent) throws IOException {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI("https://www.nhlbi.nih.gov/health/stroke"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void arrythmiaLink(MouseEvent Mevent) throws IOException {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI("https://medlineplus.gov/arrhythmia.html"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void returnToPatientInfo(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/patientinfoscreen.fxml"));
        root = loader.load();
        PatientInfoController patientcontroller = loader.getController();
        patientcontroller.setDoctor(doctor);
        patientcontroller.setPatient(patient);
        patientcontroller.setInfo();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

}
