/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionvehicule2.dao;

import java.util.List;

/**
 *
 * @author Inclusiv Academy 03
 */
public interface IDAO<E> {
    public List<E> getAll();
    public List<E> getAll(String sort);
    public void delete(int i);
    public void save(E e);
    public void update(E e);
}
