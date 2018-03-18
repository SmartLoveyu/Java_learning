/*
使用Lock()和Condition()更有效地执行生产-消费的模型。

Lock接口：替代了同步代码块或者同步函数。
		将同步的隐式锁操作变成了现实锁的操作。
		并且可以在一个锁上加上多组监视器。

lock(): 获取锁。
unlock(): 释放锁。

Condition接口：替代了Object中的wait notify notifyAll的方法。
			将这些监视器方法单独进行了封装，变成Condition监视器对象。
			可以任意锁进行组合。

await();
signal();
signalAll();


*/

import java.util.concurrent.locks.*;
//可以理解成，再调用locks。

class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;

	//创建一个锁对象。
	Lock lock = new ReentrantLock();
	
	//通过已有的锁获取该锁上的监视器对象。
//	Condition con = lock.newCondition();

	//通过已有的锁，获取两组监视器，一组监视生产者，一组监视消费者。
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();

	public void set(String name)
	{
		lock.lock();
		try
		{
			while(flag)
			//try{lock.wait();}catch(InterruptedException e){}
			try{producer_con.await();}catch (InterruptedException e){}

			this.name = name + count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...生产者5.0......"+this.name);
			flag = true;
	//		notifyAll();
	//		con.signalAll(); 创建单一锁时，使用。
			consumer_con.signal();//唤醒，一个监视器对应一个对象。
		}
		finally //经常由于释放资源而使用，在这里，释放锁。
		{
			lock.unlock();
		}
	}

	public void out()
	{
		lock.lock();
		try
		{
			while(!flag)
				try
				{
					consumer_con.await();
				}
				catch (InterruptedException e)
				{
				}
			System.out.println(Thread.currentThread().getName()+".......消费者5.0......"+this.name);
			flag = false;
			producer_con.signal();

		}
		finally 
		{
			lock.unlock();
		}
	}
}

class Producer implements Runnable
{
	private Resource r;//创建私有对象。类 + 名。
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.set("烤鱼");
		}
	}

}

class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}


class ProducerConsumerDemo2
{
	public static void main(String[] args)
	{
	//先创建个资源类对象。
	Resource r = new Resource();
	
	new Thread(new Producer(r)).start();
	new Thread(new Consumer(r)).start();
	new Thread(new Producer(r)).start();
	new Thread(new Consumer(r)).start();
	}
}
