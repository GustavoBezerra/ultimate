package br.com.ultimate.dao;

import br.com.ultimate.modelo.Turma;
import br.com.ultimate.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by Gustavo on 23/06/2017.
 */
public abstract class AbstractJDBCDAO<T> implements IDAO<T> {

    protected EntityManager entityManager = new JPAUtil().getEntityManager();

    protected void openConnection(){
        entityManager = new JPAUtil().getEntityManager();
    }

    public void salvar(T entity) {
        openConnection();
        entityManager.getTransaction().begin();

        entityManager.persist(entity);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public T atualizar(T entity) {
        openConnection();

        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.merge(entity);
        entityManager.flush();
        t.commit();

        entityManager.close();
        return entity;
    }
}
