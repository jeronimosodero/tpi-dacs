package rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.Orden;
import facade.OrdenFacade;

@Stateless
@Dependent
@Path("/orden")
public class OrdenEndpoint {
	
	@EJB
	private OrdenFacade ordenFacade;

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") final Long id) {	
		Orden orden = ordenFacade.find(id);
		if (orden == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(orden).build();
	}

}
