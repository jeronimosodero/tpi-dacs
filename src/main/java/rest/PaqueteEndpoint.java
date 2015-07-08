package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.Estado;
import model.Paquete;
import facade.PaqueteFacade;

@Stateless
@Dependent
@Path("/paquete")
public class PaqueteEndpoint {
	
	@EJB
	private PaqueteFacade paqueteFacade;

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") final Long id) {
		
		Paquete paquete = paqueteFacade.findPaqueteById(id);
		if (paquete == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(paquete).build();
	}
	
	@GET
	@Path("/{id:[0-9][0-9]*}/estados")
	@Produces("application/json")
	public List<Estado> estados(@PathParam("id") final Long id) {
		
		Paquete paquete = paqueteFacade.findPaqueteById(id);
		if (paquete == null) {
			return (List<Estado>) Response.status(Status.NOT_FOUND).build();
		}
		return paquete.getEstado();
	}
	
	

}
