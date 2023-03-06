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

    public JDBCDoctorManager(JDBCManager m) {
        this.manager = m;
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

             d = new Doctor(doctorId, name, surname, gender, hospital,email, password);
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
    public Doctor checkPassword(String email, String password) throws SQLException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            Doctor d = null;
            String sql = "SELECT * FROM doctor WHERE email = ? AND password = ?";
            PreparedStatement prep = manager.getConnection().prepareStatement(sql);
            prep.setString(1, email);
            prep.setBytes(2, hash);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                d = new Doctor(rs.getInt("doctorId"), rs.getString("name"),
                        rs.getString("surname"), rs.getString("gender"),
                        rs.getString("hospital"), rs.getString("email"), 
                        rs.getString("password"));
            }
            prep.close();
            rs.close();
            return d;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
