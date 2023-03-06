/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author mariadefarges
 */
public class Condition {
    

    private Integer conditionId;
    
    private boolean chestPain;
    private boolean sweating;
    private boolean nausea;
    
    private boolean legsPain;
    private boolean skinChanges;
    private boolean decreasedPulse;
    
    private boolean swellingLegs;
    private boolean shortnessOfBreath;
    private boolean fatigue;
    
    private boolean increasedPulse;
    private boolean headache;
    private boolean dizziness;
    
    private boolean upperBodyPain;
    private boolean temperatureChanges;
    private boolean highBloodPressure;
    private boolean irregularHeartBeat;
    private boolean weakness;

    public Condition(boolean chestPain, boolean sweating, boolean nausea, boolean legsPain, boolean skinChanges, boolean decreasedPulse, boolean swellingLegs, boolean shortnessOfBreath, boolean fatigue, boolean increasedPulse, boolean headache, boolean dizziness, boolean upperBodyPain, boolean temperatureChanges, boolean highBloodPressure, boolean irregularHeartBeat, boolean weakness) {
        
        this.chestPain = chestPain;
        this.sweating = sweating;
        this.nausea = nausea;
        this.legsPain = legsPain;
        this.skinChanges = skinChanges;
        this.decreasedPulse = decreasedPulse;
        this.swellingLegs = swellingLegs;
        this.shortnessOfBreath = shortnessOfBreath;
        this.fatigue = fatigue;
        this.increasedPulse = increasedPulse;
        this.headache = headache;
        this.dizziness = dizziness;
        this.upperBodyPain = upperBodyPain;
        this.temperatureChanges = temperatureChanges;
        this.highBloodPressure = highBloodPressure;
        this.irregularHeartBeat = irregularHeartBeat;
        this.weakness = weakness;
    }

 
    

    public void setTemperatureChanges(boolean temperatureChanges) {
        this.temperatureChanges = temperatureChanges;
    }

    public boolean isTemperatureChanges() {
        return temperatureChanges;
    }

    public boolean isChestPain() {
        return chestPain;
    }

    public boolean isLegsPain() {
        return legsPain;
    }

    public boolean isSkinChanges() {
        return skinChanges;
    }

    public boolean isDecreasedPulse() {
        return decreasedPulse;
    }

    public boolean isSwellingLegs() {
        return swellingLegs;
    }

    public boolean isShortnessOfBreath() {
        return shortnessOfBreath;
    }

    public boolean isIncreasedPulse() {
        return increasedPulse;
    }

    public boolean isUpperBodyPain() {
        return upperBodyPain;
    }

    public Condition() {
        this.conditionId = null;
    }
    
    public Integer getConditionId() {
        return conditionId;
    }

    public boolean isSweating() {
        return sweating;
    }

    public boolean isNausea() {
        return nausea;
    }

    public boolean isFatigue() {
        return fatigue;
    }

    public boolean isHeadache() {
        return headache;
    }

    public boolean isDizziness() {
        return dizziness;
    }


    public void setSweating(boolean sweating) {
        this.sweating = sweating;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public void setFatigue(boolean fatigue) {
        this.fatigue = fatigue;
    }

    public void setHeadache(boolean headache) {
        this.headache = headache;
    }

    public void setDizziness(boolean dizziness) {
        this.dizziness = dizziness;
    }

    
    public void setChestPain(boolean chestPain) {
        this.chestPain = chestPain;
    }

    public void setLegsPain(boolean legsPain) {
        this.legsPain = legsPain;
    }

    public void setSkinChanges(boolean skinChanges) {
        this.skinChanges = skinChanges;
    }

    public void setDecreasedPulse(boolean decreasedPulse) {
        this.decreasedPulse = decreasedPulse;
    }

    public void setSwellingLegs(boolean swellingLegs) {
        this.swellingLegs = swellingLegs;
    }

    public void setShortnessOfBreath(boolean shortnessOfBreath) {
        this.shortnessOfBreath = shortnessOfBreath;
    }

    public void setIncreasedPulse(boolean increasedPulse) {
        this.increasedPulse = increasedPulse;
    }

    public void setUpperBodyPain(boolean upperBodyPain) {
        this.upperBodyPain = upperBodyPain;
    }

    public void setHighBloodPressure(boolean highBloodPressure) {
        this.highBloodPressure = highBloodPressure;
    }

    public void setIrregularHeartBeat(boolean irregularHeartBeat) {
        this.irregularHeartBeat = irregularHeartBeat;
    }

    public void setWeakness(boolean weakness) {
        this.weakness = weakness;
    }

    public boolean isHighBloodPressure() {
        return highBloodPressure;
    }

    public boolean isIrregularHeartBeat() {
        return irregularHeartBeat;
    }

    public boolean isWeakness() {
        return weakness;
    }
 
}
