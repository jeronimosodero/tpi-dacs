package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Seguro;
import dao.SeguroDao;

@Stateless
public class SeguroFacadeImp implements SeguroFacade {
	
	@EJB
	private SeguroDao seguroDao;

	public SeguroFacadeImp() {
	}

	@Override
	public void save(Seguro seguro) {
		seguroDao.save(seguro);
	}

	@Override
	public List<Seguro> findAll() {
		return seguroDao.findAll();
	}

}
