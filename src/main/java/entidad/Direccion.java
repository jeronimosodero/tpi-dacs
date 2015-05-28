package entidad;

public class Direccion extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mCalle;
	private int mAltura;
	private int mPiso;
	private String mCiudad;
	private String mProvincia;
	private String mPais;
	
	public String getCalle() {
		return mCalle;
	}
	public void setCalle(String calle) {
		mCalle = calle;
	}
	public int getAltura() {
		return mAltura;
	}
	public void setAltura(int altura) {
		mAltura = altura;
	}
	public int getPiso() {
		return mPiso;
	}
	public void setPiso(int piso) {
		mPiso = piso;
	}
	public String getCiudad() {
		return mCiudad;
	}
	public void setCiudad(String ciudad) {
		mCiudad = ciudad;
	}
	public String getProvincia() {
		return mProvincia;
	}
	public void setProvincia(String provincia) {
		mProvincia = provincia;
	}
	public String getPais() {
		return mPais;
	}
	public void setPais(String pais) {
		mPais = pais;
	}

	}