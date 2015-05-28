package entidad;

import java.util.Date;

public class Unidad extends BaseEntity{
	private String mDominio;
	private String mModelo;
	private String mMarca;
	private Float mCapacidadPeso;
	private Float mCapacidadTamaño;
	private Date mFechaAdquisicion;
	private Viaje mViaje;
	
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
	public Viaje getViaje() {
		return mViaje;
	}
	public void setViaje(Viaje viaje) {
		mViaje = viaje;
	}
	
}
