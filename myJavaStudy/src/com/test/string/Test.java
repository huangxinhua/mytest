package com.test.string;

import java.io.IOException;

/**
 * HUANGXINHUA
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a,b,c,d;
		a="1";
		b=null;
		c=null;
		d=null;
		if (a!=null||b!=null||c!=null||d!=null) {
			System.out.println("a null");
		}
		if (b!=null||c!=null||d!=null) {
			System.out.println("a not null");
		}
	}

}
