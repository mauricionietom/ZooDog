package restServices;

import DAO.PerroDAO;
import DAO.comentarioDao;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import configuration.jwtConfiguration.JsonTokenNeeded;
import models.Device;
import models.Perro;
import response.AuthorizationResponse;
import response.BaseResponse;
import response.DeviceCollectionResponse;
import util.JwTokenHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import models.Comentarios;

@Path("/")
public class HomeApiService extends BaseApiService {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("perro/{puesto}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Perro getPerro(@PathParam("puesto") String puesto) {
        return PerroDAO.listarPerro(puesto);
    }

    @GET
    @Path("perros")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ArrayList<Perro> getPerros() {
        return PerroDAO.listarPerros();
    }
    @OPTIONS
    @Path("perros")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response ok() {
        return Response.ok().build();
    }
    
    @POST
    @Path ("AgregarComentario")
    @Produces ({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Comentarios agregarComentarios(Comentarios comentarios){
        return comentarioDao.agregarComentario(comentarios);
    }
    
     @GET
    @Path("ListarComentarios")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ArrayList<Comentarios> getComentarios() {
        return comentarioDao.listarComentarios();
    }
   
}
