package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Direccion", schema="tpidacs")
public class Direccion extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Properties -------------------------------------------------------------
	@NotNull
	@Column(name="calle")
	private String mCalle;
	
	@NotNull
	@Column(name="altura")
	private int mAltura;
	
	@Column(name="piso")
	private int mPiso;
	
	@Column(name="departamento")
	private int mDepartamento;
	
	@NotNull
	@Column(name="ciudad")
	private String mCiudad;
	
	@NotNull
	@Column(name="provincia")
	private String mProvincia;
	
	@NotNull
	@Column(name="pais")
	private String mPais;
	
	// Getters/Setters -------------------------------------------------------------
	
	public String getCalle() {
		return mCalle;
	}
	public void setCalle(String calle) {
		mCalle = calle;
	}
	public int getAltura() {
		return mAltura;
	}
	public void setAltura(int altura) {
		mAltura = altura;
	}
	public int getPiso() {
		return mPiso;
	}
	public void setPiso(int piso) {
		mPiso = piso;
	}
	public String getCiudad() {
		return mCiudad;
	}
	public void setCiudad(String ciudad) {
		mCiudad = ciudad;
	}
	public String getProvincia() {
		return mProvincia;
	}
	public void setProvincia(String provincia) {
		mProvincia = provincia;
	}
	public String getPais() {
		return mPais;
	}
	public void setPais(String pais) {
		mPais = pais;
	}
	public int getDepartamento() {
		return mDepartamento;
	}
	public void setDepartamento(int departamento) {
		mDepartamento = departamento;
	}

	}