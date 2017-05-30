package br.com.ultimate.controller;

import br.com.ultimate.modelo.Usuario;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(){
        Usuario usuario = new Usuario();
        json = new JSONObject();

        usuario.setLogin("teste");
        usuario.setSenha("teste");

        json.put("usuario", usuario);

        return Response.status(200).entity(json.toString()).build();
    }
}
