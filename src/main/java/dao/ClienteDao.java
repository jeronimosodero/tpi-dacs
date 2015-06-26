package dao;

import javax.ejb.Stateless;

import model.Cliente;

@Stateless
public class ClienteDao extends GenericDao<Cliente> {

	public ClienteDao(){
		super(Cliente.class);
	}
	
}
