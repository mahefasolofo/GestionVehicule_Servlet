<%-- 
    Document   : vehiculeJsp
    Created on : 2 août 2022, 10:25:35
    Author     : Inclusiv Academy 03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.mycompany.gestionvehicule2.model.Vehicule"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Gestion véhicule</h1>
        <h2>Ajout véhicule</h2>
        <form name="ajout" id="ajout" action="/gestionVehicule2/vehicule" method="POST">
            
            <label>Modele : </label>
            <input type="text" name="modele" /><br/>
            
            <label>Marque : </label>
            <input type="text" name="marque" /><br/>
            
            <label>Année : </label>
            <input type="text" name="annee" /><br/>
            
            <input type="submit" name="boutonSubmit" value="Envoyer"/>
            
         </form>
        
        <h2>Recherche véhicule</h2>
        <table border="1" width="100%">
            <tr>
                <form name="recherche" id="recherche" action="/gestionVehicule2/vehicule" method="GET" >
                    <p>Recherche  <input type="text" name="sort" placeHolder="Saisissez ici ..." />
                    <input type="submit" name="boutonFind" value="Rechercher"/> </p>
                </form>
            </tr>
            <tr>
                <th>ID </th>
                <th>Modèle </th>
                <th>Marque</th>
                <th>Année</th>
                <th>Actions</th>
            </tr>

            <c:forEach var="car" items="${carObj}">
                <tr>
                    <td><c:out value="${car.idvoiture}"/></td>
                    <td><c:out value="${car.modele}"/></td>
                    <td><c:out value="${car.marque}"/></td>
                    <td><c:out value="${car.annee}"/></td>
                    <td>
                        <a href="vehicule?suppr=${car.idvoiture}"  id="suppr${car.idvoiture}">[Supprimer]</a>
                        
                        
                    </td>
                </tr>
            </c:forEach>
    </table>
      
    </body>
</html>
