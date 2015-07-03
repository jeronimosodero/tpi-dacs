package dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import model.Administrador;

@Stateless
public class AdministradorDao extends GenericDao<Administrador>{

	public AdministradorDao() {
		super(Administrador.class);
	}

	public Administrador findAdministradorByEmail(String email){
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		return super.findOneResult(Administrador.FIND_BY_EMAIL, parameters);
	}
	
}
