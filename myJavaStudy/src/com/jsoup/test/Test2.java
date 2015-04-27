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
 * ʹ��Jsoupȥ������ѯ�ֻ��Ź�����
 * ԭ��ץȡ�ٽ���html...
 * @author ljl
 *
 */
public class Test2 {

	/**
	 * ������ʽ,��ȡ�ֻ�������
	 */
	public static final String REGEX_GET_MOBILE = "(?is)(<tr[^>]+>[\\s]*<td[^>]+>[\\s]*���Ź�����[\\s]*</td>[\\s]*<td[^>]+>([^<]+)</td>[\\s]*</tr>)"; // 2:from
	/**
	 * ������ʽ,���Ҫ��ȡ�ֻ������ص��ֻ��Ƿ���ϸ�ʽ,����ֻ�����ֻ�����ǰ7λ
	 */
	public static final String REGEX_IS_MOBILE = "(?is)(^1[3|4|5|8][0-9]\\d{4,8}$)";

	/**
	 * ��www.ip138.com
	 * ���صĽ����ҳ�����л�ȡ�ֻ����������,���Ϊ��ʡ�� ����
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
	 * ��֤�ֻ���
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
				throw new Exception("����������11λ�ֻ��Ż�����ȷ���ֻ���ǰ��λ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		StringBuffer buffer = new StringBuffer();
		String url = "http://www.ip138.com";
		buffer.append(url);
		buffer.append(":8080");//�˿�
		buffer.append("/");
		buffer.append("search.asp?");
		buffer.append("mobile=" + mobileNumber);
		buffer.append("&action=mobile");
		 
		String basePath = buffer.toString();
		 
		Document doc=Jsoup.parse(new URL(basePath), 3000); 
		if(doc!=null){
			//��class=tdc��ʽ����ץȡ  
			 Elements tdcs = doc.getElementsByAttributeValue("class", "tdc");  
		        for(Element td:tdcs){  
		        	//��class=tdc2��ʽ����ץȡ  
		        	Elements tdc2s=td.getElementsByAttributeValue("class","tdc2");
		        	 for(Element tdc:tdc2s){
		        		 //System.out.println(tdc);
		        		 //<[^>]+>ȥ��html��ǩ,ȥ��&nbsp;html��ǩ�Ŀո�
		        		 String mobileInfo=tdc.select("td").html().replaceAll("<[^>]+>", "").replaceAll("&nbsp;", "").replaceAll("-->", "");
		        		 System.out.println(mobileInfo);
		        	 }
		        }  
		}else{
			System.err.println("�����쳣~~");
		}
	}
}

