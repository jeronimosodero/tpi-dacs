package facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Seguro;
import dao.SeguroDao;

@Stateless
public class SeguroFacadeImp implements SeguroFacade {
	
	@EJB
	private SeguroDao seguroDao;

	public SeguroFacadeImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Seguro seguro) {
		seguroDao.save(seguro);

	}

}
