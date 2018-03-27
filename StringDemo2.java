package work.string.demo;

public class StringConstructorDemo
{
	public static void main(String[] args)
	{
		//通过String类的构造函数，将字节数组或者字符数组转成字符串。
		stringConstructorDemo();
		stringConstructorDemo2();
	}

	private static void stringConstructorDemo2()
	{
		char[] arr = {'s','m','a','r','t','y','u'};
		String s = new String(arr,1,4);//取角标第1-4个。

		System.out.println("s="+s);

	}

	public static void stringConstructorDemo()
	{
		String s = new String();
		//等效于String s = "";转换成数组。
		//不是String s = null;
		 byte[] arr = {52,56,69,68};//4,8,E,D
		 //{}括内容，()跟在方法之后。不一样！！！
		 String s1 = new String(arr);
		 //打印出来的就是编码对应的字符。
		 System.out.println("s1="+s1);
	}
}
