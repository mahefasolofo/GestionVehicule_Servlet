/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionvehicule2.dao;

import com.mycompany.gestionvehicule2.model.Vehicule;
import static java.lang.Math.E;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inclusiv Academy 03
 */
public class VehiculeDAO implements IDAO<Vehicule> {

    
    private DaoFactory daofactory;
    Connection cnx=null;
    PreparedStatement pst = null;
    
    VehiculeDAO(DaoFactory daofactory) {
        this.daofactory = DaoFactory.getInstance();
    }

    @Override
    public List<Vehicule> getAll() {
    List<Vehicule> listeVoiture = new ArrayList<>();
        try {
                      
            cnx = daofactory.getConnexion();
            pst = cnx.prepareStatement("SELECT * FROM voitures ;");
            
            ResultSet res = pst.executeQuery();
            while(res.next()){
                listeVoiture.add(new Vehicule(res.getInt(4), res.getString(2),res.getString(1),res.getInt(3)));
            }
            
                    } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return listeVoiture;
    }

    @Override
    public List<Vehicule> getAll(String sort) {
        List<Vehicule> listeVoiture = new ArrayList<>();
        try {
                      
            cnx = daofactory.getConnexion();
            pst = cnx.prepareStatement("SELECT * FROM voitures WHERE marque = '"+sort+"' or modele ='"+sort+"';");
            
            ResultSet res = pst.executeQuery();
            while(res.next()){
                listeVoiture.add(new Vehicule(res.getInt(4), res.getString(2),res.getString(1),res.getInt(3)));
            }
            
                    } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return listeVoiture;
    }
    @Override
    public void delete(int id){
        try {
            cnx = daofactory.getConnexion();
            pst = cnx.prepareStatement("DELETE FROM voitures WHERE \"IdVoiture\" = ?;");
            pst.setInt(1, id);
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            System.out.println("Erreur SQL :: "+ ex.getMessage());
        }catch (Exception ex) {
            System.out.println("Erreur inconnu :: " + ex.getMessage());
        }
    }
    @Override
    public void save(Vehicule e){
        try {
            //
            cnx = daofactory.getConnexion();
            pst = cnx.prepareStatement("INSERT INTO public.voitures(\n" +
                                        "	marque, modele, annee)\n" +
                                        "	VALUES (?, ?, ?);");
            pst.setString(1, e.getMarque());
            pst.setString(2, e.getModele());
            pst.setInt(3, e.getAnnee());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erreur SQL :: "+ ex.getMessage());
        }
    }
    
    @Override
    public void update(Vehicule e){
        try {
            cnx = daofactory.getConnexion();
            pst = cnx.prepareStatement("UPDATE public.voitures\n" +
                                        "	SET marque=?, modele=?, annee=?\n" +
                                        "	WHERE \"IdVoiture\"=?;");
            pst.setString(1, e.getMarque());
            pst.setString(2, e.getModele());
            pst.setInt(3, e.getAnnee());
            pst.setInt(4, e.getIdvoiture());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
