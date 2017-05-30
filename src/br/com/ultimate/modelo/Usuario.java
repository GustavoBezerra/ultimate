package br.com.ultimate.modelo;

import com.google.gson.Gson;
import netscape.javascript.JSObject;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe responsável pelos dados comuns de acesso dos usuários
 */
public class Usuario {

    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
