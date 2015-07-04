package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Estado",schema="tpidacs")
public class Estado extends BaseEntity{

	private static final long serialVersionUID = 1L;


	@NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
	private Date mFecha;
	
	@NotNull
	@Temporal(TemporalType.TIME)
	@Column(name="hora")
	private Date mHora;
	
    
	public Date getFecha() {
		return mFecha;
	}
	public void setFecha(Date fecha) {
		mFecha = fecha;
	}
	public Date getHora() {
		return mHora;
	}
	public void setHora(Date hora) {
		mHora = hora;
	}
	@NotNull
	@Column(name="latitud")
	private float mLatitud;
	
    @NotNull
	@Column(name="longitud")
	private float mLongitud;
	
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="fk_sucursal")
	private Sucursal mSucursal;
	
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
