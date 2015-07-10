package dao;

import javax.ejb.Stateless;

import model.Direccion;

@Stateless
public class DireccionDao extends GenericDao<Direccion>{

	public DireccionDao() {
		super(Direccion.class);
	}

}
