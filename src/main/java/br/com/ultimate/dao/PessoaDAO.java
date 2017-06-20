package br.com.ultimate.dao;

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
public class PessoaDAO extends AbstractJDBCDAO implements IDAO<Pessoa, Integer>{

    @Override
    public void salvar(Pessoa entity) {
        openConnection();

        entityManager.getTransaction().begin();

        entityManager.persist(entity.getUsuario());
        entityManager.persist(entity);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public List<Pessoa> getList(Class<Pessoa> persistedClass) {
        openConnection();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pessoa> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        List<Pessoa> resultList = entityManager.createQuery(query).getResultList();

        entityManager.close();
        return resultList;
    }

    @Override
    public Pessoa atualizar(Pessoa entity) {
        openConnection();

        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.merge(entity);
        entityManager.flush();
        t.commit();

        entityManager.close();
        return entity;
    }

    @Override
    public void remover(Class<Pessoa> persistedClass, Integer id) {
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

    @Override
    public Pessoa encontrar(Class<Pessoa> persistedClass, Integer id) {
        openConnection();

        Pessoa t = entityManager.find(persistedClass, id);

        entityManager.close();
        return t;
    }

    public Pessoa buscarUsuario(String login, String senha){
        openConnection();
        String jpql = "select u from Usuario u where u.login=:pLogin "
                + "and u.senha=:pSenha";

        TypedQuery<Usuario> user = entityManager.createQuery(jpql, Usuario.class);

        user.setParameter("pLogin", login);
        user.setParameter("pSenha", senha);


        Usuario usuario = user.getSingleResult();

        if(usuario != null){
            jpql = "select p from Pessoa p where p.usuario=:pUsuario";
            TypedQuery<Pessoa> query = entityManager.createQuery(jpql, Pessoa.class);
            query.setParameter("pUsuario", usuario);
            Pessoa retorno = query.getSingleResult();
            entityManager.close();
            return retorno;
        }
        entityManager.close();
        return null;
    }
}
