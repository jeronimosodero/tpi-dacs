package model;

@Entity
@Table(name="Orden",schema="tpidacs")
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;




public class Orden extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date mFecha;
	private Float mMonto;
	private boolean mPagado;
	private List<Paquete> mPaquetes;
	
	public Date getFecha() {
		return mFecha;
	}
	public void setFecha(Date fecha) {
		mFecha = fecha;
	}
	public Float getMonto() {
		return mMonto;
	}
	public void setMonto(Float monto) {
		mMonto = monto;
	}
	public boolean isPagado() {
		return mPagado;
	}
	public void setPagado(boolean pagado) {
		mPagado = pagado;
	}
	public List<Paquete> getPaquetes() {
		return mPaquetes;
	}
	public void setPaquetes(List<Paquete> paquetes) {
		mPaquetes = paquetes;
	}
}
