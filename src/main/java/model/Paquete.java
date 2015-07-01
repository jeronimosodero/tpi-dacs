package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Paquete",schema="tpidacs")
public class Paquete extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(name="contenido")
	private String mContenido;
	
	@NotNull
	@Min(1)
    @Max(9999)
	@Column(name="tamaño")
	private float mTamaño;
	
	@NotNull
	@Min(1)
    @Max(9999)
	@Column(name="peso")
	private float mPeso;
	
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Estado> mEstado;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_orden")
	private Orden orden;
	
	public String getContenido() {
		return mContenido;
	}
	public void setContenido(String contenido) {
		mContenido = contenido;
	}
	public float getTamaño() {
		return mTamaño;
	}
	public void setTamaño(float tamaño) {
		mTamaño = tamaño;
	}
	public float getPeso() {
		return mPeso;
	}
	public void setPeso(float peso) {
		mPeso = peso;
	}
	
	public List<Estado> getEstado() {
		return mEstado;
	}
	public void setEstado(List<Estado> estado) {
		mEstado = estado;
	}
	

	
	
}
