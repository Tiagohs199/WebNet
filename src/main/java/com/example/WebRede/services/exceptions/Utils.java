package com.example.WebRede.services.exceptions;

import java.util.regex.Pattern;

import com.example.WebRede.entities.Equipment;

public class Utils {
	
	private String ipValidateRegex = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	

	public  Boolean ipValidate(Equipment obj) {
	
	return	Pattern.matches(ipValidateRegex, obj.getIp());
		
	}

}
