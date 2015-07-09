package mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.Unidad;
import facade.UnidadFacade;

@ManagedBean
@RequestScoped
public class UnidadMB implements Serializable {
	
	private static final String LIST_ALL_UNIDADES = "listAllUnidades";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	private static final long serialVersionUID = 1L;

	@EJB
	private UnidadFacade unidadFacade;

	private Unidad mUnidad;

	private List<Unidad> mUnidades;
	
	public String listarUnidades() {
		return "/pages/protected/admin/listUnidad.jsp?faces-redirect=true";
	}
	
	public String altaUnidad() {
		return "/pages/protected/admin/altaUnidad.jsp?faces-redirect=true";
	}

	public String create() {
		try {
			unidadFacade.save(mUnidad);
		} catch (Exception e) {
			sendErrorMessageToUser("Error");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operacion completada.");
		mUnidades = findAll();
		return LIST_ALL_UNIDADES;
	}

	public List<Unidad> findAll(){
		return unidadFacade.findAll();
	}
	
	@PostConstruct
	public void init(){
		mUnidades = findAll();
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

	public Unidad getUnidad() {
		if (mUnidad == null) {
			mUnidad = new Unidad();
		}
		return mUnidad;
	}

	public void setUnidad(Unidad unidad) {
		mUnidad = unidad;
	}

	public List<Unidad> getUnidades() {
		return mUnidades;
	}

	public void setUnidades(List<Unidad> unidades) {
		mUnidades = unidades;
	}

}
