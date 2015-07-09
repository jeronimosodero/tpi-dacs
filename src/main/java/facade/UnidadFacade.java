package facade;

import java.util.List;

import javax.ejb.Local;

import model.Unidad;

@Local
public interface UnidadFacade {
	public abstract void save(Unidad unidad);
	public abstract List<Unidad> findAll();
	public abstract Unidad update(Unidad unidad);
}
