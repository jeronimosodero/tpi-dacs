package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Viaje",schema="tpidacs")
public class Viaje extends BaseEntity{
	
	/**
	 * Ruta -> lista de sucursales
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_partida")
	private Date mFechaPartida;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_llegada_estimada")
	private Date mFechaLlegadaEstimada;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_llegada")
	private Date mFechaLlegada;
	

	//relacion muchos a uno con unidad
	@NotNull
    @ManyToOne
    @JoinColumn(name="fk_unidad")
	private Unidad mUnidad;
	
	@NotNull
	@OneToMany
	@JoinColumn(name="fk_orden")
	private List<Orden> mOrdenes;
	
	public List<Orden> getOrdenes() {
		return mOrdenes;
	}
	public void setOrdenes(List<Orden> ordenes) {
		mOrdenes = ordenes;
	}
	public Date getFechaPartida() {
		return mFechaPartida;
	}
	public void setFechaPartida(Date fechaPartida) {
		mFechaPartida = fechaPartida;
	}
	public Date getFechaLlegadaEstimada() {
		return mFechaLlegadaEstimada;
	}
	public void setFechaLlegadaEstimada(Date fechaLlegadaEstimada) {
		mFechaLlegadaEstimada = fechaLlegadaEstimada;
	}
	public Date getFechaLlegada() {
		return mFechaLlegada;
	}
	public void setFechaLlegada(Date fechaLlegada) {
		mFechaLlegada = fechaLlegada;
	}


}
