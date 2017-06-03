package br.com.ultimate.testes;

import br.com.ultimate.modelo.Aluno;
import br.com.ultimate.modelo.Usuario;
import br.com.ultimate.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

/**
 * Created by Gustavo on 27/05/2017.
 */
public class Main {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setSenha("123");
        usuario.setLogin("teste");

        Aluno aluno = new Aluno();
        aluno.setUsuario(usuario);
        aluno.setDtCadastro(LocalDate.now());

        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(usuario);
        entityManager.persist(aluno);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
