package br.com.ultimate.dao;

import br.com.ultimate.modelo.Pessoa;
import br.com.ultimate.modelo.Usuario;

import javax.persistence.TypedQuery;

/**
 * Created by Gustavo on 23/06/2017.
 */
public class LoginDAO extends DAO<Pessoa> {

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
