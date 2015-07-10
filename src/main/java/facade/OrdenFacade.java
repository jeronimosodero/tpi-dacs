package facade;

import java.util.List;

import javax.ejb.Local;

import model.Empleado;
import model.Orden;

@Local
public interface OrdenFacade {
	public abstract void save (Orden orden);
	public abstract List<Orden> findAll();
	public abstract Orden update(Orden orden);
	public abstract Orden find(Long id);
	public abstract List<Orden> findUnassigned(Empleado empleado);
	public abstract List<Orden> findOrdenesSucursal(Empleado empleado);
}