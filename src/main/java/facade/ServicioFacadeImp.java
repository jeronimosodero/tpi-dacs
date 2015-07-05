package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Servicio;
import dao.ServicioDao;

@Stateless
public class ServicioFacadeImp implements ServicioFacade {

	@EJB
	private ServicioDao servicioDao;
	
	@Override
	public void save(Servicio servicio) {
		servicioDao.save(servicio);
	}

	@Override
	public List<Servicio> findAll() {
		return servicioDao.findAll();
	}

}
