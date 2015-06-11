package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Empleado", schema="tpidacs")
public class Empleado extends Usuario{

	/**
	 * 
	 */
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
	@ManyToOne(fetch = FetchType.LAZY)
	private Sucursal mSucursal;
}
