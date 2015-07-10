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
	private double mLatitud;
	
    @NotNull
	@Column(name="longitud")
	private double mLongitud;
	
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="fk_sucursal")
	private Sucursal mSucursal;
	
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
	public Sucursal getSucursal() {
		return mSucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		mSucursal = sucursal;
	}
	
	@Override
	public String toString(){
		if (getId()==null) {
			return null;
		}
		return String.format("%s - %s - %s", getSucursal(),getFecha(),getHora());
	}

}
