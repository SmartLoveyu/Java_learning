/*
一个卖票的小程序
涉及多线程的安全问题。
1、多线程操作共享数据时。
2、操作共享数据的代码有多条。

简单的说，一个线程运行时，不能及时结束。导致其他线程参与其中。

解决思路：
进行分装，一个运行，第二个就不能进来。
------
同步代码块：
synchronized(对象)
{
	需要被同步的代码;
}

同步的多个线程使用同一个锁。
解决了安全性，降低了运行效率。
*/


class Ticket implements Runnable //extends Thread
{
	private int num = 1000;

	Object obj = new Object();//作为一个同步锁。
	public void run()//覆写run方法。
	{
		while(true)//默认循环，就是会一直转。
		{
			synchronized(obj)
			{
				if(num>0)
				{
					try
					{
						Thread.sleep(10);
					}
					catch (InterruptedException e)//排除 错误.名。					{
					{}
					//这一块还有疑惑，需要复习。
					

					System.out.println(Thread.currentThread().getName()+"......sale......"+num--);
				}
			}
		}
	}
}

class TicketDemo
{
	public static void main(String[] args)
	{
		
		Ticket t = new Ticket();//创建一个线程任务对象。

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		Thread t5 = new Thread(t);
		Thread t6 = new Thread(t);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();

		/*
		错误方式
		
		Ticket t1 = new Ticket();
		Ticket t2 = new Ticket();
		Ticket t3 = new Ticket();
		Ticket t4 = new Ticket();

		t1.start();
		t2.start();//一个线程不能开启两次。
		t3.start();
		t4.start();

		简单的说，必须通过Thread创建线程，并且创建时须指名对象。
		*/


	}

}
