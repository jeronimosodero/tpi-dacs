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
	
	public Cliente findClienteByCUIL(Long CUIL){
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("cuil", CUIL);
		return super.findOneResult(Cliente.FIND_BY_CUIL, parameters);
	}
	
}
