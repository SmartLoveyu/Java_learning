package work.string.test;

	/*
	4、将字符串反转。

	思路：
	1、数组可以反转打印，可以先将字符串变成数组。
	2、对数组反转。
	3、将数组变成字符串。
	*/

public class StringTest_4
{	
	//千万不能忘记了主函数。
	public static void main(String[] args)
	{

		String str = "smartyu";

		sop("(  "+str+"  )");
		sop("(  "+reverseString(str)+"  )");

	}
	

	public static String reverseString(String s, int start, int end)//方法名(),没有分号。
	{
		//字符串变成数组。
		char[] chs = s.toCharArray();
		//反转数组。
		reverse(chs,start,end);
		//将数组变成字符串。
		return new String(chs);
		
	}

	public static String reverseString(String s)
	{
		return reverseString(s,0,s.length());//start = 0,end = s.length-1
		//ruturn返回，直接调用方法
		
		/*
		//字符串变成数组。
		char[] chs = s.toCharArray();
		//反转数组。
		reverse(chs);
		//将数组变成字符串。
		return new String(chs);
		*/
	}

	private static void reverse(char[] arr, int x, int y)//调用方法时，方法名一定要对应。
	{
		for(int start=x,end=y-1; start<end ; start++,end--)
		{
			swap(arr,start,end);
		}
	}
	private static void swap(char[] arr, int x, int y)
	{
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void sop(String str)
	{
		System.out.println(str);
	}
}
