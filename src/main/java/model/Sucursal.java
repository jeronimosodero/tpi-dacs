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
	@OneToOne(fetch = FetchType.EAGER)
	private Direccion mDireccion;
	
	@NotNull
	@Column(name="latitud")
	private double mLatitud;
	
    @NotNull
	@Column(name="longitud")
	private double mLongitud;
	
	public double getLatitud() {
		return mLatitud;
	}
	public void setLatitud(double latitud) {
		mLatitud = latitud;
	}
	public double getLongitud() {
		return mLongitud;
	}
	public void setLongitud(double longitud) {
		mLongitud = longitud;
	}
	
	
	// Constructor
	public Sucursal(String mTelefono, String mEmail, Direccion mDireccion, double mLatitud, double mLongitud) {
		super();
		this.mTelefono = mTelefono;
		this.mEmail = mEmail;
		this.mDireccion = mDireccion;
		this.mLatitud = mLatitud;
		this.mLongitud = mLongitud;
	}

	public Sucursal(){
		super();
	}
	
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
	public String toString() {
		return "Sucursal [mTelefono=" + mTelefono + ", mEmail=" + mEmail
				+ ", mDireccion=" + getDireccion().getCiudad()+""+getDireccion().getProvincia() + ", mLatitud=" + mLatitud
				+ ", mLongitud=" + mLongitud + "]";
	}
}
	

