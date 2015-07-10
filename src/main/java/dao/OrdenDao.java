package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import model.Orden;

@Stateless
public class OrdenDao extends GenericDao<Orden> {
	
	public OrdenDao(){
		super(Orden.class);
	}
	
	public List<Orden> findUnassigned(){
		List<Orden> result = null;
		Query q = em.createNativeQuery("select * from Orden o where o.viaje_fk is null and o.pagado like 'Si'",Orden.class);
		result = q.getResultList();
		return result;
	}
}
