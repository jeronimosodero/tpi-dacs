package facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Empleado;
import dao.EmpleadoDao;

@Stateless
public class EmpleadoFacadeImp implements EmpleadoFacade {

	@EJB
	private EmpleadoDao empleadoDao;
	
	public EmpleadoFacadeImp() {}

	@Override
	public void save(Empleado empleado) {
		empleadoDao.save(empleado);
	}

	@Override
	public Empleado findEmpleadoByEmail(String email) {
		return empleadoDao.findEmpleadoByEmail(email);
	}

}
