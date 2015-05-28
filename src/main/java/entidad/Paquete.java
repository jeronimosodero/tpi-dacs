package entidad;

public class Paquete {

	private String mContenido;
	private int mTamaño;
	private float mPeso;
	private Estado mEstado;
	
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
	public Estado getEstado() {
		return mEstado;
	}
	public void setEstado(Estado estado) {
		mEstado = estado;
	}
	
	
}
