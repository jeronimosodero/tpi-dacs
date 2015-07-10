package model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Orden", schema = "tpidacs")
public class Orden extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date mFecha;

	@NotNull
	@Column(name = "monto")
	private Float mMonto;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "servicio")
	private Servicio mServicio;

	@NotNull
	@Pattern(regexp = "Si|No")
	@Column(name = "pagado")
	private String mPagado;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "orden_fk")
	private Set<Paquete> mPaquetes;

	@ManyToOne
	@JoinColumn(name = "destino_fk")
	private Sucursal mDestino;

	@ManyToOne
	@JoinColumn(name = "origen_fk")
	private Sucursal mOrigen;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Estado> mEstado;

	public Servicio getServicio() {
		return mServicio;
	}

	public void setServicio(Servicio servicio) {
		mServicio = servicio;
	}

	public String getPagado() {
		return mPagado;
	}

	public void setPagado(String pagado) {
		mPagado = pagado;
	}

	public Sucursal getDestino() {
		return mDestino;
	}

	public void setDestino(Sucursal destino) {
		mDestino = destino;
	}

	public Sucursal getOrigen() {
		return mOrigen;
	}

	public void setOrigen(Sucursal origen) {
		mOrigen = origen;
	}

	public Date getFecha() {
		return mFecha;
	}

	public void setFecha(Date fecha) {
		mFecha = fecha;
	}

	public Float getMonto() {
		return mMonto;
	}

	public void setMonto(Float monto) {
		mMonto = monto;
	}

	public String getmPagado() {
		return mPagado;
	}

	public void setmPagado(String mPagado) {
		this.mPagado = mPagado;
	}

	public Set<Paquete> getPaquetes() {
		return mPaquetes;
	}

	public void setPaquetes(Set<Paquete> paquetes) {
		mPaquetes = paquetes;
	}

	public List<Estado> getEstado() {
		return mEstado;
	}

	public void setEstado(List<Estado> estado) {
		mEstado = estado;
	}

	@Override
	public String toString(){
		return String.format("%d - %s - %s", getId(),getOrigen(),getDestino());
	}
}
