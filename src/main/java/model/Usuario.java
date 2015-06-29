package model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cosas.Cifrador;

@MappedSuperclass
public abstract class Usuario extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@NotNull
	@Min(1)
	@Max(999999999999999L)
	@Column(name = "cuil")
	protected Long mCUIL;

	@NotNull
	@Min(1)
	@Max(999999999999999L)
	@Column(name = "dni")
	protected Long mDNI;

	@NotNull
	@Size(min = 6, max = 20)
	@Column(name = "pass")
	protected String mPass;

	public Long getmCUIL() {
		return mCUIL;
	}

	public void setmCUIL(Long mCUIL) {
		this.mCUIL = mCUIL;
	}

	public String getPass() {
		return mPass;
	}

	public void setPass() {
		Cifrador c = new Cifrador();
		mPass = c.cifrar(getmCUIL());
	}

	public Long getDNI() {
		return mDNI;
	}

	public void setDNI() {
		String s = String.valueOf(mCUIL);
		mDNI = Long.decode(s.substring(2, 10));
	}

}
