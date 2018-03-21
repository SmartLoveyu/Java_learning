package work.stringbuffer.demo;

/*
StringBuffer:就是字符串缓冲区。
用于存储数据的容器。

特点：
1、长度可变。
2、可以存储不同类型数据。
3、最终要转成字符串进行使用。
4、可以对字符串进行修改。



所具有的功能：
1、添加：
	StringBuffer apend(data);
	StringBuffer insert(index,data);//从index处插入。

2、删除：
	StringBuffer delete(start,end)：包含头，不包含尾。
	StringBuffer deleteCharAt(int index):删除指定位置的元素。

3、查找：
	char charAt(index);
	int indexOf(string);
	int lastIndexOf(string);查找string最后一次出现的地方。

4、修改：
	StringBuffer replace(start,end,string);
	void setCharAt(index,char);

增删改查 C create U update R read D delete


特别说明：
jak5.0之后，出现了功能和StringBuffer一模一样的对象，StringBuilder

不同的是：
StringBuffer 线程同步，通常用于多线程。
StringBuilder 线程不同步，通常用于单线程，提高效率。

简化书写，
提高效率，
增强安全性。

*/

public class StringBufferDemo
{
	public static void main(String[] args)
	{
		bufferMethodDemo_1();
		bufferMethodDemo_2();
	}

	public static void bufferMethodDemo()
	{
		//创建缓冲区对象。
		StringBuffer sb = new StringBuffer();

		sb.append(6).append(false);//6false
		sb.insert(1,"qinyu");//6qinyufalse
		sop(sb);
	}

	private static void bufferMethodDemo_1()
	{
		StringBuffer sb = new StringBuffer("smart");
		StringBuffer sb1 = new StringBuffer("qin");

		sb.append("yu");//append
		sb1.insert(2,"yu");

		sop(sb.toString());//toString()覆写功能，然后打印对象。
		
	}

	private static void bufferMethodDemo_2()
	{
		StringBuffer sb = new StringBuffer("samrtloveyu");
		StringBuffer sb1 = new StringBuffer("samrtloveyu");
		StringBuffer sb2 = new StringBuffer("samrtloveyu");
		StringBuffer sb3 = new StringBuffer("samrtloveyu");
		sb.delete(5,8);//不包括尾。
		
		//清空缓冲区。
		sb1.delete(0,sb.length());
		sb1 = new StringBuffer();
		sb1.setLength(12);

		sb2.replace(5,9,"qin");
		sb3.setCharAt(2, 'a');//setCharAt ,在指定位置上进行修改。


		sop(sb.reverse());
		sop("length:"+sb1.length());//  方法()
		sop(sb2);
		sop(sb3);
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
