package br.com.ultimate.dao;

import br.com.ultimate.modelo.Pessoa;

/**
 * Created by Gustavo on 06/06/2017.
 * DAO responsável pelo acesso aos dados de Pessoa
 */
public class PessoaDAO<T extends Pessoa> extends DAO<T> {

    @Override
    public void salvar(T entity) {
        openConnection();

        entityManager.getTransaction().begin();

        entityManager.persist(entity.getUsuario());
        entityManager.persist(entity);

        entityManager.getTransaction().commit();

        entityManager.close();
    }


}
