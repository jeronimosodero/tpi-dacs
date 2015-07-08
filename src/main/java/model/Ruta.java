package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Ruta", schema = "tpidacs")
public class Ruta extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(name = "nombre")
	private String mNombre;
	
	@ManyToMany
	private List<Sucursal> mSucursales;
	

	public String getNombre() {
		return mNombre;
	}

	public void setNombre(String nombre) {
		mNombre = nombre;
	}

	public List<Sucursal> getSucursales() {
		return mSucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		mSucursales = sucursales;
	} 
	
	
	
	

}
