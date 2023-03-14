/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;
import ifaces.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    public void addPatient(Patient p, int doctorId) throws SQLException {
        String sql = "INSERT INTO patient (name, surname, gender, birthDate, weight, bloodType, background, doctorId) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setString(1, p.getName());
        prep.setString(2, p.getSurname());
        prep.setString(3, p.getGender());
        prep.setDate(4, p.getBirthDate());
        prep.setFloat(5, p.getWeight());
        prep.setString(6, p.getBloodType());
        prep.setString(7, p.getBackground());
        prep.setInt(8,doctorId);
        prep.executeUpdate();
        prep.close();
    }
    
    /*@Override
    public void editPatient(Patient p) throws SQLException {
        String sql = "UPDATE patient SET name = ?, surname = ?, weight = ?, background = ? WHERE patientId = ?";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setString(1, p.getName());
        prep.setString(2, p.getSurname());
        prep.setFloat(3, p.getWeight());

        prep.executeUpdate();
        prep.close();
    }*/


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
    
    	@Override
	public List<Patient> getPatientsOfDoctor(int doctorId) throws SQLException {
		Patient p = null;
		String sql = "SELECT * FROM patient WHERE doctorId = ?";
		PreparedStatement prep = manager.getConnection().prepareStatement(sql);
		prep.setInt(1, doctorId);
		ResultSet rs = prep.executeQuery();
		List <Patient> patients = new ArrayList<Patient>();
		while(rs.next()){
			int id = rs.getInt("patientId");
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			String gender = rs.getString("gender");
			Date birthDate = rs.getDate("birthDate");
			float weight = rs.getFloat("weight");
			String bloodType = rs.getString("bloodType");
			String background = rs.getString("background");
			p= new Patient(id, name, surname, gender, birthDate, weight, bloodType, background);
			patients.add(p);
		}
		rs.close();	
		return patients;
	}
}
