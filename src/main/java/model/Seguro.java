package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name="Seguro",schema="tpidacs")
public class Seguro extends BaseEntity{

	/**
	 * 
	 */
	
	// Properties -------------------------------------------------------------
	
	private static final long serialVersionUID = 1L;
	
	@Size(min = 1, max = 50 )
	@NotNull
	@Column(name="nombre")
	private String mNombre;
	
	@NotNull
	@Column(name = "porcentaje_cubierto")
	@Min(0)
	@Max(100)
	private Float mPorcentajeCubierto;
	
	@NotNull
	@Column(name = "precio")
	private Float mPrecio;
	
	@NotNull
	@Column(name = "duracion")
	private int mDuracion;
	
	// Getters/Setters --------------------------------------------------------
	public String getNombre() {
		return mNombre;
	}
	public void setNombre(String nombre) {
		mNombre = nombre;
	}
	public Float getPorcentajeCubierto() {
		return mPorcentajeCubierto;
	}
	public void setPorcentajeCubierto(Float porcentajeCubierto) {
		mPorcentajeCubierto = porcentajeCubierto;
	}
	public Float getPrecio() {
		return mPrecio;
	}
	public void setPrecio(Float precio) {
		mPrecio = precio;
	}
	public int getDuracion() {
		return mDuracion;
	}
	public void setDuracion(int duracion) {
		mDuracion = duracion;
	}
	
	@Override
	public String toString(){
		if (getId() == null){
			return null;
		}
		return String.format("%s - %d - %d%%", getNombre(),getPrecio().intValue(),getPorcentajeCubierto().intValue());
	}
	
}
