/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifaces;
import java.sql.*;
import pojos.Patient;
/**
 *
 * @author carme
 */
public interface PatientManager {
    
    public void addPatient(Patient p) throws SQLException;
    public Patient searchPatientById(int patientId) throws SQLException;
    
}
