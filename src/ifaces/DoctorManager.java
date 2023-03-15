/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifaces;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import pojos.Doctor;
/**
 *
 * @author carme
 */
public interface DoctorManager {
    
     public void addDoctor(Doctor p) throws SQLException;
     public Doctor searchDoctorById(int doctorId) throws SQLException;
     public String checkEmail(String email) throws SQLException;
     public Doctor checkUser(String email, String password) throws SQLException;
     public void changePassword(String new_password, int doctorId) throws SQLException, NoSuchAlgorithmException;
     public int checkPassword(String password) throws SQLException, NoSuchAlgorithmException ;
}
