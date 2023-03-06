/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;
import ifaces.*;
import java.sql.*;
import pojos.Condition;
/**
 *
 * @author carme
 */
public class JDBCConditionManager implements ConditionManager{
    
    private final JDBCManager manager;

    public JDBCConditionManager(JDBCManager m) {
        this.manager = m;
    }
    
    @Override
    public void addCondition(Condition c) throws SQLException {
        String sql = "INSERT INTO condition (chestPain, sweating, nausea, legsPain, skinChanges, decreasedPulse, swellingLegs,shortnessOfBreath, fatigue, increasedPulse, headache , dizziness, upperBodyPain,temperatureChanges, highBloodPressure, irregularHeartBeat, weakness  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setBoolean(1, c.isChestPain());
        prep.setBoolean(2, c.isSweating());
        prep.setBoolean(3, c.isNausea());
        prep.setBoolean(4, c.isLegsPain());
        prep.setBoolean(5, c.isSkinChanges());
        prep.setBoolean(6, c.isDecreasedPulse());
        prep.setBoolean(7, c.isSwellingLegs());
        prep.setBoolean(8, c.isShortnessOfBreath());
        prep.setBoolean(9, c.isFatigue());
        prep.setBoolean(10, c.isIncreasedPulse());
        prep.setBoolean(11, c.isHeadache());
        prep.setBoolean(12, c.isDizziness());
        prep.setBoolean(13, c.isUpperBodyPain());
        prep.setBoolean(14, c.isTemperatureChanges());
        prep.setBoolean(15, c.isHighBloodPressure());
        prep.setBoolean(16, c.isIrregularHeartBeat());
        prep.setBoolean(17, c.isWeakness());
        prep.executeUpdate();
        prep.close();
    }


    @Override
    public Condition searchConditionById(int conditionId) throws SQLException {
        Condition c = null;
        String sql = "SELECT * FROM condition WHERE diseaseId= ?";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setInt(1, conditionId);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            Boolean chestPain = rs.getBoolean("chestPain");
            Boolean sweating = rs.getBoolean("sweating");
            Boolean nausea = rs.getBoolean("nausea");
            Boolean legsPain = rs.getBoolean("legsPain");
            Boolean skinChanges = rs.getBoolean("skinChanges");
            Boolean decreasedPulse = rs.getBoolean("decreasedPulse");
            Boolean swellingLegs = rs.getBoolean("swellingLegs");
            Boolean shortnessOfBreath = rs.getBoolean("shortnessOfBreath");
            Boolean fatigue = rs.getBoolean("fatigue");
            Boolean increasedPulse = rs.getBoolean("increasedPulse");
            Boolean headache = rs.getBoolean("headache");
            Boolean dizziness = rs.getBoolean("dizziness");
            Boolean upperBodyPain = rs.getBoolean("upperBodyPain");
            Boolean temperatureChanges = rs.getBoolean("temperatureChanges");
            Boolean highBloodPressure = rs.getBoolean("highBloodPressure");
            Boolean irregularHeartBeat = rs.getBoolean("irregularHeartBeat");
            Boolean weakness = rs.getBoolean("weakness");
            
             c = new Condition(chestPain, sweating, nausea, legsPain, skinChanges, decreasedPulse, swellingLegs,shortnessOfBreath, fatigue, increasedPulse, headache , dizziness, upperBodyPain,temperatureChanges, highBloodPressure, irregularHeartBeat, weakness);
        }
        prep.close();
        rs.close();
        return c;
    }
}
