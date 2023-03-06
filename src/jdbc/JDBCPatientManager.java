/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;
import ifaces.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import pojos.Patient;
/**
 *
 * @author carme
 */
public class JDBCPatientManager implements PatientManager{
    
    private final JDBCManager manager;

    public JDBCPatientManager(JDBCManager m) {
        this.manager = m;
    }
    
    
    @Override
    public void addPatient(Patient p) throws SQLException {
        String sql = "INSERT INTO patient (name, surname, gender, birthDate,weight, bloodType, background) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setString(1, p.getName());
        prep.setString(2, p.getSurname());
        prep.setString(3, p.getGender());
        prep.setDate(4, p.getBirthDate());
        prep.setFloat(5, p.getWeight());
        prep.setString(6, p.getBloodType());
        prep.setString(7, p.getBackground());
        prep.executeUpdate();
        prep.close();
    }


    @Override
    public Patient searchPatientById(int patientId) throws SQLException {
        Patient p = null;
        String sql = "SELECT * FROM patient WHERE patientId= ?";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setInt(1, patientId);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String gender = rs.getString("gender");
            Date birthDate = rs.getDate("birthDate");
            Float weight = rs.getFloat("weight");
            String bloodType = rs.getString("bloodType");
            String background = rs.getString("background");

            p = new Patient(patientId, name, surname, gender, birthDate,weight, bloodType, background);
        }
        prep.close();
        rs.close();
        return p;
    }
}
