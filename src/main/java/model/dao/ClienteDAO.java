/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Cliente;

/**
 *
 * @author vanessalagomachado
 */
public class ClienteDAO extends PersistenciaJPA{
    public List<Cliente> listaClientes(){
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Cliente> query
                    = em.createQuery("SELECT v FROM Cliente v", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
