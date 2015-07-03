package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Estado;
import dao.EstadoDao;

@Stateless
public class EstadoFacadeImp implements EstadoFacade{
	
	@EJB
	private EstadoDao estadoDao;

	@Override
	public void save(Estado estado) {
		estadoDao.save(estado);
		
	}

	@Override
	public List<Estado> findAll() {
		return estadoDao.findAll();
	}

	@Override
	public Estado findEstadoById(Long id) {
		return estadoDao.find(id);
	}

}
