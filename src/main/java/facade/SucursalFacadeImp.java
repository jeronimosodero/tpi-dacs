package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Sucursal;
import dao.SucursalDao;

@Stateless	
public class SucursalFacadeImp implements SucursalFacade {

	@EJB
	private SucursalDao sucursalDao;
	
	@Override
	public void save(Sucursal sucursal) {
		sucursalDao.save(sucursal);
	}

	@Override
	public List<Sucursal> findAll() {
		return sucursalDao.findAll();
	}

	@Override
	public Sucursal findSucursalById(Long id) {
		return sucursalDao.find(id);
	}

}
