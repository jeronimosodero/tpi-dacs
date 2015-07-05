package dao;

import javax.ejb.Stateless;

import model.Orden;

@Stateless
public class OrdenDao extends GenericDao<Orden> {
	
	public OrdenDao(){
		super(Orden.class);
	}
	
}
