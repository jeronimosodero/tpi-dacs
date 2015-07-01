package facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;



import dao.PaqueteDao;
import model.Paquete;

@Stateless
public class PaqueteFacadeImp implements PaqueteFacade{

	@EJB
	private PaqueteDao paqueteDao;
	@Override
	public Paquete findPaqueteById(Long id) {
		return paqueteDao.find(id);
	}
	@Override
	public void save(Paquete paquete) {
		paqueteDao.save(paquete);
		
	}

}
