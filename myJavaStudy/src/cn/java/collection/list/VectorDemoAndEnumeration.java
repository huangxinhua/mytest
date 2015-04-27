package cn.java.collection.list;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
/*
	 Enumeration �˽ӿڵĹ����� Iterator �ӿڵĹ������ظ���
	Iterator��Enumeration������ˣ�
	ԭ��Enumeration�ӿڵķ������ƹ����������������ա�
*/
public class VectorDemoAndEnumeration {
	public static void main(String[] args) {
			
		Vector v = new Vector();
		v.addElement("abc1");
		v.addElement("abc2");
		v.addElement("abc3");
		v.addElement("abc4");
		
		for (int i = 0; i < v.size(); i++) {
			System.out.println("ͨ�û�ȡ��ʽ��"+v.get(i));
		}
		
		//�ڶ���ȡ����ʽ
		Enumeration en = v.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
		
		System.out.println("----------------");
		//������ȡ����ʽ
		Iterator it = v.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
//����ִ�н��Ϊ��

/*	ͨ�û�ȡ��ʽ��abc1
	ͨ�û�ȡ��ʽ��abc2
	ͨ�û�ȡ��ʽ��abc3
	ͨ�û�ȡ��ʽ��abc4
	abc1
	abc2
	abc3
	abc4
	----------------
	abc1
	abc2
	abc3
	abc4*/
