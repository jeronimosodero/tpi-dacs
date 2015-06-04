package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Cliente",schema="tpidacs")
public class Cliente extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp = "[a-z \\s A-Z ñ Ñ á é í ó ú Á É Í Ó Ú]{1,100}", message = "El nombre no puede contener caracteres no válidos")
	@Column(name="nombre")
	private String mNombre;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nac")
	private Date mFecNac;
	
	@NotNull
	@Column(name="telefono")
	private String mTelefono;
	
	@NotNull
	@Pattern(regexp = PATTERN_EMAIL, message = "Email invalido")
	@Column(name="email")
	private String mEmail;
	
	@Min(1)
    @Max(999999999999999L)
	@Column(name="dni")
	private Long mDNI;
	
	@NotNull
	@Min(1)
    @Max(999999999999999L)
	@Column(name="cuil")
	private Long mCUIL;
	
	@NotNull
	@Column(name="direccion")
	private Direccion mDireccion;
	
	public String getNombre() {
		return mNombre;
	}
	public void setNombre(String nombre) {
		mNombre = nombre;
	}
	public Date getFecNac() {
		return mFecNac;
	}
	public void setFecNac(Date fecNac) {
		mFecNac = fecNac;
	}
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
	public Long getDNI() {
		return mDNI;
	}
	public void setDNI(Long dNI) {
		mDNI = dNI;
	}
	public Long getCUIL() {
		return mCUIL;
	}
	public void setCUIL(Long cUIL) {
		mCUIL = cUIL;
	}
	public Direccion getDireccion() {
		return mDireccion;
	}
	public void setDireccion(Direccion direccion) {
		mDireccion = direccion;
	}
		
}
