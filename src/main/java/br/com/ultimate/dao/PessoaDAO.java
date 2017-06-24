package br.com.ultimate.dao;

import br.com.ultimate.modelo.Aluno;
import br.com.ultimate.modelo.Pessoa;
import br.com.ultimate.modelo.Usuario;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Gustavo on 06/06/2017.
 * DAO responsável pelo acesso aos dados de Pessoa
 */
public class PessoaDAO<T extends Pessoa> extends AbstractJDBCDAO<T> {

    @Override
    public void salvar(T entity) {
        openConnection();

        entityManager.getTransaction().begin();

        entityManager.persist(entity.getUsuario());
        entityManager.persist(entity);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public List<T> getList(Class<T> persistedClass) {
        openConnection();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        List<T> resultList = entityManager.createQuery(query).getResultList();

        entityManager.close();
        return resultList;
    }

    @Override
    public T encontrar(Class<T> persistedClass, Integer id) {
        openConnection();

        T t = entityManager.find(persistedClass, id);

        entityManager.close();
        return t;
    }

    @Override
    public void remover(Class<T> persistedClass, Integer id) {
        Pessoa entity = encontrar(persistedClass, id);
        openConnection();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Pessoa mergedEntity = entityManager.merge(entity);
        entityManager.remove(mergedEntity);
        entityManager.flush();
        tx.commit();

        entityManager.close();
    }


}
