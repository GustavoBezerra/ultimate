package br.com.ultimate.controller;

import br.com.ultimate.dao.PessoaDAO;
import br.com.ultimate.modelo.Aluno;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

/**
 * Created by Gustavo on 20/06/2017.
 * Controller responsável pelas requisições referentes ao Aluno
 */
@Path("/aluno")
public class AlunoController implements IController{

    private PessoaDAO pessoaDAO = new PessoaDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response novoAluno(String usuario){
        Aluno aluno = gson.fromJson(usuario, Aluno.class);
        aluno.setDtCadastro(LocalDate.now());
        pessoaDAO.salvar(aluno);

        json.put("tipo", aluno.getClass().getSimpleName());
        json.put("usuario", new Gson().toJson(aluno));

        return Response.status(Response.Status.OK).entity(json.toString()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAluno(@PathParam("id") int id){
        return Response.status(200).build();
    }
}
