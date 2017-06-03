package br.com.ultimate.modelo;

import javax.persistence.Entity;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe responsável por representar um Aluno
 */
@Entity
public class Aluno extends Pessoa{

    //private int matricula;
    private NumeroLivro livro;
    private NumeroAula numeroAula;

    public NumeroLivro getLivro() {
        return livro;
    }

    public void setLivro(NumeroLivro livro) {
        this.livro = livro;
    }

    public NumeroAula getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(NumeroAula numeroAula) {
        this.numeroAula = numeroAula;
    }
}
