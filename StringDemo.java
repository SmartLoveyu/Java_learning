//开始接触用包来储存文件。
package work.string.demo;

public class StringDemo
{

	public static void main(String[] args)
	{
		stringDemo2();
		//String类的特点：
		//字符串对象一旦被初始化就不会被改变。
		stringDemo1();

	}

	public static void stringDemo2()
	{
		String s = "abc";
		//创建一个字符串对象在常量池中。
		String s1 = new String("abc");
		//这是在创建两个对象，一个new，一个字符串对象，放在堆内存中。
		System.out.println(s==s1);//false，s和s1是两个对象，比较的是地址，不一样。

		System.out.println(s.equals(s1));
		//equals()在比较字符串的内容。
		//原理：string类里的equals覆写了object类里的equals，建立了string类中自己的判断字符串对象是否相同的依据。

		System.out.println("s="+s);
		System.out.println("s1="+s1);

	}

	/**
	字符串常量池的特点：池中没有就建立，池中有就直接用
	*/

	private static void stringDemo1()
	{
		String s = "abc";
		s = "jdk";//s被覆写。
		String s1 = "abc";
		System.out.println(s==s1);//false
		System.out.println("s="+s);
	}

}

