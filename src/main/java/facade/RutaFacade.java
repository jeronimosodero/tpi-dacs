package facade;

import java.util.List;

import javax.ejb.Local;

import model.Ruta;

@Local
public interface RutaFacade {
	public abstract void save (Ruta ruta);
	public abstract List<Ruta> findAll();
}