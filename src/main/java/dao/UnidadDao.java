package dao;

import javax.ejb.Stateless;

import model.Unidad;

@Stateless
public class UnidadDao extends GenericDao<Unidad> {
	
	public UnidadDao(){
		super(Unidad.class);
	}
	
}
