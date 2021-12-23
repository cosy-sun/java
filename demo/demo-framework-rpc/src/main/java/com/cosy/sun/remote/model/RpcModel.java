package com.cosy.sun.remote.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RpcModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private Object param;
	
}
