package dao;

import javax.ejb.Stateless;

import model.Paquete;

@Stateless
public class PaqueteDao extends GenericDao<Paquete> {
	public PaqueteDao(){
		super(Paquete.class);
	}

}
