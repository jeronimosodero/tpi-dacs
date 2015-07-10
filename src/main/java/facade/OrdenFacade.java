package facade;

import java.util.List;

import javax.ejb.Local;

import model.Orden;

@Local
public interface OrdenFacade {
	public abstract void save (Orden orden);
	public abstract List<Orden> findAll();
	public abstract Orden update(Orden orden);
	public abstract Orden find(Long id);

}