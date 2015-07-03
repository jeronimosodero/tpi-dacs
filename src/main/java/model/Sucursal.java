package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Sucursal", schema = "tpidacs")
public class Sucursal extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Properties -------------------------------------------------------------
	@NotNull
	@Column(name = "telefono")
	private String mTelefono;
	
	@NotNull
	@Column(name = "email")
	@Pattern(regexp = PATTERN_EMAIL)
	private String mEmail;
	
	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Direccion mDireccion;
	
	// Getters/Setters --------------------------------------------------------
	public String getTelefono() {
		return mTelefono;
	}
	public void setTelefono(String telefono) {
		mTelefono = telefono;
	}
	public String getEmail() {
		return mEmail;
	}
	public void setEmail(String email) {
		mEmail = email;
	}
	public Direccion getDireccion() {
		return mDireccion;
	}
	public void setDireccion(Direccion direccion) {
		mDireccion = direccion;
	}
	
	@Override
	public String toString(){
		if (getId() == null) {
			return null;
		}
		return String.format("%d - %s - %s", getId(),getDireccion().getProvincia(),getDireccion().getCiudad());
	}
}
