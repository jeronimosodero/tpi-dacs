package model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import cosas.Cifrador;

@MappedSuperclass
public abstract class Usuario extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	
	@NotNull
	@Pattern(regexp = PATTERN_EMAIL, message = "Email invalido")
	@Column(name="email", unique = true)
	private String mEmail;	
	
	@NotNull
	@Min(1)
	@Max(999999999999999L)
	@Column(name = "cuil", unique = true)
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
	
	@NotNull
	@Column(name= "role")
	protected String mRole;

	public Long getCUIL() {
		return mCUIL;
	}

	public void setCUIL(Long mCUIL) {
		this.mCUIL = mCUIL;
	}

	public String getPass() {
		return mPass;
	}

	public void setPass() {
		Cifrador c = new Cifrador();
		mPass = c.cifrar(getCUIL());
	}

	public Long getDNI() {
		return mDNI;
	}

	public void setDNI() {
		String s = String.valueOf(mCUIL);
		mDNI = Long.decode(s.substring(2, 10));
	}

	public String getRole() {
		return mRole;
	}

	public String getEmail() {
		return mEmail;
	}
	public void setEmail(String email) {
		mEmail = email;
	}
	
}
