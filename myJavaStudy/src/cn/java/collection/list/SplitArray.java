package cn.java.collection.list;

import java.util.ArrayList;
import java.util.List;

public class SplitArray {
	public static void main(String[] args) {
		String aString="a,n,g";
		String jiexi=aString+" ";//������һ����ֵ�ǿ�ֵ�ᱨ������һ���ո��Է����쳣
		String a=(String)jiexi.split(",")[0];
		String b=(String)jiexi.split(",")[1];
		String c=(String)jiexi.split(",")[2];
		
		if (jiexi.split(",").length>0) {
			System.out.println("ȷʵ����0");
		}
		if (jiexi.split(",").length==3) {
			System.out.println("3");
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
		
	}
	
	/**
	 * �������е�ֵ��֯��Ҫ���صĸ�ʽ�ַ���
	 * @param value  ֵ����
	 * @param row    ��������ȡ���� ��һ��ת�� ֵ,ֵ,ֵ �������ַ��� ����
	 * @param colum  ÿ�е��ֶθ���
	 * @return
	 */
	public static String arrayToString(String[][] value,int row,int colum)
	{
		StringBuffer temp = new StringBuffer();
		if(value[row]!=null)
		{
			for(int i=0;i<colum;i++)
			{				
				if(i>0)
				{
					temp.append(",");
				}
				temp.append(value[row][i]==null?"0":value[row][i]);//����Ҫ����vasĬ��ֵ���� Ϊ��ʱ��ʲô Ҳ���Ǵ�0
			}
		}
		return temp.toString();
	}
}
