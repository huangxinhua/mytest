package com.sql;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.drew.metadata.Tag;

public class SqlString {

	public static void main(String args[])throws IOException{
		Properties pro=new Properties();
		pro.load(SqlString.class.getResourceAsStream("sql.properties"));
		String str=pro.getProperty("str");
		String param=pro.getProperty("value");
		String split[]=param.split(",");
		
		for (int i = 0; i < split.length; i++) {
			String value=split[i];
			StringBuilder targetValue=new StringBuilder(value);
			if (value.contains("(String)")) {
				targetValue.delete(value.indexOf("(String)"), value.length());
				targetValue.insert(0, "'").insert(targetValue.length(), "'");
			}else if (value.contains("(Double)")) {
				targetValue.delete(value.indexOf("(Double)"), value.length());
			}else if (value.contains("(Long)")) {
				targetValue.delete(value.indexOf("(Long)"), value.length());
			}
			str=str.replaceFirst("\\?", targetValue.toString());
		}
		pro.put("out", str);
		System.out.println(str);
		java.io.OutputStream outputStream=new FileOutputStream(new File("sql.properties"));
		pro.store(outputStream, "");
	}
}
