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
			int j = list.lastIndexOf(list.get(i));//lastIndexOf ��������һ������ֵ��ָ�� String ���������ַ����Ŀ�ʼλ��
			if (i != j) {
				list.remove(j);
				i--;// ÿ�����ظ�����i�ص���ʼλ�ã�i==jʱ�ſ�������ѭ��
			}
		}
		System.out.println(list);
	}
}
