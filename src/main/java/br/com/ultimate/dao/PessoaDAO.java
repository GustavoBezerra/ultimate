package br.com.ultimate.dao;

import br.com.ultimate.modelo.Aluno;
import br.com.ultimate.modelo.Pessoa;
import br.com.ultimate.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Gustavo on 06/06/2017.
 */
public class PessoaDAO<T extends Pessoa, Integer>{

    protected EntityManager entityManager = new JPAUtil().getEntityManager();

    private void openConnection(){
        entityManager = new JPAUtil().getEntityManager();
    }

    public void salvar(T entity) {
        openConnection();

        entityManager.getTransaction().begin();

        entityManager.persist(entity.getUsuario());
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

    public void remover(Class<T> persistedClass, Integer id) {
        T entity = encontrar(persistedClass, id);
        openConnection();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        T mergedEntity = entityManager.merge(entity);
        entityManager.remove(mergedEntity);
        entityManager.flush();
        tx.commit();

        entityManager.close();
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

    public T encontrar(Class<T> persistedClass, Integer id) {
        openConnection();

        T t = entityManager.find(persistedClass, id);

        entityManager.close();
        return t;
    }
}
