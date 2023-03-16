/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import jdbc.JDBCConditionManager;
import jdbc.JDBCDoctorManager;
import jdbc.JDBCManager;
import jdbc.JDBCPatientManager;
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
public class QuestionnaireController {
    
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
    RadioButton yesChestpain, noChestpain;

    @FXML
    RadioButton yesSweating, noSweating;

    @FXML
    RadioButton yesNausea, noNausea;

    @FXML
    RadioButton yesLegpain, noLegpain;

    @FXML
    RadioButton yesSkinc, noSkinc;

    @FXML
    RadioButton normalPulse, increasedPulse, decreasedPulse, irregularPulse;

    @FXML
    RadioButton yesSwelling, noSwelling;

    @FXML
    RadioButton yesWeakness, noWeakness;

    @FXML
    RadioButton yesSob, noSob;

    @FXML
    RadioButton yesFatigue, noFatigue;

    @FXML
    RadioButton yesHeadache, noHeadache;

    @FXML
    RadioButton yesDizziness, noDizziness;

    @FXML
    RadioButton yesUbp, noUbp;

    @FXML
    RadioButton yesTc, noTc;

    @FXML
    RadioButton yesHbp, noHbp;

    @FXML
    Button okButton;

    ToggleGroup chestpainGroup, sweatingGroup, nauseaGroup, legpainGroup, skincGroup, pulseGroup,
            swellingGroup, weaknessGroup, sobGroup, fatigueGroup, headacheGroup, dizzinessGroup,
            ubpGroup, tcGroup, hbpGroup;

    public void setButtons() {

        this.chestpainGroup = new ToggleGroup();
        this.yesChestpain.setToggleGroup(this.chestpainGroup);
        this.noChestpain.setToggleGroup(this.chestpainGroup);

        this.sweatingGroup = new ToggleGroup();
        this.yesSweating.setToggleGroup(this.sweatingGroup);
        this.noSweating.setToggleGroup(this.sweatingGroup);

        this.nauseaGroup = new ToggleGroup();
        this.yesNausea.setToggleGroup(this.nauseaGroup);
        this.noNausea.setToggleGroup(this.nauseaGroup);

        this.legpainGroup = new ToggleGroup();
        this.yesLegpain.setToggleGroup(this.legpainGroup);
        this.noLegpain.setToggleGroup(this.legpainGroup);

        this.skincGroup = new ToggleGroup();
        this.yesSkinc.setToggleGroup(this.skincGroup);
        this.noSkinc.setToggleGroup(this.skincGroup);

        this.pulseGroup = new ToggleGroup();
        this.normalPulse.setToggleGroup(this.pulseGroup);
        this.increasedPulse.setToggleGroup(this.pulseGroup);
        this.decreasedPulse.setToggleGroup(this.pulseGroup);
        this.irregularPulse.setToggleGroup(this.pulseGroup);

        this.swellingGroup = new ToggleGroup();
        this.yesSwelling.setToggleGroup(this.swellingGroup);
        this.noSwelling.setToggleGroup(this.swellingGroup);

        this.weaknessGroup = new ToggleGroup();
        this.yesWeakness.setToggleGroup(this.weaknessGroup);
        this.noWeakness.setToggleGroup(this.weaknessGroup);

        this.sobGroup = new ToggleGroup();
        this.yesSob.setToggleGroup(this.sobGroup);
        this.noSob.setToggleGroup(this.sobGroup);

        this.fatigueGroup = new ToggleGroup();
        this.yesFatigue.setToggleGroup(this.fatigueGroup);
        this.noFatigue.setToggleGroup(this.fatigueGroup);

        this.headacheGroup = new ToggleGroup();
        this.yesHeadache.setToggleGroup(this.headacheGroup);
        this.noHeadache.setToggleGroup(this.headacheGroup);

        this.dizzinessGroup = new ToggleGroup();
        this.yesDizziness.setToggleGroup(this.dizzinessGroup);
        this.noDizziness.setToggleGroup(this.dizzinessGroup);

        this.ubpGroup = new ToggleGroup();
        this.yesUbp.setToggleGroup(this.ubpGroup);
        this.noUbp.setToggleGroup(this.ubpGroup);

        this.tcGroup = new ToggleGroup();
        this.yesTc.setToggleGroup(this.tcGroup);
        this.noTc.setToggleGroup(this.tcGroup);

        this.hbpGroup = new ToggleGroup();
        this.yesHbp.setToggleGroup(this.hbpGroup);
        this.noHbp.setToggleGroup(this.hbpGroup);

    }

