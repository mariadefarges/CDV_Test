/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import static menu.Menu.execute;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import pojos.Condition;
import pojos.Patient;

/**
 *
 * @author mariadefarges
 */
public class ResultsTestController {
    
    Patient patient;

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    @FXML
    Label resultMI, resultHF, resultPAD, resultHB, resultH, resultS, resultA;
    


    
    public void setResults(Condition condition){
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        execute(kc);      
        KieSession ksession = kc.newKieSession("CardiovascularDiagnosisKS");
        ksession.insert(patient);
        ksession.fireAllRules();
        resultMI.setText(""+ patient.getDisease().getMyocardialInfarction());
        resultHF.setText(""+ patient.getDisease().getHeartFailure());
        resultPAD.setText(""+ patient.getDisease().getpArterialDisease());
        resultHB.setText(""+ patient.getDisease().getHeartBurn());
        resultH.setText(""+ patient.getDisease().getHypertension());
        resultS.setText(""+ patient.getDisease().getStroke());
        resultA.setText("" + patient.getDisease().getArrythmia());
        
        
    }
     
}
