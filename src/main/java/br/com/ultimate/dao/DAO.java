package br.com.ultimate.dao;

import br.com.ultimate.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Gustavo on 23/06/2017.
 */
public class DAO<T> implements IDAO<T> {

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

    public T encontrar(Class<T> persistedClass, Integer id) {
        openConnection();

        T t = entityManager.find(persistedClass, id);

        entityManager.close();
        return t;
    }

    public T atualizar(T entity){
        openConnection();
        entityManager.getTransaction().begin();

        entityManager.merge(entity);

        entityManager.getTransaction().commit();
        entityManager.close();

        return entity;
    }

    public List<T> getList(Class<T> persistedClass) {
        openConnection();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        List<T> resultList = entityManager.createQuery(query).getResultList();

        entityManager.close();
        return resultList;
    }

    public void remover(T entity) {
        openConnection();
        entityManager.getTransaction().begin();
        T t = entityManager.merge(entity);
        entityManager.remove(t);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
