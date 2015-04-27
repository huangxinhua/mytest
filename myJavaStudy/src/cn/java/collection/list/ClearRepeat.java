package cn.java.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ClearRepeat {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("efg");
		list.add("ghi");
		list.add("ghi");
		list.add("gho");
		list.add("efg");
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			System.out.println(list.lastIndexOf(list.get(i)));
			int j = list.lastIndexOf(list.get(i));//lastIndexOf 方法返回一个整数值，指出 String 对象内子字符串的开始位置
			if (i != j) {
				list.remove(j);
				i--;// 每次有重复都让i回到初始位置，i==j时才可以向下循环
			}
		}
		System.out.println(list);
	}
}
