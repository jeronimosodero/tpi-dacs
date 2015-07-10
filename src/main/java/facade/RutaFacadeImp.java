package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Ruta;
import dao.RutaDao;

@Stateless
public class RutaFacadeImp implements RutaFacade {

	@EJB
	private RutaDao RutaDao;
	
	@Override
	public void save(Ruta ruta) {
		RutaDao.save(ruta);
	}

	@Override
	public List<Ruta> findAll() {
		return RutaDao.findAll();
	}

}
