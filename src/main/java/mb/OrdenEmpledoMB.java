package mb;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.transaction.UserTransaction;

import model.Cliente;
import model.Empleado;
import model.Estado;
import model.Orden;
import model.Paquete;
import facade.ClienteFacade;
import facade.EstadoFacade;
import facade.OrdenFacade;
import facade.PaqueteFacade;

@ManagedBean
@SessionScoped
public class OrdenEmpledoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String STAY_IN_THE_SAME_PAGE = null;
	private static final String LIST_ALL_PAQUETES = "listAllPaquetes";

	@EJB
	private ClienteFacade clienteFacade;

	@EJB
	private OrdenFacade ordenFacade;

	@EJB
	private PaqueteFacade paqueteFacade;
	
	@EJB
	private EstadoFacade estadoFacade;

	@ManagedProperty("#{logInMb}")
	private LogInMb login;

	private Empleado mEmpleado;

	private Estado mEstado;

	@Resource
	UserTransaction tx;

	private Cliente mCliente;

	private Paquete mPaquete;

	private Set<Paquete> mPaquetes;

	private Long mIdCliente;

	private Orden mOrden;

	private Set<Orden> mOrdenes;

	public String findClienteById() {
		mCliente = clienteFacade.findClienteById(mIdCliente);
		mOrdenes = mCliente.getOrdenes();
		return "/pages/protected/employee/altaOrden1.jsp";
	}

	public String addPaquetes() {
		mEstado = crearEstado();
		return "/pages/protected/employee/altaOrden2.jsp";
	}

	public String createAndRedirect() {
		create();
		mPaquete = new Paquete();
		return "/pages/protected/employee/altaOrden2.jsp";
	}

	public String create() {
		try {
			tx.begin();
			paqueteFacade.save(mPaquete);
			mOrden.getPaquetes().add(mPaquete);
			mOrden.getEstado().add(mEstado);
			estadoFacade.save(mEstado);
			ordenFacade.update(mOrden);
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
		mPaquetes = mOrden.getPaquetes();
		sendInfoMessageToUser("Operacion completada.");
		return LIST_ALL_PAQUETES;
	}

	private Estado crearEstado() {
		Estado e = new Estado();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		e.setFecha(date);
		e.setHora(ts);
		e.setSucursal(mEmpleado.getSucursal());
		e.setLatitud(mEmpleado.getSucursal().getLatitud());
		e.setLongitud(mEmpleado.getSucursal().getLongitud());
		return e;
	}

	@PostConstruct
	public void init() {
		mEmpleado = login.getEmpleado();
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
	public Cliente getCliente() {
		return mCliente;
	}

	public void setCliente(Cliente cliente) {
		mCliente = cliente;
	}

	public Long getIdCliente() {
		return mIdCliente;
	}

	public void setIdCliente(Long idCliente) {
		mIdCliente = idCliente;
	}

	public Set<Orden> getOrdenes() {
		return mOrdenes;
	}

	public void setOrdenes(Set<Orden> ordenes) {
		mOrdenes = ordenes;
	}

	public Orden getOrden() {
		return mOrden;
	}

	public void setOrden(Orden orden) {
		mOrden = orden;
	}

	public Paquete getPaquete() {
		if (mPaquete == null) {
			mPaquete = new Paquete();
		}
		return mPaquete;
	}

	public void setPaquete(Paquete paquete) {
		mPaquete = paquete;
	}

	public Set<Paquete> getPaquetes() {
		return mPaquetes;
	}

	public void setPaquetes(Set<Paquete> paquetes) {
		mPaquetes = paquetes;
	}

	public Empleado getEmpleado() {
		return mEmpleado;
	}

	public void setEmpleado(Empleado empleado) {
		mEmpleado = empleado;
	}

	public void setLogin(LogInMb login) {
		this.login = login;
	}

}
