package dao;

import javax.ejb.Stateless;

import model.Ruta;

@Stateless
public class RutaDao extends GenericDao<Ruta> {
	
	public RutaDao(){
		super(Ruta.class);
	}
	
}
