/*
需求：银行储户，两个，每个都每次存100，共10次。
用到多线程，也就是两个线程。

*/

class  Bank
{
	private int sum;
	private Object obj = new Object();
	public synchronized void add(int num)//同步函数。
	{
		//synchronized(obj)
		//{
			sum = sum + num;
			
			/*
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
			}
			*/
			System.out.println(Thread.currentThread().getName()+"sum ="+sum);
		//}
	}
}

class Cus implements Runnable
{
	private Bank b = new Bank();
	public void run()
	{
		for (int x=0; x<10; x++)
		{
			b.add(100);//使用Bank类下的add方法。
		}
	}
}


class BankDemo
{
	public static void main(String[] args)
	{
		Cus c = new Cus();//创建类.名的对象
		Thread t1 = new Thread(c);//创建线程并使用
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}
