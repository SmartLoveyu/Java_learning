package work.wrapper.test;

//调用类方法
import java.util.Arrays;

/*
将一组数据，从小到大排列，有正负数

"12 18 34 -9 -38 -23 54 2"

思路：
1、熟悉int类的排序，但这是字符串。
2、可以将字符串切割，然后转后成int型
3、这里是通过空格来切割，然后可以用包装类，将字符串--->基本类型
*/

public class WrapperTest
{
	private static final String space = " ";

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args)
	{
		String numStr = "12 18 34 -9 -38 -23 54 2";

		sop(numStr);
		numStr = sortStringNumber(numStr);
		sop(numStr);
		
	}

	public static String sortStringNumber(String numStr)
	{
		//方法确定好，封装成对象后，然后直接调用。
		
		//1、将字符串变成字符数组。
		//这里用到的是，将字符串切割。
		String[] str_arr = stringToArray(numStr);

		//2、将字符串数组变成int数组。
		int[] num_arr = toIntArray(str_arr);

		//3、对int数组排序
		//这里是调用了自定义的方法。
		mySortArray(num_arr);

		//4、对排序后的int数组变成字符串。
		String temp = arrayToString(num_arr);
		return temp;
		
	}

	//stringToArray()
	public static String[] stringToArray(String numStr)
	{
		String[] str_arr = numStr.split(space);

		return str_arr;
	}

	//toIntArray()
	public static int[] toIntArray(String[] str_arr)
	{
		int[] arr = new int[str_arr.length];

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		//使用for，通过角标，一个一个进行转换。
		return arr;
	}

	//mySortArray()
	public static void mySortArray(int[] num_arr)
	{
		Arrays.sort(num_arr);
	}

	//arrayToString()
	//int[] num_arr = toIntArray(str_arr);
	public static String arrayToString(int[] num_arr)
	{
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < num_arr.length; x++)
		{
			if(x!=num_arr.length-1)
				sb.append(num_arr[x]+space);
			else
				sb.append(num_arr[x]);
		}

		return sb.toString();
	}
}
