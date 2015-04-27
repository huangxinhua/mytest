package cn.java.collection.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
	/*
	LinkedList中的一些方法在JDK1.6以后有了替代。

	addFirst();
	addLast();
	JDK1.6:
	offerFirst();
	offerLast();

	getFirst();如果链表中没有元素，获取出现异常。NoSuchElementException
	getLast();
	JDK1.6:
	peekFirst();如果链表中没有元素，则返回null。
	peekLast();

	removeFirst();如果链表中没有元素，获取出现异常。NoSuchElementException
	removeLast();
	JDK1.6:
	pollFirst();如果链表中没有元素，则返回null。
	pollLast();
	*/

		public static void sop(Object obj)
		{
			System.out.println(obj);
		}
		public static void main(String[] args) 
		{
			LinkedList<String> link = new LinkedList<String>();
			
//			System.out.println("heihei……"+link.getFirst());//如果链表中没有元素，获取出现异常。NoSuchElementException
			System.out.println("heihei……"+link.peekFirst());//jdk1.6以后的方法，如果链表中没有元素，返回null
//			System.out.println("heihei……"+link.removeLast());//如果链表中没有元素，获取出现异常。NoSuchElementException
			System.out.println("heihei……"+link.pollLast());//jdk1.6以后的方法，如果链表中没有元素，返回null
			
			//链表的特有方法。添加.
			link.addFirst("abc1");
			link.addFirst("abc2");
			link.addFirst("abc3");
			link.addFirst("abc4");
			//link.addLast("abc5");
			
			for(int x=0; x<link.size();x++)
			{
				System.out.println("get："+link.get(x));
			}
			
		/*	for(int x=0; x<link.size();)
			{
				System.out.println("x="+x+"...size="+link.size());
				System.out.println(link.removeFirst());
			}*/
			printColl(link);//这里也可以将Linkedlist作为一个参数传递给超类Collection,然后用Collection的获取方法，如果使用了迭代器，则不能同时使用collection本身的增加,修改,删除
			
			while(!link.isEmpty())
			{
				System.out.println("remove:"+link.removeFirst());
			}

			System.out.println("----------------------");
			link.add("weiba");
			link.clear();
			System.out.println(link);//打印出来为一个空的数组:[]
			
			
/*			sop("getFirst:"+link.getFirst());//获取元素，长度不改变。如果链表中没有元素，获取出现异常。NoSuchElementException
			sop("getLast:"+link.getLast());
			sop("get size="+link.size());
			sop("removeFirst:"+link.removeFirst());//获取元素，但是元素被删除，长度会改变。如果链表中没有元素，获取出现异常。NoSuchElementException
			sop("removeLast:"+link.removeLast());
			sop("remove size="+link.size());*/

		}

		public static void printColl(Collection<String> coll)
		{
			Iterator<String> it = coll.iterator();

			while(it.hasNext())
			{
				//此处不能调用coll.remove(it.next());否则会报java.util.ConcurrentModificationException
				System.out.println("haha"+it.next());
			}
		
		}
	}



