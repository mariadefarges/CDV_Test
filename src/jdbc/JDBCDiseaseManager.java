/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;
import ifaces.*;
import java.sql.*;
import pojos.*;
/**
 *
 * @author carme
 */
public class JDBCDiseaseManager implements DiseaseManager{
    
    private final JDBCManager manager;

    public JDBCDiseaseManager(JDBCManager m) {
        this.manager = m;
    }
    
    @Override
    public void addDisease(Disease d) throws SQLException {
        String sql = "INSERT INTO disease (myocardialInfarction, heartFailure, pArterialDisease, heartBurn,hypertension, stroke,arrythmia) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setInt(1, d.getMyocardialInfarction());
        prep.setInt(2, d.getHeartFailure());
        prep.setInt(3, d.getpArterialDisease());
        prep.setInt(4, d.getHeartBurn());
        prep.setInt(5, d.getHypertension());
        prep.setInt(6, d.getStroke());
        prep.setInt(7, d.getArrythmia());
        prep.close();
    }


    @Override
    public Disease searchDiseaseById(int diseaseId) throws SQLException {
        Disease d = null;
        String sql = "SELECT * FROM disease WHERE diseaseId= ?";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setInt(1, diseaseId);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int myocardialInfarction = rs.getInt("myocardialInfarction");
            int heartFailure = rs.getInt("heartFailure");
            int pArterialDisease = rs.getInt("pArterialDisease");
            int heartBurn = rs.getInt("heartBurn");
            int hypertension = rs.getInt("hypertension");
            int stroke = rs.getInt("stroke");
            int arrythmia = rs.getInt("arrythmia");
            
             d = new Disease(myocardialInfarction, heartFailure, pArterialDisease, heartBurn, hypertension,stroke, arrythmia);
        }
        prep.close();
        rs.close();
        return d;
    }
}
