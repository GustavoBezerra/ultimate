package br.com.ultimate.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe responsável por representar a agenda de aulas
 */
public class Agenda {

    private int id;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private LocalDate diaAula;
    private Turma turma;
    private Sala sala;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public LocalDate getDiaAula() {
        return diaAula;
    }

    public void setDiaAula(LocalDate diaAula) {
        this.diaAula = diaAula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
