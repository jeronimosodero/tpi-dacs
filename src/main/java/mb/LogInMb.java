package mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.Cliente;
import facade.ClienteFacade;

@ManagedBean
@SessionScoped
public class LogInMb {

	private static final String LOGOUT_SUCCESS = "LOGOUT";

	@EJB
	private ClienteFacade clienteFacade;
	
	private Cliente mCliente;

	public Cliente getCliente(){
		if (mCliente == null) {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			if (context.getUserPrincipal() == null) {
				return null;
			}
			String clienteEmail = context.getUserPrincipal().getName();
			mCliente = clienteFacade.findClienteByEmail(clienteEmail);
		}
		return mCliente;
	}
	
	public boolean isClienteAdmin(){
		return getRequest().isUserInRole("ADMIN");
	}
	
	public String logOut(){
		getRequest().getSession().invalidate();
		return LOGOUT_SUCCESS;
	}
	
	private HttpServletRequest getRequest(){
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
}
