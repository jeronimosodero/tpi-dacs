package facade;

import java.util.List;

import javax.ejb.Local;

import model.Estado;

@Local
public interface EstadoFacade {
	public abstract void save (Estado estado);
	public abstract List<Estado> findAll();
	public abstract Estado findEstadoById(Long id);
}
