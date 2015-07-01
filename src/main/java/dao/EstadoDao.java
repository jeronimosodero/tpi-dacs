package dao;


import javax.ejb.Stateless;

import model.Estado;


@Stateless
public class EstadoDao extends GenericDao<Estado> {

	public EstadoDao(){
		super(Estado.class);
	}

}
