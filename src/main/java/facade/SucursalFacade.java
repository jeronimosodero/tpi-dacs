package facade;

import java.util.List;

import javax.ejb.Local;

import model.Sucursal;

@Local
public interface SucursalFacade {
	public abstract void save(Sucursal sucursal);
	public abstract List<Sucursal> findAll();
	public abstract Sucursal findSucursalById(Long id);
}
