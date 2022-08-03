/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionvehicule2.servlet;

import com.mycompany.gestionvehicule2.dao.DaoFactory;
import com.mycompany.gestionvehicule2.dao.VehiculeDAO;
import com.mycompany.gestionvehicule2.model.Vehicule;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Inclusiv Academy 03
 */
public class VehiculeServlet extends HttpServlet {
    VehiculeDAO vehiculeDAO;
        
    @Override
       public void init() throws ServletException {
          DaoFactory daofactory = DaoFactory.getInstance();
          this.vehiculeDAO = daofactory.getVehiculeDAOImpl();
          System.out.println("Objet vehiculeDAO = " + vehiculeDAO.toString());
       }
       
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Ajout
        if(req.getParameter("modele") != null && req.getParameter("marque") != null && req.getParameter("annee") != null ){
        Vehicule vehicule = new Vehicule(0,req.getParameter("modele"),req.getParameter("marque"),Integer.parseInt(req.getParameter("annee")));
                             
        try {
            vehiculeDAO.save(vehicule);
        } catch (Exception e) {
            System.out.println("Erreur d'envoie vers la base ::: "+e.toString());
        }
        }else{
            System.out.println("Les champs sont vide !!!!");
        }  
        resp.sendRedirect("http://localhost:8080/gestionVehicule2/vehicule");
        init();
        
        //Modification
//        if(req.getParameter("modeleU") != null && req.getParameter("marqueU") != null && req.getParameter("anneeU") != null){
//        Vehicule vehicule = new Vehicule(Integer.parseInt(req.getParameter("idU")),req.getParameter("modeleU"),req.getParameter("marque"),Integer.parseInt(req.getParameter("anneeU")));
//            try {
//                vehiculeDAO.update(vehicule);
//            } catch (Exception e) {
//                System.out.println("erreur update ::: "+e.toString());
//            }
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if(req.getParameter("sort")!=null){
               req.setAttribute("carObj",vehiculeDAO.getAll(req.getParameter("sort")));
               this.getServletContext().getRequestDispatcher("/vehiculeJsp.jsp").forward(req, resp);
            }else{
              req.setAttribute("carObj", vehiculeDAO.getAll());
            this.getServletContext().getRequestDispatcher("/vehiculeJsp.jsp").forward(req, resp);  
            }
            
        if(req.getParameter("suppr")!=null){            
            vehiculeDAO.delete(Integer.parseInt(req.getParameter("suppr")));
            resp.sendRedirect("/Vehicule");
            init();
        }  
    }

    
    
        
}
