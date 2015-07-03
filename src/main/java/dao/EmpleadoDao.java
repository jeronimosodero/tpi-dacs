package dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import model.Empleado;

@Stateless
public class EmpleadoDao extends GenericDao<Empleado>{

	public EmpleadoDao() {
		super(Empleado.class);
	}
	
	public Empleado findEmpleadoByEmail(String email){
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		return super.findOneResult(Empleado.FIND_BY_EMAIL, parameters);
	}

}
