package br.com.ultimate.controller;

import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by Gustavo on 29/05/2017.
 */

@Path("/ftoc")
public class ConvertFtoC {

    @GET
    @Produces("application/json")
    public Response convertFtoC() throws JSONException {
        JSONObject json = new JSONObject();
        double f = 98.4;
        double c;
        c = (f - 32) * 5/9;

        json.put("F", f);
        json.put("C", c);

        String result = "@Produces(\"application/json\") Output: \n\nF to C conversion: \n\n "+json;

        return Response.status(200).entity(result).build();
    }

    @Path("{f}")
    @GET
    @Produces("application/json")
    public Response convertFtoC(@PathParam("f") float f) throws JSONException{
        JSONObject json = new JSONObject();
        double c;
        c = (f - 32) * 5/9;

        json.put("F", f);
        json.put("C", c);

        String result = "@Produces(\"application/json\") Output: \n\nF to C conversion: \n\n "+json;

        return Response.status(200).entity(result).build();
    }

}
