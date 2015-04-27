package com.other.test;

class One {
	One(String str) {
		System.out.println(str);
	}
}

class Two {
	static int l = 0;
	One one_1 = new One("one-1");
	static One one_2 = new One("one-2");
	static One one_3 = new One("one-3");

	Two(String str) {
		System.out.println(str);
	}
}

public class TestString {
	public static void main(String[] arg) {
		System.out.println("Two.i=" + Two.l);
		System.out.println("Two.i=" + Two.l);
		
		System.out.println("---题2----------------" );
		//另外的题2 begin
		String a=new String("a");//开辟一块新的内存使用
		String b="a";
		String c="a";//b、c是共用的一块内存,只要对象信息一样就是同一块内存，不一样就会开辟新的
		System.out.println(a==b);
		System.out.println(b==c);//为什么是true呢
		//另外的题2 end
		//考的是内存分配的问题
		

		System.out.println("---题3----------------" );
		String str1 = new String("ABC");
		String str2 = new String("ABC");
		System.out.println(str1==str2);
		System.out.println("---题4----------------" );
		String str3 = "ABC";
		String str4 = "ABC";
		String str5 = "A" + "BC";
		System.out.println(str3==str4);
		System.out.println(str4==str5);

		System.out.println("---题5----------------" );
		String aa = "ABC";
		String bb="AB";
		String cc=bb+"C";
		System.out.println(aa==cc);
		/*a和b都是字符串常量所以在编译期就被确定了！
		而c中有个b是引用不是字符串常量所以不会在编译期确定。
		而String是final的！所以在b+"c"的时候实际上是新创建了一个对象，然后在把新创建对象的引用传给c.*/
		System.out.println("---题6-----test --/++ -----------" );
		int x=1,y=2,z=3;
		System.out.println(y+=z--/++x );
		System.out.println("---题7-----test --/++ -----------" );
		int xx=2;
		System.out.println((xx++)/3);
		
		System.out.println("---题8-----关系运算-----------" );
		int yy=10;
		yy+=yy-=yy-yy;
		System.out.println(yy);
		System.out.println("---题9-----boolean运算-----------" );
		Boolean m=true;
		if(m==false)
		System.out.println("False");
		else
		System.out.println("True");
		

	}
}
/*考的是静态方法
 * 答案
 * 
one-2
one-3
Two.i=0
Two.i=0
 */



