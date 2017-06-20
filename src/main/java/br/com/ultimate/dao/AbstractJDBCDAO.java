package br.com.ultimate.dao;

import br.com.ultimate.util.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by Gustavo on 20/06/2017.
 * Classe abstrata responsável pela instanciação do entityManager
 */
public abstract class AbstractJDBCDAO{

    protected EntityManager entityManager = new JPAUtil().getEntityManager();

    protected void openConnection(){
        entityManager = new JPAUtil().getEntityManager();
    }
}
