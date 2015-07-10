package mb;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Cliente;
import model.Estado;
import model.Orden;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import facade.OrdenFacade;

@ManagedBean
@SessionScoped
public class ClienteHomeMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SHOW_ESTADO = "showEstado";

	@EJB
	private OrdenFacade ordenFacade;

	@ManagedProperty("#{logInMb}")
	private LogInMb login;

	private Cliente mCliente;

	private Orden mOrden;

	private Set<Orden> mOrdenes;

	private List<Estado> mEstados;

	private Estado mLastEstado;

	private MapModel model;

	@PostConstruct
	public void init() {
		mOrdenes = new HashSet<Orden>();
		if (login.isUser()) {
			mCliente = login.getCliente();
			for(Orden orden : mCliente.getOrdenes()){
				if (orden.isEstadoNull()) {
					mOrdenes.add(orden);
				}
			}
		}
	}

	public String showEstados(){
		mEstados = mOrden.getEstado();
		mLastEstado = mEstados.get(mEstados.size() - 1);
		model = new DefaultMapModel();
		model.addOverlay(new Marker(new LatLng(mLastEstado.getLatitud(),mLastEstado.getLongitud()), "Su paquete se encuentra aqui"));
		return SHOW_ESTADO;
	}
	
	// Setters and getters

	public List<Estado> getEstados() {
		return mEstados;
	}

	public void setEstados(List<Estado> estados) {
		mEstados = estados;
	}

	public Estado getLastEstado() {
		return mLastEstado;
	}

	public void setLastEstado(Estado lastEstado) {
		mLastEstado = lastEstado;
	}

	public MapModel getModel() {
		return model;
	}

	public void setCliente(Cliente cliente) {
		mCliente = cliente;
	}

	public Orden getOrden() {
		return mOrden;
	}

	public void setOrden(Orden orden) {
		mOrden = orden;
	}

	public Set<Orden> getOrdenes() {
		return mOrdenes;
	}

	public void setOrdenes(Set<Orden> ordenes) {
		mOrdenes = ordenes;
	}

	public Cliente getCliente() {
		return mCliente;
	}

	public void setLogin(LogInMb login) {
		this.login = login;
	}

}
