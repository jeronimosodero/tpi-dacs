package facade;

import java.util.List;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface ClienteFacade {
	public abstract void save (Cliente cliente);
	public abstract List<Cliente> findAll();
	public abstract Cliente findClienteByEmail(String email);
	public abstract Cliente findClienteById(Long id);
}
