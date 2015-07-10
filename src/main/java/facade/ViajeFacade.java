package facade;



import java.util.List;

import javax.ejb.Local;

import model.Viaje;

@Local
public interface ViajeFacade {
	
	public abstract Viaje findViajeById(Long id);
	public abstract void save(Viaje viaje);
	public abstract Viaje update(Viaje viaje);
	public abstract List<Viaje> findAll();
	public abstract List<Viaje> findActuales();
}
