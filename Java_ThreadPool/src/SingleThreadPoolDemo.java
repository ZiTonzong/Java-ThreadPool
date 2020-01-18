import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolDemo {
	public static void main(String args[]){
		//创建一个使用单个worker线程的Executor，以无界队列方式来运行该线程
		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		Runnable task1 = new SingleTask();
		Runnable task2 = new SingleTask();
		Runnable task3 = new SingleTask();
		
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		
		/**
		 * 测试shutdown()方法和shutdownNow()方法的区别：延迟5秒后执行关闭线程池方法，若是
		 * showdownNow方法则会在执行第二个线程任务时马上打断其执行因而抛出sleep interrupted异常，
		 * 而如果是showdown方法则会在所有等待执行的线程全部执行完后才关闭线程池。
		 */
		try {
	        Thread.sleep(5000);//括号里面的5000代表5000毫秒，也就是5秒，可以该成你需要的时间
	} catch (InterruptedException e) {
	        e.printStackTrace();
	}
		//pool.shutdownNow();
		//关闭线程池，等待已经提交的任务全部结束，不再接受新的任务
				pool.shutdown();
	}
	
}

class SingleTask implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在执行……");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"执行完毕");
	}
	
}
