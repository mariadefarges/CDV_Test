/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

/**
 *
 * @author carlo
 */

import pojos.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Menu {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

        execute(kc);
    }
    
    
    public static void execute(KieContainer kc) {
        
        boolean sweating = true;
        boolean nausea = true;
    
        boolean legsPain = true;
        boolean skinChanges = true;
        boolean decreasedPulse = true;
    
        
        boolean shortnessOfBreath = false;
        boolean tiredness = false;
    
        boolean increasedPulse = true;
        boolean headache = true;
        boolean dizziness = true;
    
        boolean neckShoulderBackPain = true;
        boolean temperatureChanges = true;
        boolean highBloodPressure = true;
        
        boolean weakness = true;
        
        //constraint attributes
        boolean irregularHeartBeat = false;
        boolean legsSwealing = true;
        boolean chestPain = false;
        
        KieSession ksession = kc.newKieSession("CardiovascularDiagnosisKS");
        Patient p1 = new Patient( chestPain,  sweating,  nausea,  legsPain, 
             skinChanges,  decreasedPulse,  legsSwealing, 
             shortnessOfBreath,  tiredness,  increasedPulse, 
             headache,  dizziness,  neckShoulderBackPain,  temperatureChanges,
             highBloodPressure,  irregularHeartBeat,  weakness);
        
        ksession.insert(p1);
        ksession.fireAllRules();
        System.out.println("Myocardial Infarction: " + p1.getDisease().getMyocardialInfarction());
        System.out.println("Heart Failure: " + p1.getDisease().getHeartFailure());
        System.out.println("Peripheral Arterial Disease: " + p1.getDisease().getpArterialDisease());
        System.out.println("Heart Burn: " + p1.getDisease().getHeartBurn());
        System.out.println("Stroke: " + p1.getDisease().getStroke());
        System.out.println("Arrythmia: " + p1.getDisease().getArrythmia());
        System.out.println("Hypertension: " + p1.getDisease().getHypertension());
        
        
        ksession.dispose();

    }
}
