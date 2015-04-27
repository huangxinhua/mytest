package cn.java.collection.list;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
/*
	 Enumeration 此接口的功能与 Iterator 接口的功能是重复的
	Iterator将Enumeration给替代了，
	原因：Enumeration接口的方法名称过长。所以郁郁而终。
*/
public class VectorDemoAndEnumeration {
	public static void main(String[] args) {
			
		Vector v = new Vector();
		v.addElement("abc1");
		v.addElement("abc2");
		v.addElement("abc3");
		v.addElement("abc4");
		
		for (int i = 0; i < v.size(); i++) {
			System.out.println("通用获取方式："+v.get(i));
		}
		
		//第二种取出方式
		Enumeration en = v.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
		
		System.out.println("----------------");
		//第三种取出方式
		Iterator it = v.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
//此类执行结果为：

/*	通用获取方式：abc1
	通用获取方式：abc2
	通用获取方式：abc3
	通用获取方式：abc4
	abc1
	abc2
	abc3
	abc4
	----------------
	abc1
	abc2
	abc3
	abc4*/
