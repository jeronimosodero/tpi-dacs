package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Viaje",schema="tpidacs")
@NamedQuery(name = "Viaje.findActuales", query = "select u.mViajeActual from Unidad u where u.mViajeActual is not null")
public class Viaje extends BaseEntity{
	
	/**
	 * Ruta -> lista de sucursales
	 */

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ACTUALES = "Viaje.findActuales";

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_partida")
	private Date mFechaPartida;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_unidad")
	private Unidad mUnidad;
	
/*	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="viaje_fk") */

	@OneToMany
	@JoinColumn(name = "viaje_fk")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Orden> mOrdenes;

	@Column(name = "finalizado")
	private boolean mFinalizado;

	@ManyToOne
	@JoinColumn(name = "fk_ruta")
	private Ruta mRuta;

	public Date getFechaPartida() {
		return mFechaPartida;
	}

	public void setFechaPartida(Date fechaPartida) {
		mFechaPartida = fechaPartida;
	}

	public Set<Orden> getOrdenes() {
		return mOrdenes;
	}

	public void setOrdenes(Set<Orden> ordenes) {
		mOrdenes = ordenes;
	}

	public Ruta getRuta() {
		return mRuta;
	}

	public void setRuta(Ruta ruta) {
		mRuta = ruta;
	}

	public boolean isFinalizado() {
		return mFinalizado;
	}

	public void setFinalizado(boolean finalizado) {
		mFinalizado = finalizado;
	}

	@Override
	public String toString() {
		if (getId() == null) {
			return null;
		}
		return String.format("%s - %s", getFechaPartida(), getRuta());
	}

	public Unidad getUnidad() {
		return mUnidad;
	}

	public void setUnidad(Unidad unidad) {
		mUnidad = unidad;
	}
}

