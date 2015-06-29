package facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Direccion;
import dao.DireccionDao;

@Stateless
public class DireccionFacadeImp implements DireccionFacade {

	@EJB
	private DireccionDao direccionDao;
	
	public DireccionFacadeImp() {
	}

	@Override
	public void save(Direccion direccion) {
		direccionDao.save(direccion);
	}

}
