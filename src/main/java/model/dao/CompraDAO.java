/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Compra;

/**
 *
 * @author vanessalagomachado
 */
public class CompraDAO extends PersistenciaJPA{
    public List<Compra> listaCompras(){
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Compra> query
                    = em.createQuery("SELECT v FROM Compra v", Compra.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
