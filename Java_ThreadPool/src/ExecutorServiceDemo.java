import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable implements Runnable{
		@Override
		public void run() {
			for(int x = 0;x<100;x++){
				System.out.println(Thread.currentThread().getName()+":"+x);
			}
		}
	}

public class ExecutorServiceDemo{
	public static void main(String args[]){
		//����һ���̳߳ض��󣬿���Ҫ���������̶߳���
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		//����ִ��Runnable�������Callable���������߳�
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
		
		//�����̳߳�
		pool.shutdown();
		
		/*Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		t1.start();
		t2.start();*/
	}
}
