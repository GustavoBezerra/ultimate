package br.com.ultimate.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe responsável por represetar uma turma
 */
@Entity
public class Turma {

    @Id
    private int id;
    private Tipo tipo;
    @OneToMany
    private List<Aluno> alunos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
