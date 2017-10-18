package org.usac.edd.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.edd.ArbolB;
import org.usac.edd.Donacion;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("donaciones")
@RequestScoped
public class DonacionesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DonacionesResource
     */
    public DonacionesResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        ArbolB arbol = ArbolB.getInstance();
        return Response.ok(arbol).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Donacion nueva) {
        ArbolB arbol = ArbolB.getInstance();
        arbol.agregarDonacion(nueva);
    }
    
    @PUT
    public void update(@QueryParam("name") String nombre){
        ArbolB arbol = ArbolB.getInstance();
        arbol.setNombre(nombre);
    }
    
    @Produces(MediaType.MULTIPART_FORM_DATA)
    public void getImage(){
        
    }
    
}
