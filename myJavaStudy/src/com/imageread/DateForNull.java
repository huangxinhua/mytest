package com.imageread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateForNull {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date date;

		date= new Date();
		System.out.println(date);
		date=null;
		System.out.println(date);
	


	}
}
