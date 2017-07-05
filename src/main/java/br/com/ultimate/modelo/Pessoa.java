package br.com.ultimate.modelo;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe responsável pelos dados comuns entre os tipos de usuários
 */
@Entity
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate dtCadastro;
    private String nome;
    @OneToOne(orphanRemoval=true)
    private Usuario usuario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
