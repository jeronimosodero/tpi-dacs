package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Servicio",schema="tpidacs")
public class Servicio extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Size(min = 1, max = 50 )
	@NotNull
	@Column(name="nombre")
	private String mNombre;
	
	@Size(min = 1, max = 300 )
	@NotNull
	@Column(name="descripcion")
	private String mDescripcion;
	
	
	@NotNull
	@Column(name="coeficiente_costo")
	private Float mCoeficienteCosto;
	
	@ManyToOne
    @JoinColumn(name="seguro")
	private Seguro mSeguro;
	
	public String getNombre() {
		return mNombre;
	}
	public void setNombre(String nombre) {
		mNombre = nombre;
	}
	public String getDescripcion() {
		return mDescripcion;
	}
	public void setDescripcion(String descripcion) {
		mDescripcion = descripcion;
	}
	public Float getCoeficienteCosto() {
		return mCoeficienteCosto;
	}
	public void setCoeficienteCosto(Float coeficienteCosto) {
		mCoeficienteCosto = coeficienteCosto;
	}
	public Seguro getSeguro() {
		return mSeguro;
	}
	public void setSeguro(Seguro seguro) {
		mSeguro = seguro;
	}
	
	
}
