package br.com.ultimate.testes;

import br.com.ultimate.dao.PessoaDAO;
import br.com.ultimate.modelo.Aluno;
import br.com.ultimate.modelo.Pessoa;
import br.com.ultimate.modelo.Tipo;
import br.com.ultimate.modelo.Turma;
import br.com.ultimate.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 23/06/2017.
 */
public class CadastrarTurma {

    public static void main(String[] args) {
        Turma turma = new Turma();
        Aluno aluno = new Aluno();
        List<Aluno> alunos = new ArrayList<>();

        PessoaDAO pessoaDAO = new PessoaDAO();
        aluno = (Aluno) pessoaDAO.encontrar(Aluno.class, 2);
        alunos.add(aluno);

        turma.setAlunos(alunos);
        turma.setTipo(Tipo.GOLD);

        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(turma);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
