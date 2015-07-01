/**
 * 
 */
package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import facade.ClienteFacade;
import model.Cliente;

/**
 * @author dacs
 *
 */
@RequestScoped
@Stateless
@Path("/clientes")
public class ClienteEndpoint {
	
	@EJB
	private ClienteFacade clienteFacade;
	

	/**
	 * @param cliente
	 * @return
	 */
	@POST
	@Consumes("application/json")
	public Response create(final Cliente cliente) {
		//you may want to use the following return statement, assuming that Cliente#getId() or a similar method 
		//would provide the identifier to retrieve the created Cliente resource:
		//return Response.created(UriBuilder.fromResource(ClienteEndpoint.class).path(String.valueOf(cliente.getId())).build()).build();
		return Response.created(null).build();
	}

	/**
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") final Long id) {		
		
		Cliente cliente = clienteFacade.findClienteById(id);
		if (cliente == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(cliente).build();
	}

	/**
	 * @param startPosition
	 * @param maxResult
	 * @return
	 */
	@GET
	@Produces("application/json")
	public List<Cliente> listAll(
			@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<Cliente> clientes = clienteFacade.findAll();
		return clientes;
	}

	/**
	 * @param id
	 * @param cliente
	 * @return
	 */
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, final Cliente cliente) {
		return Response.noContent().build();
	}

	/**
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		return Response.noContent().build();
	}

}
