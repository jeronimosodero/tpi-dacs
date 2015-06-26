package facade;

import javax.ejb.Local;

import model.Seguro;

@Local
public interface SeguroFacade {
	public abstract void save (Seguro seguro);
}
