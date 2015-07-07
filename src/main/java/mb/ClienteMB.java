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

import model.Cliente;
import model.Direccion;
import facade.ClienteFacade;
import facade.DireccionFacade;

@ManagedBean
@RequestScoped
public class ClienteMB implements Serializable {

	private static final String LIST_ALL_CLIENTES = "listAllClientes";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	private static final long serialVersionUID = 1L;

	@EJB
	private ClienteFacade clienteFacade;

	@EJB
	private DireccionFacade direccionFacade;
	

	@Resource
	UserTransaction tx;

	private Cliente mCliente;

	private List<Cliente> mClientes;

	private Direccion mDireccion;

	public String createClienteEnd() {
		try {
			tx.begin();
			direccionFacade.save(mDireccion);
			mCliente.setDireccion(mDireccion);
			mCliente.setDNI();
			mCliente.setPass();
			mCliente.setRole();
			clienteFacade.save(mCliente);
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
		return LIST_ALL_CLIENTES;
	}

	public List<Cliente> findAll() {
		return clienteFacade.findAll();
	}

	@PostConstruct
	public void init() {
		mClientes = findAll();
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
		if (mCliente == null) {
			mCliente = new Cliente();
		}
		return mCliente;
	}

	public void setCliente(Cliente cliente) {
		mCliente = cliente;
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

	public List<Cliente> getClientes() {
		return mClientes;
	}
}
