package org.usac.edd.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.edd.Grafo;
import org.usac.edd.Nodo;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("localidades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class LocalidadesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LocalidadesResource
     */
    public LocalidadesResource() {
    }

    @GET
    public Response getAll() {
        Grafo grafo = Grafo.getInstance();
        return Response.ok(grafo).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id) {
        Grafo grafo = Grafo.getInstance();
        Nodo nodo = grafo.obtenerNodo(id);
        if(nodo==null)
            return Response.noContent().build();
        return Response.ok(nodo).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Nodo nodo) {
        Grafo grafo = Grafo.getInstance();
        grafo.actualizarNodo(id, nodo);
        return Response.ok().build();
    }
    
    @POST
    public Response create(Nodo nodo) {
        Grafo grafo = Grafo.getInstance();
        grafo.agregarNodo(nodo);
        return Response.ok().build();
    }
    
    @DELETE
    public Response delete(@QueryParam("id") String id) {
        Grafo grafo = Grafo.getInstance();
        grafo.borrarNodo(id);
        return Response.ok().build();
    }
    
}
