package facade;

import javax.ejb.Local;

import model.Administrador;

@Local
public interface AdministradorFacade {
	public abstract void save(Administrador administrador);
	public abstract Administrador findAdministradorByEmail(String email);
}
