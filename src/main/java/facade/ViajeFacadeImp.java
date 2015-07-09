package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Viaje;
import dao.ViajeDao;

@Stateless
public class ViajeFacadeImp implements ViajeFacade{

	@EJB
	private ViajeDao viajeDao;
	
	@Override
	public Viaje findViajeById(Long id) {
		return viajeDao.find(id);
	}
	@Override
	public void save(Viaje viaje) {
		viajeDao.save(viaje);
		
	}
	@Override
	public List<Viaje> findAll() {
		return viajeDao.findAll();
	}

}
