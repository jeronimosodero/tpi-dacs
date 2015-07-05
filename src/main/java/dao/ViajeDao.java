package dao;

import javax.ejb.Stateless;

import model.Viaje;

@Stateless
public class ViajeDao extends GenericDao<Viaje> {

	public ViajeDao(){
		super(Viaje.class);
	}
	
}
