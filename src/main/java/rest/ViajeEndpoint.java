package rest;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import model.Estado;
import model.Orden;
import model.Viaje;
import facade.EstadoFacade;
import facade.OrdenFacade;
import facade.SucursalFacade;
import facade.ViajeFacade;

@Stateless
@Dependent
@Path("/viaje")
public class ViajeEndpoint {
	
	@EJB
	private ViajeFacade viajeFacade;
	
	@EJB
	private EstadoFacade estadoFacade;
	
	@EJB
	private SucursalFacade sucursalFacade;
	
	@EJB
	private OrdenFacade ordenFacade;

	@POST
	@Path("/actualizarViaje")
	public Response save(@FormParam("idViaje") String idViaje,
	    @FormParam("idSucursal") String idSucursal) {
		Viaje elViaje = viajeFacade.findViajeById(Long.valueOf(idViaje));
		Estado estado = new Estado();
		estado.setSucursal(sucursalFacade.findSucursalById(Long.valueOf(idSucursal)));
		estado.setFecha(new Date());
		estado.setHora(new Date());
		estadoFacade.save(estado);
		for(Orden o: elViaje.getOrdenes()){
			o.getEstado().add(estado);
			ordenFacade.update(o);
		}
		viajeFacade.update(elViaje);
		System.out.println("gg");
		return Response.noContent().build();
	}

}
