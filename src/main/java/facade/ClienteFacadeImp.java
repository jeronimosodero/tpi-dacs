package facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Cliente;
import dao.ClienteDao;

@Stateless
public class ClienteFacadeImp implements ClienteFacade {
	
	@EJB
	private ClienteDao seguroDao;

	public ClienteFacadeImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Cliente cliente) {
		seguroDao.save(cliente);

	}

}
