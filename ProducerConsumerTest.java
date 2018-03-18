/*
生产者和消费者的问题。

多个生产者，
多个消费者，

其中会出现的问题：
if判断标记flag，只是判断一次，会导致不该运行的线程也运行了。出现数据错误的情况。
while判断标记flag，就是，线程获得执行权，还会再判断一次，是否可以运行。

notify唤醒的问题：如果只是本方唤醒了本方，没有实际意义。而且while判断标记+notify会导致死锁现象。
notifyAll解决了本方线程一定会唤醒对方线程的问题。
*/


//建议资源类，注意，私有和共有的方法。private和public。
class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;//作为一个标记。
	//记得，flag作为标记，是标记真假的，只有while(true),if(true)的时候才往下运行，否则不运行。

	public synchronized void set(String name)//t0 t1
	{
		while(flag)//一开始是flase，所以不会进入循环。 另外if(flag)会出现只能判断一次的问题。
			try //to执行过一次，flag=true，进入while(true)循环，然后会冻结。同样t1如果此时进入也会被冻结。			
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
			}
		this.name = name + count;//就是 烤鸡1 烤鸡2 烤鸡3
		count++;//2 3 4
		System.out.println(Thread.currentThread().getName()+"......生产者......"+this.name);
		flag = true;
		notifyAll();//使用notifyAll(),这是想把对方也唤醒。
		//如果notify()，只唤醒本方，会出现即使本方都被唤醒了，但会卡在while(true)循环里，然后就是一直卡死。
	}

	public synchronized void out()//t2 t3
	{
		while(!flag)//接上t1被冻结，如果t2获得执行，那么非真，不会进入循环，flag改变，下一次进入会被冻结。
			try
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
			}
		System.out.println(Thread.currentThread().getName()+"......消费者......"+this.name);
		flag = false;
		notifyAll();
	}
}

class Producer implements Runnable
{
	private Resource r;//私有后，只在本类中使用。
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.set("烤鸡");
		}
	}
}

class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)//调用Resource类下的方法，就是先建立，然后调用，r.set(),r.out()
	{
		this.r = r;
	}
	public void run()//是对Runnable里的run方法进行覆写。
	{
		while(true)
		{
			r.out();
		}
	}
}

class ProducerConsumerDemo
{
	public static void main(String[] args)
	{
		Resource r = new Resource();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);
		//简单地说，就是建立对象，然后调用方法。

		//创建线程
		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(con);

		//开启线程
		t0.start();	
		t1.start();
		t2.start();
		t3.start();




	}
}
