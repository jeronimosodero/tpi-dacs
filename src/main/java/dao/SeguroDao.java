package dao;

import javax.ejb.Stateless;

import model.Seguro;

@Stateless
public class SeguroDao extends GenericDao<Seguro> {

	public SeguroDao(){
		super(Seguro.class);
	}
	
}
