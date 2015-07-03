package facade;

import java.util.List;

import javax.ejb.Local;

import model.Empleado;

@Local
public interface EmpleadoFacade {
	public abstract void save(Empleado empleado);
	public abstract List<Empleado> findAll();
	public abstract Empleado findEmpleadoByEmail(String email);
}
