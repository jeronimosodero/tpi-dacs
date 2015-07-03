package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Empleado", schema="tpidacs")
@NamedQuery(name="Empleado.findClienteByEmail",query="select u from Empleado u where u.mEmail = :email")
public class Empleado extends Usuario{

	public static final String FIND_BY_EMAIL = "Empleado.findClienteByEmail";
	
	private static final long serialVersionUID = -5896334576051713617L;

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
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Sucursal mSucursal;

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

	public Sucursal getSucursal() {
		return mSucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		mSucursal = sucursal;
	}
	
	public void setRole(){
		mRole = "EMPLOYEE";
	}
}
