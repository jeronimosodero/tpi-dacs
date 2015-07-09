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

import model.Ruta;
import model.Unidad;
import model.Viaje;
import facade.RutaFacade;
import facade.UnidadFacade;
import facade.ViajeFacade;

@ManagedBean
@RequestScoped
public class ViajeMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String LIST_ALL_VIAJES = "listAllViajes";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	@EJB
	private ViajeFacade ViajeFacade;

	@EJB
	private RutaFacade RutaFacade;

	@EJB
	private UnidadFacade UnidadFacade;

	@Resource
	UserTransaction tx;

	private Viaje mViaje;

	private List<Viaje> mViajes;

	private List<Unidad> mUnidades;

	private List<Ruta> mRutas;

	public String create() {
		try {
			tx.begin();
			ViajeFacade.save(mViaje);
			mViaje.getUnidad().setViajeActual(mViaje);
			UnidadFacade.update(mViaje.getUnidad());
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
		mViajes = findAllViajes();
		return LIST_ALL_VIAJES;
	}

	public List<Unidad> findAllUnidades() {
		return UnidadFacade.findAll();
	}

	public List<Ruta> findAllRutas() {
		return RutaFacade.findAll();
	}

	public List<Viaje> findAllViajes() {
		return ViajeFacade.findAll();
	}

	@PostConstruct
	public void init() {
		mViajes = findAllViajes();
		mUnidades = findAllUnidades();
		mRutas = findAllRutas();
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
	public Viaje getViaje() {
		if (mViaje == null) {
			mViaje = new Viaje();
		}
		return mViaje;
	}

	public void setViaje(Viaje viaje) {
		mViaje = viaje;
	}

	public List<Viaje> getViajes() {
		return mViajes;
	}

	public void setViajes(List<Viaje> viajes) {
		mViajes = viajes;
	}

	public List<Unidad> getUnidades() {
		return mUnidades;
	}

	public void setUnidades(List<Unidad> unidades) {
		mUnidades = unidades;
	}

	public List<Ruta> getRutas() {
		return mRutas;
	}

	public void setRutas(List<Ruta> rutas) {
		mRutas = rutas;
	}

}
