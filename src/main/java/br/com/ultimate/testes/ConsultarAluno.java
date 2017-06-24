package br.com.ultimate.testes;

import br.com.ultimate.dao.PessoaDAO;
import br.com.ultimate.modelo.Aluno;
import br.com.ultimate.modelo.Pessoa;
import br.com.ultimate.modelo.Professor;

import java.util.List;

/**
 * Created by Gustavo on 23/06/2017.
 */
public class ConsultarAluno {

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Professor> list = pessoaDAO.getList(Professor.class);
        for(Professor a : list){
            System.out.println(a.getNome());
        }
    }
}
