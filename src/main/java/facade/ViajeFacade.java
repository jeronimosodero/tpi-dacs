package facade;



import javax.ejb.Local;

import model.Viaje;

@Local
public interface ViajeFacade {
	
	public abstract Viaje findViajeById(Long id);
	public abstract void save(Viaje viaje);
}
