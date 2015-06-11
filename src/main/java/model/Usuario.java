package model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import cosas.Cifrador;

@MappedSuperclass
public abstract class Usuario extends BaseEntity{

	
	@NotNull
	@Min(1)
    @Max(999999999999999L)
	@Column(name="cuil")
	protected Long mCUIL;
	
	/*@NotNull
	@Min(1)
    @Max(999999999999999L)
	@Column(name="dni")
	protected Long mDNI = Long.valueOf(String.valueOf(this.mCUIL).substring(2, 10));*/
	
	
	@NotNull
	@Min(6)
	@Column(name="pass")
	protected String mPass;

	
	
	public Long getmCUIL() {
		return mCUIL;
	}


	public void setmCUIL(Long mCUIL) {
		this.mCUIL = mCUIL;
	}


	public String getmPass() {
		return mPass;
	}


	public void setmPass(String mPass) {
		Cifrador c = new Cifrador();
		String pass = c.cifrar(getmCUIL());
		this.mPass = pass;
	}
	
	
	
}
