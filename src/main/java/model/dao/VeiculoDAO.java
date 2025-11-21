/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Produto;

/**
 *
 * @author vanessalagomachado
 */
public class VeiculoDAO extends PersistenciaJPA {

    public List<Produto> listaVeiculos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Produto> query
                    = em.createQuery("SELECT v FROM Produto v", Produto.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Produto> buscarPorPlaca(String placa) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Produto> query = em.createQuery(
                    "SELECT v FROM Produto v WHERE v.placa = :placa", Produto.class);
            query.setParameter("placa", placa);
            return query.getResultList().stream().findFirst();
        } finally {
            em.close();
        }
    }
    
    public List<Produto> listaVeiculos(String placa) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Produto> query
                    = em.createQuery("SELECT v FROM Produto v where v.placa like :placa", Produto.class);
            query.setParameter("placa", "%"+placa.toUpperCase()+"%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
