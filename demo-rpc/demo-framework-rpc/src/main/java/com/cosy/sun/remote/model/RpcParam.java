package com.cosy.sun.remote.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RpcParam {
	private String methodName;
	private String serverName;
	private Class<?>[] paramTypes;
	private Object[] paramValues;
}