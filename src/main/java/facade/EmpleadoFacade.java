package facade;

import javax.ejb.Local;

import model.Empleado;

@Local
public interface EmpleadoFacade {
	public abstract void save(Empleado empleado);
	public abstract Empleado findEmpleadoByEmail(String email);
}
