package ateprosdiana.model.controller;

import ateprosdiana.model.item;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class itemcontroller {
    @GET
    public Response get(@PathParam("name") String name){
        return Response.status(Response.Status.OK).entity(item.findAll().list()).build();}

    @POST
    @Transactional
    public Response post(Map<String, Objects> request){
        item item1 = new item();
        item1.name = request.get("name").toString();
        item1.count = request.get("count").toString();
        item1.price = request.get("price").toString();
        item1.type = request.get("type").toString();
        item1.description = request.get("description").toString();
        item1.createdAt = request.get("requestAt").toString();
        item1.updatedAt = request.get("updateAt").toString();
        //method untuk menyimpan data :
        item1.persist();
        return  Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response put(@PathParam("id") Long id, Map<String, Objects> request){
        item item1 = item.findById(id);
        if (item1 == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        item1.name = request.get("name").toString();
        item1.count = request.get("count").toString();
        item1.price = request.get("price").toString();
        item1.type = request.get("type").toString();
        item1.description = request.get("description").toString();
        item1.createdAt = request.get("createdAt").toString();
        item1.updatedAt = request.get("updateAt").toString();
        //method untuk menyimpan data :
        item1.persist();
        return  Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }
}







