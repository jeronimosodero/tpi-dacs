package dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import model.Cliente;

@Stateless
public class ClienteDao extends GenericDao<Cliente> {

	public ClienteDao(){
		super(Cliente.class);
	}
	
	public Cliente findClienteByEmail(String email){
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		return super.findOneResult(Cliente.FIND_BY_CUIL, parameters);
	}
	
}
