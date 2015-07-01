package facade;



import javax.ejb.Local;
import model.Paquete;

@Local
public interface PaqueteFacade {
	
	public abstract Paquete findPaqueteById(Long id);
	public abstract void save(Paquete paquete);
}
