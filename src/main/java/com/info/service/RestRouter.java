package com.info.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/persons")
public class RestRouter {
    PersonServiceImpl p = new PersonServiceImpl();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return p.getALLPersons();
    }

    @PUT
    @Path("/add/{age}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(
            @PathParam("age") int age,
            @PathParam("name") String name) {
        Person user = new Person();
        user.setAge(age);
        user.setName(name);
        p.addPerson(user);
        return Response.ok().entity(new ApiResponse("ok")).build();
    }

    @DELETE
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") int id) {
        try {
            if (p.deletePerson(id)) {
                return Response.ok().entity(new ApiResponse("ok")).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponse("id doesn't exist")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponse("no", e.getMessage())).build();
        }
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id) {
        try {
            Person person = p.getPerson(id);
            if (person != null) {
                return Response.ok().entity(new ApiResponse("ok", person)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponse("id doesn't exist")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponse("no", e.getMessage())).build();
        }
    }

    @PUT
    @Path("/update/{id}/{age}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(
            @PathParam("id") int id,
            @PathParam("age") int age,
            @PathParam("name") String name) {
        Person user = new Person();
        user.setId(id);
        user.setAge(age);
        user.setName(name);
        if (p.UpdatePerson(user)) {
            return Response.ok().entity(new ApiResponse("ok")).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ApiResponse("id doesn't exist")).build();
        }
    }

    @GET
    @Path("/getname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNameUser(@PathParam("name") String name) {
        try {
            Person person = p.getPersonByName(name);
            if (person != null) {
                return Response.ok().entity(new ApiResponse("ok", person)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponse("Name doesn't exist")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponse("no", e.getMessage())).build();
        }
    }

    // Define a generic ApiResponse class
    private static class ApiResponse {
        private final String state;
        private final Object data;

        public ApiResponse(String state, Object data) {
            this.state = state;
            this.data = data;
        }

        public ApiResponse(String state) {
            this.state = state;
            this.data = null;
        }

        public String getState() {
            return state;
        }

        public Object getData() {
            return data;
        }
    }
}
