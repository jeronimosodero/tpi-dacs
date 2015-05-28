package entidad;

import java.util.List;

public class Paquete extends BaseEntity{

	private String mContenido;
	private int mTamaño;
	private float mPeso;
	private List<Estado> mEstado;
	
	public String getContenido() {
		return mContenido;
	}
	public void setContenido(String contenido) {
		mContenido = contenido;
	}
	public int getTamaño() {
		return mTamaño;
	}
	public void setTamaño(int tamaño) {
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
