package work.string.test;

/*
3、找出两个字符串中最大相同的子串。
"bailuyishanjinhuangheruhailiu"
"bairiyiyunchangheruhaijin"

思路：
1、先判断短的字符串是否就在长的字符串中。
2、如果不是，将短的字符段，长度递减，然后和长串中进行比较。
3、找到后，停止运算。
*/

public class StringTest_3//打成了Tset，会报错的！！！
{
	public static void main(String[] args)
	{
		String s1 = "bairiyiyunchangheruhaijin";
		String s2 = "bailuyishanjinhuangheruhailiu";

		String s = getMaxSubstring(s1, s2);
		System.out.println("s="+s);
	}



	//先判断哪一个是最短的字符串。
	
	public static String getMaxSubstring(String s1, String s2)
	{
		String max = null,min = null;
		max = (s1.length()>s2.length())?s1:s2;
		min = max.equals(s1)?s2:s1;
		//先判断max，然后用是否相等，来判断min。

		System.out.println("max="+max);
		System.out.println("min="+min);


		for (int i = 0; i<min.length(); i++)
		{
			for(int a = 0,b = min.length()-i; b != min.length()+1; a++,b++)//大循环i++,小循环a++，b++			
			/*
			会出现
			******
			*****
			*****
			****
			****
			****
			***
			***
			***
			***
			类似这种形式的打印。
			
			*/
			{
				String sub = min.substring(a,b);
				//获取子串，
				System.out.println(sub);
				if (max.contains(sub))
					return sub;
			}
		}
		return null;//get，需要有返回语句。
	}


}


