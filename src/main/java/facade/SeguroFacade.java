package facade;

import java.util.List;

import javax.ejb.Local;

import model.Seguro;

@Local
public interface SeguroFacade {
	public abstract void save (Seguro seguro);
	public abstract List<Seguro> findAll();
}
