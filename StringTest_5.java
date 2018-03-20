package work.string.test;

/*
5、模拟一个trim功能一致的方法。去除字符串两端空白。

思路：
1、删除两端空格，那么需要两个变量，一个从头开始删，一个从尾开始删。
2、判断不再是空格为止，然后取头尾之间的字符串。

*/

public class StringTest_5
{
	public static void main(String[] args)
	{
		String s = "     smart yu    ";

		s = myTrim(s);
		System.out.println("-"+s+"-");
	}

	public static String myTrim(String s)
	{
		int start = 0, end = s.length()-1;
		//可以通过charAt()位置的字符是否为空格，然后需要同时满足，start<end,然后进行删除。
		while (start <= end && s.charAt(start) == ' ')//需要同时满足，第一个不满足即无须再运算。
		{
			start++;
		}
		while(start <= end && s.charAt(end) == ' ')
		{
			end--;
		}
		return s.substring(start, end+1);//默认是取头不取尾。
	}
}
