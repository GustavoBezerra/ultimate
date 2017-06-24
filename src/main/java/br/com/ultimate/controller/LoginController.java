package br.com.ultimate.controller;

import br.com.ultimate.dao.LoginDAO;
import br.com.ultimate.modelo.Pessoa;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Gustavo on 29/05/2017.
 * Controller responsável por atender as requisições referentes ao login
 */

@Path("/login")
public class LoginController implements IController{
    private LoginDAO loginDAO = new LoginDAO();
    private JSONObject json = new JSONObject();

    @GET
    @Path("/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("login") String login, @PathParam("senha") String senha){
        Pessoa retorno;
        try{
            retorno = loginDAO.buscarUsuario(login, senha);

            json.put("tipo", retorno.getClass().getSimpleName());
            json.put("usuario", new Gson().toJson(retorno));
        } catch(NoResultException e){
            return Response.status(401).entity("Nenhum usuario encontrado!").build();
        }
        return Response.status(200).entity(json.toString()).build();
    }


}
