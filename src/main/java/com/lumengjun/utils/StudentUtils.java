package com.lumengjun.utils;

public class StudentUtils {

	public static boolean isIdNumber(String idNumber){
		String msg="^\\d{17}[x|X|0-9]$";
		return idNumber.matches(msg);
	}
	
}
