/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Funcionario;

/**
 *
 * @author vanessalagomachado
 */
public class VendedorDAO extends PersistenciaJPA{
    
    public List<Funcionario> listaVendedores(){
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Funcionario> query
                    = em.createQuery("SELECT v FROM Funcionario v", Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
