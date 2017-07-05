package br.com.ultimate.modelo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe reponsável por representar uma Aula
 */
@Entity
public class Aula {

    @Id
    private int id;

    @ManyToOne
    private HorarioAula horario;

    @ManyToOne
    private Professor professor;

    @OneToMany
    private List<Aluno> alunos;

    @Enumerated(EnumType.STRING)
    private TipoAula tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HorarioAula getHorario() {
        return horario;
    }

    public void setHorario(HorarioAula horario) {
        this.horario = horario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
