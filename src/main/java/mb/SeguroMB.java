package mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Seguro;
import facade.SeguroFacade;

@ManagedBean
@ViewScoped
public class SeguroMB implements Serializable {

	private static final String LIST_ALL_SEGUROS = "listAllSeguros";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	private static final long serialVersionUID = 1L;

	@EJB
	private SeguroFacade seguroFacade;
	
	private Seguro mSeguro;
	
	private List<Seguro> mSeguros;
	
	public String create(){
		try {
			seguroFacade.save(mSeguro);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operacion completada.");
		mSeguros = findall();
		return LIST_ALL_SEGUROS;
	}
	
	public List<Seguro> findall(){
		return seguroFacade.findAll();
	}
	
	@PostConstruct
	public void init(){
		mSeguros = findall();
	}
	
// Views errors
	
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
	
	// Setters and getters
	
	public Seguro getSeguro() {
		if(mSeguro == null){
			mSeguro = new Seguro();
		}
		return mSeguro;
	}

	public void setSeguro(Seguro seguro) {
		mSeguro = seguro;
	}

	public List<Seguro> getSeguros() {
		return mSeguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		mSeguros = seguros;
	}
	
}
