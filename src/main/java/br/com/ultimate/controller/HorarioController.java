package br.com.ultimate.controller;

import br.com.ultimate.dao.DAO;
import br.com.ultimate.modelo.HorarioAula;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Gustavo on 05/07/2017.
 */
@Path("/horario")
public class HorarioController implements IController{

    private DAO<HorarioAula> horarioDAO = new DAO();
    private JSONObject json = new JSONObject();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response novoHorario(String novoHorario){
        HorarioAula horario = gson.fromJson(novoHorario, HorarioAula.class);
        horarioDAO.salvar(horario);

        json.put("horario", new Gson().toJson(horario));

        return Response.status(Response.Status.OK).entity(json.toString()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterarHorario(String novoHorario){
        HorarioAula horario = gson.fromJson(novoHorario, HorarioAula.class);
        horarioDAO.atualizar(horario);

        json.put("horario", new Gson().toJson(horario));

        return Response.status(Response.Status.OK).entity(json.toString()).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response excluirHorario(@PathParam("id") int id){
        HorarioAula horarioAula = new HorarioAula();
        horarioAula.setId_horario(id);

        horarioDAO.remover(horarioAula);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHorarios(){
        List list = horarioDAO.getList(HorarioAula.class);
        json.put("horarios", new Gson().toJson(list));
        return Response.status(Response.Status.OK).entity(json.toString()).build();
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getHorario(@PathParam("id") int id){
        HorarioAula horario = horarioDAO.encontrar(HorarioAula.class, id);

        json.put("horario", new Gson().toJson(horario));

        return Response.status(Response.Status.OK).entity(json.toString()).build();
    }
}
