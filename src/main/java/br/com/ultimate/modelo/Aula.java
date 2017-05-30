package br.com.ultimate.modelo;

import br.com.ultimate.modelo.Nota;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe reponsável por representar uma Aula
 */
public abstract class Aula {

    private int id;
    private Sala sala;
    private LocalDateTime dtInicio;
    private LocalDateTime dtFim;
    private List<Nota> notas;

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDateTime dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDateTime getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDateTime dtFim) {
        this.dtFim = dtFim;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}
