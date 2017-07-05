package br.com.ultimate.controller;

import br.com.ultimate.dao.PessoaDAO;
import br.com.ultimate.modelo.Aluno;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Gustavo on 20/06/2017.
 * Controller responsável pelas requisições referentes ao Aluno
 */
@Path("/aluno")
public class AlunoController implements IController{
    private JSONObject json = new JSONObject();

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
        pessoaDAO = new PessoaDAO();
        Aluno aluno = null;
        try {
            aluno = (Aluno) pessoaDAO.encontrar(Aluno.class, id);

            if(aluno == null){
                json.put("resposta", "Nenhum aluno encontrado com este ID!");
                return Response.status(Response.Status.UNAUTHORIZED).entity(json.toString()).build();
            } else{
                json.put("tipo", aluno.getClass().getSimpleName());
                json.put("usuario", new Gson().toJson(aluno));
            }
        } catch (ClassCastException e){
            json.put("resposta", "Este ID não é referente a um aluno!");
            return Response.status(Response.Status.BAD_REQUEST).entity(json.toString()).build();
        }
        return Response.status(Response.Status.OK).entity(json.toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlunos(){
        pessoaDAO = new PessoaDAO();
        List list = pessoaDAO.getList(Aluno.class);
        json.put("alunos", new Gson().toJson(list));
        return Response.status(Response.Status.OK).entity(json.toString()).build();
    }
}
