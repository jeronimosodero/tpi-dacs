package facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Administrador;
import dao.AdministradorDao;

@Stateless
public class AdministradorFacadeImp implements AdministradorFacade {

	@EJB
	private AdministradorDao administradorDao;
	
	public AdministradorFacadeImp() {}

	@Override
	public void save(Administrador administrador) {
		administradorDao.save(administrador);

	}

	@Override
	public Administrador findAdministradorByEmail(String email) {
		return administradorDao.findAdministradorByEmail(email);
	}

}
