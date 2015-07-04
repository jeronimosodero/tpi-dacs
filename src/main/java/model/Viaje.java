package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Viaje",schema="tpidacs")
public class Viaje extends BaseEntity{
	
	/**
	 * 
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
	
	//relacion uno a uno con tabla estado
	@Column(name="estado")
	private Estado mEstado;
	
	//relacion muchos a uno con unidad
	@NotNull
    @ManyToOne
    @JoinColumn(name="fk_unidad")
	private Unidad mUnidad;
	
	
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
	public Estado getEstado() {
		return mEstado;
	}
	public void setEstado(Estado estado) {
		mEstado = estado;
	}
	
	
}
