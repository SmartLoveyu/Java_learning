package work.string.test;

/*
1、给定一个字符串数组。按照字典顺序从小到大进行排序。
{"persistent","attitude","smart","peace"}

思路：
1、关于数组排序，有选择、冒泡排序。
2、for的嵌套循环，比较和换位。
3、字符串对象如何比较？
对象中提供了用于字符串比较的功能。
compareTo()

*/
public class StringTest_1
{
	public static void main(String[] args)
	{
		String[] arr = {"persistent","attitude","smart","peace","abced","abeca"};

		printArray(arr);//将方法进行封装，然后直接调用。

		sortString(arr);

		printArray(arr);

	}

	public static void sortString(String[] arr)
	{
		//compareTo()方法：如果指定字符数值大于参数数字，返回正数。Unicode的差值。
		
		for (int i =0; i < arr.length-1; i++)
		{
			for (int j = i+1; j<arr.length; j++)
			{
				if(arr[i].compareTo(arr[j])>0)
				//比较的是整个字符串中*逐个*字符对应的Unicode值，然后进行比较。
					swap(arr,i,j);//封装了方法，然后调用。
			}
		}
	}

	public static void swap(String[] arr, int i, int j)
	{
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArray(String[] arr)
	{
		System.out.println("[");
		for (int i = 0; i < arr.length; i++)
		{
			if(i != arr.length - 1)
				System.out.println(arr[i] + ", ");
			else
				System.out.println(arr[i] + "]");
		}
	}
}
