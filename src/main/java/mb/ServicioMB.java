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

import model.Seguro;
import model.Servicio;
import facade.SeguroFacade;
import facade.ServicioFacade;

@ManagedBean
@RequestScoped
public class ServicioMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String LIST_ALL_SERVICIOS = "listAllServicios";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	
	@EJB
	private ServicioFacade servicioFacade;
	
	@EJB
	private SeguroFacade seguroFacade;
	
	@Resource
	UserTransaction tx;
	
	private Servicio mServicio;
	
	private Seguro mSeguro;
	
	private List<Servicio> mServicios;
	
	private List<Seguro> mSeguros;
	
	public String listarServicios() {
		return "/pages/protected/admin/listServicio.jsp?faces-redirect=true";
	}
	
	public String altaServicio() {
		return "/pages/protected/admin/altaServicio.jsp?faces-redirect=true";
	}
	
	public String create(){
		try {
			tx.begin();
			mServicio.setSeguro(mSeguro);
			servicioFacade.save(mServicio);
			tx.commit();
		} catch (Exception e){
			try {
				tx.rollback();
			} catch (Exception e1){
				sendErrorMessageToUser("Error del servidor.");
				return STAY_IN_THE_SAME_PAGE;
			}
			sendErrorMessageToUser("Error: datos inválidos.");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operación completada.");
		mServicios = findAllServicios();
		return LIST_ALL_SERVICIOS;
	}
	
	public List<Servicio> findAllServicios(){
		return servicioFacade.findAll();
	}
	
	public List<Seguro> findAllSeguros(){
		return seguroFacade.findAll();
	}
	
	@PostConstruct
	public void init(){
		mServicios = findAllServicios();
		mSeguros = findAllSeguros();
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

	public Servicio getServicio() {
		if (mServicio == null) {
			mServicio = new Servicio();
		}
		return mServicio;
	}

	public void setServicio(Servicio Servicio) {
		mServicio = Servicio;
	}

	public List<Servicio> getServicios() {
		return mServicios;
	}

	public void setServicios(List<Servicio> Servicios) {
		mServicios = Servicios;
	}
	
	public Seguro getSeguro() {
		if(mSeguro == null) {
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
