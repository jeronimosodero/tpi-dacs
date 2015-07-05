package mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Estado;
import model.Paquete;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import facade.PaqueteFacade;

@ManagedBean
@SessionScoped
public class ClienteHomeMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SHOW_ESTADO = "showEstado";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	@EJB
	private PaqueteFacade paqueteFacade;

	private Paquete mPaquete;

	private Long mIdPaquete;

	private List<Estado> mEstados;

	private Estado mLastEstado;

	private MapModel model = new DefaultMapModel();

	public String findPaqueteById() {
		try {
			mPaquete = paqueteFacade.findPaqueteById(mIdPaquete);
		} catch (Exception e) {
			return STAY_IN_THE_SAME_PAGE;
		}
		mEstados = mPaquete.getEstado();
		mLastEstado = mEstados.get(mEstados.size() - 1);
		model.addOverlay(new Marker(new LatLng(mLastEstado.getLatitud(),
				mLastEstado.getLongitud()), "Su paquete se encuentra aqui"));
		return SHOW_ESTADO;
	}

	public Long getIdPaquete() {
		return mIdPaquete;
	}

	public void setIdPaquete(Long idPaquete) {
		mIdPaquete = idPaquete;
	}

	public Paquete getPaquete() {
		if (mPaquete == null) {
			mPaquete = new Paquete();
		}
		return mPaquete;
	}

	public void setPaquete(Paquete paquete) {
		mPaquete = paquete;
	}

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

}
