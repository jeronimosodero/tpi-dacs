package mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.transaction.UserTransaction;

import model.Direccion;
import model.Sucursal;
import facade.DireccionFacade;
import facade.SucursalFacade;

@ManagedBean
@RequestScoped
public class SucursalMB implements Serializable {
	private static final String LIST_ALL_SUCURSALES = "listAllSucursales";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	private static final long serialVersionUID = 1L;

	@EJB
	private SucursalFacade sucursalFacade;

	@EJB
	private DireccionFacade direccionFacade;

	@Resource
	UserTransaction tx;

	private Sucursal mSucursal;

	private Direccion mDireccion;

	private List<Sucursal> mSucursales;

	public List<Sucursal> findAll() {
		return sucursalFacade.findAll();
	}

	public String create() {
		try {
			tx.begin();
			direccionFacade.save(mDireccion);
			mSucursal.setDireccion(mDireccion);
			sucursalFacade.save(mSucursal);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (Exception e1) {
				sendErrorMessageToUser("Error del servidor.");
				return STAY_IN_THE_SAME_PAGE;
			}
			sendErrorMessageToUser("Error datos invalidos.");
			return STAY_IN_THE_SAME_PAGE;
		}
		mSucursales = findAll();
		sendInfoMessageToUser("Operacion completada.");
		return LIST_ALL_SUCURSALES;
	}

	@PostConstruct
	public void init() {
		mSucursales = findAll();
	}

	// Views errors

	private void sendInfoMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				message, message));
	}

	private void sendErrorMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				message, message));
	}

	private FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}

	// Setters and getters

	public Sucursal getSucursal() {
		if (mSucursal == null) {
			mSucursal = new Sucursal();
		}
		return mSucursal;
	}

	public List<Sucursal> getSucursales() {
		return mSucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		mSucursales = sucursales;
	}

	public void setSucursal(Sucursal sucursal) {
		mSucursal = sucursal;
	}

	public Direccion getDireccion() {
		if (mDireccion == null) {
			mDireccion = new Direccion();
		}
		return mDireccion;
	}

	public void setDireccion(Direccion direccion) {
		mDireccion = direccion;
	}

}
