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
		
		System.out.println("---��2----------------" );
		//�������2 begin
		String a=new String("a");//����һ���µ��ڴ�ʹ��
		String b="a";
		String c="a";//b��c�ǹ��õ�һ���ڴ�,ֻҪ������Ϣһ������ͬһ���ڴ棬��һ���ͻῪ���µ�
		System.out.println(a==b);
		System.out.println(b==c);//Ϊʲô��true��
		//�������2 end
		//�������ڴ���������
		

		System.out.println("---��3----------------" );
		String str1 = new String("ABC");
		String str2 = new String("ABC");
		System.out.println(str1==str2);
		System.out.println("---��4----------------" );
		String str3 = "ABC";
		String str4 = "ABC";
		String str5 = "A" + "BC";
		System.out.println(str3==str4);
		System.out.println(str4==str5);

		System.out.println("---��5----------------" );
		String aa = "ABC";
		String bb="AB";
		String cc=bb+"C";
		System.out.println(aa==cc);
		/*a��b�����ַ������������ڱ����ھͱ�ȷ���ˣ�
		��c���и�b�����ò����ַ����������Բ����ڱ�����ȷ����
		��String��final�ģ�������b+"c"��ʱ��ʵ�������´�����һ������Ȼ���ڰ��´�����������ô���c.*/
		System.out.println("---��6-----test --/++ -----------" );
		int x=1,y=2,z=3;
		System.out.println(y+=z--/++x );
		System.out.println("---��7-----test --/++ -----------" );
		int xx=2;
		System.out.println((xx++)/3);
		
		System.out.println("---��8-----��ϵ����-----------" );
		int yy=10;
		yy+=yy-=yy-yy;
		System.out.println(yy);
		System.out.println("---��9-----boolean����-----------" );
		Boolean m=true;
		if(m==false)
		System.out.println("False");
		else
		System.out.println("True");
		

	}
}
/*�����Ǿ�̬����
 * ��
 * 
one-2
one-3
Two.i=0
Two.i=0
 */



