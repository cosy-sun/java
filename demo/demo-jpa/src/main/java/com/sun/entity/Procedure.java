package com.sun.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(name = "Procedure.pluslinout",
		procedureName = "pluslinout", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN,name = "arg", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT,name = "res", type = Integer.class)
		})
public class Procedure {
	@Id
	private Integer arg;
	public void setArg(Integer arg) {
		this.arg = arg;
	}
	
	public Integer getArg() {
		return this.arg;
	}
}
