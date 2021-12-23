package com.sun.entity;

import java.io.Serializable;

public class ExamplesKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mingzi;
	private String dianhua;
	
	public ExamplesKey() {
		
	}
	
	public ExamplesKey(String mingzi, String dianhua) {
		this.mingzi = mingzi;
		this.dianhua = dianhua;
	}

	public String getmingzi() {
		return mingzi;
	}

	public void setmingzi(String mingzi) {
		this.mingzi = mingzi;
	}

	public String getdianhua() {
		return dianhua;
	}

	public void setdianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mingzi == null) ? 0 : mingzi.hashCode());
		result = prime * result + ((dianhua == null) ? 0 : dianhua.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamplesKey other = (ExamplesKey) obj;
		if (mingzi == null) {
			if (other.mingzi != null)
				return false;
		} else if (!mingzi.equals(other.mingzi))
			return false;
		if (dianhua == null) {
			if (other.dianhua != null)
				return false;
		} else if (!dianhua.equals(other.dianhua))
			return false;
		return true;
	}
	
	

}
