package entidad;

import java.util.Date;

public class Viaje {
	private Date mFechaPartida;
	private Date mFechaLlegadaEstimada;
	private Date mFechaLlegada;
	private Estado mEstado;
	public Date getFechaPartida() {
		return mFechaPartida;
	}
	public void setFechaPartida(Date fechaPartida) {
		mFechaPartida = fechaPartida;
	}
	public Date getFechaLlegadaEstimada() {
		return mFechaLlegadaEstimada;
	}
	public void setFechaLlegadaEstimada(Date fechaLlegadaEstimada) {
		mFechaLlegadaEstimada = fechaLlegadaEstimada;
	}
	public Date getFechaLlegada() {
		return mFechaLlegada;
	}
	public void setFechaLlegada(Date fechaLlegada) {
		mFechaLlegada = fechaLlegada;
	}
	public Estado getEstado() {
		return mEstado;
	}
	public void setEstado(Estado estado) {
		mEstado = estado;
	}
	
	
}
