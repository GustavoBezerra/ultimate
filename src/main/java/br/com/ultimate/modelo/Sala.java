package br.com.ultimate.modelo;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe responsável pelos dados comuns das salas
 */
public abstract class Sala {

    private int id;
    private String nome;

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
}
