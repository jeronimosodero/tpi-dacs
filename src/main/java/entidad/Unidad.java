package entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Unidad",schema="tpidacs")
public class Unidad extends BaseEntity{
	
	@NotNull
	@Column(name="dominio")
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