    @FXML
    private void changeToResults(ActionEvent e) throws IOException, SQLException {
        boolean sweating = false;
        boolean nausea = false;
        boolean legsPain = false;
        boolean skinChanges = false;
        boolean decreasedpulse = false;
        boolean shortnessOfBreath = false;
        boolean fatigue = false;
        boolean increasedpulse = false;
        boolean headache = false;
        boolean dizziness = false;
        boolean upperBodyPain = false;
        boolean temperatureChanges = false;
        boolean highBloodPressure = false;
        boolean weakness = false;
        boolean irregularHeartBeat = false;
        boolean swellingLegs = false;
        boolean chestPain = false;

        //CHEST PAIN
        if (chestpainGroup.getSelectedToggle() == yesChestpain) {
            chestPain = true;
        }
        if (chestpainGroup.getSelectedToggle() == noChestpain) {
            chestPain = false;
        }
        //SWEATING
        if (sweatingGroup.getSelectedToggle() == yesSweating) {
            sweating = true;
        }
        if (sweatingGroup.getSelectedToggle() == noSweating) {
            sweating = false;
        }
        //NAUSEA
        if (nauseaGroup.getSelectedToggle() == yesNausea) {
            nausea = true;
        }
        if (nauseaGroup.getSelectedToggle() == noNausea) {
            nausea = false;
        }
        //LEGS PAIN
        if (legpainGroup.getSelectedToggle() == yesLegpain) {
            legsPain = true;
        }
        if (sweatingGroup.getSelectedToggle() == noLegpain) {
            legsPain = false;
        }
        //SKIN CHANGES
        if (skincGroup.getSelectedToggle() == yesSkinc) {
            skinChanges = true;
        }
        if (skincGroup.getSelectedToggle() == noSkinc) {
            skinChanges = false;
        }
        //PULSE
        if (pulseGroup.getSelectedToggle() == decreasedPulse) {
            decreasedpulse = true;
        }
        if (pulseGroup.getSelectedToggle() == increasedPulse) {
            increasedpulse = true;
        }
        if (pulseGroup.getSelectedToggle() == irregularPulse) {
            irregularHeartBeat = true;
        }
        if (pulseGroup.getSelectedToggle() == normalPulse) {
            decreasedpulse = false;
            increasedpulse = false;
            irregularHeartBeat = false;
        }
        //SWELLING
        if (swellingGroup.getSelectedToggle() == yesSwelling) {
            swellingLegs = true;
        }
        if (skincGroup.getSelectedToggle() == noSwelling) {
            swellingLegs = false;
        }
        //WEAKNESS
        if (weaknessGroup.getSelectedToggle() == yesWeakness) {
            weakness = true;
        }
        if (weaknessGroup.getSelectedToggle() == noWeakness) {
            weakness = false;
        }
        //SHORTNESS OF BREATH
        if (sobGroup.getSelectedToggle() == yesSob) {
            shortnessOfBreath = true;
        }
        if (sobGroup.getSelectedToggle() == noSob) {
            shortnessOfBreath = false;
        }
        //FATIGUE
        if (fatigueGroup.getSelectedToggle() == yesFatigue) {
            fatigue = true;
        }
        if (fatigueGroup.getSelectedToggle() == noFatigue) {
            fatigue = false;
        }
        //HEADACHE
        if (headacheGroup.getSelectedToggle() == yesHeadache) {
            headache = true;
        }
        if (headacheGroup.getSelectedToggle() == noHeadache) {
            headache = false;
        }
        //DIZZINESS
        if (dizzinessGroup.getSelectedToggle() == yesDizziness) {
            dizziness = true;
        }
        if (dizzinessGroup.getSelectedToggle() == noDizziness) {
            dizziness = false;
        }
        //UPPER BODY PAIN
        if (ubpGroup.getSelectedToggle() == yesUbp) {
            upperBodyPain = true;
        }
        if (ubpGroup.getSelectedToggle() == noUbp) {
            upperBodyPain = false;
        }
        //TEMPERATURE CHANGES
        if (tcGroup.getSelectedToggle() == yesTc) {
            temperatureChanges = true;
        }
        if (tcGroup.getSelectedToggle() == noTc) {
            temperatureChanges = false;
        }
        //HIGH BLOOD PRESSURE
        if (hbpGroup.getSelectedToggle() == yesHbp) {
            highBloodPressure = true;
        }
        if (hbpGroup.getSelectedToggle() == noHbp) {
            highBloodPressure = false;
        }

        Condition condition = new Condition(chestPain, sweating, nausea, legsPain, skinChanges, decreasedpulse,
                swellingLegs, shortnessOfBreath, fatigue, increasedpulse, headache, dizziness, upperBodyPain,
                temperatureChanges, highBloodPressure, irregularHeartBeat, weakness);
        
        patient.setConditions(condition);
        patient.getDisease().setArrythmia(0);
        patient.getDisease().setHeartBurn(0);
        patient.getDisease().setHeartFailure(0);
        patient.getDisease().setHypertension(0);
        patient.getDisease().setMyocardialInfarction(0);
        patient.getDisease().setStroke(0);
        patient.getDisease().setpArterialDisease(0);
        
        JDBCManager manager = new JDBCManager();
        JDBCConditionManager conditionmanager = new JDBCConditionManager(manager);
        conditionmanager.addCondition(condition, patient.getPatientId());
        
        
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

        KieSession ksession = kc.newKieSession("CardiovascularDiagnosisKS");
        ksession.insert(patient);
        ksession.fireAllRules();
        System.out.println("Myocardial Infarction: " + patient.getDisease().getMyocardialInfarction());
        System.out.println("Heart Failure: " + patient.getDisease().getHeartFailure());
        System.out.println("Peripheral Arterial Disease: " + patient.getDisease().getpArterialDisease());
        System.out.println("Heart Burn: " + patient.getDisease().getHeartBurn());
        System.out.println("Stroke: " + patient.getDisease().getStroke());
        System.out.println("Arrythmia: " + patient.getDisease().getArrythmia());
        System.out.println("Hypertension: " + patient.getDisease().getHypertension());
        ksession.dispose();

 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlfiles/resultstestscreen.fxml"));
        root = loader.load();
        ResultsTestController resultstest = loader.getController();
        resultstest.setDoctor(doctor);
        resultstest.setPatient(patient);
        resultstest.setResults();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

}
