package br.com.ultimate.testes;

import br.com.ultimate.modelo.Aluno;
import br.com.ultimate.modelo.NumeroAula;
import br.com.ultimate.modelo.NumeroLivro;

/**
 * Created by Gustavo on 27/05/2017.
 */
public class Main {

    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setLivro(NumeroLivro.LIVRO_1);
        aluno.setNumeroAula(NumeroAula.AULA_3);
    }
}
