package facade;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface ClienteFacade {
	public abstract void save (Cliente cliente);
}
