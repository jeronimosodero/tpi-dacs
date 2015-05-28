package entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Estado",schema="tpidacs")
public class Estado extends BaseEntity{
	
	private Date mFecha_Hora;
	private float mLatitud;
	private float mLongitud;
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
