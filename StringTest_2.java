package work.string.test;

/*
2、一个 子串 在整串中出现的次数。
"smartyuqinyucongbuyudaoyujianzaixiangyu"
思路：
1、可以使用indexOf来获取存在子串出现的位置。
2、如果找到了，那么就记录出现的位置，并在剩余的字符串中继续查找该子串。
	而剩余字符串的起始位置是：出现位置+子串的长度。
3、以此类推，通过循环完成查找，如果找不到就是-1，并且，每次找到的用计数器记录。
*/


public class StringTest_2
{
	public static void main(String[] args)
	{
		
		String str = "smartyuqinyucongbuyudaoyujianzaixiangyu";
		String str_1 = "yusmartyuqinyucongbuyudaoyujianzaixiangyu";
		String str_2 = "yusmartyuqinyucongbuyudaoyujianzaixiang";
		String key = "yu";

		sop("count="+str.split("yu").length);
		sop("count="+str_1.split("yu").length);//6 "","smart",....,也就是在开头出切片会产生 空字符串""。
		sop("count="+str_2.split("yu").length);//6 "","samrt",....,
		
		String[] arr_1 = str_1.split("yu");
		String[] arr_2 = str_2.split("yu");
		
		sopn("[");
		for (int i = 0; i < arr_1.length; i++)
		{
			if (i!=arr_1.length-1)
			{
				sopn(arr_1[i]+", ");
			}
			else
			{
				sop(arr_1[i]+"]");
			}
			
		}
		
	
		sopn("[");
		for (int i = 0; i < arr_2.length; i++)
		{
			
			if (i!=arr_2.length-1)
			{
				sopn(arr_2[i]+", ");
			}
			else
			{
				sop(arr_2[i]+"]");
			}
		}
		
		//sop(arr_2);//不加[]，打印出来的是字符串位置。
		//
	

		int count = getKeyStringCount_2(str,key);
		//int count = getKeyStringCount_2(str,key);
	//封装方法，然后直接调用。
		System.out.println("count="+count);
	}

	public static int getKeyStringCount_2(String str, String key)
	{
		int count = 0;
		int index = 0;

		while((index = str.indexOf(key,index))!=-1)
		//如果等于-1，说明该子串不在整串中。
		{
			index = index + key.length();
			//下一次索引的位置。
			count++;
			//作为计数器使用
		}

		return count;
		//返回count，使得调用该方法时，可以获得count。
	}

	public static int getKeyStringCount(String str, String key)
	{
		int count = 0;
		int index = 0;

		while((index = str.indexOf(key))!=-1)
		{
			//使用substring，获取子串的功能。
			str = str.substring(index+key.length());
			//使用这个功能，相当于一次一次把字符串去除key后剪短，但是和切片功能不一样。
			count++;
		}
		return count;
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void sopn(Object obj)
	{
		System.out.print(obj);
	}
}
