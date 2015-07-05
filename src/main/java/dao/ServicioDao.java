package dao;

import javax.ejb.Stateless;

import model.Servicio;

@Stateless
public class ServicioDao extends GenericDao<Servicio> {
	
	public ServicioDao(){
		super(Servicio.class);
	}
	
}
