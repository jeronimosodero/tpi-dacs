package mb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.Cliente;
import model.Direccion;
import facade.ClienteFacade;

@ManagedBean
@RequestScoped
public class ClienteMB implements Serializable	 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ClienteFacade ClienteFacade;
	
	private Cliente mCliente;
	
	private Direccion mDireccion;
	
	public Direccion getDireccion() {
		return mDireccion;
	}

	public void setDireccion(Direccion Direccion) {
		this.mDireccion = Direccion;
	}

	public Cliente getCliente() {
		if(mCliente == null){
			mCliente = new Cliente();
		}
		return mCliente;
	}

	public void setCliente(Cliente cliente) {
		mCliente = cliente;
	}

	public String createClienteEnd(){
		try {
			ClienteFacade.save(mCliente);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error");
			return "Error";
		}
		sendInfoMessageToUser("Operacion completada.");
		return "OK";
	}
	
	private void sendInfoMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,message,message));		
	}

	private void sendErrorMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,message,message));
	}
	
	private FacesContext getContext(){
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}
	
}
