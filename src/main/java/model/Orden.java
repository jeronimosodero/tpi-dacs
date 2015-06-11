package model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@Entity
@Table(name="Orden",schema="tpidacs")
public class Orden extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
	private Date mFecha;
	
	@NotNull
	@Column(name="monto")
	private Float mMonto;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name="servicio")
	private Servicio servicio;
	
	@NotNull
	@Pattern(regexp = "Si|No")
	@Column(name="pagado")
	private String mPagado;
	
	@OneToMany(mappedBy="orden", fetch=FetchType.LAZY)
	private List<Paquete> mPaquetes;
	
	@ManyToOne
	@JoinColumn(name="destino_fk")
	private Sucursal mDestino;
	
	@ManyToOne
	@JoinColumn(name="origen_fk")
	private Sucursal mOrigen;
	
	
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
	public String getmPagado() {
		return mPagado;
	}
	public void setmPagado(String mPagado) {
		this.mPagado = mPagado;
	}
	
	
	
	public List<Paquete> getPaquetes() {
		return mPaquetes;
	}
	public void setPaquetes(List<Paquete> paquetes) {
		mPaquetes = paquetes;
	}
}
