package entidad;

import java.util.Date;

public class Cliente {
	private String mNombre;
	private Date mFecNac;
	private String mTelefono;
	private String mEmail;
	private int mDNI;
	private String mCUIL;
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
	public int getDNI() {
		return mDNI;
	}
	public void setDNI(int dNI) {
		mDNI = dNI;
	}
	public String getCUIL() {
		return mCUIL;
	}
	public void setCUIL(String cUIL) {
		mCUIL = cUIL;
	}
	public Direccion getDireccion() {
		return mDireccion;
	}
	public void setDireccion(Direccion direccion) {
		mDireccion = direccion;
	}
		
}
