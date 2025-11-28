package model.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Produto;

public class ProdutoDAO extends PersistenciaJPA {

    public List<Produto> listarProdutos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Produto> query =
                    em.createQuery("SELECT p FROM Produto p", Produto.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Produto> buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Produto> query = em.createQuery(
                    "SELECT p FROM Produto p WHERE p.id = :id", Produto.class);
            query.setParameter("id", id);
            return query.getResultList().stream().findFirst();
        } finally {
            em.close();
        }
    }

    public List<Produto> buscarPorNome(String nome) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Produto> query =
                    em.createQuery("SELECT p FROM Produto p WHERE UPPER(p.nome) LIKE :nome", Produto.class);
            query.setParameter("nome", "%" + nome.toUpperCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
