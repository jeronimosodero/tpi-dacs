package mb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.transaction.UserTransaction;

import model.Cliente;
import model.Orden;
import model.Servicio;
import model.Sucursal;
import facade.ClienteFacade;
import facade.OrdenFacade;
import facade.ServicioFacade;
import facade.SucursalFacade;

@ManagedBean
@RequestScoped
public class OrdenMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String LIST_ALL_ORDENES = "listAllordenes";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	@EJB
	private OrdenFacade OrdenFacade;

	@EJB
	private ServicioFacade ServicioFacade;

	@EJB
	private SucursalFacade SucursalFacade;

	@EJB
	private ClienteFacade clienteFacade;

	@ManagedProperty("#{logInMb}")
	private LogInMb login;

	private Cliente mCliente;

	@Resource
	UserTransaction tx;

	private List<Sucursal> mSucursales;

	private List<Servicio> mServicios;

	private Orden mOrden;

	private Servicio mServicio;

	private Sucursal mOrigen;

	private Sucursal mDestino;

	private Float mMonto;

	private Set<Orden> mOrdenes;

	private Date mFecha;

	public String estadoOrden() {
		return "/pages/protected/user/selectOrden.jsp?faces-redirect=true";
	}

	public String altaOrden() {
		return "/pages/protected/user/altaOrden.jsp?faces-redirect=true";
	}

	public String altaOrdenEmpleado() {
		return "/pages/protected/employee/altaOrden.jsp?faces-redirect=true";
	}

	public String create() {
		try {
			tx.begin();
			mOrden = getOrden();
			mOrden.setFecha(mFecha);
			mOrden.setServicio(mServicio);
			mOrden.setOrigen(mOrigen);
			mOrden.setDestino(mDestino);
			mOrden.setMonto(0.f);
			mOrden.setPagado("No");
			OrdenFacade.save(mOrden);
			mCliente = login.getCliente();
			mCliente.getOrdenes().add(mOrden);
			clienteFacade.update(mCliente);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (Exception e1) {
				sendErrorMessageToUser("Error del servidor.");
				return STAY_IN_THE_SAME_PAGE;
			}
			sendErrorMessageToUser("Error: datos inválidos.");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operación completada.");
		mOrdenes = findAllOrdenes();
		return LIST_ALL_ORDENES;
	}

	@PostConstruct
	public void init() {
		mFecha = new Date();
		mCliente = login.getCliente();
		mSucursales = findAllSucursales();
		mServicios = findAllServicios();
		mOrdenes = findAllOrdenes();
	}

	public Set<Orden> findAllOrdenes() {
		return mCliente.getOrdenes();
	}

	public List<Servicio> findAllServicios() {
		return ServicioFacade.findAll();
	}

	public List<Sucursal> findAllSucursales() {
		return SucursalFacade.findAll();
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

	public Set<Orden> getOrdenes() {
		return mOrdenes;
	}

	public void setOrdenes(Set<Orden> ordenes) {
		mOrdenes = ordenes;
	}

	public Orden getOrden() {
		if (mOrden == null) {
			mOrden = new Orden();
		}
		return mOrden;
	}

	public void setOrden(Orden Orden) {
		mOrden = Orden;
	}

	public List<Sucursal> getSucursales() {
		return mSucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		mSucursales = sucursales;
	}

	public List<Servicio> getServicios() {
		return mServicios;
	}

	public void setServicios(List<Servicio> servicios) {
		mServicios = servicios;
	}

	public Servicio getServicio() {
		return mServicio;
	}

	public void setServicio(Servicio servicio) {
		mServicio = servicio;
	}

	public Sucursal getOrigen() {
		return mOrigen;
	}

	public void setOrigen(Sucursal origen) {
		mOrigen = origen;
	}

	public Sucursal getDestino() {
		return mDestino;
	}

	public void setDestino(Sucursal destino) {
		mDestino = destino;
	}

	public Float getMonto() {
		return mMonto;
	}

	public void setMonto(Float monto) {
		mMonto = monto;
	}

	public Date getFecha() {
		return mFecha;
	}

	public void setLogin(LogInMb login) {
		this.login = login;
	}
}