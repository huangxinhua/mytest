package com.timer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class GetTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		System.out.println("date:"+date);
		String zidingyidate = "2014-9-14 21:35:09";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//String aa=df.format(date);
		try {
		Date date2 =df.parse(zidingyidate);
			//System.out.println(df.parse(source)(aa));
			if (date2.after(date)) {
				System.out.println("这个时间段可以执行操作");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
