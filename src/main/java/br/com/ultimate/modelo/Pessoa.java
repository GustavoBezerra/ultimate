package br.com.ultimate.modelo;

import java.time.LocalDate;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe responsável pelos dados comuns entre os tipos de usuários
 */
public abstract class Pessoa {

    private int id;
    private LocalDate dtCadastro;
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
