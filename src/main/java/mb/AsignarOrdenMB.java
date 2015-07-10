package mb;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.transaction.UserTransaction;

import model.Orden;
import model.Viaje;
import facade.OrdenFacade;
import facade.ViajeFacade;

@ManagedBean
@RequestScoped
public class AsignarOrdenMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String LIST_ALL_ORDENES = "listAllordenes";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	@EJB
	private OrdenFacade OrdenFacade;

	@EJB
	private ViajeFacade ViajeFacade;

	@Resource
	UserTransaction tx;

	private List<Orden> mOrdenes;

	private Set<Orden> mSelectedOrdenes;

	private List<Viaje> mViajes;

	private Viaje mViaje;

	public String asignarOrden() {
		return "/pages/protected/employee/asignarOrdenes.jsp?faces-redirect=true";
	}


	
	public String save() {
		try {
			tx.begin();
			for(Orden o:mSelectedOrdenes){
				mViaje.getOrdenes().add(o);
				ViajeFacade.update(mViaje);
			}
			tx.commit();
		} catch (Exception e) {
			try {
				e.printStackTrace();
				tx.rollback();
			} catch (Exception e1) {
				sendErrorMessageToUser("Error del servidor.");
				return STAY_IN_THE_SAME_PAGE;
			}
			sendErrorMessageToUser("Error: datos inválidos.");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operación completada.");
		mOrdenes = findUnassignedOrdenes();
		return LIST_ALL_ORDENES;
	}

	@PostConstruct
	public void init() {
		mViajes = findViajesActuales();
		mOrdenes = findUnassignedOrdenes();
	}

	private List<Viaje> findViajesActuales() {
		return ViajeFacade.findActuales();
	}

	public List<Orden> findUnassignedOrdenes() {
		return OrdenFacade.findUnassigned();
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

	public List<Orden> getOrdenes() {
		return mOrdenes;
	}

	public List<Viaje> getViajes() {
		return mViajes;
	}

	public void setViajes(List<Viaje> viajes) {
		mViajes = viajes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		mOrdenes = ordenes;
	}

	public Viaje getViaje() {
		if (mViaje == null) {
			mViaje = new Viaje();
		}
		return mViaje;
	}

	public void setViaje(Viaje viaje) {
		mViaje = viaje;
	}

	public Set<Orden> getSelectedOrdenes() {
		return mSelectedOrdenes;
	}

	public void setSelectedOrdenes(Set<Orden> selectedOrdenes) {
		mSelectedOrdenes = selectedOrdenes;
	}

}