package model;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public abstract class Usuario extends BaseEntity{

	
	@NotNull
	@Min(1)
    @Max(999999999999999L)
	@Column(name="cuil")
	protected Long mCUIL;
	
	@NotNull
	@Min(1)
    @Max(999999999999999L)
	@Column(name="cuil")
	protected Long mDNI = String.valueOf(this.mCUIL).;
	
	
	@NotNull
	@Min(6)
	@Column(name="pass")
	protected String mPass;
	
}
