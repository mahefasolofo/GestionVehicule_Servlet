/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionvehicule2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inclusiv Academy 03
 */
public class DaoFactory {
    String url;
    String username;
    String password;
    
    public DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    public static DaoFactory getInstance(){
       try {
            Class.forName("org.postgresql.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        DaoFactory daofactoryInstance =
                new DaoFactory("jdbc:postgresql://localhost:5432/devoirServlet","postgres","passe");
        return daofactoryInstance;
    }
    
    public Connection getConnexion() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    
    public VehiculeDAO getVehiculeDAOImpl(){
        return new VehiculeDAO(this);
    }
}
