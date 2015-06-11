package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Administrador extends Usuario {

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
}
