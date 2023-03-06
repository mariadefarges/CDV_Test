/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifaces;
import java.sql.*;
import pojos.Disease;
/**
 *
 * @author carme
 */
public interface DiseaseManager {
    
    public void addDisease(Disease d) throws SQLException;
     public Disease searchDiseaseById(int diseaseId) throws SQLException;
    
}
