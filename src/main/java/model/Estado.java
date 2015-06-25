package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


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
    
    
    public Paquete getPaquete() {
		return paquete;
	}
	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
	@NotNull
	@Column(name="latitud")
	private float mLatitud;
	
    @NotNull
	@Column(name="longitud")
	private float mLongitud;
	
    @NotNull
	private Sucursal mSucursal;
    
    @ManyToOne
    @JoinColumn(name="fk_paquete")
    private Paquete paquete;
	
	
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
