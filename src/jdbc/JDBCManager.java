/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;
import java.sql.*;

/**
 *
 * @author carme
 */
public class JDBCManager {
    
        private Connection c = null;
        
         public JDBCManager() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./db/CardiovascularDiagnosis.db");
            c.createStatement().execute("PRAGMA foreign_keys=ON");
            System.out.println("Database connection opened.");
            try {
                this.createTables();
            } catch (SQLException e) {

                System.out.println("The tables have been already created");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Libraries not loaded");
        }
    }

    public void disconnect() {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return c;
    }

    public void createTables() throws SQLException {
        // Create Tables
        Statement stmt = c.createStatement();
        String sql = "CREATE TABLE doctor "
                + "(doctorId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "	name TEXT NOT NULL,"
                + " surname TEXT NOT NULL,"
                + "	gender TEXT NOT NULL,"
                + " hospital TEXT NOT NULL,"
                + "	email TEXT NOT NULL,"
                + " password TEXT NOT NULL )";
        stmt.executeUpdate(sql);
        sql = "CREATE TABLE condition "
                + "(conditionId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "	chestPain BOOLEAN NOT NULL,"
                + "	sweating BOOLEAN NOT NULL,"
                + "	nausea BOOLEAN NOT NULL,"
                + "	legsPain BOOLEAN NOT NULL,"
                + "	skinChanges BOOLEAN NOT NULL,"
                + "	decreasedPulse BOOLEAN NOT NULL,"
                + "	swellingLegs BOOLEAN NOT NULL,"
                + "	shortnessOfBreath BOOLEAN NOT NULL,"
                + "	fatigue BOOLEAN NOT NULL,"
                + "	increasedPulse BOOLEAN NOT NULL,"
                + "	headache BOOLEAN NOT NULL,"
                + "	dizziness BOOLEAN NOT NULL,"
                + "	upperBodyPain BOOLEAN NOT NULL,"
                + "	temperatureChanges BOOLEAN NOT NULL,"
                + "	highBloodPressure BOOLEAN NOT NULL,"
                + "	irregularHeartBeat BOOLEAN NOT NULL,"
                + "	weakness BOOLEAN NOT NULL )" ;
        stmt.executeUpdate(sql);
        sql = "CREATE TABLE disease "
                + "(diseaseId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "	myocardialInfarction DOUBLE NOT NULL,"
                + "	heartFailure DOUBLE NOT NULL,"
                + "	pArterialDisease DOUBLE NOT NULL,"
                + "	heartBurn DOUBLE NOT NULL,"
                + "	hypertension DOUBLE NOT NULL,"
                + "	stroke DOUBLE NOT NULL,"
                + "	arrythmia DOUBLE NOT NULL ) ";
        stmt.executeUpdate(sql);
        sql = "CREATE TABLE patient "
                + "(patientId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "	name TEXT NOT NULL,"
                + " surname TEXT NOT NULL,"
                + "	gender TEXT NOT NULL,"
                + "	birthDate DATE NOT NULL,"
                + " weight TEXT NOT NULL,"
                + "	bloodType TEXT NOT NULL,"
                + " background TEXT NOT NULL,"
                + "	conditionId INTEGER REFERENCES condition(conditionId) ON DELETE CASCADE,"
                + "	diseaseId INTEGER REFERENCES disease(diseaseId) ON DELETE CASCADE,"
                + "	doctorId INTEGER REFERENCES doctor(doctorId) ON DELETE CASCADE )";
                
        stmt.executeUpdate(sql);
        System.out.println("Tables created");
    }
    
}
