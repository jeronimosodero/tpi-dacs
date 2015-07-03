package mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.Administrador;
import model.Cliente;
import model.Empleado;
import facade.AdministradorFacade;
import facade.ClienteFacade;
import facade.EmpleadoFacade;

@ManagedBean
@SessionScoped
public class LogInMb {

	@EJB
	private ClienteFacade clienteFacade;

	@EJB
	private AdministradorFacade administradorFacade;

	@EJB
	private EmpleadoFacade empleadoFacade;

	private Cliente mCliente;
	private Administrador mAdministrador;
	private Empleado mEmpleado;

	public Cliente getCliente() {
		if (mCliente == null) {
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();
			if (context.getUserPrincipal() == null) {
				return null;
			}
			String clienteEmail = context.getUserPrincipal().getName();
			mCliente = clienteFacade.findClienteByEmail(clienteEmail);
		}
		return mCliente;
	}

	public Administrador getAdministrador() {
		if (mAdministrador == null) {
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();
			if (context.getUserPrincipal() == null) {
				return null;
			}
			String administradorEmail = context.getUserPrincipal().getName();
			mAdministrador = administradorFacade
					.findAdministradorByEmail(administradorEmail);
		}
		return mAdministrador;
	}

	public Empleado getEmpleado() {
		if (mEmpleado == null) {
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();
			if (context.getUserPrincipal() == null) {
				return null;
			}
			String empleadoEmail = context.getUserPrincipal().getName();
			mEmpleado = empleadoFacade.findEmpleadoByEmail(empleadoEmail);
		}
		return mEmpleado;
	}

	public boolean isAdmin() {
		return getRequest().isUserInRole("ADMIN");
	}

	public boolean isUser() {
		return getRequest().isUserInRole("USER");
	}

	public boolean isEmployee() {
		return getRequest().isUserInRole("EMPLOYEE");
	}

	public boolean isLoggedIn() {
		if (isAdmin()) {
			return getAdministrador() != null;
		}
		if (isUser()) {
			return getCliente() != null;
		}
		if (isEmployee()) {
			return getEmpleado() != null;
		}
		
		return false;
	}

	public String logOut() {
		getRequest().getSession().invalidate();
		return "/pages/public/index.jsp?faces-redirect=true";
	}

	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

}
