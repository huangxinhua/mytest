package cn.java.collection.list;

import java.util.ArrayList;
import java.util.List;

public class SplitArray {
	public static void main(String[] args) {
		String aString="a,n,g";
		String jiexi=aString+" ";//如果最后一个数值是空值会报掉，加一个空格以防报异常
		String a=(String)jiexi.split(",")[0];
		String b=(String)jiexi.split(",")[1];
		String c=(String)jiexi.split(",")[2];
		
		if (jiexi.split(",").length>0) {
			System.out.println("确实大于0");
		}
		if (jiexi.split(",").length==3) {
			System.out.println("3");
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
		
	}
	
	/**
	 * 把数组中的值组织成要返回的格式字符串
	 * @param value  值数组
	 * @param row    这个代表读取哪行 把一行转化 值,值,值 这样的字符串 返回
	 * @param colum  每行的字段个数
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
				temp.append(value[row][i]==null?"0":value[row][i]);//这里要根据vas默认值来设 为空时存什么 也许是存0
			}
		}
		return temp.toString();
	}
}
