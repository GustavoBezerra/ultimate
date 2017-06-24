package br.com.ultimate.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe responsável por representar um Aluno
 */
@Entity
public class Aluno extends Pessoa {


    private int matricula;
    @Enumerated(EnumType.STRING)
    private NumeroLivro livro;

    @Enumerated(EnumType.STRING)
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
