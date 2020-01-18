
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ScheduledThreadPoolDemo {
	public static void main(String args[]){
		// ����һ���̳߳أ����ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ�С�
				ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
				// ����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
				Thread t1 = new MyThread1();
				Thread t2 = new MyThread1();
				Thread t3 = new MyThread1();
				Thread t4 = new MyThread1();
				// ���̷߳�����н���ִ��
				pool.execute(t1);
				// ʹ���ӳ�ִ�з��ķ���
				pool.schedule(t2, 3000, TimeUnit.MILLISECONDS);
				pool.schedule(t3, 10, TimeUnit.MILLISECONDS);
				pool.schedule(t4, 10, TimeUnit.MILLISECONDS);
				// �ر��̳߳�
				pool.shutdown();
	}
}


class MyThread1 extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"����ִ�С���");
	}
	
}

