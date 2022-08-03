/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionvehicule2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Inclusiv Academy 03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicule {
    private int idvoiture;
    private String modele;
    private String marque;    
    private int annee;

    
}
