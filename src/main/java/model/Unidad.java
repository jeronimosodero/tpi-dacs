package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Unidad",schema="tpidacs")
public class Unidad extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name="dominio")
	@Pattern(regexp = "[A-Z][A-Z][A-Z] [0-9][0-9][0-9]")
	private String mDominio;
	
	@NotNull
	@Column(name="modelo")
	private String mModelo;
	
	@NotNull
	@Column(name="marca")
	private String mMarca;
	
	@NotNull
	@Column(name="capacidad_peso")
	private Float mCapacidadPeso;
	
	
	
	@NotNull
	@Column(name="capacidad_tamanio")
	private Float mCapacidadTamaño;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_Adquisicion")
	private Date mFechaAdquisicion;
		
	
	public String getDominio() {
		return mDominio;
	}
	public void setDominio(String dominio) {
		mDominio = dominio;
	}
	public String getModelo() {
		return mModelo;
	}
	public void setModelo(String modelo) {
		mModelo = modelo;
	}
	public String getMarca() {
		return mMarca;
	}
	public void setMarca(String marca) {
		mMarca = marca;
	}
	public Float getCapacidadPeso() {
		return mCapacidadPeso;
	}
	public void setCapacidadPeso(Float capacidadPeso) {
		mCapacidadPeso = capacidadPeso;
	}
	public Float getCapacidadTamaño() {
		return mCapacidadTamaño;
	}
	public void setCapacidadTamaño(Float capacidadTamaño) {
		mCapacidadTamaño = capacidadTamaño;
	}
	public Date getFechaAdquisicion() {
		return mFechaAdquisicion;
	}
	public void setFechaAdquisicion(Date fechaAdquisicion) {
		mFechaAdquisicion = fechaAdquisicion;
	}
	
}
