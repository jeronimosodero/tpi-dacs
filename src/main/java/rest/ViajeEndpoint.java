package rest;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import model.Estado;
import model.Orden;
import model.Sucursal;
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
		
		
		if(!idSucursal.equals("-1")){
			
			
			
			//OBTENGO SUCURSAL DEL ESTADO NUEVO
			Sucursal sucursal = sucursalFacade.findSucursalById(Long.valueOf(idSucursal));
			
			//OBTENGO ID DE LA ULTIMA SUCURSAL DEL VIAJE
			List<Sucursal> sucursales = elViaje.getRuta().getSucursales();
			Long ultimoId = sucursales.get(sucursales.size()-1).getId();
			
			//SI SON IGUALES LAS SUCURSALES SE CAMBIA EL VIAJE A FINALIZADO
			if(sucursal.getId()==ultimoId){
				elViaje.setFinalizado(true);
			}
			
			Estado estado = new Estado();
			estado.setSucursal(sucursal);
			estado.setFecha(new Date());
			estado.setHora(new Date());
			estadoFacade.save(estado);
			
			//SE SETEA EL ESTADO A TODAS LAS ORDENES DEL VIAJE
			for(Orden o: elViaje.getOrdenes()){
				o.getEstado().add(estado);
				ordenFacade.update(o);
			}
			
			
			viajeFacade.update(elViaje);
			
			
			return Response.ok().build();
		}else{
			return Response.noContent().build();
		}
		
		
		
		

	}

}
