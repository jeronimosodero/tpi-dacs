package dao;

import javax.ejb.Stateless;

import model.Sucursal;

@Stateless
public class SucursalDao extends GenericDao<Sucursal> {

	public SucursalDao() {
		super(Sucursal.class);
	}

}
