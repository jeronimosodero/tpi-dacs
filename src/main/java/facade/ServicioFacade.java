package facade;

import java.util.List;

import javax.ejb.Local;

import model.Servicio;

@Local
public interface ServicioFacade {
	public abstract void save (Servicio servicio);
	public abstract List<Servicio> findAll();
}