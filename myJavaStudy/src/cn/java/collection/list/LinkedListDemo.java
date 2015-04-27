package cn.java.collection.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
	/*
	LinkedList�е�һЩ������JDK1.6�Ժ����������

	addFirst();
	addLast();
	JDK1.6:
	offerFirst();
	offerLast();

	getFirst();���������û��Ԫ�أ���ȡ�����쳣��NoSuchElementException
	getLast();
	JDK1.6:
	peekFirst();���������û��Ԫ�أ��򷵻�null��
	peekLast();

	removeFirst();���������û��Ԫ�أ���ȡ�����쳣��NoSuchElementException
	removeLast();
	JDK1.6:
	pollFirst();���������û��Ԫ�أ��򷵻�null��
	pollLast();
	*/

		public static void sop(Object obj)
		{
			System.out.println(obj);
		}
		public static void main(String[] args) 
		{
			LinkedList<String> link = new LinkedList<String>();
			
//			System.out.println("heihei����"+link.getFirst());//���������û��Ԫ�أ���ȡ�����쳣��NoSuchElementException
			System.out.println("heihei����"+link.peekFirst());//jdk1.6�Ժ�ķ��������������û��Ԫ�أ�����null
//			System.out.println("heihei����"+link.removeLast());//���������û��Ԫ�أ���ȡ�����쳣��NoSuchElementException
			System.out.println("heihei����"+link.pollLast());//jdk1.6�Ժ�ķ��������������û��Ԫ�أ�����null
			
			//��������з��������.
			link.addFirst("abc1");
			link.addFirst("abc2");
			link.addFirst("abc3");
			link.addFirst("abc4");
			//link.addLast("abc5");
			
			for(int x=0; x<link.size();x++)
			{
				System.out.println("get��"+link.get(x));
			}
			
		/*	for(int x=0; x<link.size();)
			{
				System.out.println("x="+x+"...size="+link.size());
				System.out.println(link.removeFirst());
			}*/
			printColl(link);//����Ҳ���Խ�Linkedlist��Ϊһ���������ݸ�����Collection,Ȼ����Collection�Ļ�ȡ���������ʹ���˵�����������ͬʱʹ��collection���������,�޸�,ɾ��
			
			while(!link.isEmpty())
			{
				System.out.println("remove:"+link.removeFirst());
			}

			System.out.println("----------------------");
			link.add("weiba");
			link.clear();
			System.out.println(link);//��ӡ����Ϊһ���յ�����:[]
			
			
/*			sop("getFirst:"+link.getFirst());//��ȡԪ�أ����Ȳ��ı䡣���������û��Ԫ�أ���ȡ�����쳣��NoSuchElementException
			sop("getLast:"+link.getLast());
			sop("get size="+link.size());
			sop("removeFirst:"+link.removeFirst());//��ȡԪ�أ�����Ԫ�ر�ɾ�������Ȼ�ı䡣���������û��Ԫ�أ���ȡ�����쳣��NoSuchElementException
			sop("removeLast:"+link.removeLast());
			sop("remove size="+link.size());*/

		}

		public static void printColl(Collection<String> coll)
		{
			Iterator<String> it = coll.iterator();

			while(it.hasNext())
			{
				//�˴����ܵ���coll.remove(it.next());����ᱨjava.util.ConcurrentModificationException
				System.out.println("haha"+it.next());
			}
		
		}
	}



