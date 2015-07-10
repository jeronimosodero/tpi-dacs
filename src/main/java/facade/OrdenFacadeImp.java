package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Orden;
import dao.OrdenDao;

@Stateless
public class OrdenFacadeImp implements OrdenFacade {
	
	@EJB
	private OrdenDao ordenDao;

	public OrdenFacadeImp() {
	}

	@Override
	public void save(Orden orden) {
		ordenDao.save(orden);
	}

	@Override
	public List<Orden> findAll() {
		return ordenDao.findAll();
	}

	@Override
	public Orden update(Orden orden) {
		return ordenDao.update(orden);
	}
	
	public Orden find(Long id) {
		return ordenDao.find(id);

	}

	@Override
	public List<Orden> findUnassigned() {
		return ordenDao.findUnassigned();
	}

}
