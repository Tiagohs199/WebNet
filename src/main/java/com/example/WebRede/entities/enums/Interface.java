package com.example.WebRede.entities.enums;

public enum Interface {
	
	
	GE(1),
	FGE40G(2),
	XGE10GAFP(3),
	XGEBASET(4);
	
	
	private int code;
	
	private Interface (int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static Interface valueOf(int code) {
		for(Interface value : Interface.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid interface code");
			
	}


}
