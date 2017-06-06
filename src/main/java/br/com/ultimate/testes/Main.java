package br.com.ultimate.testes;

import br.com.ultimate.dao.PessoaDAO;
import br.com.ultimate.modelo.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Gustavo on 27/05/2017.
 */
public class Main {

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Usuario usuario = new Usuario();
        usuario.setSenha("123");
        usuario.setLogin("teste");

        Usuario usuarioProfessor = new Usuario();
        usuarioProfessor.setSenha("123");
        usuarioProfessor.setLogin("professor");

        Aluno aluno = new Aluno();
        aluno.setUsuario(usuario);
        aluno.setDtCadastro(LocalDate.now());
        aluno.setNome("Teste");
        aluno.setLivro(NumeroLivro.LIVRO_1);
        aluno.setNumeroAula(NumeroAula.AULA_3);

        Professor professor = new Professor();
        professor.setNome("Le");
        professor.setDtCadastro(LocalDate.now());
        professor.setUsuario(usuarioProfessor);


        pessoaDAO.salvar(aluno);
        pessoaDAO.salvar(professor);
        List<Professor> list = pessoaDAO.getList(Professor.class);
        for(Professor a : list){
            System.out.println("ID: "+a.getId()+" - "+a.getNome());
        }
    }
}
