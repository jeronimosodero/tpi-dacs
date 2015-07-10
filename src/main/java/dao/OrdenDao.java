package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import model.Empleado;
import model.Orden;

@Stateless
public class OrdenDao extends GenericDao<Orden> {
	
	public OrdenDao(){
		super(Orden.class);
	}
	
	public List<Orden> findUnassigned(Empleado empleado){
		List<Orden> result = null;
		Long id = empleado.getSucursal().getId();
		Query q = em.createNativeQuery("select * from Orden o where o.viaje_fk is null and o.origen_fk = :id",Orden.class);
		q.setParameter("id", id);
		result = q.getResultList();
		return result;
	}
	
	public List<Orden> findOrdenesSucursal(Empleado empleado){
		List<Orden> result = null;
		Long id = empleado.getSucursal().getId();
		Query q = em.createNativeQuery("select * from Orden o where o.origen_fk = :id",Orden.class);
		q.setParameter("id", id);
		result = q.getResultList();
		return result;
	}
}
