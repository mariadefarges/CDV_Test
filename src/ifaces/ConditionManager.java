/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifaces;
import java.sql.*;
import pojos.Condition;
/**
 *
 * @author carme
 */
public interface ConditionManager {
    
        public void addCondition(Condition c) throws SQLException;
        public Condition searchConditionById(int conditionId) throws SQLException;
}
