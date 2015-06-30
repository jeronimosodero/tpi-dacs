package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Cliente;
import dao.ClienteDao;

@Stateless
public class ClienteFacadeImp implements ClienteFacade {
	
	@EJB
	private ClienteDao clienteDao;

	public ClienteFacadeImp() {
	}

	@Override
	public void save(Cliente cliente) {
		clienteDao.save(cliente);

	}

	@Override
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	public Cliente findClienteByCUIL(Long CUIL) {
		return clienteDao.findClienteByCUIL(CUIL);
	}

	@Override
	public Cliente findClienteById(Long id) {
		return clienteDao.find(id);
	}

}
