package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Unidad;
import dao.UnidadDao;

@Stateless
public class UnidadFacadeImp implements UnidadFacade {

	@EJB
	private UnidadDao unidadDao;
	
	@Override
	public void save(Unidad unidad) {
		unidadDao.save(unidad);
	}

	@Override
	public List<Unidad> findAll() {
		return unidadDao.findAll();
	}

	@Override
	public Unidad update(Unidad unidad) {
		return unidadDao.update(unidad);
	}

	@Override
	public Unidad find(Long id) {
		return unidadDao.find(id);
	}

}
