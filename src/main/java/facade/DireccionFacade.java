package facade;

import javax.ejb.Local;

import model.Direccion;

@Local
public interface DireccionFacade {
	public abstract void save (Direccion direccion);
}
