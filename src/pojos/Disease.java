/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author mariadefarges
 */
public class Disease {
    
    private int diseaseId;
    private int myocardialInfarction;
    private int heartFailure ;
    private int pArterialDisease;
    private int heartBurn;
    private int hypertension;
    private int stroke;
    private int arrythmia;

    public Disease(int myocardialInfarction, int heartFailure, int pArterialDisease, int heartBurn, int hypertension, int stroke, int arrythmia) {
        this.myocardialInfarction = myocardialInfarction;
        this.heartFailure = heartFailure;
        this.pArterialDisease = pArterialDisease;
        this.heartBurn = heartBurn;
        this.hypertension = hypertension;
        this.stroke = stroke;
        this.arrythmia = arrythmia;
    }
    
    public Disease(){
        this.myocardialInfarction = 0;
        this.heartFailure = 0;
        this.pArterialDisease = 0;
        this.heartBurn = 0;
        this.hypertension = 0;
        this.stroke = 0;
        this.arrythmia = 0;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public int getMyocardialInfarction() {
        return myocardialInfarction;
    }

    public int getHeartFailure() {
        return heartFailure;
    }

    public int getpArterialDisease() {
        return pArterialDisease;
    }

    public int getHeartBurn() {
        return heartBurn;
    }

    public int getHypertension() {
        return hypertension;
    }

    public int getStroke() {
        return stroke;
    }

    public int getArrythmia() {
        return arrythmia;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public void setMyocardialInfarction(int myocardialInfarction) {
        this.myocardialInfarction = myocardialInfarction;
    }

    public void setHeartFailure(int heartFailure) {
        this.heartFailure = heartFailure;
    }

    public void setpArterialDisease(int pArterialDisease) {
        this.pArterialDisease = pArterialDisease;
    }

    public void setHeartBurn(int heartBurn) {
        this.heartBurn = heartBurn;
    }

    public void setHypertension(int hypertension) {
        this.hypertension = hypertension;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public void setArrythmia(int arrythmia) {
        this.arrythmia = arrythmia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.diseaseId;
        hash = 89 * hash + this.myocardialInfarction;
        hash = 89 * hash + this.heartFailure;
        hash = 89 * hash + this.pArterialDisease;
        hash = 89 * hash + this.heartBurn;
        hash = 89 * hash + this.hypertension;
        hash = 89 * hash + this.stroke;
        hash = 89 * hash + this.arrythmia;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disease other = (Disease) obj;
        if (this.diseaseId != other.diseaseId) {
            return false;
        }
        if (this.myocardialInfarction != other.myocardialInfarction) {
            return false;
        }
        if (this.heartFailure != other.heartFailure) {
            return false;
        }
        if (this.pArterialDisease != other.pArterialDisease) {
            return false;
        }
        if (this.heartBurn != other.heartBurn) {
            return false;
        }
        if (this.hypertension != other.hypertension) {
            return false;
        }
        if (this.stroke != other.stroke) {
            return false;
        }
        return this.arrythmia == other.arrythmia;
    }

    @Override
    public String toString() {
        return "Disease{" + "diseaseId=" + diseaseId + ", myocardialInfarction=" + myocardialInfarction + ", heartFailure=" + heartFailure + ", pArterialDisease=" + pArterialDisease + ", heartBurn=" + heartBurn + ", hypertension=" + hypertension + ", stroke=" + stroke + ", arrythmia=" + arrythmia + '}';
    }

   
   
    


    
    
}
