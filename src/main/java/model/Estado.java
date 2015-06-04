package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="Estado",schema="tpidacs")
public class Estado extends BaseEntity{
	
   
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_hora")
	private Date mFecha_Hora;
    
    
    @NotNull
	@Column(name="latitud")
	private float mLatitud;
	
    @NotNull
	@Column(name="longitud")
	private float mLongitud;
	
    @NotNull
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,100}", message = "El nombre no puede contener caracteres no válidos")
	@Column(name="sucursal")
	private Sucursal mSucursal;
	
	
	public Date getFecha_Hora() {
		return mFecha_Hora;
	}
	public void setFecha_Hora(Date fecha_Hora) {
		mFecha_Hora = fecha_Hora;
	}
	public float getLatitud() {
		return mLatitud;
	}
	public void setLatitud(float latitud) {
		mLatitud = latitud;
	}
	public float getLongitud() {
		return mLongitud;
	}
	public void setLongitud(float longitud) {
		mLongitud = longitud;
	}
	public Sucursal getSucursal() {
		return mSucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		mSucursal = sucursal;
	}
	

}
