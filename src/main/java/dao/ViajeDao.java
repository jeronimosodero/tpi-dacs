package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import model.Viaje;

@Stateless
public class ViajeDao extends GenericDao<Viaje> {

	public ViajeDao(){
		super(Viaje.class);
	}
	
	public List<Viaje> findActuales(){
		Map<String,Object> parameters = new HashMap<String, Object>();
		return super.findManyResults(Viaje.FIND_ACTUALES, parameters);
	}
}
