/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import pojos.*;

/**
 *
 * @author carme
 */
public class JDBCDoctorManager implements DoctorManager {

    private final JDBCManager manager;
    private final JDBCPatientManager patientmanager;

    public JDBCDoctorManager(JDBCManager m, JDBCPatientManager patientmanager) {
        this.manager = m;
        this.patientmanager = patientmanager;
    }

    @Override
    public void addDoctor(Doctor d) throws SQLException {
        String sql = "INSERT INTO doctor (name, surname, gender, hospital,email, password) VALUES (?,?,?,?,?,?)";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setString(1, d.getName());
        prep.setString(2, d.getSurname());
        prep.setString(3, d.getGender());
        prep.setString(4, d.getHospital());
        prep.setString(5, d.getEmail());
        prep.setString(6, d.getPassword());
        prep.executeUpdate();
        prep.close();
    }

    @Override
    public Doctor searchDoctorById(int doctorId) throws SQLException {
        Doctor d = null;
        String sql = "SELECT * FROM doctor WHERE doctorId= ?";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setInt(1, doctorId);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String gender = rs.getString("gender");
            String hospital = rs.getString("hospital");
            String email = rs.getString("email");
            String password = rs.getString("password");

            d = new Doctor(doctorId, name, surname, gender, hospital, email, password);
        }
        prep.close();
        rs.close();
        return d;
    }

    @Override
    public String checkEmail(String email) throws SQLException {
        String checkemail = "";
        String sql = "SELECT email FROM doctor WHERE email = ?";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setString(1, email);
        ResultSet rs = prep.executeQuery();

        if (rs.next()) {
            checkemail = rs.getString("email");
        }
        prep.close();
        rs.close();
        return checkemail;
    }

    @Override
    public Doctor checkUser(String email, String password) throws SQLException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            String hash2 = new String(hash, 0, hash.length);
            Doctor d = null;
            String sql = "SELECT * FROM doctor WHERE email = ? AND password = ?";
            PreparedStatement prep = manager.getConnection().prepareStatement(sql);
            prep.setString(1, email);
            prep.setString(2, hash2);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                int doctorId = rs.getInt("doctorId");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String gender = rs.getString("gender");
                String hospital = rs.getString("hospital");
                String email2 = rs.getString("email");
                String password2 = rs.getString("password");
                d = new Doctor(doctorId, name, surname, gender, hospital, email2, password2);
                d.setPatients(patientmanager.getPatientsOfDoctor(doctorId));
            }
            prep.close();
            rs.close();
            return d;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changePassword(String new_password, int doctorId) throws SQLException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(new_password.getBytes());
        byte[] hash = md.digest();
        String hash2 = new String(hash, 0, hash.length);
        String sql = "UPDATE doctor SET password=? WHERE doctorId = ?";
        PreparedStatement prep = manager.getConnection().prepareStatement(sql);
        prep.setString(1, hash2);
        prep.setInt(2, doctorId);
        prep.executeUpdate();

    }

    @Override
    public int checkPassword(String password) throws SQLException , NoSuchAlgorithmException {
        int doctorId = 0;
        MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            String hash2 = new String(hash, 0, hash.length);
            Doctor d = null;
            String sql = "SELECT doctorId FROM doctor WHERE password = ?";
            PreparedStatement prep = manager.getConnection().prepareStatement(sql);
            prep.setString(1, hash2);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                doctorId = rs.getInt("doctorId");           
            }
            prep.close();
            rs.close();
            return doctorId;
    }
}
