package br.com.ultimate.controller;

import br.com.ultimate.dao.PessoaDAO;
import br.com.ultimate.modelo.Pessoa;
import br.com.ultimate.modelo.Usuario;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.persistence.NoResultException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Gustavo on 29/05/2017.
 */

@Path("/usuario")
public class LoginController {
    JSONObject json;

    @GET
    @Path("/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("login") String login, @PathParam("senha") String senha){
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa retorno;
        try{
            retorno = pessoaDAO.buscarUsuario(login, senha);
            json = new JSONObject();

            json.put("tipo", retorno.getClass().getSimpleName());
            json.put("usuario", new Gson().toJson(retorno));
        } catch(NoResultException e){
            return Response.status(401).entity("Nenhum usuario encontrado!").build();
        }
        return Response.status(200).entity(json.toString()).build();
    }
}
