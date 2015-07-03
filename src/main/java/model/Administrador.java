package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Administrador",schema="tpidacs")
@NamedQuery(name="Administrador.findAdministradorByEmail",query="select u from Administrador u where u.mEmail = :email")
public class Administrador extends Usuario {

	public static final String FIND_BY_EMAIL = "Administrador.findAdministradorByEmail";
	 
	private static final long serialVersionUID = -3775440016598723771L;

	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp = "[a-z \\s A-Z ñ Ñ á é í ó ú Á É Í Ó Ú]{1,100}", message = "El nombre no puede contener caracteres no válidos")
	@Column(name="nombre")
	private String mNombre;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nac")
	private Date mFechaNac;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ing")
	private Date mFechaIng;

	public String getNombre() {
		return mNombre;
	}

	public void setNombre(String nombre) {
		mNombre = nombre;
	}

	public Date getFechaNac() {
		return mFechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		mFechaNac = fechaNac;
	}

	public Date getFechaIng() {
		return mFechaIng;
	}

	public void setFechaIng(Date fechaIng) {
		mFechaIng = fechaIng;
	}
	
	public void setRole(){
		mRole = "ADMIN";
	}
	
}
