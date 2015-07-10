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

import model.Empleado;
import model.Sucursal;
import facade.EmpleadoFacade;
import facade.SucursalFacade;

@ManagedBean
@RequestScoped
public class EmpleadoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String LIST_ALL_EMPLEADOS = "listAllEmpleados";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	@EJB
	private EmpleadoFacade empleadoFacade;

	@EJB
	private SucursalFacade sucursalFacade;
	
	@Resource
	UserTransaction tx;

	private Empleado mEmpleado;

	private Sucursal mSucursal;
	
	private List<Empleado> mEmpleados;
	
	private List<Sucursal> mSucursales;
	
	public String listarEmpleados() {
		return "/pages/protected/admin/listEmpleado.jsp?faces-redirect=true";
	}
	
	public String altaEmpleado() {
		return "/pages/protected/admin/altaEmpleado.jsp?faces-redirect=true";
	}

	public String createEmpleadoEnd(){
		try {
			tx.begin();
			mEmpleado.setSucursal(mSucursal);
			mEmpleado.setDNI();
			mEmpleado.setPass();
			mEmpleado.setRole();
			empleadoFacade.save(mEmpleado);
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
		sendInfoMessageToUser("Operacion completada.");
		mEmpleados = findAllEmpleados();
		return LIST_ALL_EMPLEADOS;
	}
	
	public List<Empleado> findAllEmpleados(){
		return empleadoFacade.findAll();
	}
	
	public List<Sucursal> findAllSucursales(){
		return sucursalFacade.findAll();
	}
	
	@PostConstruct
	public void init(){
		mEmpleados = findAllEmpleados();
		mSucursales = findAllSucursales();
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

	public Empleado getEmpleado() {
		if (mEmpleado == null) {
			mEmpleado = new Empleado();
		}
		return mEmpleado;
	}

	public void setEmpleado(Empleado empleado) {
		mEmpleado = empleado;
	}

	public Sucursal getSucursal() {
		if (mSucursal == null) {
			mSucursal = new Sucursal();
		}		
		return mSucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		mSucursal = sucursal;
	}

	public List<Empleado> getEmpleados() {
		return mEmpleados;
	}

	public List<Sucursal> getSucursales() {
		return mSucursales;
	}
	
}
