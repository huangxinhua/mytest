package com.jsoup.test;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/***
 * 使用Jsoup去解析查询手机号归属地
 * 原理：抓取再解析html...
 * @author ljl
 *
 */
public class Test2 {

	/**
	 * 正则表达式,抽取手机归属地
	 */
	public static final String REGEX_GET_MOBILE = "(?is)(<tr[^>]+>[\\s]*<td[^>]+>[\\s]*卡号归属地[\\s]*</td>[\\s]*<td[^>]+>([^<]+)</td>[\\s]*</tr>)"; // 2:from
	/**
	 * 正则表达式,审核要获取手机归属地的手机是否符合格式,可以只输入手机号码前7位
	 */
	public static final String REGEX_IS_MOBILE = "(?is)(^1[3|4|5|8][0-9]\\d{4,8}$)";

	/**
	 * 从www.ip138.com
	 * 返回的结果网页内容中获取手机号码归属地,结果为：省份 城市
	 * @param htmlSource
	 * @return
	 */
	public static String parseMobileFrom(String htmlSource){
		Pattern p=null;
		Matcher m=null;
		String result=null;
		p=Pattern.compile(REGEX_GET_MOBILE);
		m=p.matcher(htmlSource);
		
		while(m.find()){
			if(m.start(2)>0){
				result=m.group(2);
				result=result.replaceAll("&nbsp;", " ");
			}
		}
		return result;
	}
	
	/**
	 * 验证手机号
	 * @param mobileNumber
	 * @return
	 */
	public static boolean veriyMobile(String mobileNumber){
		Pattern p=null;
		Matcher m=null;
		p=Pattern.compile(REGEX_IS_MOBILE);
		m=p.matcher(mobileNumber);
		return m.matches();
	}
	public static void main(String[] args) throws Exception {
		String mobile="18640209363";
		getNetFormMobileInfo(mobile);

	}

	private static void getNetFormMobileInfo(String mobileNumber) throws IOException, HttpException {
		if(!veriyMobile(mobileNumber)){
			try {
				throw new Exception("不是完整的11位手机号或者正确的手机号前七位");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		StringBuffer buffer = new StringBuffer();
		String url = "http://www.ip138.com";
		buffer.append(url);
		buffer.append(":8080");//端口
		buffer.append("/");
		buffer.append("search.asp?");
		buffer.append("mobile=" + mobileNumber);
		buffer.append("&action=mobile");
		 
		String basePath = buffer.toString();
		 
		Document doc=Jsoup.parse(new URL(basePath), 3000); 
		if(doc!=null){
			//从class=tdc样式下面抓取  
			 Elements tdcs = doc.getElementsByAttributeValue("class", "tdc");  
		        for(Element td:tdcs){  
		        	//从class=tdc2样式下面抓取  
		        	Elements tdc2s=td.getElementsByAttributeValue("class","tdc2");
		        	 for(Element tdc:tdc2s){
		        		 //System.out.println(tdc);
		        		 //<[^>]+>去掉html标签,去掉&nbsp;html标签的空格
		        		 String mobileInfo=tdc.select("td").html().replaceAll("<[^>]+>", "").replaceAll("&nbsp;", "").replaceAll("-->", "");
		        		 System.out.println(mobileInfo);
		        	 }
		        }  
		}else{
			System.err.println("网络异常~~");
		}
	}
}

