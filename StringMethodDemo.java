package work.string.demo;

/*
按照面向对象的思想对字符串进行功能分类。

1、获取：
1.1 获取字符串中字符的长度（个数）
	int length();
1.2 根据位置获取字符。
	char charAt(int index);
1.3 根据 字符 获取在字符中的第一次出现的位置。
	int indexOf(inr ch)
	int indexOf(int ch,int fromIndex):fromIndex从指定位置来时查找第一次出现的位置。
	int indexOf(String str);
	int indexOf(String str,int fromIndex);

	根据 字符串 获取字符串中的第一次出现的位置。
	int lastIndexOf(int ch)
	int lastIndexOf(int ch,int fromIndex):fromIndex从指定位置开始。
	int lastIndexOf(String str);
	int lastIndexOf(String str,int fromIndex);
1.4 获取字符串中的 一部分字符串。也就做子串。
	String substring(int beginIndex, int endIndex)
	//包括begin，不包括end。
	String substring(int beginIndex);

2、转换：
2.1 将 字符串 变成 字符串数组（也就是，字符串的切割）
	String[] split(String regex):涉及到 正则表达式。 后面会学到！！
2.2 将 字符串 变成 字符数组。
	char[] toCharArray();
2.3 将 字符串 变成 字节数组。
	byte[] getBytes();
2.4 将 字符串 中的字母转换成大小写。
	String toUppeCase():大写
	String toLowerCase():小写
2.5 将 字符串 中的内容进行替换。
	String replace(char oldch,char newch);
	String replace(String s1,String s2);
2.6 将 字符串 两端的空格去除。//这里需要试验一下运行效果。
	String trim();
2.7 将字符串进行连接。
	String concat(String);

3、判断
3.1 两个 字符串 内容是否相同？
	boolean equals(Object obj);
	boolean equalsIgnoreCase(string str);//忽略大写，比较字符串内容。
3.2 字符串 中是否包含指定字符串？
	boolean contains(string str);
3.3 字符串 是否以指定 字符串开头，是否以指定 字符串 结尾？

4、比较

*/

public class StringMethodDemo
{
	public static void main(String[] args)
	{
	
		//stringMethodDemo_1();
		//stringMethodDemo_2();
		//stringMethodDemo_3();
		stringMethodDemo_4();
	}

	private static void stringMethodDemo_1()
	{
		String s = "smartyu";

		System.out.println("length:"+s.length());
		System.out.println("char:"+s.charAt(2));
		//获取该位置的字符。
		System.out.println("index:"+s.indexOf('k'));
		//可以根据-1，来判断字符或者字符串是否存在。
		System.out.println("lastIndex:"+s.lastIndexOf('m'));
		//字符串获取字符的位置。
		System.out.println("substring:"+s.substring(1,4));
		//获取1-4的子串，不包括结尾。
	}

	private static void stringMethodDemo_2()
	{
		String s = "赵云,关羽,张飞,马超,项羽";//,和，不一样！！！
		String[] arr = s.split(",");//用,进行切割。

		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
			//逐个打印切割之后的块。
		}

		char[] chs = s.toCharArray();
		//将字符串变成字符数组。
		for (int i = 0; i < chs.length; i++)
		{
			System.out.println(chs[i]);
			//打印出来的 赵 云 , 关 羽 ,……
		}

		s = "smartyu琴彧abcdefg";
		byte[] bytes = s.getBytes();
		//将字符串变成字节数组。打印出来的是对应编码。
		for (int i = 0; i < bytes.length; i++)
		{
			System.out.println(bytes[i]);
		}

		System.out.println("samrtloveyu".toUpperCase());
		//将字符串大写。

		String s1 = "qinyu";
		String s2 = s1.replace('q','t');
		//用t替换q。
		System.out.println(s1==s2);
		//false,s1被替换后产生新对象s2。

		System.out.println("---"+"    samrt yu     ".trim()+"---");
		//去除空格。


	}

	private static void stringMethodDemo_3()
	{
		String s = "smartyu";
		System.out.println(s.equals("SMARTYU".toLowerCase()));
		System.out.println(s.equalsIgnoreCase("SmARTyu"));
		//忽略大写的比较。

		System.out.println(s.contains("mm"));//false
		//判断是否包括，blooean。

		//判断是否是以指定内容开头、结尾、包括？
		String str = "StringMethodDemo.java";

		System.out.println(str.startsWith("String"));
		System.out.println(str.endsWith(".java"));
		System.out.println(str.contains("Demo"));
	}

	private static void stringMethodDemo_4()
	{
		System.out.println("qinyu".compareTo("smartyu"));//比较
		//比较的是Unicode的值。
		System.out.println("smart".concat("yu"));//连接。方法();
		sop("qin".concat("yu"));
	}

	public static void sop(Object obj)//没有分号！！！！！将打印功能封装成对象。
	{
		System.out.println(obj);
	}
}
