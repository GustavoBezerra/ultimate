package br.com.ultimate.testes;

import br.com.ultimate.dao.PessoaDAO;
import br.com.ultimate.modelo.Aluno;
import br.com.ultimate.modelo.NumeroAula;
import br.com.ultimate.modelo.NumeroLivro;
import br.com.ultimate.modelo.Usuario;

import java.time.LocalDate;

/**
 * Created by Gustavo on 20/06/2017.
 * Classe teste
 */
public class CadastrarAluno {

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Usuario usuario = new Usuario();
        Aluno aluno = new Aluno();

        usuario.setLogin("gu");
        usuario.setSenha("123");

        aluno.setDtCadastro(LocalDate.now());
        aluno.setNome("Gustavo Bezerra");
        aluno.setLivro(NumeroLivro.LIVRO_3);
        aluno.setNumeroAula(NumeroAula.AULA_2);
        aluno.setUsuario(usuario);

        pessoaDAO.salvar(aluno);
    }
}
