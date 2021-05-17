package com.example.WebRede.entities.enums;

public enum Type {
	
	ACESSO(1),
	HYBRID(2),
	TRUNK(3),
	IRFLOOP(4);
	
	
	private int code;
	
	private Type (int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static Type valueOf(int code) {
		for(Type value : Type.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid type code");
			
	}

}
