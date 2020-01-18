import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
	public static void main(String args[]){
		//创建一个可重用的固定线程数的线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		Thread t1 = new MyThread2();
		Thread t2 = new MyThread2();
		Thread t3 = new MyThread2();
		Thread t4 = new MyThread2();
		Thread t5 = new MyThread2();
		//将线程放入池中进行执行
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		//关闭线程池
		pool.shutdown();
	}
}


class MyThread2 extends Thread{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在执行……");
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"执行完毕。");
	}
	
}
